import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	public Rocketship(int xinfo, int yinfo, int widthinfo, int heightinfo) {
		super(xinfo, yinfo, widthinfo, heightinfo, 20);
		
		if (needImage) {
		    loadImage ("rocket.png");
		}
	
	speed = 20;
	
	} 
	
public void right() {
x+=speed;
}
public void left() {
x-=speed;
}
public void down() {
y+=speed;
}
public void up() {
y-=speed;
}
void draw(Graphics g) {


g.setColor(Color.BLUE);
g.fillRect(x, y, width, height);

if (gotImage) {
	g.drawImage(image, x, y, width, height, null);
} else {
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
}
}








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







}

