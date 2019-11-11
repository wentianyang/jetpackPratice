package com.ytw.core.data.api.appconfig

import com.ytw.core.data.Result
import com.ytw.core.data.api.appconfig.AppConfigApiService
import com.ytw.core.util.safeApiCall
import java.io.IOException
import javax.inject.Inject

/**
 * @Author: Ytw
 * @Date: 2019/10/18 0:04
 * @Description: 通过AppConfigService获取AppConfig的数据源的类
 **/
class AppConfigRemoteDataSource @Inject constructor(private val service: AppConfigApiService) {

  suspend fun loadData() = safeApiCall(
    call = { requestData() },
    errorMessage = "Error load data"
  )

  private suspend fun requestData(): Result<String> {
    val response = service.getData()
    if (response.isSuccessful) {
      val body = response.body()
      if (body != null) {
        return Result.Success(body)
      }
    }
    return Result.Error(IOException("Error loading data ${response.code()} ${response.message()}"))
  }
}