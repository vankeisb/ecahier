package com.rvkb.ecahier.woko;

import com.rvkb.ecahier.model.User;
import woko.ext.usermanagement.hibernate.HibernateUserManager;
import woko.hibernate.HibernateStore;

public class EcahierUserManager extends HibernateUserManager {

    public EcahierUserManager(HibernateStore hibernateStore) {
        super(hibernateStore, User.class);
    }
}
