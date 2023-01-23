package com.quicksnap.framework.base.app

abstract class NetworkConfig {
    abstract fun baseUrl(): String
    abstract fun timeout(): Long
    open fun isDev(): Boolean = false
}