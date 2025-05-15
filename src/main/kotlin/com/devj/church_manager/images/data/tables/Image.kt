package com.devj.church_manager.images.data.tables

import com.devj.church_manager.common.Auditable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "images")
data class Image(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val url: String,
    val description: String?,
    val entityType: String,
    val entityId: Int
) : Auditable()