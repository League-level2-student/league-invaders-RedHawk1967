import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int xinfo, int yinfo, int widthinfo, int heightinfo) {
		super(xinfo, yinfo, widthinfo, heightinfo, 20);
		
	
	
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

}
















}

