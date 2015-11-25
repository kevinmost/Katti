package com.kevinmost.katti.extension

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

@ColorInt
fun Context.getColorCompat(@ColorRes colorRes: Int): Int {
  return ContextCompat.getColor(this, colorRes)
}
