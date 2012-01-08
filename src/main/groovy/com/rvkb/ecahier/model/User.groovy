package com.rvkb.ecahier.model

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.OrderBy
import woko.ext.usermanagement.hibernate.HbUser

@Entity
class User extends HbUser {

    @OneToMany(mappedBy="createdBy", fetch=FetchType.LAZY)
    @OrderBy("creationDate ASC")
    List<Entry> createdEntries

}
