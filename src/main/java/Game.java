import java.util.Scanner;
import java.util.Random;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Game extends JFrame{
  static int q = 0;
  static int scoreKeep;
  static int gameSize;
  static Player currentPlayer;
  static int t1;
  static int t2;
  static boolean played = false;
  static Random r = new Random();

  public Game() {
    setTitle("Tic Tac Toe");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(640,480);
    setLayout(new FlowLayout());
    setResizable(true);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void play(int gameSize, Scanner c) {
    System.out.println(gameSize);
    int[][] board = new int[gameSize][gameSize]; //// Making the Board
    for (int w = 0; w < gameSize; w++) {
      for (int a = 0; a < gameSize; a++) {
        board[w][a] = 0;
        Button b = new Button(w*gameSize + a, 0);
        add(b);
      }
    }
    System.out.println(board);
    while (Main.playing) {

      currentPlayer = Main.players[q % Main.players.length];
      System.out.println("Hello Player " + currentPlayer.icon + ".");
      if (currentPlayer.CPU) {
        played = false;
        while (!played) {
          t1 = r.nextInt(gameSize);
          t2 = r.nextInt(gameSize);
          if (board[t1][t2] == 0) {
            board[t1][t2] = currentPlayer.icon;
            played = true;
          }
        }
      } 
      else {
        played = false;
        while (!played) {
        System.out.println("What row would you like to play in?");
        int row = c.nextInt();
        System.out.println("What coulumn would you like to play in?");
        int column = c.nextInt();
          if(board[row - 1][column - 1] == 0){
            played = true;
            board[row - 1][column - 1] = currentPlayer.icon;
            Main.buttons[((row-1)*Main.gameSize + row - 1)].status = currentPlayer.icon;
          }
          else{
            System.out.println("That's an illegal move :(");
          }
        }
        
      }
      for (int w = 0; w < gameSize; w++) {
        for (int a = 0; a < gameSize; a++) {
          System.out.print(board[w][a] + ",");
        }
        System.out.println("");
      }
      win(board, gameSize);
      q++;
      if (gameSize * gameSize == q) {
        Main.playing = false;
  
        System.out.println("No one was victorious :(");

      }
      

    }
  }

  public static void win(int[][] board1, int gameSize) {

    for (int b = 0; b < board1.length; b++) {
      int temp1 = currentPlayer.icon;
      scoreKeep = 0;
      for (int p = 0; p < board1[b].length; p++) {
        if (board1[b][p] == temp1) {
          scoreKeep += 1;
        }
      }
      if (scoreKeep == gameSize) {
        System.out.println("Congrats to Player " + currentPlayer.icon + " for winning this game!");
        Main.playing = false;

        break;
      }
    }
    scoreKeep = 0;
    for (int y = 0; y < board1.length; y++) {
      int temp1 = currentPlayer.icon;
      
      for (int u = 0; u < board1[y].length; u++) {
        if (y==u && temp1 == board1[y][y]) {
          scoreKeep += 1;
          System.out.println(scoreKeep);
        }
      }
      if (scoreKeep == gameSize) {
        System.out.println("Congrats to Player " + currentPlayer.icon + " for winning this game!");
        Main.playing = false;

        break;
      }
    }

    int OtherCounter = board1.length;
    int scoreKeep = 0;
    for (int y = 0; y < board1.length; y++) {
      int temp1 = currentPlayer.icon;
      OtherCounter -= 1;
        if (board1[y][OtherCounter] == temp1) {
          scoreKeep += 1;
          System.out.println(scoreKeep);
        }
      if (scoreKeep == gameSize) {
        Main.playing = false;
        System.out.println("Congrats to Player " + currentPlayer.icon + " for winning this game!");

        break;
      }
    }

    for (int s = 0; s < board1.length; s++){
      scoreKeep = 0;
      int temp1 = currentPlayer.icon;
      
      if(board1[s][s] == temp1){
        scoreKeep += 1;
      }
      if (scoreKeep == gameSize) {
        System.out.println("Congrats to Player " + currentPlayer.icon + " for winning this game!");
        Main.playing = false;

        break;
      }
    }

  }
}
