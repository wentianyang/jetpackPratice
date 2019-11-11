package com.ytw.core.dagger

import com.google.gson.Gson
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @Author: Ytw
 * @Date: 2019/10/18 0:14
 * @Description:
 **/
@Component(modules = [CoreModule::class])
@Singleton
interface CoreComponent {

  @Component.Builder
  interface Builder {
    fun build(): CoreComponent
  }

  fun provideRetrofit(): Retrofit

  fun providerOkHttpClient(): OkHttpClient

  fun providerGson(): Gson

  fun providerGsonConverterFactory(): GsonConverterFactory
}