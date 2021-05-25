package com.iotxc.deps_plugin.task

import com.iotxc.deps_plugin.VersionPlugin
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.artifacts.Configuration
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.getByType

/**
 * Author     : iot_xc
 * Date       : 2021/5/2
 * Email      : chaoxu@pateo.com.cn
 * Description: 检验依赖的合法性
 */
open class FindDependenciesTask : DefaultTask() {

    @TaskAction
    fun analysisDependencies() {
        VersionPlugin.logger("analysisDependencies entry ${project.name}\n")

        val ext = project.extensions.getByType<VersionExtension>()

        if (ext.releaseCheck && ext.debugCheck) {
            throw GradleException(
                "Only one of releaseCheck and debugCheck can be selected！"
            )
        }

        if (!ext.releaseCheck && !ext.debugCheck) {
            VersionPlugin.logger("No select releaseCheck and debugCheck！")
            return
        }

        DeclaredDepTask().declaredDeps(project)

        val type = if (ext.releaseCheck) "release" else "debug"

        project.configurations.forEach {
            if (it.name == "${type}RuntimeClasspath") {
                checkJar(it, ext)
                checkUrl(it)
                return
            }
        }
    }

    /**
     * 对jar和aar进行检测
     */
    private fun checkJar(configuration: Configuration, ext: VersionExtension) {
        val jarPath = if (ext.jarPath.isEmpty()) project.rootProject.name else ext.jarPath

        configuration.asFileTree.files.filter { fileIt ->
            (fileIt.path.endsWith(".jar") ||
                    fileIt.path.endsWith(".aar")) &&
                    fileIt.path.contains(jarPath)
        }.forEach { jarIt ->
            VersionPlugin.logger(jarIt.path)
            if (!ext.jarExcludeList.contains(jarIt.name))
                throw GradleException(
                    "The library \"${jarIt.name}：\n" +
                            "\t\t${jarIt.path}\" is illegal, " +
                            "\n" +
                            "\t\tPlease contact the administrator！"
                )
        }
    }

    /**
     * 对url的依赖进行检测
     */
    private fun checkUrl(configuration: Configuration) {
        configuration.incoming.resolutionResult.root.dependencies.forEach dr@{ dr ->
            val dependencyResultInfo = "$dr"
            if (dependencyResultInfo.isEmpty()) return@dr
            if (!Utils.versionList.contains(dependencyResultInfo))
                throw GradleException(
                    "The dependency \"$dependencyResultInfo\" is illegal, " +
                            "Please contact the administrator！"
                )

            VersionPlugin.logger(
                dependencyResultInfo
            )
        }
    }
}