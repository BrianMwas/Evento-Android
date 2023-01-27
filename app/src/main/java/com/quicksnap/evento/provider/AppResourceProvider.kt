package com.quicksnap.evento.provider

import android.content.Context
import com.quicksnap.provider.ResourceProvider
import javax.inject.Inject

class AppResourceProvider @Inject constructor(private val context: Context): ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}