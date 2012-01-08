package com.rvkb.ecahier.model

import javax.persistence.Entity
import woko.ext.usermanagement.hibernate.HbUser

@Entity
class User extends HbUser {

    String firstName
    String lastName

}
