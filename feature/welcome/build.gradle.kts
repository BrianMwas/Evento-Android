import extensions.THEME
import extensions.addNavigationDependency

plugins {
    id("commons.android-feature")
    id("commons.android-comp")
    id("com.google.devtools.ksp")
}

dependencies {
    THEME
    addNavigationDependency()

    // Dagger hilt
    implementation(DaggerHilt.Android)
    kapt(DaggerHilt.Compiler)
    implementation(DaggerHilt.Compose)
}