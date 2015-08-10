# MCTowerDefence
Tower Defence mod for Minecraft using Forge

Development just started, so there is not much to see yet...

However, what is there can be seen if you:
## Setup IntelliJ
* Clone the repository to your computer and import the project into IntelliJ
* Using Gradle, run the *setupDevWorkspace* goal (this will download all necessary dependencies)
* Again using Gradle, run the *genIntellijRuns* goal (this will create to launch configurations, for client and server)
* Select the *Minecraft Client* launch configuration and run it (this will start the Minecraft client with the mod loaded)
* Load a world with cheats enabled and type `/give <playername> td:shooter`
* Place the shooter somewhere and see it automatically firing arrows on you

That's all until now, not much, but good enough for one evening of work with no mod ever created before ;)

## Ideas
Some ideas on what this mod should include in the future:
* Building blocks for automatic towers
  * Shooters for different projectiles (standard, splash, slow, poison, etc.)
  * Ammo providers for shooters that need ammo
  * Blocks that improve range, speed, etc.
* Upgrades for towers via new recipes
* Aura towers that increase shooter properties
* Different properties of shooters depending on where they are placed (e.g. higher up = more range)
* Spawners that spawns custom mobs in increasingly difficult waves
* Block to mark the target for mobs
* Tool to lay out a path for mobs from spawner to target
