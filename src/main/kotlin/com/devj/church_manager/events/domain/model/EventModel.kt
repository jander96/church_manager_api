package com.devj.church_manager.events.domain.model
import com.devj.church_manager.curch.domain.models.ChurchModel
import com.devj.church_manager.persons.domain.model.PersonModel
import java.time.LocalDateTime

data class EventModel(

    val id: Long,
    val dateTime: LocalDateTime,
    val preacher: PersonModel,
    val sermonTitle: String,
    val bibleText: String,
    val attendance: Int,
    val church: ChurchModel,
    val updatedAt: LocalDateTime,
    val createdAt: LocalDateTime
)