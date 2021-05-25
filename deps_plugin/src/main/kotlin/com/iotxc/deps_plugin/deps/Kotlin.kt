package com.iotxc.deps_plugin.deps

/**
 * Author     : iot_xc
 * Date       : 2021/5/6
 * Email      : chaoxu@pateo.com.cn
 * Description: 描写描述
 */
object Kotlin{
    var plugin                = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    var ktstd_jdk7            = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    var ktstd                 = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    var test                  = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    var coroutinesCore        = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kt_coroutines}"
    var coroutinesAndroid     = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kt_coroutines}"
}