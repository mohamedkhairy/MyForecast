package dependencies

object Retrofit {

    private const val okhttpVersion = "4.9.0"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
    const val okhttp = "com.squareup.okhttp3:okhttp:$okhttpVersion"

    private const val retrofitVersion = "2.7.1"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"



    private const val adapter = "0.9.2"
    const val coroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$adapter"


}