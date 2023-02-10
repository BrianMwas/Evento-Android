import extensions.*

plugins {
    id("commons.android-feature")
    id("commons.android-comp")
    id("com.google.devtools.ksp")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "home")
}

dependencies {
    THEME
    FEATURE_EVENTS
    FEATURE_TICKETS
    FEATURE_PROFILE
    PROVIDER
    addNavigationDependency()
}