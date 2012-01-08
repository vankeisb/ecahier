package com.rvkb.ecahier.model

import javax.persistence.Entity
import org.compass.annotations.Searchable
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import org.compass.annotations.SearchableId
import org.compass.annotations.SearchableProperty
import javax.validation.constraints.NotNull
import javax.persistence.ManyToOne
import javax.persistence.FetchType

@Entity
@Searchable
class Entry {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @SearchableId
    Long id

    @NotNull
    @SearchableProperty
    Date creationDate = new Date()

    String text

    @ManyToOne(fetch=FetchType.LAZY)
    User createdBy

}
