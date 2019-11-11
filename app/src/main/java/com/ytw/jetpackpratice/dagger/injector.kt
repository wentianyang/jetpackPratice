package com.ytw.jetpackpratice.dagger

import com.ytw.jetpackpratice.ui.activity.MainActivity

/**
 * @Author: Ytw
 * @Date: 2019/10/27 1:53
 * @Description:
 **/
fun inject(activity: MainActivity) {
  DaggerMainComponent.builder()
    .build()
    .inject(activity)
}