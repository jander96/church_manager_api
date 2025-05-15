package com.devj.church_manager.persons.data.tables

import com.devj.church_manager.church_person.data.tables.ChurchPerson
import com.devj.church_manager.common.Auditable
import com.devj.church_manager.events.data.tables.Event
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name = "persons")
data class Person(
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val role: String,
    val imageId: Int,
    @OneToMany(targetEntity = Event::class, cascade = [CascadeType.REMOVE], mappedBy = "preacher")
    val events :List<Event>,
    @OneToMany(targetEntity = ChurchPerson::class, cascade = [CascadeType.REMOVE], mappedBy = "person")
    val churchPerson: List<ChurchPerson> = emptyList()
) : Auditable()
