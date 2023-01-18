package commons

import DaggerHilt
import extensions.implementation
import extensions.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android.plugin")
}

dependencies {
    implementation(DaggerHilt.Android)
    kapt(DaggerHilt.Compiler)
}