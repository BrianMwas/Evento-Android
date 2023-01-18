buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.google.devtools.ksp") version "1.7.20-1.0.8" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    //    id("com.android.application") version "7.3.1" apply false

//    id ("org.jetbrains.kotlin.android") version "1.7.20" apply false
}
