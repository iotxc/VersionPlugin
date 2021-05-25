package com.iotxc.deps_plugin.task

import com.iotxc.deps_plugin.deps.Versions

/**
 * Author     : iot_xc
 * Date       : 2021/4/28
 * Email      : chaoxu@pateo.com.cn
 * Description: 描写描述
 */
open class VersionExtension {

    /**
     * 依赖校验release还是debug
     */
    var releaseCheck = true
    var debugCheck = false

    /**
     * 不检查的jar和aar
     * 如果包全部在本项目中可直接写[project.rootProject.name]
     */
    var jarPath = ""
    var jarExcludeList = mutableListOf<String>()

    /**
     * 从网络获取依赖项
     * eg.
     */
    var extLibUrl = ""

    /**
     * 修改[Versions]接口
     */
    fun defVersion(block: Versions.() -> Unit){
        Versions.block()
//        VersionPlugin.logger("------------------------")
//        VersionPlugin.logger("\napplicationId = ${Versions.applicationId}\n")
//        VersionPlugin.logger("\napplicationId = ${BuildConfig.applicationId}\n")
//        VersionPlugin.logger("------------------------")
    }
 }