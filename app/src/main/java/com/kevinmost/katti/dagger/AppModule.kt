package com.kevinmost.katti.dagger

import com.google.android.gms.analytics.GoogleAnalytics
import com.google.android.gms.analytics.Tracker
import com.kevinmost.katti.App
import com.kevinmost.katti.R
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

  @Provides
  @Singleton
  fun tracker(app: App): Tracker {
    val analytics = GoogleAnalytics.getInstance(app)
    return analytics.newTracker(app.getString(R.string.analytics_tracker_id))
  }
}
