import extensions.FRAMEWORK
import extensions.implementation

plugins {
    id("commons.android-library")
    id("dagger.hilt.android.plugin")
}

dependencies {
    FRAMEWORK
    implementation(DaggerHilt.Android)
    kapt(DaggerHilt.Compiler)
    implementation(SupportLibs.DataStore)
}