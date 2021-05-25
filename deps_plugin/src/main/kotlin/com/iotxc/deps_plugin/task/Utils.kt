package com.iotxc.deps_plugin.task

import com.iotxc.deps_plugin.VersionPlugin
import com.iotxc.deps_plugin.deps.AndroidX
import com.iotxc.deps_plugin.deps.Deps
import com.iotxc.deps_plugin.deps.Google
import com.iotxc.deps_plugin.deps.Kotlin
import com.iotxc.deps_plugin.deps.Repositories
import com.iotxc.deps_plugin.deps.Testing
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

/**
 * Author     : iot_xc
 * Date       : 2021/5/6
 * Email      : chaoxu@pateo.com.cn
 * Description: 描写描述
 */
open class Utils {
    companion object {
        val versionList = mutableListOf<String>()

        /**
         * 将所有的依赖添加到[versionList]
         */
        private fun getDeclaredFields(vararg cls: Class<*>) {
            cls.forEach { clsIt ->
                val declaredFields = clsIt.declaredFields
                declaredFields.forEach df@{
                    try {
                        it.isAccessible = true
                        if ("INSTANCE" == it.name) return@df
                        if (it.get(clsIt) is String) {
                            versionList.add(it.get(clsIt) as String)
                        }
//                        VersionPlugin.logger(
//                            "Dependency：" +
//                                    "${it.name}: " +
//                                    "${it.get(clsIt)}"
//                        )
                    } catch (e: IllegalAccessException) {
                        VersionPlugin.logger("getDeclaredFields：$e")
                    }
                }
//                VersionPlugin.logger("getDeclaredFields finish ：${Versions.androidx_lifecycle}")
//                VersionPlugin.logger("getDeclaredFields finish ：${versionList.size}")
            }
        }

        fun getConfig(url: String) {
//            val url = "http://10.10.105.38/D%3A/Doc/test.txt"
            val okHttpClient = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .build()

            val call = okHttpClient.newCall(request)
            try {
                val response: Response = call.execute()
                val json = response.body?.string()
                VersionPlugin.logger("getConfig：onResponse =${json}")
                val jsonObject = JSONObject(json)
                val libList =
                    jsonObject.getJSONArray("extlib").toList() as List<Map<String, String>>
                libList.forEach {
                    Deps.extLib[it.getValue("name")] = it.getValue("url")
                }
            }catch (e: IOException){
                VersionPlugin.logger("getConfig：JSONException =$e")
            } catch (e: JSONException) {
                VersionPlugin.logger("getConfig：JSONException =$e")
            }finally {
                scanDep()
            }
        }

        fun scanDep(){
            getDeclaredFields(
                AndroidX::class.java,
                Google::class.java,
                Deps::class.java,
                Kotlin::class.java,
                Repositories::class.java,
                Testing::class.java
            )
        }
    }
}