

object SupportLibs {
    const val CoreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val Appcompat = "androidx.appcompat:appcompat:1.6.0"
    const val Material = "com.google.android.material:material:1.7.0"
    const val CoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
    const val CoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
    const val LifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    const val ActivityKtx = "androidx.activity:activity-ktx:1.6.1"
    const val Splashscreen = "androidx.core:core-splashscreen:1.0.0"
    const val DataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
}

object ComposeLibs {
    const val Bom = "androidx.compose:compose-bom:${Versions.composeBom}"
    const val UI = "androidx.compose.ui:ui"
    const val Activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val Material = "androidx.compose.material:material"
    const val Runtime = "androidx.compose.runtime:runtime"
    const val Foundation = "androidx.compose.foundation:foundation"
    const val ConstraintLayout = "androidx.constraintlayout:constraintlayout-compose"
    const val MaterialIcons = "androidx.compose.material:material-icons-core"
    const val MaterialExtended = "androidx.compose.material:material-icons-extended"
    const val WindowSize = "androidx.compose.material3:material3-window-size-class"
    const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeLifecycleViewModel}"
    const val UITooling = "androidx.compose.ui:ui-tooling:${Versions.composeTooling}"
    const val Manifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeTooling}"
    const val Preview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeTooling}"
    const val Coil = "io.coil-kt:coil-compose:${Versions.coil}"
}

object NavigationLib {
    const val DestinationCore = "io.github.raamcosta.compose-destinations:core:${Versions.destination}"
    const val DestinationAnimation = "io.github.raamcosta.compose-destinations:animations-core:${Versions.destination}"
    const val DestinationKsp = "io.github.raamcosta.compose-destinations:ksp:${Versions.destination}"
    const val Navigation = "androidx.navigation:navigation-compose"
}

object AccompanistLib {
    const val SystemUIController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanistSystUiController}"
    const val Pager = "com.google.accompanist:accompanist-pager:${Versions.accompanistPager}"
    const val PagerIndicators = "com.google.accompanist:accompanist-pager-indicators:${Versions.accompanistPager}"
}

object DaggerHilt {
    const val Android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val Compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val Compose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltCompose}"
}

object TestingLib {
    const val JUnit = "junit:junit:4.13.2"
}

object AndroidTestLib {
    const val JUnitCompose = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val UITest = "androidx.compose.ui:ui-test-manifest"
    const val EspressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}