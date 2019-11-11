package com.ytw.core.dagger.appconfig

import com.ytw.core.dagger.ApiServiceModule
import com.ytw.core.data.api.appconfig.AppConfigRemoteDataSource
import com.ytw.core.data.api.appconfig.AppConfigRepository
import dagger.Module
import dagger.Provides

/**
 * @Author: Ytw
 * @Date: 2019/10/24 23:53
 * @Description:
 **/
@Module(includes = [ApiServiceModule::class])
class AppConfigRepositoryModule {

  @Provides
  fun provideAppConfigRepository(appConfigRemoteDataSource: AppConfigRemoteDataSource): AppConfigRepository {
    return AppConfigRepository.getInstance(appConfigRemoteDataSource)
  }
}