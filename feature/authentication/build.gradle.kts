import extensions.THEME
import extensions.addNavigationDependency

plugins {
    id("commons.android-feature")
    id("commons.android-comp")
    id("com.google.devtools.ksp")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "authentication")
}

dependencies {
    THEME
    addNavigationDependency()
}