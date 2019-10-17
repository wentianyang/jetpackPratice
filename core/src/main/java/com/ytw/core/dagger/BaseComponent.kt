package com.ytw.core.dagger

import android.app.Activity
import android.app.Service

/**
 * @Author: Ytw
 * @Date: 2019/10/18 0:14
 * @Description:
 **/
interface BaseComponent<T> {

  fun inject(target: T)
}

interface BaseActivityComponent<T : Activity> : BaseComponent<T>

interface BaseServiceComponent<T : Service> : BaseComponent<T>