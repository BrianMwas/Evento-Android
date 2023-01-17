package commons
import com.android.build.api.dsl.CommonExtension

/*
* Add base compose configurations
* */
fun CommonExtension<*, *, *, *>.addComposeConfig() {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
        }
    }
}

/* Add base default android config*/
fun CommonExtension<*, *, *, *>.addDefaultConfig() {
    defaultConfig {
        compileSdk = ConfigData.compileSdkVersion
        minSdk = ConfigData.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}