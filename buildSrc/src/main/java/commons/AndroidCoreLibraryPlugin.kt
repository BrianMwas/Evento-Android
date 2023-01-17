package commons

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.api.dsl.BuildType
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType

class AndroidCoreLibraryPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.applyPlugins()
    }

    private fun Project.applyPlugins() {
        plugins.apply("com.android.library")
        plugins.apply("org.jetbrains.kotlin.android")
        plugins.apply("com.google.devtools.ksp")
        plugins.apply("org.jetbrains.kotlin.kapt")
    }

    private fun Project.configureAndroid() = extensions.getByType(LibraryExtension::class).run {
        compileSdk = ConfigData.compileSdkVersion
        defaultConfig {
            minSdk = ConfigData.minSdkVersion
            targetSdk = ConfigData.targetSdkVersion
            testInstrumentationRunner = ConfigData.androidJunitRunner
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }
}