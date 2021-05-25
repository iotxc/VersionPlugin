package com.iotxc.deps_plugin.deps

/**
 * Author     : iot_xc
 * Date       : 2021/4/20
 * Version    : V1.0
 * Description: 描写描述
 */
object Deps {
    val extLib = mutableMapOf<String, String>()

    var rxjava                    = "io.reactivex.rxjava3:rxjava:${Versions.rxjava}"
    var rxAndroid                 = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    var rxlifecycleCmp            = "com.trello.rxlifecycle2:rxlifecycle-components:${Versions.rxlifecycle}"
    var rxlifecycleNavi           = "com.trello.rxlifecycle2:rxlifecycle-navi:${Versions.rxlifecycle}"
    var annotation                = "org.jetbrains:annotations:${Versions.jb_annotation}"
    var binding                   = "com.hi-dhl:binding:${Versions.viewbind}"
    var titlebar                  = "com.hjq:titlebar:${Versions.titlebar}"
    var background                = "com.noober.background:core:${Versions.background}"
    var autosize                  = "me.jessyan:autosize:${Versions.autosize}"
    var utilcodex                 = "com.blankj:utilcodex:${Versions.utilcodex}"
    var brvh                      = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.brvh}"
    var immersionbar              = "com.gyf.immersionbar:immersionbar:${Versions.immersionbar}"
    var pag                       = "com.tencent.tav:libpag:${Versions.pag}"
    var permissionX               = "com.permissionx.guolindev:permissionx:${Versions.permissionx}"
    var coil                      = "io.coil-kt:coil:${Versions.coil}"
}