import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
 Font smallFont;
 Font titleFont;

 public GamePanel() {
	    titleFont = new Font("Arial", Font.PLAIN, 48);
	    smallFont = new Font("Arial", Font.PLAIN, 25);
 }
int enemies; 
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}

final int MENU = 0;
final int GAME = 1;
final int END = 2;

int currentState = MENU;


void updateMenuState() { }
void updateGameState() {  }
void updateEndState()  {  }

void drawMenuState(Graphics g) {g.setColor(Color.BLUE);
g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
g.setFont(titleFont);
g.setColor(Color.WHITE);
g.drawString("League Invaders",50, 100);g.setFont(smallFont);
g.drawString("Press Enter To Start", 100 , 400);
g.drawString("Press Space for instructions", 75, 700);
}

void drawGameState(Graphics g) { g.setColor(Color.BLACK);
g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
}
void drawEndState(Graphics g)  { g.setColor(Color.RED);
g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT); 
g.setFont(titleFont);

g.drawString("GAME OVER", 350,400);
g.setFont(smallFont);
g.drawString("You killed " + enemies + " enemies", 250,400);
g.drawString("Press Enter to restart", 75,700 );

}











}
