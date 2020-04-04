import javax.swing.JFrame;

public class LeagueInvaders {
	GamePanel gpanel;
	public static void main(String[] args) {
		LeagueInvaders lobj = new LeagueInvaders();
		lobj.setup();
		
	}


	JFrame gframe;
	

	public LeagueInvaders() {
		 gpanel = new GamePanel();
gframe = new JFrame();
	}

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	

	


public void setup() {
	gframe.add(gpanel);
	
	gframe.setSize(WIDTH,HEIGHT);
	gframe.addKeyListener(gpanel);
	gframe.setVisible(true);
	gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}





}





