package dependencies

object RXdependencies {

    private const val version = "1.5.1"
//    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    const val coroutinesRx = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$version"

    private const val rxKotlinVersion = "2.4.0"
    const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:$rxKotlinVersion"

    private const val rxAndroidVersion = "2.1.1"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion"

    private const val rxJavaVersion = "2.2.7"
    const val rxJava = "io.reactivex.rxjava2:rxjava:$rxJavaVersion"


}