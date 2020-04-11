import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int xinfo, int yinfo, int widthinfo, int heightinfo) {
		super(xinfo, yinfo, widthinfo, heightinfo, 1);
		// TODO Auto-generated constructor stub
	}


public void update() {
	y+=speed;
}

public void draw(Graphics g) {
	
	g.setColor(Color.YELLOW);
    g.fillRect(x, y, width, height);
}
		
	

}
