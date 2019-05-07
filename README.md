# MutualEngine
A text-based game engine written in Java that is easily extensible and very versatile.


# Usage
Initialize the `game` property of `MutualEngine` by running the methods `Game.initializeWindow()`, `Game.initializeWorld()`, `Game.initializePlayer()`, and `Game.initializeCommandRunner()`, either with the default provided implementations or with your own implementations, and then completing initialization by running `Game.finishInitialization()`. To test to see if you have it installed right, simply running `Game.initializeDefaults()` will run all of the above with their default settings and complete initialization for you. The main one you will want to write your own implementation of first would likely be `World`.
