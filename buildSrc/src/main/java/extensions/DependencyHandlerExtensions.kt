package extensions

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/* Add dependency to the release implementation dependency configuration
* @dependencyNotation is the dependency
* @return the dependency
* */
fun DependencyHandler.releaseImplementation(dependencyNotation: Any): Dependency? = add("releaseImplementation", dependencyNotation)

/* Add dependency to the test implementation dependency configuration
* @dependencyNotation is the dependency
* @return the dependency
* */
fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? = add("testImplementation", dependencyNotation)

/* Add dependency to the implementation dependency configuration
* @dependencyNotation is the dependency
* @return the dependency
* */
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? = add("implementation", dependencyNotation)

/* Add dependency to the api dependency configuration
* @dependencyNotation is the dependency
* @return the dependency
* */
fun DependencyHandler.api(dependencyNotation: Any): Dependency? = add("api", dependencyNotation)

/* Add dependency to the kapt dependency configuration
* @dependencyNotation is the dependency
* @return the dependency
* */
fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? = add("kapt", dependencyNotation)

/* Add dependency to the test dependency configuration
* @dependencyNotation is the dependency
* @return the dependency
* */
fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? = add("api", dependencyNotation)

/* Add dependency to the android test implementation dependency configuration
* @dependencyNotation is the dependency
* @return the dependency
* */
fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? = add("androidTestImplementation", dependencyNotation)

/* Add dependency to the ksp dependency configuration
* @dependencyNotation is the dependency
* @return the dependency
* */
fun DependencyHandler.ksp(dependencyNotation: Any): Dependency? = add("ksp", dependencyNotation)

fun DependencyHandler.addCommonDependency() {
    implementation(SupportLibs.CoreKtx)
    implementation(SupportLibs.Appcompat)
    implementation(SupportLibs.Material)
    implementation(SupportLibs.ActivityKtx)
    implementation(SupportLibs.LifecycleRuntime)
    implementation(SupportLibs.ActivityKtx)
}

fun DependencyHandler.addComposeDependency() {
    implementation(platform(ComposeLibs.Bom))
    implementation(ComposeLibs.UI)
    implementation(ComposeLibs.Material)
    implementation(ComposeLibs.Runtime)
    implementation(ComposeLibs.MaterialIcons)
    implementation(ComposeLibs.Activity)

    implementation(ComposeLibs.ViewModel)
    implementation(ComposeLibs.Preview)
    implementation(AccompanistLib.SystemUIController)
    implementation(ComposeLibs.UITooling)
    androidTestImplementation(AndroidTestLib.JUnitCompose)
    debugImplementation(ComposeLibs.Manifest)

}

fun DependencyHandler.addNavigationDependency() {
    implementation(platform(ComposeLibs.Bom))
    implementation(NavigationLib.Navigation)
    implementation(NavigationLib.DestinationCore)
    ksp(NavigationLib.DestinationKsp)
    implementation(NavigationLib.DestinationAnimation)
}

fun DependencyHandler.addTestDependencies() {
    TEST
}

fun DependencyHandler.addModuleDependency() {
    implementation(project(mapOf("path" to ":feature:authentication")))
    implementation(project(mapOf("path" to ":feature:home")))
    implementation(project(mapOf("path" to ":feature:onboarding")))
    implementation(project(mapOf("path" to ":feature:tickets")))
    implementation(project(mapOf("path" to ":feature:profile")))
    implementation(project(mapOf("path" to ":common:theme")))
    implementation(project(mapOf("path" to ":libraries:testutils")))
    implementation(project(mapOf("path" to ":libraries:framework")))
    implementation(project(mapOf("path" to ":common:provider")))
}

val DependencyHandler.FEATURE_AUTHENTICATION
    get() = implementation(project(mapOf("path" to ":feature:authentication")))

val DependencyHandler.FEATURE_HOME
    get() = implementation(project(mapOf("path" to ":feature:home")))

val DependencyHandler.FEATURE_ONBOARDING
    get() = implementation(project(mapOf("path" to ":feature:onboarding")))

val DependencyHandler.FEATURE_TICKETS
    get() = implementation(project(mapOf("path" to ":feature:tickets")))

val DependencyHandler.FEATURE_PROFILE
    get() = implementation(project(mapOf("path" to ":feature:profile")))

val DependencyHandler.PROVIDER
    get() = implementation(project(mapOf("path" to ":common:provider")))

val DependencyHandler.FRAMEWORK
    get() = implementation(project(mapOf("path" to ":libraries:framework")))


val DependencyHandler.THEME
    get() = implementation(project(mapOf("path" to ":common:theme")))

val DependencyHandler.TEST
    get() = implementation(project(mapOf("path" to ":libraries:testutils")))


