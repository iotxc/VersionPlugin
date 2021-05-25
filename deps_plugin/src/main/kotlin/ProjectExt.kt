import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.iotxc.deps_plugin.VersionPlugin
import com.iotxc.deps_plugin.api
import com.iotxc.deps_plugin.deps.AndroidX
import com.iotxc.deps_plugin.deps.BuildConfig
import com.iotxc.deps_plugin.deps.Deps
import com.iotxc.deps_plugin.deps.Google
import com.iotxc.deps_plugin.deps.Kotlin
import com.iotxc.deps_plugin.deps.Repositories
import com.iotxc.deps_plugin.deps.Testing
import com.iotxc.deps_plugin.deps.Testing.androidTestImplementation
import com.iotxc.deps_plugin.deps.Testing.testImplementation
import com.iotxc.deps_plugin.deps.Versions
import com.iotxc.deps_plugin.implementation
import com.iotxc.deps_plugin.task.VersionExtension
import org.gradle.api.GradleException
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.withType

/**
 * library Module 公共依赖
 */
fun Project.configLibraryDependencies() {
    dependencies.apply {
        add(implementation, fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        add(api, Kotlin.ktstd)
        add(api, AndroidX.core_ktx)
        add(api, AndroidX.compat)
        add(api, Google.design)
        add(api, AndroidX.constraintLayout)
        configTestDependencies()
    }
}

/**
 * app Module 公共依赖
 */
fun Project.configAppDependencies() {
    dependencies.apply {
        add(implementation, fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        add(implementation, Kotlin.ktstd)
        add(implementation, AndroidX.core_ktx)
        add(implementation, AndroidX.compat)
        add(implementation, Google.design)
        add(implementation, AndroidX.constraintLayout)
        configTestDependencies()
    }
}

/**
 * test 依赖配置
 */
fun DependencyHandler.configTestDependencies() {
    testImplementation(Testing.testLibraries)
    androidTestImplementation(Testing.androidTestLibraries)
}

/**
 * kotlin 插件
 */
fun Project.configCommonPlugin() {
    plugins.apply("kotlin-android")
}

/**
 * app Module 配置项，此处固定了 applicationId
 */
fun AppExtension.applyAppCommons(project: Project) {
    if (BuildConfig.applicationId.isEmpty()) {
        throw GradleException(
            "Please set applicationId first in com.pateo.deps_plugin.task.VersionExtension！\n" +
                    "eg: defVersion {\n" +
                    "       applicationId = \"com.android.example\"\n" +
                    "    }"
        )
    }

    defaultConfig { applicationId = BuildConfig.applicationId }
    applyBaseCommons(project)
}

/**
 * library Module 配置项
 */
fun LibraryExtension.applyLibraryCommons(project: Project) {
    applyBaseCommons(project)
}

fun BaseExtension.applyBaseCommons(project: Project) {
    compileSdkVersion(BuildConfig.compileSdkVersion)

    defaultConfig {
        minSdkVersion(BuildConfig.minSdkVersion)
        targetSdkVersion(BuildConfig.targetSdkVersion)
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName
        testInstrumentationRunner = BuildConfig.runner
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    project.tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    @Suppress("UnstableApiUsage")
    buildFeatures.viewBinding = true

    VersionPlugin.logger(
        "\ncompileSdkVersion = ${BuildConfig.compileSdkVersion}\n" +
                "buildToolsVersion = ${BuildConfig.buildToolsVersion}\n" +
                "versionName = ${BuildConfig.versionName}\n"
    )
}

/**
 * 配置扩展属性的扩展方法
 */
fun Project.versionConfig(block: VersionExtension.() -> Unit) {
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("VersionExt", block)
}

//val Project.deps: Deps
//    get() = Deps
//
//val Project.androidX: AndroidX
//    get() = AndroidX
//
//val Project.buildConfig: BuildConfig.Companion
//    get() = BuildConfig.Companion
//
//val Project.kotlin: Kotlin
//    get() = Kotlin
//
//val Project.pateo: Repositories
//    get() = Repositories
//
//val Project.testing: Testing
//    get() = Testing
//
//val Project.versions: Versions
//    get() = Versions

val DependencyHandlerScope.DepThird: Deps
    get() = Deps

val DependencyHandlerScope.DepAndroid: AndroidX
    get() = AndroidX

val DependencyHandlerScope.DepGoogle: Google
    get() = Google

val Project.buildConfig: BuildConfig.Companion
    get() = BuildConfig.Companion

val DependencyHandlerScope.DepKotlin: Kotlin
    get() = Kotlin

val DependencyHandlerScope.DepPateo: Repositories
    get() = Repositories

val DependencyHandlerScope.DepTest: Testing
    get() = Testing

val Project.versions: Versions
    get() = Versions