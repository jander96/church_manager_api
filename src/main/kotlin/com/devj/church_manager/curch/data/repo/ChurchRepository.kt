package com.devj.church_manager.curch.data.repo

import com.devj.church_manager.curch.data.table.Church
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface ChurchRepository : JpaRepository<Church, Long> {
    override  fun findAll(pageable: Pageable): Page<Church>
}