buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("com.google.gms:google-services:4.3.15")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.google.devtools.ksp") version "1.7.20-1.0.8" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}
