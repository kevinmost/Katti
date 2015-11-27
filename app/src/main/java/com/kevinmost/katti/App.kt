package com.kevinmost.katti

import android.app.Application
import com.kevinmost.katti.dagger.AppModule
import com.kevinmost.katti.dagger.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import timber.log.Timber

object App : Application() {
  val appComponent = DaggerAppComponent
      .builder()
      .appModule(AppModule(this))
      .build()
    get

  lateinit var refWatcher: RefWatcher
    get

  override fun onCreate() {
    super.onCreate()
    refWatcher = LeakCanary.install(this)
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}
