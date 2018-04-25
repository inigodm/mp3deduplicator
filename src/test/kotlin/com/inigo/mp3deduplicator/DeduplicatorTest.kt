package com.inigo.mp3deduplicator

import com.inigo.mp3deduplicator.data.SongInfo
import org.junit.Assert
import org.junit.Test

class DeduplicatorTest {
    @Test
    fun testVoid(){
        assertDeduplication(listOf<SongInfo>(), listOf<SongInfo>())
    }

    @Test
    fun testOneSong(){
        var si = SongInfo("Thunderstruck", "/music/thunderstruck.mp3")
        assertDeduplication(listOf<SongInfo>(si), listOf<SongInfo>())
    }

    @Test
    fun testTwoDifferentSongs(){
        var si = SongInfo("Thunderstruck", "/music/thunderstruck.mp3")
        assertDeduplication(listOf<SongInfo>(si, SongInfo("Take me to the moon", "/music/takemetothemoon.mp3")), listOf<SongInfo>())
    }

    fun assertDeduplication(songsInDirectory: List<SongInfo>, expectedSongInfo: List<SongInfo>){
        var dup = Deduplicator()
        var si = dup.deduplicate(songsInDirectory)
        Assert.assertEquals(expectedSongInfo, si)
    }
}