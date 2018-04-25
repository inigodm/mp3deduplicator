package com.inigo.mp3deduplicator

import com.inigo.mp3deduplicator.data.SongInfo
import org.junit.Assert
import org.junit.Test
import java.util.stream.Collectors

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

    @Test
    fun testTwoEqualSongs(){
        var si = SongInfo("Thunderstruck", "/music/thunderstruck.mp3")
        var si2 = SongInfo("Thunderstruck", "/music/thunderstruck.mp3")
        assertDeduplication(listOf<SongInfo>(si, si2), listOf<SongInfo>(si, si2))
    }

    private fun assertDeduplication(songs: List<SongInfo>, expectedDups: List<SongInfo>){
        var dup = Deduplicator()
        dup.findDuplicates(songs)
        var si = obtainAllSongWithDuplicatesFrom(songs)
        Assert.assertTrue(haveSameElements(si, expectedDups))
    }

    private fun obtainAllSongWithDuplicatesFrom(songs: List<SongInfo>): List<SongInfo>{
        return songs.parallelStream().filter({it -> !it.duplicates.isEmpty()}).collect(Collectors.toList())
    }

    private fun haveSameElements(l1: List<SongInfo>, l2: List<SongInfo>): Boolean{
        return l1.size == l2.size && l1.containsAll(l2)
    }
}