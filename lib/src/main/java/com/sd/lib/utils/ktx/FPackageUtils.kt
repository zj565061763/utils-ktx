package com.sd.lib.utils.ktx

import android.app.ActivityManager
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.PackageManager.PackageInfoFlags
import android.os.Build
import android.os.Process
import com.sd.lib.ctx.fContext

private val packageManager = fContext.packageManager

/**
 * 当前App的版本信息
 */
fun fVersionCode(): Long {
    val packageInfo = fPackageInfo()
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        packageInfo.longVersionCode
    } else {
        packageInfo.versionCode.toLong()
    }
}

/**
 * 当前App的版本信息
 */
fun fVersionName(): String {
    return fPackageInfo().versionName
}

/**
 * 当前App的包信息
 */
fun fPackageInfo(flags: Int = PackageManager.GET_CONFIGURATIONS): PackageInfo {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        packageManager.getPackageInfo(fContext.packageName, PackageInfoFlags.of(flags.toLong()))
    } else {
        packageManager.getPackageInfo(fContext.packageName, flags)
    }
}

/**
 * 启动某个App，默认启动自身
 */
fun fStartApp(packageName: String = fContext.packageName) {
    try {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        fContext.startActivity(intent)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * 当前是否主进程
 */
fun fIsMainProcess(): Boolean {
    return fProcessName() == fContext.packageName
}

/**
 * 进程名称
 */
fun fProcessName(): String {
    val manager = fContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val list = manager.runningAppProcesses
    if (list.isNullOrEmpty()) return ""
    val pid = Process.myPid()
    return list.find { it.pid == pid }?.processName ?: ""
}