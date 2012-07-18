package com.rvkb.ecahier.woko

import woko.ext.usermanagement.core.DatabaseUserManager
import com.rvkb.ecahier.model.User
import woko.hibernate.HibernateStore
import woko.ext.usermanagement.hibernate.HibernateUserManager
import woko.hibernate.TxCallback

class EcahierUserManager extends HibernateUserManager {

    EcahierUserManager(HibernateStore hibernateStore) {
        super(hibernateStore, User.class)
    }

    @Override
    DatabaseUserManager createDefaultUsers() {
        super.createDefaultUsers()
        hibernateStore.doInTx({ um, session ->
            hibernateStore.save(
                    new User([
                            username:"guillaume",
                            name: "Guillaume Lefrancois",
                            password: encodePassword("guillaume!"),
                            roles: ["admin", "educ"],
                            email: "guillaume.lefrancois@fondation-chiris.com"
                    ])
            )

//            hibernateStore.save(
//                    new User([
//                            username:"marie",
//                            name: "Marie Dupond",
//                            password: encodePassword("marie"),
//                            roles: ["educ"],
//                            email: "marei@fondation-chiris.com"
//                    ])
//            )
//
//            hibernateStore.save(
//                    new User([
//                            username:"nicolas",
//                            name: "Nicolas Xxx",
//                            password: encodePassword("nicolas"),
//                            roles: ["usager"],
//                            email: "nicolas@fondation-chiris.com"
//                    ])
//            )
//
//            hibernateStore.save(
//                    new User([
//                            username:"audrey",
//                            name: "Audrey Yyy",
//                            password: encodePassword("audrey"),
//                            roles: ["usager"],
//                            email: "audrey@fondation-chiris.com"
//                    ])
//            )

        } as TxCallback)

        return this
    }
}

