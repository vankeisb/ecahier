package com.rvkb.ecahier.woko

import woko.util.WLogger
import woko.hbcompass.HibernateCompassStore
import woko.persistence.ResultIterator
import com.rvkb.ecahier.model.User
import org.hibernate.criterion.Restrictions
import org.hibernate.Criteria
import org.hibernate.criterion.MatchMode
import woko.persistence.ListResultIterator

class EcahierStore extends HibernateCompassStore {

    private static final WLogger logger = WLogger.getLogger(EcahierStore.class)

    EcahierStore(List<String> packageNames) {
        super(packageNames)
    }

    ResultIterator<User> getCompletionUsers(String criteria, Integer start, Integer limit) {
        Criteria crit = session.createCriteria(User.class);
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

        return new ListResultIterator<User>(results, s, l, totalSize)
    }

}
