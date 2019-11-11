package com.ytw.jetpackpratice.dagger

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.ytw.core.dagger.appconfig.AppConfigRepositoryModule
import com.ytw.jetpackpratice.ui.model.MainViewModel
import dagger.Module

/**
 * @Author: Ytw
 * @Date: 2019/10/26 15:54
 * @Description:
 **/
@Module(includes = [AppConfigRepositoryModule::class])
abstract class MainModule {

  @Module
  companion object {
    fun mainViewModel(activity: FragmentActivity): MainViewModel {
      return ViewModelProviders.of(activity).get(MainViewModel::class.java)
    }
  }
}