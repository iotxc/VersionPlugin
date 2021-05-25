package com.iotxc.deps_plugin.task

import com.iotxc.deps_plugin.VersionPlugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Author     : iot_xc
 * Date       : 2021/5/10
 * Email      : chaoxu@pateo.com.cn
 * Description: 获取依赖项
 */
open class DeclaredDepTask {

    fun declaredDeps(project: Project) {
        val ext = project.extensions.getByType<VersionExtension>()
        VersionPlugin.logger("VersionExtension：url =${ext.extLibUrl}")
        if (ext.extLibUrl.isNotEmpty()) {
            Utils.getConfig(ext.extLibUrl)
            return
        }

        Utils.scanDep()
    }
}