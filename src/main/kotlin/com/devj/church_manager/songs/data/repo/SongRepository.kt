package com.devj.church_manager.songs.data.repo

import com.devj.church_manager.songs.data.tables.Song
import org.springframework.data.jpa.repository.JpaRepository

interface SongRepository: JpaRepository<Song, Long> {
}