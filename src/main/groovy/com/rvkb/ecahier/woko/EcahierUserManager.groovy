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
                  username:"kakou",
                  name: "Guillaume Lefrançois",
                  password: encodePassword("kakou"),
                  roles: ["admin", "educ"],
                  email: "kakou@lefrancois.com"
              ])
            )

            hibernateStore.save(
              new User([
                  username:"david",
                  name: "David Hasseloff",
                  password: encodePassword("david"),
                  roles: ["educ"],
                  email: "david@vincent.com"
              ])
            )

            hibernateStore.save(
              new User([
                  username:"sofiane",
                  name: "Sofiane Belmondo",
                  password: encodePassword("sofiane"),
                  roles: ["usager"],
                  email: "sofiane@fondation-chiris.com"
              ])
            )

            hibernateStore.save(
              new User([
                  username:"sandy",
                  name: "Sandy Avecunnomvachementlong",
                  password: encodePassword("sandy"),
                  roles: ["usager"],
                  email: "sandy@gmail.com"
              ])
            )

        } as TxCallback)

        return this
    }
}

