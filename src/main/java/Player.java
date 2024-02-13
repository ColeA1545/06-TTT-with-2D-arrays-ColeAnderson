public class Player{

  int icon;
  boolean CPU;
  String name;

  
  public Player(String name, boolean CPU, int icon){

    this.name = name;
    this.CPU = CPU;
    
    System.out.println("Hello my name is " + this.name);
    System.out.println("Am I a CPU? :" + this.CPU);
    Main.numplayers += 1;
  }
}