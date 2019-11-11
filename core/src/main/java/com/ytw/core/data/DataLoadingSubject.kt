package com.ytw.core.data

/**
 * @Author: Ytw
 * @Date: 2019/10/23 22:42
 * @Description: 用来观察加载状态的类
 **/
interface DataLoadingSubject {
  fun registerCallback(callbacks: DataLoadingCallbacks)

  interface DataLoadingCallbacks {
    fun dataStartedLoading()

    fun dataFinishedLoading()
  }
}