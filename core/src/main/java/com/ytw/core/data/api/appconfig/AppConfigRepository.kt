package com.ytw.core.data.api.appconfig

import com.ytw.core.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @Author: Ytw
 * @Date: 2019/10/18 0:03
 * @Description: 存储和获取AppConfig的类
 **/
class AppConfigRepository(private val remoteDataSource: AppConfigRemoteDataSource) {

  suspend fun loadData(): Result<String> {
    return withContext(Dispatchers.IO) {
      return@withContext remoteDataSource.loadData()
    }
  }

  companion object {
    @Volatile
    private var INSTANCE: AppConfigRepository? = null

    fun getInstance(remoteDataSource: AppConfigRemoteDataSource): AppConfigRepository {
      return INSTANCE ?: synchronized(this) {
        INSTANCE ?: AppConfigRepository(remoteDataSource).also { INSTANCE = it }
      }
    }
  }
}