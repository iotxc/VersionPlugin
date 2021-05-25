package com.iotxc.deps_plugin

import applyAppCommons
import applyLibraryCommons
import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import com.iotxc.deps_plugin.task.DeclaredDepTask
import com.iotxc.deps_plugin.task.FindDependenciesTask
import com.iotxc.deps_plugin.task.Utils
import com.iotxc.deps_plugin.task.VersionExtension
import configAppDependencies
import configCommonPlugin
import configLibraryDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginContainer
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByType

/**
 * Author     : iot_xc
 * Date       : 2021/4/20
 * Version    : V1.0
 * Description: 描写描述
 */
class VersionPlugin : Plugin<Project> {
    companion object{
        fun logger(msg: String){
            println("VersionPlugin -> $msg")
        }
    }

    private var extension: VersionExtension? = null

    override fun apply(project: Project) {
        extension = project.extensions.create("VersionExt")

//        val taskDeps = project.tasks.create("depsTask", DeclaredDepTask::class.java)
//        project.tasks.whenTaskAdded {
//            if (this.name == "findDependenciesTask"){
//                this.dependsOn(taskDeps)
//            }
//        }

        val task = project.tasks.create("findDependenciesTask", FindDependenciesTask::class.java)
        project.tasks.whenTaskAdded {
            if (this.name == "preBuild"){
                this.dependsOn(task)
            }
        }

        project.tasks.whenTaskAdded {
            if (this.name == "clean"){
                logger("versionList clear")
                Utils.versionList.clear()
            }
        }

        project.plugins.config(project)
    }

    private fun PluginContainer.config(project: Project) {
        whenPluginAdded {
//            logger("-------------apply version_plugin start-------------")
//            logger("apply version_plugin project name:${project.name} $this")
            when (this) {
                //com.android.application
                is AppPlugin -> {
                    //公共插件
                    project.configCommonPlugin()
                    //公共 android 配置项
                    project.extensions.getByType<AppExtension>().applyAppCommons(project)
                    //公共依赖
                    project.configAppDependencies()
//                    DeclaredDepTask().declaredDeps(project)
                }
                //com.android.library
                is LibraryPlugin -> {
                    //公共插件
                    project.configCommonPlugin()
                    //公共 android 配置项
                    project.extensions.getByType<LibraryExtension>().applyLibraryCommons(project)
                    //公共依赖
                    project.configLibraryDependencies()
                }
            }
//            logger("-------------apply  version_plugin  end-------------\n")
        }
    }

}