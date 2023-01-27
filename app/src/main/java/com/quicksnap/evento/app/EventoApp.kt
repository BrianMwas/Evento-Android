package com.quicksnap.evento.app

import com.quicksnap.framework.base.app.AppInitializer
import com.quicksnap.framework.base.app.CoreApplication
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class EventoApp: CoreApplication() {
    @Inject
    lateinit var initializer: AppInitializer

    override fun onCreate() {
        super.onCreate()
        initializer.init(this)
    }
}