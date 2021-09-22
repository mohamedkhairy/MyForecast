import dependencies.BuildVersion
import dependencies.AndroidX
import dependencies.Room
import dependencies.Retrofit
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

    implementation(Kotlinx.javaxInject)

    implementation(Retrofit.retrofit)
    implementation(Retrofit.loggingInterceptor)
    implementation(Retrofit.coroutinesAdapter)
    implementation(Retrofit.okhttp)
    implementation(Retrofit.retrofitConverter)

    implementation(Room.room)
    implementation(Room.roomKtx)
    kapt(Room.roomCompiler)
    kapt(Room.roomKtx)

    implementation(project(":domain"))

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.2-alpha01")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.2-alpha01")


}

