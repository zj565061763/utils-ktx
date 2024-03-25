package com.sd.lib.utils.ktx.ext

import kotlin.random.Random

class FLoopIndexer @JvmOverloads constructor(
    size: Int,
    initialIndex: Int = Random.nextInt(size)
) {
    private val _size = size
    private var _index = initialIndex

    init {
        check(size > 0)
        check(initialIndex in 0..<size)
    }

    fun get(): Int {
        return _index
    }

    fun increment(): Int {
        _index = (_index + 1).takeIf { it < _index } ?: 0
        return _index
    }
}