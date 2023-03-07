import extensions.FRAMEWORK
import extensions.REPOSITORY
import extensions.implementation

plugins {
    id("commons.android-library")
    id("dagger.hilt.android.plugin")
}

dependencies {
    FRAMEWORK
    REPOSITORY
    implementation(DaggerHilt.Android)
    kapt(DaggerHilt.Compiler)
}