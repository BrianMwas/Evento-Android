import extensions.*
import org.gradle.kotlin.dsl.implementation

plugins {
    id("commons.android-feature")
    id("commons.android-comp")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "tickets")
}

dependencies {
    THEME
    PROVIDER
    QR_CODE
    FEATURE_EVENTS
    EVENTOFRAMEWORK
    /// Generate a bar code
    implementation(ComposeLibs.BarCode)
    implementation(ComposeLibs.MaterialExtended)
    implementation("androidx.core:core-ktx:+")
    addNavigationDependency()
}