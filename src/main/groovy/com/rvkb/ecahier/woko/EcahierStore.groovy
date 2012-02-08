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

class EcahierStore extends HibernateCompassStore {

    private static final WLogger logger = WLogger.getLogger(EcahierStore.class)

    EcahierStore(List<String> packageNames) {
        super(packageNames)
    }

    // overriden to add orderBy to criteria...
    @Override
    ResultIterator list(String className, Integer start, Integer limit) {
        Class clazz = getMappedClass(className);
        int s = start==null ? 0 : start;
        int l = limit==null ? -1 : limit;
        if (clazz==null) {
          return new ListResultIterator(Collections.emptyList(), s, l, 0);
        } else {
          Criteria crit = getSession().
            createCriteria(clazz).
            setFirstResult(s).
            addOrder(Order.desc("creationDate"));
          if (l!=-1) {
            crit.setMaxResults(l);
          }

          // TODO optimize with scrollable results ?
          List objects = crit.list();

          // compute total count
          String mappedClassName = getClassMapping(clazz);
          String query = new StringBuilder("select count(*) from ").append(mappedClassName).toString();
          Long count = (Long)getSession().createQuery(query).list().get(0);

          return new ListResultIterator(objects, s, l, count.intValue());
        }
    }

    ResultIterator<User> getCompletionUsers(String criteria, Integer start, Integer limit) {
        Criteria crit = session.createCriteria(User.class).add( Restrictions.eq("devel", false) )
        if (criteria) {
            crit.add(
                Restrictions.ilike("username", criteria, MatchMode.ANYWHERE)
            )
        }
        def results = crit.list()
        def totalSize = results.size()
        def s = start && start>0 ? start : 0
        def l = limit && limit>0 && start+limit < totalSize ? limit : totalSize
        def subList = results.subList(s,l)

        return new ListResultIterator<User>(subList, s, l, totalSize)
    }

}
