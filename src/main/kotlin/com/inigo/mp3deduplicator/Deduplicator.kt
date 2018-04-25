package com.inigo.mp3deduplicator

import com.inigo.mp3deduplicator.data.SongInfo

class Deduplicator {

    fun findDuplicates(songs: List<SongInfo>) {
        songs.forEach { song -> checkDuplications(song, songs) }
    }

    private fun checkDuplications(song: SongInfo, inSongs: List<SongInfo>){
        inSongs.parallelStream()
                .filter({it !== song && !song.duplicates.contains(it)})
                .forEach({
                    println("it ${it} and song ${song}")
                    if(it.equals(song)){
                        song.duplicates.add(it)
                    }
                })
    }

}