import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	Random rand = new Random();
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	public ObjectManager(Rocketship rocketinfo) {
		this.rocket = rocketinfo;
	}

	private void addProjecti(Projectile proinfo) {
		projectiles.add(proinfo);

	}

	private void addAlien() {
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

	}

	private void update() {

		for (int i = 0; i <= aliens.size(); i++) {

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

	}

	private void draw(Graphics g) {

		rocket.draw(g);
		for (int i = 0; i <= aliens.size(); i++) {

			aliens.get(i).draw(g);
			
		}
		for (int j = 0; j < projectiles.size(); j++) {

			projectiles.get(j).draw(g);
		
		}
	}




private void purgeObjects() {


}





}
