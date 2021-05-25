package com.iotxc.deps_plugin.deps

import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Author     : iot_xc
 * Date       : 2021/4/22
 * Version    : V1.0
 * Description: 描写描述
 */
object Testing {
    private var testImplementation            = "testImplementation"
    private var androidTestImplementation     = "androidTestImplementation"

    private var jUnit                         = "junit:junit:${Versions.junit}"
    private var androidJunit                  = "androidx.test.ext:junit:${Versions.junit_ext}"
    private var androidRunner                 = "androidx.test:runner:${Versions.androidx_test_runner}"
    private var espresso                      = "androidx.test.espresso:espresso-core:${Versions.androidx_test_esp}"

    val androidTestLibraries = arrayListOf<String>().apply {
        add(androidJunit)
        add(androidRunner)
        add(espresso)
    }

    fun DependencyHandler.androidTestImplementation(list: List<String>) {
        list.forEach { dependency ->
            add(androidTestImplementation, dependency)
        }
    }

    val testLibraries = arrayListOf<String>().apply {
        add(jUnit)
    }

    fun DependencyHandler.testImplementation(list: List<String>) {
        list.forEach { dependency ->
            add(testImplementation, dependency)
        }
    }


}