package com.ytw.jetpackpratice.dagger

import com.ytw.core.dagger.BaseComponent
import com.ytw.jetpackpratice.ui.activity.MainActivity
import dagger.Component

/**
 * @Author: Ytw
 * @Date: 2019/10/26 16:13
 * @Description:
 **/
@Component(modules = [MainModule::class])
interface MainComponent : BaseComponent<MainActivity> {

  @Component.Builder
  interface Builder {
    fun build(): MainComponent
  }
}