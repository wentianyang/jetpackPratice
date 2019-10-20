package com.ytw.core.dagger

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: Ytw
 * @Date: 2019/10/20 0:11
 * @Description:
 **/
@Module
class BaseModule {

  @Provides
  fun createRetrofit(okHttpClient: Lazy<OkHttpClient>, gsonConverterFactory: GsonConverterFactory): Retrofit {
    return Retrofit.Builder()
      .baseUrl("")
      .client(okHttpClient.value)
      .addConverterFactory(gsonConverterFactory)
      .build()
  }
}