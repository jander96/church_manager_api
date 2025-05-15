package com.devj.church_manager.curch.domain.models

data class ChurchCreationRequest(
    val name: String,
    val denomination: String,
    val address: String,
    val lat: Double,
    val lng: Double,
)