import extensions.EVENTOFRAMEWORK
import extensions.FRAMEWORK
import extensions.THEME
import extensions.addNavigationDependency

plugins {
    id("commons.android-feature")
    id("commons.android-comp")
    id("commons.dagger-hilt")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation("androidx.core:core-ktx:+")
    THEME
    FRAMEWORK
    EVENTOFRAMEWORK
    addNavigationDependency()

    // Dagger hilt
    implementation(DaggerHilt.Android)
    kapt(DaggerHilt.Compiler)
    implementation(DaggerHilt.Compose)

    // Accompanist pager
    implementation(AccompanistLib.Pager)
    implementation(AccompanistLib.PagerIndicators)

    // More icons
    implementation(ComposeLibs.MaterialExtended)
}