import extensions.THEME
import extensions.addComposeDependency
import extensions.addNavigationDependency

plugins {
    id("commons.android-feature")
    id("commons.android-comp")
    id("com.google.devtools.ksp")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "events")
}

dependencies {
    THEME
    addComposeDependency()
    addNavigationDependency()
}