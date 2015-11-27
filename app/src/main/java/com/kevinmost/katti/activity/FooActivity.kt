package com.kevinmost.katti.activity

import android.widget.Toast
import butterknife.OnClick
import com.kevinmost.katti.R
import com.kevinmost.katti.dagger.AppComponent
import com.kevinmost.katti.event.ButtonPressedEvent
import com.kevinmost.katti.extension.toast
import com.squareup.otto.Bus
import com.squareup.otto.Subscribe
import javax.inject.Inject

class FooActivity : BaseActivity() {
  var numTimesPressed = 0

  override val layoutRes = R.layout.foo

  @Subscribe
  public fun toastedPoastedEvent(event: ButtonPressedEvent) {
    numTimesPressed = event.numTimesPressed
    toast("Clicked button $numTimesPressed times!")
  }

  @OnClick(R.id.button)
  fun poastAboutToast() {
    // Roundabout, unnecessary use of the bus just to make sure things are working!
    bus.post(ButtonPressedEvent(numTimesPressed + 1))
  }

  override fun injectSelf(appComponent: AppComponent) {
    appComponent.inject(this)
  }
}