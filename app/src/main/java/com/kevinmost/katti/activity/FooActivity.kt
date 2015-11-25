package com.kevinmost.katti.activity

import android.widget.Toast
import butterknife.OnClick
import com.kevinmost.katti.R
import com.kevinmost.katti.dagger.AppComponent
import com.kevinmost.katti.event.ButtonPressedEvent
import com.squareup.otto.Subscribe

class FooActivity : BaseActivity() {

  var numTimesPressed = 0

  @Subscribe
  public fun toastedPoastedEvent(event: ButtonPressedEvent) {
    numTimesPressed = event.numTimesPressed
    Toast.makeText(this, "You clicked the button $numTimesPressed times", Toast.LENGTH_SHORT).show()
  }

  @OnClick(R.id.button)
  fun poastAboutToast() {
    // Roundabout, unnecessary use of the bus just to make sure things are working!
    bus.post(ButtonPressedEvent(numTimesPressed + 1))
  }

  override fun layoutRes(): Int {
    return R.layout.foo
  }

  override fun injectSelf(appComponent: AppComponent) {
    appComponent.inject(this)
  }
}