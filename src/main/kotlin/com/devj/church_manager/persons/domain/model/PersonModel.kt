package com.devj.church_manager.persons.domain.model

import java.time.LocalDateTime


data class PersonModel (
    val id: Long,
    val name: String,
    val role: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
)
