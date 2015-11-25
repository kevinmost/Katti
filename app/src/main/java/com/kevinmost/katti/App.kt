package com.kevinmost.katti

import android.app.Application
import com.kevinmost.katti.dagger.AppModule
import com.kevinmost.katti.dagger.DaggerAppComponent

object App : Application() {
  val appComponent = DaggerAppComponent
      .builder()
      .appModule(AppModule(this))
      .build()
    get
}
