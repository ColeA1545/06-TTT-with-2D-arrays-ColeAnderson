
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

public class Button extends JButton implements ActionListener {
  public int status;
  private static int tag;

  public Button(int tag, int status) {
    super("Yeah, this is Nice");
    Main.buttons[tag] = this;
    this.tag = tag + 1;
    this.status = status;
    this.setPreferredSize(new Dimension(640 / Main.gameSize, 480 / Main.gameSize));
    setText(status + "");
    addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("Played on tile " + this.tag);
    setText(status + "");
  }
}