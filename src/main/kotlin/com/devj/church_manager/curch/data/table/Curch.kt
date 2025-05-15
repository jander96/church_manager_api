package com.devj.church_manager.curch.data.table

import com.devj.church_manager.church_person.data.tables.ChurchPerson
import com.devj.church_manager.common.Auditable
import com.devj.church_manager.events.data.tables.Event
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name= "churches")
data class Church(
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int,
    val name : String,
    val denomination : String,
    val address : String,
    val lat : Double,
    val lng : Double,
    @OneToMany(targetEntity = Event::class, mappedBy = "church")
    val events: List<Event>,
    @OneToMany(targetEntity = ChurchPerson::class, mappedBy = "church")
    val churchPerson: List<ChurchPerson> = emptyList()
) : Auditable()
