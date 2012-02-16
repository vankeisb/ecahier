package com.rvkb.ecahier.woko

import woko.util.WLogger
import woko.hbcompass.HibernateCompassStore
import woko.persistence.ResultIterator
import com.rvkb.ecahier.model.User
import org.hibernate.criterion.Restrictions
import org.hibernate.Criteria
import org.hibernate.criterion.MatchMode
import woko.persistence.ListResultIterator
import org.hibernate.criterion.Order
import org.compass.core.CompassException
import org.compass.core.Compass
import org.compass.core.CompassTemplate
import org.compass.core.CompassSession
import org.compass.core.CompassHits
import org.compass.core.CompassHitsOperations
import woko.hbcompass.CompassResultIterator
import com.rvkb.ecahier.model.Entry
import org.compass.core.CompassCallback
import com.rvkb.ecahier.utils.ImageUtils
import org.hibernate.Hibernate

class EcahierStore extends HibernateCompassStore {

    private static final WLogger logger = WLogger.getLogger(EcahierStore.class)

    EcahierStore(List<String> packageNames) {
        super(packageNames)
    }

    User saveUser(User user){
        if (user.avatarStripes) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream()
            ImageUtils.rescaleImage(user.avatarStripes.inputStream, 150, bos)
            user.avatar = Hibernate.createBlob(new ByteArrayInputStream(bos.toByteArray()))
        }

        return save(user)
    }
    
    // overriden to add orderBy to criteria...
    @Override
    ResultIterator list(String className, Integer start, Integer limit) {
        Class clazz = getMappedClass(className);
        int s = start == null ? 0 : start;
        int l = limit == null ? -1 : limit;
        if (clazz == null) {
            return new ListResultIterator(Collections.emptyList(), s, l, 0);
        } else {
            Criteria crit = getSession().
              createCriteria(clazz).
              setFirstResult(s).
              addOrder(Order.desc("creationDate"));
            if (l != -1) {
                crit.setMaxResults(l);
            }

            // TODO optimize with scrollable results ?
            List objects = crit.list();

            // compute total count
            String mappedClassName = getClassMapping(clazz);
            String query = new StringBuilder("select count(*) from ").append(mappedClassName).toString();
            Long count = (Long) getSession().createQuery(query).list().get(0);

            return new ListResultIterator(objects, s, l, count.intValue());
        }
    }

    /**
     * Display the news where the user is the author
     */
    ResultIterator getAuthoredEntriesForUser(User u, Integer start, Integer limit) {
        Class clazz = getMappedClass("Entry");
        int s = start == null ? 0 : start;
        int l = limit == null ? -1 : limit;
        if (clazz == null) {
            return new ListResultIterator(Collections.emptyList(), s, l, 0);
        } else {
            Criteria crit = getSession().
              createCriteria(clazz).
              setFirstResult(s).
              addOrder(Order.desc("creationDate")).
              add(Restrictions.like("createdBy", u));
            if (l != -1) {
                crit.setMaxResults(l);
            }

            // TODO optimize with scrollable results ?
            List objects = crit.list();

            // compute total count
            String mappedClassName = getClassMapping(clazz);
            String query = new StringBuilder("select count(*) from Entry where createdBy.id like('$u.id')").toString();
            Long count = (Long) getSession().createQuery(query).list().get(0);

            return new ListResultIterator(objects, s, l, count.intValue());
        }
    }

    /**
     * Display the news where the user is in the participant list
     */
    ResultIterator getParticipatedEntriesForUser(User u, Integer start, Integer limit) {
        Class clazz = getMappedClass("Entry");
        int s = start == null ? 0 : start;
        int l = limit == null ? -1 : limit;
        if (clazz == null) {
            return new ListResultIterator(Collections.emptyList(), s, l, 0);
        } else {
            Criteria crit = getSession().
              createCriteria(clazz).
              setFirstResult(s).
              addOrder(Order.desc("creationDate")).
              createCriteria("participants").
              add(Restrictions.like("id", u.id))

            if (l != -1) {
                crit.setMaxResults(l);
            }

            // TODO optimize with scrollable results ?
            List objects = crit.list();

            String query = new StringBuilder("select count(*) from Entry e join e.participants p where p.id like('$u.id')").toString();
            Long count = (Long) getSession().createQuery(query).list().get(0);

            return new ListResultIterator(objects, s, l, count.intValue());
        }
    }

    ResultIterator<User> getCompletionUsers(String criteria, Integer start, Integer limit) {
        Criteria crit = session.createCriteria(User.class).add(Restrictions.eq("devel", false))
        if (criteria) {
            crit.add(
              Restrictions.ilike("username", criteria, MatchMode.ANYWHERE)
            )
        }
        def results = crit.list()
        def totalSize = results.size()
        def s = start && start > 0 ? start : 0
        def l = limit && limit > 0 && start + limit < totalSize ? limit : totalSize
        def subList = results.subList(s, l)

        return new ListResultIterator<User>(subList, s, l, totalSize)
    }

    ResultIterator<User> getUsersForAdministration(User currentUser, Integer start, Integer limit) {
        Criteria crit = session.createCriteria(User.class).add(Restrictions.eq("devel", false))



        def results = crit.list()
        def totalSize = results.size()
        def s = start && start > 0 ? start : 0
        def l = limit && limit > 0 && start + limit < totalSize ? limit : totalSize
        def subList = results.subList(s, l)

        return new ListResultIterator<User>(subList, s, l, totalSize)
    }

    @Override
    public ResultIterator search(final Object query, Integer start, Integer limit) {
        if (!(query instanceof String)) {
            throw new IllegalArgumentException("Query must be a String but was " + query?.getClass())
        }
        final int iStart = start == null ? 0 : start
        final int iLimit = limit == null ? -1 : limit
        return new CompassTemplate(compass).execute({ CompassSession compassSession ->
            CompassHits hits = compassSession.find((String) query);
            int len = hits.length();
            int size = iLimit == -1 ? len - iStart : iLimit;
            CompassHitsOperations hitsOps = hits.detach(iStart, size);
            def highlightedFragments = []
            for (int hitIndex = iStart ; hitIndex < len ; hitIndex++) {
                Object o = hits.data(hitIndex);
                if (o instanceof Entry) {
                    highlightedFragments << hits.highlighter(hitIndex).fragment("text");
                } else {
                    highlightedFragments << null
                }
            }
            return new CompassResultIteratorWithHighlight(
              hitsOps,
              iStart,
              iLimit,
              len,
              highlightedFragments);
        } as CompassCallback)
    }
}
