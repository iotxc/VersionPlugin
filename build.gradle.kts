import com.iotxc.deps_plugin.*

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlinVersion by extra("1.4.10")
    val android by extra("com.android.tools.build:gradle:4.1.1")
    val depsPlugin by extra("com.github.iotxc:deps_plugin:snapshot")
    val publish by extra("com.github.dcendents:android-maven-gradle-plugin:2.1")
    repositories {
        google()
        jcenter()
        maven { setUrl("depsplugin") }
        maven { setUrl("https://jitpack.io") }
    }
    dependencies {
        classpath(android)
        classpath(kotlin(module = "gradle-plugin", version = kotlinVersion))
        classpath(depsPlugin)
        classpath(publish)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { setUrl("depsplugin") }
        maven { setUrl("https://jitpack.io") }
    }

    project.apply(plugin = DEP_PLUGIN_ID)
}

subprojects {
    versionConfig {
        releaseCheck = true

        extLibUrl = "http://10.10.105.38/D%3A/Doc/test.txt"
        jarPath = project.rootProject.name
        jarExcludeList = mutableListOf("xUitls-1.6.9.jar")

        defVersion {
            applicationId = "com.iotxc.version_plugin_test"
            compile_sdk = 29
            build_tools = "29.0.3"
            version_name = "1.0.1"
        }
    }

    project.apply(
        plugin = if ("app" == project.name) {
            PLUGIN_APPLICATION
        } else {
            PLUGIN_LIBRARY
        }
    )
}

tasks.register<Delete>("clean") {
    delete(buildDir)
}

