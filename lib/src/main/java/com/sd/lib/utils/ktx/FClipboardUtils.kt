package com.sd.lib.utils.ktx

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import com.sd.lib.ctx.fContext

private val clipboardManager
    get() = fContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

/**
 * 复制字符串
 */
fun fClipboardSetText(
    text: CharSequence,
    label: CharSequence = "",
) {
    val data = ClipData.newPlainText(label, text)
    fClipboardSetData(data)
}

/**
 * 粘贴字符串
 */
fun fClipboardGetText(): CharSequence? {
    val data = fClipboardGetData() ?: return null
    val item = data.getItemAt(0) ?: return null
    return item.text
}

/**
 * 设置数据
 */
fun fClipboardSetData(data: ClipData) {
    clipboardManager.setPrimaryClip(data)
}

/**
 * 获取数据
 */
fun fClipboardGetData(): ClipData? {
    val data = clipboardManager.primaryClip ?: return null
    if (data.itemCount <= 0) return null
    return data
}