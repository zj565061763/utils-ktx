package com.sd.lib.utils.ktx

import com.sd.lib.ctx.fContext

/**
 * 根据文件名获取图片资源ID
 */
fun fResIdOfDrawable(name: String): Int? {
    val resId = try {
        val resources = fContext.resources
        resources.getIdentifier(name, "drawable", fContext.packageName)
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }
    return if (resId == 0) null else resId
}

/**
 * 返回资源ID对应的字符串
 */
fun Int.fResString(): String {
    return fContext.getString(this)
}

/**
 * 返回资源ID对应的字符串
 */
fun Int.fResString(vararg args: Any): String {
    return fContext.getString(this, *args)
}