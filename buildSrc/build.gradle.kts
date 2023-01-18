import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

gradlePlugin {
    plugins {
        register("AndroidCoreLibraryPlugin") {
            id = "android.core.library.plugin"
            implementationClass = "commons.AndroidCoreLibraryPlugin"
        }
    }
}

object Versions {
    const val Gradle = "7.2.2"
    const val KtLint = "10.2.1"
    const val Hilt = "2.44"
    const val Kotlin = "1.7.20"
    const val Spotless = "6.4.2"
    const val Detekt = "1.20.0-RC2"
}

object Deps {
    const val Gradle = "com.android.tools.build:gradle:${Versions.Gradle}"
    const val Kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}"
    const val KtLint = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.KtLint}"
    const val Spotless = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.Spotless}"
    const val Detekt = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.Detekt}"
}

dependencies {
    implementation(Deps.KtLint)
    implementation(Deps.Spotless)
    implementation(Deps.Detekt)
    implementation(Deps.Gradle)
    implementation(Deps.Kotlin)
}