package com.ytw.core.data

/**
 * author: ytw
 * time: 19-10-17
 * desc: 包含加载状态的泛型类,ViewModel 以及 ViewModel的上层都返回这个Result类型
 */
sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()

    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}