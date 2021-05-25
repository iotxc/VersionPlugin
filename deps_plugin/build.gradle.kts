buildscript {
    repositories {
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
        jcenter()
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
    dependencies {
        classpath("com.gradle.publish:plugin-publish-plugin:0.12.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31")
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    `java-library`
    `maven-publish`
    signing
    id("com.gradle.plugin-publish") version "0.15.0"
}

apply(plugin = "com.github.dcendents.android-maven")

repositories {
    jcenter()
    google()
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31")
    implementation("com.android.tools.build:gradle:4.1.1")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")
}


group = "io.github.iotxc"
version = "1.0.0"

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "io.github.iotxc"
            artifactId = "deps-plugin"
            version = "1.0.0-SNAPSHOT"
            artifact("$buildDir/libs/deps-plugin-1.0.0-SNAPSHOT.jar")
            artifact("$buildDir/libs/deps-plugin-1.0.0-SNAPSHOT-sources.jar")
            from(components["java"])

            pom {
                name.set("deps-plugin")
                description.set("A tool to manager gradle")
                url.set("https://github.com/iotxc/VersionPlugin")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        name.set("iotxc")
                        email.set("softwarexc@163.com")
                    }
                }
                scm {
                    connection.set("scm:https://github.com/iotxc/VersionPlugin.git")
                    developerConnection.set("scm:git@github.com:iotxc/VersionPlugin.git")
                    url.set("https://github.com/iotxc/VersionPlugin")
                }
            }
        }
    }
    repositories {
        maven {
            // change URLs to point to your repos, e.g. http://my.org/repo
            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = if (version.toString().endsWith("SNAPSHOT")) uri(snapshotsRepoUrl) else uri(releasesRepoUrl)

            credentials {
                username = properties["sonatypeUsername"]?.toString()
                password = properties["sonatypePassword"]?.toString()
            }
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

//publishing {
//    publications {
//        create<MavenPublication>("release") {
//            groupId = "com.github.iotxc"
//            artifactId = "deps_plugin"
//            version = "1.0.0"
//            from(components["java"])
//        }
//    }
//
//    repositories {
//        maven {
//            name = "iotxc"
//            url = uri("https://github.com/iotxc/deps_plugin")
//            credentials {
//                username = "iotxc"
//                password = "xuchao19930207"
//            }
//        }
//    }
//}
//
//pluginBundle{
//    website = "https://github.com/iotxc/deps_plugin"
//    vcsUrl = "https://github.com/iotxc/deps_plugin/releases"
//    description = "A tool to manager gradle"
//    tags = mutableListOf("android")
//}
//
//gradlePlugin {
//    plugins {
//        create("deps_plugin") {
//            id = "com.iotxc.deps_plugin"
//            displayName = "VersionPlugin"
//            implementationClass = "com.iotxc.deps_plugin.VersionPlugin"
//        }
//    }
//}