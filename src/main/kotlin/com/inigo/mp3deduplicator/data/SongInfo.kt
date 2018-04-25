package com.inigo.mp3deduplicator.data

import java.text.Normalizer

data class SongInfo(val title: String = "",
                    val path: String = "",
                    val hash: String = Normalizer
                .normalize(title.toLowerCase(),
                        Normalizer.Form.NFD).replace("[^a-z0-9]".toRegex(),
                        "")){
    val MIN_ACCEPTABLE_HASH_SIZE = 4

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other?.javaClass != javaClass) {
            return false
        }
        other as SongInfo
        if (other.hash.length < MIN_ACCEPTABLE_HASH_SIZE || hash.length < MIN_ACCEPTABLE_HASH_SIZE){
            return false
        }
        return if (other.hash.length > hash.length) other.hash.contains(hash) else hash.contains(other.hash)
    }

    override fun toString(): String {
        return hash
    }
}