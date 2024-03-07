import java.util.Scanner;

public class Player{
  Scanner s = new Scanner(System.in);
  
  int icon;
  boolean CPU;
  String name;

  
  public Player(int icon){
    System.out.println("What is your name?");
    this.name = s.next();

    System.out.println("Are you a CPU? y/n");
    System.out.println("Any input other than y/n will default to no");
    
    String C = s.next();
    if(C.equalsIgnoreCase("n")){
      this.CPU = false;
    }
    else{
      this.CPU = true;
    }
    this.icon = icon + 1;
    System.out.println("You are the " + this.icon);
    
    System.out.println("Hello my name is " + this.name);
    System.out.println("Am I a CPU? :" + this.CPU);
    Main.numplayers += 1;
    System.out.println("NEXT PLAYER");
    System.out.println("-----------------------");
    System.out.println();
    
  }
}