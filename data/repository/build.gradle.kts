import extensions.FRAMEWORK
import extensions.implementation

plugins {
    id("commons.android-library")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    FRAMEWORK
    implementation(DaggerHilt.Android)
    implementation("androidx.core:core-ktx:+")
    kapt(DaggerHilt.Compiler)
    implementation(SupportLibs.DataStore)
}