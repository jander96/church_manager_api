package com.devj.church_manager.church_person.data.repository

import com.devj.church_manager.church_person.data.tables.ChurchPerson
import org.springframework.data.jpa.repository.JpaRepository

interface ChurchPersonRepository : JpaRepository<ChurchPerson, Long> {
}