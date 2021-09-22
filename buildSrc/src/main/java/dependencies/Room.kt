package dependencies

object Room {

    private const val room_version = "2.3.0"
    const val room = "androidx.room:room-runtime:$room_version"
    const val roomKtx = "androidx.room:room-ktx:$room_version"
    const val roomCompiler = "androidx.room:room-compiler:$room_version"

//    implementation("androidx.room:room-runtime:$room_version")
//    annotationProcessor "androidx.room:room-compiler:$room_version"
//
//    // To use Kotlin annotation processing tool (kapt)
//    kapt("androidx.room:room-compiler:$room_version")
//    // To use Kotlin Symbolic Processing (KSP)
//    ksp("androidx.room:room-compiler:$room_version")
//
//    // optional - Kotlin Extensions and Coroutines support for Room
//    implementation("androidx.room:room-ktx:$room_version")

}