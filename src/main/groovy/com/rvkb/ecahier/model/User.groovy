package com.rvkb.ecahier.model

import javax.persistence.Entity
import woko.ext.usermanagement.hibernate.HbUser
import javax.persistence.Lob
import javax.persistence.FetchType
import java.sql.Blob
import javax.persistence.Transient
import net.sourceforge.stripes.action.FileBean

@Entity
class User extends HbUser {

    String name
    String email
    String phoneNumber
    String jobPosition

    // hack for completion : we don't want to join for roles all the time
    boolean devel = false

    @Override
    void setRoles(List<String> roles) {
        super.setRoles(roles)
        if (roles && roles.contains("developer")) {
            devel = true
        }
    }

//    @Lob
//    byte[] avatar

    // My tricks for easily avatar/woko integration
    @Transient
    FileBean avatarStripes

    Blob avatar


}
