package com.sd.lib.utils.ktx

/**
 * 按[chunks]指定的个数分组
 */
fun <E, R> Iterable<E>.fChunkedList(
    vararg chunks: Int,
    factory: (chunk: Int, list: List<E>) -> R,
): List<R> {
    require(chunks.isNotEmpty()) { "chunks is empty." }

    val listResult = mutableListOf<R>()

    var groupIndex = 0
    var groupSize = chunks[groupIndex]
    val groupList = mutableListOf<E>()

    for (item in this) {
        check(groupSize > 0)
        groupList.add(item)
        if (groupList.size >= groupSize) {
            listResult.add(factory(groupSize, groupList.toList()))

            groupIndex = (groupIndex + 1).let { if (it > chunks.lastIndex) 0 else it }
            groupSize = chunks[groupIndex]
            groupList.clear()
        }
    }

    if (groupList.isNotEmpty()) {
        listResult.add(factory(groupSize, groupList.toList()))
    }

    return listResult
}