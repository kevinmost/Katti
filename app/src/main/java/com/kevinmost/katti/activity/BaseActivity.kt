package com.kevinmost.katti.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.kevinmost.katti.App
import com.kevinmost.katti.dagger.AppComponent
import com.squareup.otto.Bus
import javax.inject.Inject

public abstract class BaseActivity: AppCompatActivity() {

  @Inject
  lateinit var bus: Bus

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injectSelf(App.appComponent)
    setContentView(layoutRes())
    ButterKnife.bind(this)
  }

  override fun onStart() {
    super.onStart()
    bus.register(this)
  }

  override fun onStop() {
    bus.unregister(this)
    super.onStop()
  }

  @LayoutRes
  abstract fun layoutRes(): Int

  abstract fun injectSelf(appComponent: AppComponent)
}
