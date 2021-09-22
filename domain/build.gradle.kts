import dependencies.BuildVersion
import dependencies.AndroidX
import dependencies.Hilt
import dependencies.Kotlinx


plugins {
//    id("com.android.application")
    id ("com.android.library")
    kotlin("android")
    id ("kotlin-kapt")

}


android {

    compileSdk = BuildVersion.compileSdk

    defaultConfig {
        minSdk = BuildVersion.minSdk
        targetSdk = BuildVersion.targetSdk
        versionCode  = BuildVersion.versionCode
        versionName = BuildVersion.versionName
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles( "consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility  = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = BuildVersion.jvmTarget
    }


}


dependencies {

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)

    implementation(Hilt.android)
    implementation(Kotlinx.coroutinesCore)


    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.2-alpha01")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.2-alpha01")


}

