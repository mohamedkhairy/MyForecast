// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlin_version by extra("1.5.21")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath ("com.android.tools.build:gradle:4.2.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.38.1")

    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}
