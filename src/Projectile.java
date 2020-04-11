import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	public Projectile(int xinfo, int yinfo, int widthinfo, int heightinfo, int speedinfo) {
		super(xinfo, yinfo, widthinfo, heightinfo, 10);
		// TODO Auto-generated constructor stub
	}


	public void update() {
		y-=speed;
	}

	public void draw(Graphics g) {
		
		g.setColor(Color.RED);
	    g.fillRect(x, y, width, height);
	}


}
