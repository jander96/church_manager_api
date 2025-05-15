package com.devj.church_manager.songs.data.tables

import com.devj.church_manager.common.Auditable
import com.devj.church_manager.events.data.tables.EventSong
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity(name = "songs")
data class Song(
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val title: String,
    val author: String,
    val lyricsExcerpt: String,
    val key: String,
    @OneToMany(targetEntity = EventSong::class, mappedBy = "song", cascade = [CascadeType.ALL], orphanRemoval = true)
    val eventSongs: List<EventSong> = mutableListOf()
) : Auditable()