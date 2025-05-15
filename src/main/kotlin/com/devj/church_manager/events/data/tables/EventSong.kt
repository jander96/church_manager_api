package com.devj.church_manager.events.data.tables

import com.devj.church_manager.common.Auditable
import com.devj.church_manager.songs.data.tables.Song
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "event_songs")
data class EventSong(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @ManyToOne(targetEntity = Event::class, cascade = [CascadeType.REMOVE])
    val event: Event,
    @ManyToOne(targetEntity = Song::class, cascade = [CascadeType.REMOVE])
    val song: Song,
    @JoinColumn(name = "song_order")
    val songOrder: Int
) : Auditable()