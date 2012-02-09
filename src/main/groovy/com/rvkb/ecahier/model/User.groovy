package com.rvkb.ecahier.model

import javax.persistence.Entity
import woko.ext.usermanagement.hibernate.HbUser
import javax.persistence.Lob
import javax.persistence.FetchType

@Entity
class User extends HbUser {

    String firstName
    String lastName

    // hack for completion : we don't want to join for roles all the time
    boolean devel = false

    @Override
    void setRoles(List<String> roles) {
        super.setRoles(roles)
        if (roles && roles.contains("developer")) {
            devel = true
        }
    }

    @Lob
    byte[] avatar


}
