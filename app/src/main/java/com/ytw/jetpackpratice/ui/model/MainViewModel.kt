package com.ytw.jetpackpratice.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @Author: Ytw
 * @Date: 2019/10/16 23:08
 * @Description:
 **/
class MainViewModel : ViewModel() {

  val text = MutableLiveData<String>()

  fun onClickText(text: String) {
    this.text.value = text
  }
}