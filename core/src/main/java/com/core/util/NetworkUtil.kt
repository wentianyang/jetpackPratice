package com.core.util

import com.core.data.Result
import java.io.IOException

/**
 * author: ytw
 * time: 19-10-17
 * desc: 安全的api请求函数,
 */
suspend fun <T : Any> safeApiCall(call: suspend () -> Result<T>, errorMessage: String): Result<T> {
    return try {
        call()
    } catch (e: Exception) {
        Result.Error(IOException(errorMessage, e))
    }
}