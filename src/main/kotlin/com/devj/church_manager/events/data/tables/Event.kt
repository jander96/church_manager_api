package com.devj.church_manager.events.data.tables

import com.devj.church_manager.common.Auditable
import com.devj.church_manager.curch.data.table.Church
import com.devj.church_manager.persons.data.tables.Person
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity(name = "events")
data class Event(
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val dateTime: LocalDateTime,
    @ManyToOne(targetEntity = Person::class, cascade = [CascadeType.REMOVE])
    val preacher: Person,
    val sermonTitle: String,
    val bibleText: String,
    val attendance: Int,
    @ManyToOne(targetEntity = Church::class, cascade = [CascadeType.REMOVE])
    val church: Church,
    @OneToMany(targetEntity = EventSong::class,mappedBy = "event", cascade = [CascadeType.ALL], orphanRemoval = true)
    val eventSongs: List<EventSong> = mutableListOf()
) : Auditable()