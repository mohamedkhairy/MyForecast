import dependencies.BuildVersion
import dependencies.AndroidX
import dependencies.Hilt
import dependencies.Kotlinx
import dependencies.Google
import dependencies.Glide


plugins {
//    id("com.android.application")
    id ("com.android.library")
    kotlin("android")
    id ("kotlin-kapt")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")


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

    buildFeatures {
        viewBinding = true
    }


}


dependencies {

    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)

    implementation(AndroidX.constraintlayout)
    implementation(AndroidX.lifecycleRuntime)
    implementation(AndroidX.lifecycleVmKtx)
    implementation(AndroidX.livedataKtx)
    implementation(AndroidX.fragmentKtx)
    implementation(AndroidX.swiperefreshlayout)

    implementation(Glide.glide)
    kapt(Glide.gildeCompiler)

    implementation(Hilt.android)
    kapt(Hilt.compiler)

    implementation(Google.material)


    implementation(Kotlinx.coroutinesCore)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

    implementation(project(":domain"))


    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.2-alpha01")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.2-alpha01")


}





//plugins {
//    id 'com.android.library'
//    id 'kotlin-android'
//}
//
//android {
//    compileSdkVersion 31
//
//    defaultConfig {
//        minSdkVersion 21
//        targetSdkVersion 31
//        versionCode 1
//        versionName "1.0"
//
//        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles "consumer-rules.pro"
//    }
//
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = '1.8'
//    }
//}
//
//dependencies {
//
//    implementation 'androidx.core:core-ktx:1.6.0'
//    implementation 'androidx.appcompat:appcompat:1.3.1'
//    implementation 'com.google.android.material:material:1.4.0'
//    testImplementation 'junit:junit:4.+'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
//}