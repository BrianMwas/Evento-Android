import extensions.*
import org.gradle.kotlin.dsl.implementation
import org.gradle.kotlin.dsl.kapt

plugins {
    id("commons.android-feature")
    id("commons.android-comp")
    id("commons.dagger-hilt")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "events")
}

dependencies {
    implementation("androidx.core:core-ktx:+")
    THEME
    EVENTOFRAMEWORK
    PROVIDER
    addComposeDependency()
    addNavigationDependency()

    implementation(DaggerHilt.Android)
    kapt(DaggerHilt.Compiler)
    implementation(DaggerHilt.Compose)
    implementation(ComposeLibs.MaterialExtended)
}