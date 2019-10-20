package com.ytw.jetpackpratice

import android.app.Activity
import android.app.Application
import android.content.Context
import com.ytw.core.dagger.CoreComponent
import com.ytw.core.dagger.DaggerCoreComponent

/**
 * @Author: Ytw
 * @Date: 2019/10/19 21:25
 * @Description:
 **/
class JetpackApplication : Application() {

  private val coreComponent: CoreComponent by lazy {
    DaggerCoreComponent.create()
  }

  companion object {
    @JvmStatic
    fun coreComponent(context: Context) = (context.applicationContext as JetpackApplication).coreComponent
  }

  override fun onCreate() {
    super.onCreate()
  }
}

fun Activity.coreComponent() = JetpackApplication.coreComponent(this)