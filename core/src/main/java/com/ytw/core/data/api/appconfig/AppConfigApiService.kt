package com.ytw.core.data.api.appconfig

import retrofit2.Response
import retrofit2.http.GET

/**
 * @Author: Ytw
 * @Date: 2019/10/17 23:55
 * @Description:
 **/
interface AppConfigApiService {

  @GET("api/AppConfig")
  suspend fun getData(): Response<String>
}