import java.util.Scanner;

public class Game {
    static int scoreKeep;
    static Player currentPlayer;
    public Game(){

    }
    public static void play(int gameSize, Scanner c){
  
    int[][]board = new int[gameSize][gameSize];       //// Making the Board
    for(int w = 0; w< gameSize; w++){
      for(int a = 0; a < gameSize; a++){
        board[w][a] = 0;
      }
    }
    System.out.println(board);
    while (Main.playing){
  
  currentPlayer = Main.players[Main.r%Main.numplayers];
  if(currentPlayer.CPU == true){

  }
  else{
    System.out.println("What row would you like to play in?");
    int row = c.nextInt();
    System.out.println("What coulumn would you like to play in?");
    int column = c.nextInt();
    board[row][column] = currentPlayer.icon;
  }
  for(int w = 0; w< gameSize; w++){
      for(int a = 0; a < gameSize; a++){
        System.out.print(board[w][a] + ",");
      }
      System.out.println("");
    }
    win(board);
}
  }
  
    public static void win(int[][] board1){

        for(int b = 0; b< board1.length; b++){
        int temp1 = currentPlayer.icon;
        scoreKeep = 0;
        for (int p = 0;  p < board1[b].length; p++){
            if(board1[b][p] == temp1){
                scoreKeep += 1;
            }
        }
        if(scoreKeep == Main.gameSize){
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
        if(scoreKeep == Main.gameSize){
            Main.playing = false;
            System.out.println("Congrats to Player " + currentPlayer.icon + " for winning this game!");
            
            break;
        }
    }
    }
}
