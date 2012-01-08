package com.rvkb.ecahier.woko;

import com.rvkb.ecahier.model.User;
import woko.ext.usermanagement.core.DatabaseUserManager;
import woko.ext.usermanagement.hibernate.HibernateUserManager;
import woko.hibernate.HibernateStore;

import java.util.Arrays;

public class EcahierUserManager extends HibernateUserManager {

    public EcahierUserManager(HibernateStore hibernateStore) {
        super(hibernateStore, User.class);
    }

    @Override
    public DatabaseUserManager createDefaultUsers() {
        super.createDefaultUsers();
        createUser("kakou", "kakou", Arrays.asList("educ"));
        createUser("david", "david", Arrays.asList("educ"));
        createUser("sofiane", "sofiane", Arrays.asList("usager"));
        return this;
    }
}
