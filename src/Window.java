import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame {
	
	Image[] tiles = new Image[2];
	Image buffer;
	public Window() {
		try {
			tiles[0] = ImageIO.read(new File("C:\\Users\\Ryan\\Desktop\\grass.png"));
			tiles[1] = ImageIO.read(new File("C:\\Users\\Ryan\\Desktop\\path.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("Window!");
		setSize(Main.map.getWidthInTiles()*4, Main.map.getHeightInTiles()*4);
		setVisible(true);
		
	}
	public void paint() {
		if (buffer == null) {
			buffer = new BufferedImage(Main.map.getWidthInTiles()*4, Main.map.getHeightInTiles()*4, BufferedImage.TYPE_INT_ARGB);			
		}
	}
	
}