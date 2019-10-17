package com.ytw.core.data.api

import com.ytw.core.data.Result
import retrofit2.http.GET

/**
 * @Author: Ytw
 * @Date: 2019/10/17 23:55
 * @Description:
 **/
interface ApiService {

  @GET("")
  suspend fun getData() :Result<String>
}