package com.ytw.jetpackpratice.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ytw.jetpackpratice.JetpackApplication
import com.ytw.jetpackpratice.R
import com.ytw.jetpackpratice.ui.model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  val TAG = "MainActivity"

  private lateinit var mainViewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    mainViewModel.text.observe(this, Observer {
      test.text = it
    })

    test.setOnClickListener {
      mainViewModel.onClickText("hello livedata ")
    }

    Log.d(TAG, "gson is ${JetpackApplication.coreComponent(this).providerGson()}")

    Log.d(TAG, "okhttp client is ${JetpackApplication.coreComponent(this).providerOkHttpClient()}")
  }
}
