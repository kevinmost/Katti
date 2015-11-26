# Katti

### Cutting down on boilerplate

Making an Android app always requires a certain amount of boilerplate. There are libraries that many Android developers consider a standard part of their arsenal (ButterKnife, Dagger, etc), and certain common design patterns, such as inheriting off a BaseActivity that takes care of things like ButterKnife binding. I threw the boilerplate that I do for every app I make into this project.

I've also done that boilerplate in Kotlin so that it can be made apparent how much more concise and enjoyable it is as a language. Favorite examples of that are:

- [App.kt](app/src/main/java/com/kevinmost/katti/App.kt)
- [Events.kt](app/src/main/java/com/kevinmost/katti/event/Events.kt)