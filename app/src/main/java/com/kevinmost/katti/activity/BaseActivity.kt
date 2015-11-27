package com.kevinmost.katti.activity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import butterknife.ButterKnife
import com.kevinmost.katti.App
import com.kevinmost.katti.R
import com.kevinmost.katti.dagger.AppComponent
import com.kevinmost.katti.extension.bindOptionalView
import com.kevinmost.katti.extension.getColorCompat
import com.kevinmost.katti.extension.watchForLeaks
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.squareup.otto.Bus
import javax.inject.Inject

public abstract class BaseActivity : AppCompatActivity() {

  @Inject
  protected lateinit var bus: Bus

  @Inject
  protected lateinit var app: App

  @Inject
  protected lateinit var refWatcher: RefWatcher

  private val toolbar: Toolbar? by bindOptionalView(R.id.toolbar)

  @LayoutRes
  protected abstract val layoutRes: Int

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injectSelf(App.appComponent)
    setContentView(layoutRes)
    ButterKnife.bind(this)
    if (toolbar is Toolbar) {
      initToolbar(toolbar as Toolbar)
    }
  }

  private fun initToolbar(toolbar: Toolbar) {
    setSupportActionBar(toolbar)
    toolbar.title = getToolbarTitle()
    toolbar.setTitleTextColor(getColorCompat(android.R.color.white))
  }

  override fun onStart() {
    super.onStart()
    bus.register(this)
  }

  override fun onStop() {
    bus.unregister(this)
    super.onStop()
  }

  override fun onDestroy() {
    super.onDestroy()
    watchForLeaks()
  }

  protected fun getToolbarTitle(): String {
    return resources.getString(R.string.app_name);
  }

  abstract fun injectSelf(appComponent: AppComponent)
}
