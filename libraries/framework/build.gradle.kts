import extensions.*


plugins {
    id("commons.android-library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation(SupportLibs.DataStore)
    implementation(platform(Firebase.Bom))
    implementation(Firebase.firestore)

    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    implementation("com.serjltt.moshi:moshi-lazy-adapters:2.2")
    implementation("androidx.core:core-ktx:+")
}