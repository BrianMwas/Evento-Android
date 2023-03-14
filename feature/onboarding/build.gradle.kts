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
    arg("compose-destinations.moduleName", "onboarding")
}

dependencies {
    implementation("androidx.core:core-ktx:+")
    THEME
    addNavigationDependency()
}