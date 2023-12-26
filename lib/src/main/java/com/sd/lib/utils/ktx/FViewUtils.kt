package com.sd.lib.utils.ktx

import android.view.View

/**
 * 设置View的宽度
 */
fun View?.fSetWidth(value: Int) {
    if (this == null) return
    val params = this.layoutParams ?: return
    if (params.width != value) {
        params.width = value
        this.layoutParams = params
    }
}

/**
 * 设置View的高度
 */
fun View?.fSetHeight(value: Int) {
    if (this == null) return
    val params = this.layoutParams ?: return
    if (params.height != value) {
        params.height = value
        this.layoutParams = params
    }
}

/**
 * 设置View的宽高
 */
fun View?.fSetSize(width: Int, height: Int) {
    if (this == null) return
    val params = this.layoutParams ?: return
    if (params.width != width || params.height != height) {
        params.width = width
        params.height = height
        this.layoutParams = params
    }
}