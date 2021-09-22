package dependencies

object AndroidX {
    private const val coreKtxVersion = "1.6.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.3.1"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val lifecycleRuntimeVersion = "2.3.1"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeVersion"

    private const val lifecycleVmKtxVersion = "2.4.0-alpha02"
    const val lifecycleVmKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVmKtxVersion"

    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVmKtxVersion"

    private const val fragment_ktx = "1.3.4"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragment_ktx"

    private const val constraintlayoutVersion = "2.1.0"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:$constraintlayoutVersion"

    private const val swiperefreshlayoutVersion = "1.1.0"
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:$swiperefreshlayoutVersion"

}

