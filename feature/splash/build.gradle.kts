import extensions.DOMAIN
import extensions.FRAMEWORK
import extensions.kapt

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
}

dependencies {
    FRAMEWORK
    DOMAIN
    implementation(SupportLibs.Splashscreen)
    implementation(DaggerHilt.Android)
    kapt(DaggerHilt.Compiler)
}