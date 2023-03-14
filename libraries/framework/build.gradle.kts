import extensions.*


plugins {
    id("commons.android-library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation(SupportLibs.DataStore)
    implementation(platform(Firebase.Bom))
    implementation(Firebase.firestore)
    implementation("androidx.core:core-ktx:+")
}