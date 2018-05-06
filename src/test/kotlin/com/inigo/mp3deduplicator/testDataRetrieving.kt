package com.inigo.mp3deduplicator

import com.inigo.mp3deduplicator.songinfobuilders.SongInfoBuilder
import org.junit.Assert
import org.junit.Test

class testDataRetrieving {
    @Test
    fun noFile(){
        Assert.assertNotNull(SongInfoBuilder())
    }

}