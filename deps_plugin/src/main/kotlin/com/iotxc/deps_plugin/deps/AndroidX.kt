package com.iotxc.deps_plugin.deps

/**
 * Author     : iot_xc
 * Date       : 2021/4/20
 * Version    : V1.0
 * Description: 描写描述
 */
object AndroidX {
    var core_ktx                = "androidx.core:core-ktx:${Versions.ktx}"
    var recyclerView            = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    var constraintLayout        = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    var legacy                  = "androidx.legacy:legacy-support-v4:${Versions.androidx_legacy}"
    var compat                  = "androidx.appcompat:appcompat:${Versions.androidx}"
    var media                   = "androidx.media:media:${Versions.androidx_media}"
    var lifecycleExt            = "androidx.lifecycle:lifecycle-extensions:${Versions.androidx_lifecycle}"
    var livedata                = "androidx.lifecycle:lifecycle-livedata:${Versions.androidx_lifecycle}"
    var viewmodel               = "androidx.lifecycle:lifecycle-viewmodel:${Versions.androidx_lifecycle}"
    var livedata_ktx            = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidx_lifecycle}"
    var viewmodel_ktx           = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidx_lifecycle}"
    var lifecycle_common        = "androidx.lifecycle:lifecycle-common:${Versions.androidx_lifecycle}"
    var annotation              = "androidx.annotation:annotation:${Versions.androidx_annotation}"
    var viewbinding             = "androidx.databinding:viewbinding:${Versions.androidx_viewbinding}"
    var navi_fragment           = "androidx.navigation:navigation-fragment:${Versions.jetpack_nav}"
    var navi_ui                 = "androidx.navigation:navigation-ui:${Versions.jetpack_nav}"
    var navi_fragment_ktx       = "androidx.navigation:navigation-fragment-ktx:${Versions.jetpack_nav}"
    var navi_ui_ktx             = "androidx.navigation:navigation-ui-ktx:${Versions.jetpack_nav}"
    var navi_runtime            = "androidx.navigation:navigation-runtime:${Versions.jetpack_nav}"
    var navi_runtime_ktx        = "androidx.navigation:navigation-runtime-ktx:${Versions.jetpack_nav}"
    var navi_test               = "androidx.navigation:navigation-testing:${Versions.jetpack_nav}"
    var navi_dynamic            = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.jetpack_nav}"
    var navi_compose            = "androidx.navigation:navigation-compose:${Versions.jetpack_compose}"
    var navi_safe_args_plugin   = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.jetpack_nav}"
    var startup                 = "androidx.startup:startup-runtime:${Versions.jetpack_startup}"
    var datastore               = "androidx.datastore:datastore:${Versions.jetpack_datastore}"
    var datastore_core          = "androidx.datastore:datastore-core:${Versions.jetpack_datastore}"
    var datastore_prefs         = "androidx.datastore:datastore-preferences:${Versions.jetpack_datastore}"
    var datastore_prefs_core    = "androidx.datastore:datastore-preferences-core:${Versions.jetpack_datastore}"
}