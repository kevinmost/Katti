package com.kevinmost.katti.util.analytics

interface EventTracking {
  fun track(event: AnalyticsEvent, vararg properties: Pair<String, Any?>)
}