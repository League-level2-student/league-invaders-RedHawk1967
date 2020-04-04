import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int xinfo, int yinfo, int widthinfo, int heightinfo) {
		super(xinfo, yinfo, widthinfo, heightinfo);
		
	} 
	

void draw(Graphics g) {


g.setColor(Color.BLUE);
g.fillRect(x, y, width, height);

}
















}

