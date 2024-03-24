
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

public class Button extends JButton implements ActionListener {
  public int status;
  private int tag;
  private int q = 0;
  public Button(int tag, int status) {
    super("Yeah, this is Nice");

    System.out.println("New Button+");
    Main.buttons[tag] = this;
    this.tag = tag + 1;
    this.status = status;
    this.setPreferredSize(new Dimension(640 / Main.gameSize, 480 / Main.gameSize));
    setText(status + "");
    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
    if(this.status == 0){
      status = Main.players[Game.q%Main.numplayers].icon;
    System.out.println("Played on tile " + tag);
    
      Game.board[(this.tag-1)/Main.gameSize][(this.tag-1)%Main.gameSize] = this.status;
      Game.win(Game.board, Main.gameSize);
    setText(status + "");
      Game.q++;
    

    }
    else if(Game.q >= Main.gameSize * Main.gameSize){
      status = Main.players[Game.q%Main.numplayers].icon;
      System.out.println("Played on tile " + tag);
      
        Game.board[(this.tag-1)/Main.gameSize][(this.tag-1)%Main.gameSize] = this.status;
        Game.win(Game.board, Main.gameSize);
      setText(status + "");
      Game.q++;

    }
    else{
      System.out.println("Pick a new Tile please");
    }

  }
}