package com.kevinmost.katti.dagger

import com.kevinmost.katti.App
import com.kevinmost.katti.util.PostFromAnywhereBus
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import com.squareup.okhttp.OkHttpClient
import com.squareup.otto.Bus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

  @Provides
  @Singleton
  fun app(): App {
    return app
  }

  @Provides
  @Singleton
  fun bus(): Bus {
    return PostFromAnywhereBus()
  }

  @Provides
  @Singleton
  fun okHttpClient(): OkHttpClient {
    return OkHttpClient()
  }
}
