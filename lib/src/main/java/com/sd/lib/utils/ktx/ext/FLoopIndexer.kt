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
        val index = _index + 1
        _index = if (index < _size) index else 0
        return _index
    }
}