package com.devj.church_manager.songs.domain.model

import java.time.LocalDateTime


data class SongModel(
    val id: Long,
    val title: String,
    val author: String,
    val lyricsExcerpt: String,
    val key: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)