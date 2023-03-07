import extensions.THEME

plugins {
    id("commons.android-feature")
    id("commons.android-comp")
}

dependencies {
    THEME
    implementation(ComposeLibs.BarCode)
    implementation ("com.journeyapps:zxing-android-embedded:4.3.0")
}