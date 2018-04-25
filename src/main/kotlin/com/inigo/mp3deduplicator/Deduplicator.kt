package com.inigo.mp3deduplicator

import com.inigo.mp3deduplicator.data.SongInfo

class Deduplicator {
    var res = mutableListOf<SongInfo>()

    fun deduplicate(songs: List<SongInfo>): List<SongInfo> {
        songs.forEach { song -> checkDuplications(song, songs) }
        return res
    }

    fun checkDuplications(song: SongInfo, inSongs: List<SongInfo>){
        inSongs.parallelStream()
                .filter({it !== song && !res.contains(it)})
                .forEach({
                    println("it ${it} and song ${song}")
                    if(it.equals(song)){
                        res.add(it)
                    }
                })
    }

}