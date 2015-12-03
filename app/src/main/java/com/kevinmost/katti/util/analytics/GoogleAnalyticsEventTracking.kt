package com.kevinmost.katti.util.analytics

import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.Tracker
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleAnalyticsEventTracking @Inject constructor(val tracker: Tracker): EventTracking {
  override fun track(event: AnalyticsEvent, vararg properties: Pair<String, Any?>) {
    tracker.send(HitBuilders.EventBuilder().)
  }
}