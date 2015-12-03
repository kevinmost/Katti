package com.kevinmost.katti.util.analytics

interface AnalyticsEvent {
  val eventName: String

  val category: String
    get() = ""

  val action: String
    get() = ""
}