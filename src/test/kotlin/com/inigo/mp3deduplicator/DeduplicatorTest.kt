package com.inigo.mp3deduplicator

import org.junit.Assert
import org.junit.Test

class DeduplicatorTest {
    @Test
    fun testVoidPath(){
        var dup = Deduplicator()
        var si = dup.deduplicate("")
        Assert.assertEquals("", si.title)
        Assert.assertEquals("", si.path)
    }
}