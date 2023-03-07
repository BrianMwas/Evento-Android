package com.quicksnap.evento.di

import android.content.Context
import com.quicksnap.evento.app.EventoApp
import com.quicksnap.framework.base.app.AppInitializer
import com.quicksnap.framework.base.app.AppInitializerImpl
import com.quicksnap.framework.pref.CacheManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideAppInitializer(): AppInitializer {
        return AppInitializerImpl()
    }

    @Provides
    @Singleton
    fun provideCacheManager(@ApplicationContext context: Context): CacheManager {
        return CacheManager(context)
    }

    @Provides
    @Singleton
    fun provideApplication(): EventoApp {
        return EventoApp()
    }
}