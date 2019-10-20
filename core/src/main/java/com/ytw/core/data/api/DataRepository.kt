package com.ytw.core.data.api

import com.ytw.core.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @Author: Ytw
 * @Date: 2019/10/18 0:03
 * @Description:
 **/
class DataRepository(private val remoteDataSource: RemoteDataSource) {

  suspend fun loadData(): Result<String> {
    return withContext(Dispatchers.IO) {
      return@withContext remoteDataSource.loadData()
    }
  }

  companion object {
    @Volatile
    private var INSTANCE: DataRepository? = null

    fun getInstance(remoteDataSource: RemoteDataSource): DataRepository {
      return INSTANCE ?: synchronized(this) {
        INSTANCE ?: DataRepository(remoteDataSource).also { INSTANCE = it }
      }
    }
  }
}