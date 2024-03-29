import extensions.*

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
}

android {
    signingConfigs {
        create("release") {
            storeFile = file("/Users/brian/Documents/Private/evento")
            storePassword = "Evento2023"
            keyAlias = "upload"
            keyPassword = "EventoUpload2023"
        }
    }
    namespace  ="com.quicksnap.evento"
    compileSdk  = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId  ="com.quicksnap.evento"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables{
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/*")
        }
    }
}

android.applicationVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName("main") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:+")
    // Module Dependencies
    addModuleDependency()
    // Common
    addCommonDependency()
    // Compose
    addComposeDependency()

    // Navigation deps
    addNavigationDependency()

    implementation(DaggerHilt.Android)
    implementation(DaggerHilt.Compose)
    implementation(platform(Firebase.Bom))
    implementation(Firebase.facebook)
    implementation(Firebase.auth)

    kapt(DaggerHilt.Compiler)
}

kapt {
    correctErrorTypes = true
}