plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.quicksnap.testutils"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api("junit:junit:4.13.2")
    api("androidx.test.ext:junit:1.1.5")
    api("androidx.test.espresso:espresso-core:3.5.1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    api("com.google.truth:truth:1.1.3")
    api("org.robolectric:robolectric:4.8.1")
    api("app.cash.turbine:turbine:0.7.0")
    api("io.mockk:mockk:1.13.3")
    api("org.hamcrest:hamcrest-library:2.2")
    api("org.json:json:20210307")
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")
    implementation("androidx.core:core-ktx:+")
}