# csc413-TankGame

## Student Name : Ivan Briseno
## Student ID : 915090454


TankGame Game

--------------Controls------------
Controls for Player 1

Up:    Up Arrow Key
Down:  Down Arrow Key
Right: Right Arrow Key
Left:  Left Arrow Key
Fire:  Enter Key

Controls for Player 2
Up:    w  Key
Down:  s  Key
Right: d  Key
Left:  a  Key
Fire:  f  Key

---------------Exit----------------

The game does not currently have an exit option except by closing the window. There is also no restart
option implemented, so for every restart the game has to be run again.
The game ends when one of the players reaches the end of their third life. Once that happens the game
stops completely, and closing the window should end the game.

-------------Game-----------------

This Game is a two player split screen game. Both players start at opposite ends of the map
and make their way towards the enemy tank. Each tank has three Life boxes and a health bar. 
There is a health power up that replenishes a portion of the health that a player has lost.
(Detection is a little buggy so the health may actually jump more than it should).
The map walls inside the borders of the map consist of breakable and unbreakable walls. Breakable walls
will be destroyed after they are shot and unbreakable walls will remain in the map and take no damage. 

Note: When a player is about to lose the game, the game does not freeze but for some reason it stops.
If you continue shooting bullets at the losing tank, eventually a winner screen will pop up. 
When I say eventually, I mean that after 1 or 2 seconds the message will pop up. (Shoot Away!)

Note: Collision is still buggy.

-------------PowerUps--------------

The health power ups that are scattered around the map are the little potions that are hard coded and placed around the map. 
This means that the potions will always start at the same position.
Going over these potions will give a health boost to the player.

 
-------------Compiler Used-----------
IntelliJ IDEA 2018.2.2 (Ultimate Edition)
Build #IU-182.4129.33, built on August 21, 2018
Licensed to Ivan Briseno
Subscription is active until September 4, 2019
JRE: 1.8.0_152-release-1248-b8 amd64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
Windows 10 10.0
Java SDK Version 10.0.2