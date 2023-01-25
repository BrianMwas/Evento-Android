package com.quicksnap.evento.provider

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.quicksnap.evento.R
import com.quicksnap.framework.pref.getPrefs
import com.quicksnap.provider.ThemeProvider
import kotlinx.coroutines.flow.*

class AppThemeProvider constructor(private val context: Context): ThemeProvider {
    private val sharedPreferences = context.getPrefs()

    private val defaultThemeValue = context.getString(R.string.pref_default_theme_value)

    private val preferenceKeyChangeFlow = MutableSharedFlow<String>(extraBufferCapacity = 1)

    private val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
        preferenceKeyChangeFlow.tryEmit(key)
    }

    companion object {
        const val KEY_THEME = "pref_theme"
    }

    init {
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
    }
    
    override var theme: ThemeProvider.Theme
        get() = getThemeForStorageValue(sharedPreferences.getString(KEY_THEME, defaultThemeValue)!!)
        set(value) = sharedPreferences.edit {
            putString(KEY_THEME, value.storageKey)
        }

    private fun getThemeForStorageValue(value: String)= when (value) {
        context.getString(R.string.pref_light_mode_value) -> ThemeProvider.Theme.LIGHT
        context.getString(R.string.dark_mode_value) -> ThemeProvider.Theme.DARK
        else -> ThemeProvider.Theme.SYSTEM
    }

    private val ThemeProvider.Theme.storageKey: String
        get() = when (this) {
            ThemeProvider.Theme.LIGHT -> context.getString(R.string.pref_light_mode_value)
            ThemeProvider.Theme.DARK -> context.getString(R.string.dark_mode_value)
            ThemeProvider.Theme.SYSTEM -> context.getString(R.string.system_mode_value)
        }

    override fun observeTheme(): Flow<ThemeProvider.Theme> {
        return preferenceKeyChangeFlow.onStart {
            emit(KEY_THEME)

        }
            .filter { it == KEY_THEME }
            .map { theme }
            .distinctUntilChanged()
    }

    override fun isNightMode(): Boolean {
        return theme == ThemeProvider.Theme.DARK
    }

    override fun setNightMode(forceNight: Boolean) {
        theme = if (forceNight) {
            ThemeProvider.Theme.DARK
        } else {
            ThemeProvider.Theme.LIGHT
        }
    }
}