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
    @SearchableProperty
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

    private void appendUser(StringBuilder sb, User u) {
        if (u) {
            sb << u.username
            sb << ' '
            sb << u.name
            sb << ' '
        }
    }

    // used for indexing the participants string
    @SearchableProperty
    String getParticipantsStr() {
        if (participants) {
            def res = new StringBuilder()
            participants.each { p->
                appendUser(res, p)
            }
            return res.toString()
        }
        return null
    }

    // used for indexing the created by field
    @SearchableProperty
    String getCreatedByStr() {
        def res = new StringBuilder()
        appendUser(res, createdBy)
        return res.toString()
    }


}
