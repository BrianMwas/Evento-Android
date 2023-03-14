import extensions.DOMAIN
import extensions.FRAMEWORK
import extensions.kapt

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    FRAMEWORK
    DOMAIN
    implementation(SupportLibs.Splashscreen)
    implementation(DaggerHilt.Android)
    implementation("androidx.core:core-ktx:+")
    kapt(DaggerHilt.Compiler)
}