import extensions.EVENTOFRAMEWORK
import extensions.PROVIDER
import extensions.THEME
import extensions.addNavigationDependency

plugins {
    id("commons.android-feature")
    id("commons.android-comp")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.android")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "profile")
}

dependencies {
    THEME
    PROVIDER
    EVENTOFRAMEWORK

    implementation(ComposeLibs.Blur)
    implementation(ComposeLibs.MaterialExtended)
    implementation("androidx.core:core-ktx:+")
    addNavigationDependency()
}