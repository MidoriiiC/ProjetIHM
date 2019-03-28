import java.awt.*;
import javax.swing.*;

public class Bouton extends JButton{

    public Bouton(String name, GListen l, String action){
	Color a= new Color(0x91BACF);
	this.setText(name);
	this.setActionCommand("quitter");setBackground(a);
	this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	this.addActionListener(l);
	this.setActionCommand(action);
    }
}
