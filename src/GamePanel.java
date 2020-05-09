import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer alienSpawn;
	Font smallFont;
	Font titleFont;
	Timer frameDraw;
	Rocketship rocket = new Rocketship(250,700,50,50);
ObjectManager obmanager = new ObjectManager(rocket);
private BufferedImage space;	

void startGame() {
	 alienSpawn = new Timer(1000,obmanager );
	 alienSpawn.start();
}

public GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		smallFont = new Font("Arial", Font.PLAIN, 25);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	int enemies;

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;

	int currentState = MENU;

	void updateMenuState() {
	}

	void updateGameState() {
	obmanager.update();
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("League Invaders", 50, 100);
		g.setFont(smallFont);
		g.drawString("Press Enter To Start", 100, 400);
		g.drawString("Press Space for instructions", 75, 700);  
	}

	void drawGameState(Graphics g) {
		try {
			space =ImageIO.read(getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(space,0,0,null);
	
		obmanager.draw(g);
	
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 75, 100);
		g.setFont(smallFont);
		g.drawString("You killed " + enemies + " enemies", 100, 400);
		g.drawString("Press Enter to restart", 75, 700);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		repaint();

		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	if (currentState == GAME && e.getKeyCode() == KeyEvent.VK_SPACE) {
		
		obmanager.addProjectile(rocket.getProjectile());
	}
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else if (currentState == MENU) {
				currentState = GAME; startGame();
			}else {
				currentState++;
			}
				
			
		}
		if (currentState == GAME) {

			if (e.getKeyCode() == KeyEvent.VK_UP && rocket.y > 20){
				
				rocket.up();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN && rocket.y < 720) {
				rocket.down();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT && rocket.x > 20) {
				rocket.left();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT && rocket.x < 420) {
				rocket.right();	
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}






}



