package com.kevinmost.katti.extension

import com.kevinmost.katti.App

fun Any.watchForLeaks() {
  App.refWatcher.watch(this)
}

