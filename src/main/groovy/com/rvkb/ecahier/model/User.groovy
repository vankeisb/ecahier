package com.rvkb.ecahier.model

import javax.persistence.Entity
import woko.ext.usermanagement.hibernate.HbUser
import javax.persistence.Lob
import javax.persistence.FetchType
import java.sql.Blob
import javax.persistence.Transient
import net.sourceforge.stripes.action.FileBean
import org.compass.annotations.Searchable
import org.compass.annotations.SearchableId
import org.compass.annotations.SearchableProperty

@Entity
@Searchable(boost=2.0f)
class User extends HbUser {

    @SearchableId
    @Override
    Long getId() {
        return super.getId()
    }

    @SearchableProperty
    @Override
    String getUsername() {
        return super.getUsername()
    }

    @SearchableProperty
    String name

    String email
    String phoneNumber

    @SearchableProperty
    String jobPosition

    User(){
        // Add default password for user creation
        super.setPassword(Integer.toString("password".hashCode()))
    }

    // hack for completion : we don't want to join for roles all the time
    boolean devel = false

    @Override
    void setRoles(List<String> roles) {
        super.setRoles(roles)
        if (roles && roles.contains("developer")) {
            devel = true
        }
    }

    // My tricks for easily avatar/woko integration
    @Transient
    FileBean avatarStripes

    Blob avatar


}
