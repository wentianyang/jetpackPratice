package com.ytw.core.dagger

import com.ytw.core.data.api.AppViewService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @Author: Ytw
 * @Date: 2019/10/20 0:11
 * @Description:
 **/
@Module
class BaseModule {

  @Provides
  fun provideAppViewService(retrofit: Retrofit): AppViewService {
    return retrofit.create(AppViewService::class.java)
  }
}