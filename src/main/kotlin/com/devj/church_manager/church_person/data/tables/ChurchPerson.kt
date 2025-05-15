package com.devj.church_manager.church_person.data.tables

import com.devj.church_manager.common.Auditable
import com.devj.church_manager.curch.data.table.Church
import com.devj.church_manager.persons.data.tables.Person
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity(name = "church_person")
data class ChurchPerson(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val  id: Long,
    @ManyToOne(targetEntity = Church::class)
    val church: Church,
    @ManyToOne(targetEntity = Person::class)
    val person: Person,
    val joinedAt: LocalDateTime
) : Auditable()
