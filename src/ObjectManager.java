import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	
	Random rand = new Random();
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	public ObjectManager(Rocketship rocketinfo) {
		this.rocket = rocketinfo;
	}

	void addProjectile(Projectile proinfo) {
		projectiles.add(proinfo);

	}

	private void addAlien() {
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	
	public void update() {

		for (int i = 0; i < aliens.size(); i++) {

			aliens.get(i).update();
			if (aliens.get(i).y > LeagueInvaders.HEIGHT || aliens.get(i).y > LeagueInvaders.HEIGHT) {
				aliens.get(i).isActive = false;
			}
		}
		for (int j = 0; j < projectiles.size(); j++) {

			projectiles.get(j).update();
			if (projectiles.get(j).y > LeagueInvaders.HEIGHT || projectiles.get(j).y > LeagueInvaders.HEIGHT) {
				projectiles.get(j).isActive = false;
			}
		}
checkCollision();
	}

	public void draw(Graphics g) {

		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {

			aliens.get(i).draw(g);
			
		}
		for (int j = 0; j < projectiles.size(); j++) {

			projectiles.get(j).draw(g);
		
		}
	}

private void checkCollision() {
 for (Alien alien : aliens) {
	 if (rocket.collisionBox.intersects(alien.collisionBox)) {
		alien.isActive = false;
		
	 }
}

for (Projectile projectile : projectiles) {
	if (rocket.collisionBox.intersects(projectile.collisionBox)) {
		projectile.isActive = false;
	}
}

}


private void purgeObjects() {
for (int i = 0; i < aliens.size(); i++) {
	if (aliens.get(i).isActive == false) {
		aliens.remove(i);
	}
}
for (int i = 0; i < projectiles.size(); i++) {
	if (projectiles.get(i).isActive == false) {
		projectiles.remove(i);
	}
}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	addAlien();
}





}
