import java.util.Scanner;
import java.util.Random;
public class Game {
    static int q = 0;
    static int scoreKeep;
    static int gameSize;
    static Player currentPlayer;
    static int t1;
    static int t2;
    static boolean played = false;
    static Random r = new Random();
    public Game(){

    }
    public static void play(int gameSize, Scanner c){
    System.out.println(gameSize);
    int[][]board = new int[gameSize][gameSize];       //// Making the Board
    for(int w = 0; w< gameSize; w++){
      for(int a = 0; a < gameSize; a++){
        board[w][a] = 0;
      }
    }
    System.out.println(board);
    while (Main.playing){
  
  currentPlayer = Main.players[q%Main.numplayers];
  
  if(currentPlayer.CPU){
    played = false;
    while(!played){
        t1 = r.nextInt(gameSize);
        t2 = r.nextInt(gameSize);
        if(board[t1][t2] == 0){
            board[t1][t2] = currentPlayer.icon;
            played = true;
        }
    }
}
  else{
    System.out.println("What row would you like to play in?");
    int row = c.nextInt();
    System.out.println("What coulumn would you like to play in?");
    int column = c.nextInt();
    board[row - 1][column - 1] = currentPlayer.icon;
  }
  for(int w = 0; w< gameSize; w++){
      for(int a = 0; a < gameSize; a++){
        System.out.print(board[w][a] + ",");
      }
      System.out.println("");
    }
    if(gameSize * gameSize == q){
        Main.playing = false;
        System.out.println("No one was victorious :(");
    }
    win(board, gameSize);
    q++;
}
  }
  
    public static void win(int[][] board1, int gameSize){

        for(int b = 0; b< board1.length; b++){
        int temp1 = currentPlayer.icon;
        scoreKeep = 0;
        for (int p = 0;  p < board1[b].length; p++){
            if(board1[b][p] == temp1){
                scoreKeep += 1;
            }
        }
        if(scoreKeep == gameSize){
            Main.playing = false;

            break;
        }
    }
    for(int y = 0; y< board1.length; y++){
        int temp1 = currentPlayer.icon;
        ;
        scoreKeep = 0;
        for (int u = 0;  u < board1[y].length; u++){
            if(board1[u][y] == temp1){
                scoreKeep += 1;
                System.out.println(scoreKeep);
            }
        }
        if(scoreKeep == gameSize){
            Main.playing = false;
            System.out.println("Congrats to Player " + currentPlayer.icon + " for winning this game!");
            
            break;
        }
    }
    for(int y = 0; y< board1.length; y++){
        int temp1 = currentPlayer.icon;
        ;
        scoreKeep = 0;
        for (int u = 0;  u < board1[y].length; u++){
            if(board1[y][gameSize] == temp1){
                scoreKeep += 1;
                System.out.println(scoreKeep);
            }
        }
        if(scoreKeep == gameSize){
            Main.playing = false;
            System.out.println("Congrats to Player " + currentPlayer.icon + " for winning this game!");
            
            break;
        }
    }
    }
}
