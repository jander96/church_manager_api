package com.devj.church_manager.persons.data.repo

import com.devj.church_manager.persons.data.tables.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {
}