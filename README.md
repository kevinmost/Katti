# Katti

### Cutting down on boilerplate

Making an Android app always requires a certain amount of boilerplate. There are libraries that many Android developers consider a standard part of their arsenal (ButterKnife, Dagger, etc), and certain common design patterns, such as inheriting off a BaseActivity that takes care of things like ButterKnife binding. I threw the boilerplate that I do for every app I make into this project.

I've also done that boilerplate in Kotlin so that it can be made apparent how much more concise and enjoyable it is as a language. Favorite examples of that are:

- [App.kt](app/src/main/java/com/kevinmost/katti/App.kt)
- [Events.kt](app/src/main/java/com/kevinmost/katti/event/Events.kt)

### Notes

- Google services like Analytics need a `google-services.json` in the root of your app's directory. Since this is sensitive information, the `.gitignore` file removes it from the project. When forking this project, you may choose to remove that gitignore if this is a private repo.
_Go get a config file [here](https://developers.google.com/mobile/add?platform=android&cntapi=analytics&cnturl=https:%2F%2Fdevelopers.google.com%2Fanalytics%2Fdevguides%2Fcollection%2Fandroid%2Fv4%2Fapp%3Fconfigured%3Dtrue&cntlbl=Continue%20Adding%20Analytics)_

