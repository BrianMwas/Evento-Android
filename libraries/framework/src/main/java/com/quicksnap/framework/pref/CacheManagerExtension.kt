package com.quicksnap.framework.pref

import android.content.Context
import android.content.SharedPreferences

fun Context.getPrefs(fileName: String? = null): SharedPreferences {
    val name = if(fileName.isNullOrBlank()) {
        getDefaultSharedPrefName()
    } else {
        fileName.toString()
    }

    return this.getSharedPreferences(name, Context.MODE_PRIVATE)
}

fun Context.getDefaultSharedPrefName(): String {
    return this.packageName + "_prefs"
}