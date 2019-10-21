package com.ytw.core.dagger

import com.ytw.core.data.DataManager
import dagger.Module
import dagger.Provides

/**
 * @Author: Ytw
 * @Date: 2019/10/21 23:15
 * @Description:
 **/
@Module
class DataManagerModule {

  @Provides
  fun provideDataManager(): DataManager {
    return getDataManager()
  }

  private fun getDataManager(): DataManager {
    return DataManager()
  }
}