package com.inigo.mp3deduplicator

import com.inigo.mp3deduplicator.data.SongInfo
import org.junit.Assert
import org.junit.Test

class DeduplicatorTest {
    @Test
    fun testVoidPath(){
        assertPath("", SongInfo())
    }

    @Test
    fun testOneSongDirectory(){
        assertPath("/home/inigo/projectsgit/mp3deduplicator/src/test/resources/one", SongInfo())
    }

    fun assertPath(path: String, expectedSongInfo: SongInfo){
        var dup = Deduplicator()
        var si = dup.deduplicate(path)
        Assert.assertEquals(expectedSongInfo, si)
    }
}