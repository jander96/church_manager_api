package com.devj.church_manager.curch.domain.models

import java.time.LocalDateTime


data class ChurchModel(
    val id: Long,
    val name: String,
    val denomination: String,
    val address: String,
    val lat: Double,
    val lng: Double,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
