package com.iotxc.deps_plugin.deps

/**
 * Author     : iot_xc
 * Date       : 2021/4/22
 * Version    : V1.0
 * Description: 描写描述
 */
class BuildConfig {
    companion object{
        var applicationId             = Versions.applicationId
        var compileSdkVersion         = Versions.compile_sdk
        var buildToolsVersion         = Versions.build_tools
        var minSdkVersion             = Versions.min_sdk
        var targetSdkVersion          = Versions.target_sdk
        var versionCode               = Versions.version_code
        var versionName               = Versions.version_name
        var runner                    = "androidx.test.runner.AndroidJUnitRunner"
    }
}
