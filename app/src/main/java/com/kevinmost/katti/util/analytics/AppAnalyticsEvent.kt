package com.kevinmost.katti.util.analytics

enum class AppAnalyticsEvent(override val eventName: String) : AnalyticsEvent {
  FOO("FooEvent"),
  BAR("BarEvent"),
  ;
}
