# tictactoe-android
Tic Tac Toe game made on android studio.  This game can be played by two players (X and 0).
The main structure of XML file consists of gridlayout over which imageviews are added on each space. Upon clicking on the space,
the image is displayed of the player by setting image source according to the active player. A wincombo 2d array is set up which checks the 
combinations of the players and tells the user when a player has won. A playagain function is invoked if the user presses play again
setting gamestate equals to 2 for every state.
