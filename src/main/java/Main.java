/*
This project must play Tic-Tac-Toe.


For the first in-class demonstration, you must have the following:
1) a static constand 2-D Array the represnets the board and holds the STATE data for the game.
2) You must correctly resolve:
  horizontal, 
  diagonal, 
  vertical winner conditions
  And a draw
3) You must have 1 player.

For the future and more points above an A-...
0) You must correctly resolve all win and draw states
1) You should have a seond player
2) You should be able to play on a 4 x 4 board
3) You should correctly resolve turns
4) The player and the game should be in seperate classes from your static Main


For more in the future and more awesomer...
1) You can have a text file documenting player win-loss records and another stat of your choice
2) You can have a 3rd or 4th player
3) You can have a 3rd dimension to the game
4) You can make a new class for a game session as well as a single game
5) You can make a new class for a turn, or a piece, or a screen painter
*/

import java.util.Scanner;


public class Main {
  static Game g = new Game();
  static int r = 0;
  static boolean playing;
  public static int numplayers = 0;
  static Player[] players = new Player[4];
  static Player currentPlayer;
  static int gameSize;
  static Scanner s;
  int[][]board;
  public static void main(String[] args) {
    
    Scanner c = new Scanner(System.in);
    
    System.out.println("How big of a game do you want?");

    final int gameSize = c.nextInt();
    
    playing = true;
    players[0] = new Player("t", false, 1);
    players[1] = new Player("v", false, 2);
    System.out.println("TTT - RAN WITHOUT ERRORS");
    g.play(gameSize, c);
  }
  
  }
