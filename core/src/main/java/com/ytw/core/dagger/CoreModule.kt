package com.ytw.core.dagger

import com.google.gson.Gson
import com.ytw.core.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: Ytw
 * @Date: 2019/10/19 21:03
 * @Description:
 **/
@Module
class CoreModule {

  @Provides
  fun provideRetrofit(okHttpClient: Lazy<OkHttpClient>, gsonConverterFactory: GsonConverterFactory): Retrofit {
    val endPoint = if (BuildConfig.DEBUG) {
      BuildConfig.DEV_ENDPOINT
    } else {
      BuildConfig.ENDPOINT
    }
    return Retrofit.Builder()
      .baseUrl(endPoint)
      .client(okHttpClient.value)
      .addConverterFactory(gsonConverterFactory)
      .build()
  }

  @Provides
  fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

  @Provides
  fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
      level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
      } else {
        HttpLoggingInterceptor.Level.NONE
      }
    }

  @Provides
  fun provideGson(): Gson = Gson()

  @Provides
  fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()
}