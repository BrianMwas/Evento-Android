import extensions.FRAMEWORK
import extensions.REPOSITORY
import extensions.implementation

plugins {
    id("commons.android-library")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    FRAMEWORK
    REPOSITORY
    implementation(DaggerHilt.Android)
    implementation("androidx.core:core-ktx:+")
    kapt(DaggerHilt.Compiler)
}