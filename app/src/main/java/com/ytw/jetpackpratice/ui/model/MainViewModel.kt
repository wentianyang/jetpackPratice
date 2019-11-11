package com.ytw.jetpackpratice.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ytw.core.data.api.appconfig.AppConfigRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Ytw
 * @Date: 2019/10/16 23:08
 * @Description:
 **/
class MainViewModel @Inject constructor(private val appConfigRepository: AppConfigRepository) : ViewModel() {

  val text = MutableLiveData<String>()

  fun onClickText(text: String) {
    this.text.value = text
  }

  public fun getAppConfig() {
    viewModelScope.launch {
      val loadData = appConfigRepository.loadData()
    }
  }
}