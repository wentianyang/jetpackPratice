package com.ytw.jetpackpratice.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ytw.jetpackpratice.JetpackApplication
import com.ytw.jetpackpratice.R
import com.ytw.jetpackpratice.dagger.inject
import com.ytw.jetpackpratice.ui.model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  val TAG = "MainActivity"

  @Inject
  lateinit var mainViewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    inject(this)

    mainViewModel.text.observe(this, Observer {
      test.text = it
    })

    test.setOnClickListener {
      mainViewModel.onClickText("hello livedata ")
    }
    mainViewModel.getAppConfig()
  }
}
