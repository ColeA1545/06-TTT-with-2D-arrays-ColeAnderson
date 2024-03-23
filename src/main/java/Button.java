
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

public class Button extends JButton implements ActionListener {
  public int status;
  private int tag;
  private int q;
  public Button(int tag, int status) {
    super("Yeah, this is Nice");
    q = 0;
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
      status = Main.players[q%Main.numplayers].icon;
    System.out.println("Played on tile " + tag);
    
      
      Game.win(Game.board, Main.gameSize);
    setText(status + "");
    q++;
    }
    else{
      System.out.println("Pick a new tile");
    }
  }
}