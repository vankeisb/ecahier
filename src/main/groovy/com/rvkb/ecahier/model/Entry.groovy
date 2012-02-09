package com.rvkb.ecahier.model

import javax.persistence.Entity
import org.compass.annotations.Searchable
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import org.compass.annotations.SearchableId
import org.compass.annotations.SearchableProperty
import javax.validation.constraints.NotNull
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.ManyToMany

@Entity
@Searchable
class Entry {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @SearchableId
    Long id

    @NotNull
    @SearchableProperty
    Date creationDate = new Date()

    @NotNull
    String text

    @ManyToOne(fetch=FetchType.LAZY)
    User createdBy

    @ManyToMany(fetch=FetchType.LAZY)
    List<User> participants

    void addToParticipants(User participant) {
        assert participant, "participant cannot be null"
        if (participants==null) {
            participants = []
        }
        if (!participants.contains(participant))
        participants << participant
    }

}
