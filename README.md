# Python Pocket Tutor

Pocket-sized, offline-first Python tutorial with in-app code runner.

Built with Kotlin + Chaquopy. Lessons are authored in `lessons/*.md` and compiled
to JSON into `app/src/main/assets/lessons/` using `tools/lesson_compiler.py`.

## Quick start (local dev)

1. Open this project in Android Studio.
2. Open `settings.gradle` and `build.gradle` (root) then `app/build.gradle`.
3. Android Studio will sync Gradle and Chaquopy. Allow it to download the Python runtime.
4. Run on a device (minSdk 24 recommended).

## Project structure
- `lessons/` — authoring markdown files (human-editable).
- `tools/lesson_compiler.py` — compiles markdown -> JSON for the app.
- `app/` — Android Studio module (Kotlin + Chaquopy).
- `app/src/main/python/python_runner.py` — runs Python snippet sandbox.

## Author
Thomas Hopkins (thopkins568-glitch)# Python-pocket-tutorial-
