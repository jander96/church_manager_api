package com.devj.church_manager.events.data.repo

import com.devj.church_manager.events.data.tables.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository : JpaRepository<Event, Long> {
}