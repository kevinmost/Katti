package com.kevinmost.katti.dagger

import com.kevinmost.katti.activity.FooActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun inject(target: FooActivity)
}
