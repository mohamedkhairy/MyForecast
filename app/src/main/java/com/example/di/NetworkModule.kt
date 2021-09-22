package com.example.di

import com.example.data.dataSource.remote.Endpoints
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.example.utils.Contacts.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {


    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
        client.addInterceptor(interceptor)
        client.connectTimeout(20, TimeUnit.SECONDS)
        client.readTimeout(30, TimeUnit.SECONDS)
        client.writeTimeout(30, TimeUnit.SECONDS)
        return client.build()
    }

//
//    @Provides
//    @Singleton
//    fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .addConverterFactory(object : Converter.Factory() {
//                override fun responseBodyConverter(
//                    type: Type?,
//                    annotations: Array<Annotation>?,
//                    retrofit: Retrofit?
//                ): Converter<ResponseBody, Any>? {
//                    val delegate =
//                        retrofit!!.nextResponseBodyConverter<Any>(this, type!!, annotations!!)
//                    return Converter { body ->
//                        if (body.contentLength() == 0L) null else delegate.convert(
//                            body
//                        )
//                    }
//                }
//            })
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .client(okHttpClient)
//            .build()
//    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())

    }


    @Singleton
    @Provides
    fun provideForecastService(retrofit: Retrofit.Builder): Endpoints {
        return retrofit
            .build()
            .create(Endpoints::class.java)
    }

}