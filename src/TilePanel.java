import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;



public class TilePanel extends JPanel {
	Image img;
	
	public TilePanel(int num) {
		if(num==0) {
			img=Toolkit.getDefaultToolkit().createImage("C:\\Users\\Ryan\\Desktop\\grass.png");
		}
		else if(num==1) {
			img=Toolkit.getDefaultToolkit().createImage("C:\\Users\\Ryan\\Desktop\\path.png");
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img.getWidth(null), img.getHeight(null), null);
	}
}
