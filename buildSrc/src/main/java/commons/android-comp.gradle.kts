package commons

import extensions.addComposeDependency

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    addComposeConfig()
}

dependencies {
    addComposeDependency()
}