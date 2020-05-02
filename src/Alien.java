import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public Alien(int xinfo, int yinfo, int widthinfo, int heightinfo) {
		super(xinfo, yinfo, widthinfo, heightinfo, 1);
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("rocket.png");
		}
	
	}


public void update() {
	y+=speed;
}

public void draw(Graphics g) {
	if (gotImage) {
		g.drawImage(image, x, y, width, height, null);
	} else {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

}
		
	

}
