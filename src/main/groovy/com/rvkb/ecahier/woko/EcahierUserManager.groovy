package com.rvkb.ecahier.woko

import woko.ext.usermanagement.core.DatabaseUserManager
import com.rvkb.ecahier.model.User
import woko.hibernate.HibernateStore
import woko.ext.usermanagement.hibernate.HibernateUserManager


class EcahierUserManager extends HibernateUserManager {

    EcahierUserManager(HibernateStore hibernateStore) {
        super(hibernateStore, User.class)
    }

    @Override
    DatabaseUserManager createDefaultUsers() {
        super.createDefaultUsers()
        createUser("kakou", "kakou", ["admin", "educ"])
        createUser("david", "david", Arrays.asList("educ"))
        createUser("sofiane", "sofiane", Arrays.asList("usager"))
        return this
    }
}
