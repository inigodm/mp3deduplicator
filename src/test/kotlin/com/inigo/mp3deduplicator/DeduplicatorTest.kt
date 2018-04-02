package com.inigo.mp3deduplicator

import com.inigo.mp3deduplicator.data.SongInfo
import org.junit.Assert
import org.junit.Test

class DeduplicatorTest {
    @Test
    fun testVoidPath(){
        assertPath(listOf<SongInfo>(), listOf<SongInfo>())
    }

    @Test
    fun testOneSongDirectory(){
        var si = SongInfo("Thunderstruck", "/music/thunderstruck.mp3")
        assertPath(listOf<SongInfo>(si), listOf<SongInfo>())
    }

    fun assertPath(songsInDirectory: List<SongInfo>, expectedSongInfo: List<SongInfo>){
        var dup = Deduplicator()
        var si = dup.deduplicate(songsInDirectory)
        Assert.assertEquals(expectedSongInfo, si)
    }
}