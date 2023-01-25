package com.quicksnap.framework.pref

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.quicksnap.framework.extension.fromJson
import com.quicksnap.framework.extension.fromJsonList
import com.quicksnap.framework.extension.toJson

class CacheManager (private val context: Context, private val prefFileName: String? = null) {
    private val prefs: SharedPreferences = context.getPrefs(
        prefFileName ?: context.getDefaultSharedPrefName()
    )

    fun <T> read(key: String, defaultValue: T): T {
        return when(defaultValue) {
            is String -> prefs.getString(key, defaultValue as String) as T ?: defaultValue
            is Int -> prefs.getInt(key, defaultValue as Int) as T ?: defaultValue
            is Boolean -> prefs.getBoolean(key, defaultValue as Boolean) as T ?: defaultValue
            is Long -> prefs.getLong(key, defaultValue as Long) as T ?: defaultValue
            else -> defaultValue
        }
    }

    fun <T> write(key: String, value: T) {
        when(value) {
            is String -> prefs.edit { putString(key, value).apply() }
            is Int -> prefs.edit { putInt(key, value).apply() }
            is Boolean -> prefs.edit { putBoolean(key, value).apply() }
            is Long -> prefs.edit { putLong(key, value).apply() }
            else -> Unit
        }
    }

    fun clear(key: String) {
        prefs.edit {
            remove(key)
        }
    }

    fun clearEverything(callback: () -> Unit) {
        prefs.edit {
            clear().commit()
            callback.invoke()
        }
    }

    /**
     * Reads json from SharedPreferences and casts it to requested type using Moshi
     * @param T Type parameter to cast Moshi to
     * @param key Key to read from
     * @return An object of requested type
     */
    inline fun <reified T> readObject(key: String): T? {
        val readValue = read(key, "")
        return if (readValue.isEmpty()) {
            null
        } else {
            readValue.fromJson()
        }
    }

    /**
     * Stores an object under given key or class name.
     * @param key Key to write object to. If not given, class name will be used
     * @param value Object to store.
     */
    fun writeObject(key: String, value: Any) {
        write(key, value.toJson())
    }

    /**
     * Read a list object from json string and casts it to requested type using Moshi
     * @param key Key to read from
     * @return List Object
     */
    inline fun <reified T> readListObject(key: String): List<T>? {
        return try {
            val value = read(key, "")
            if (value.isEmpty()) {
                null
            } else {
                value.fromJsonList<T>()
            }
        } catch (ex: Exception) {
            null
        }
    }
}