package com.devj.church_manager.curch.data.table

import org.springframework.data.jpa.repository.JpaRepository

interface ChurchRepository : JpaRepository<Church, Long> {
}