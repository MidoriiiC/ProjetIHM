import javax.swing.*;
import java.awt.*;

public class Camembert extends JComponent {
    int pourc=0;
    public Camembert (int p) {
        this.pourc=p;
    }

    @Override
    public void paintComponent(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillArc(50, 30, 80, 80, 0, pourc);
	g.setColor(Color.RED);
	g.fillArc(50, 30, 80, 80, (pourc),(360-pourc) );
	
    }
}

