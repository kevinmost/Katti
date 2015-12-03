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
import com.squareup.otto.Bus
import com.squareup.picasso.Picasso
import javax.inject.Inject

public abstract class BaseActivity : AppCompatActivity() {

  @Inject
  protected lateinit var bus: Bus

  @Inject
  protected lateinit var app: App

  @Inject
  protected lateinit var picasso: Picasso

  private val toolbar: Toolbar? by bindOptionalView(R.id.toolbar)

  @LayoutRes
  protected abstract val layoutRes: Int

  protected val toolbarTitle: String
    get() = resources.getString(R.string.app_name)

  protected override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injectSelf(App.appComponent)
    setContentView(layoutRes)
    ButterKnife.bind(this)
    if (toolbar is Toolbar) {
      initToolbar(toolbar as Toolbar)
    }
  }

  protected override fun onStart() {
    super.onStart()
    bus.register(this)
  }

  protected override fun onStop() {
    bus.unregister(this)
    super.onStop()
  }

  protected override fun onDestroy() {
    super.onDestroy()
    watchForLeaks()
  }

  private fun initToolbar(toolbar: Toolbar) {
    setSupportActionBar(toolbar)
    toolbar.title = toolbarTitle
    toolbar.setTitleTextColor(getColorCompat(android.R.color.white))
  }

  protected abstract fun injectSelf(appComponent: AppComponent)
}
