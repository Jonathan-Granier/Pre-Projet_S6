package main;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Test_gaufre {

	public static JMenu menuPrincipal() {
		JMenu principal;
        	JMenuItem item;
		principal = new JMenu("Option");
		item = new JMenuItem("Nouveaux");
		item.addActionListener(new Ecouteur("Nouveaux"));
		principal.add(item);
		item = new JMenuItem("Sauver");
		item.addActionListener(new Ecouteur("Sauver"));
		principal.add(item);
		item = new JMenuItem("Charger");
		item.addActionListener(new Ecouteur("Charger"));
		principal.add(item);
		item = new JMenuItem("Annuler");
		item.addActionListener(new Ecouteur("Annuler"));
		principal.add(item);
		item = new JMenuItem("Refaire");
		item.addActionListener(new Ecouteur("Refaire"));
		principal.add(item);
		return principal;
	}

	public static JMenuBar menu() {
		JMenuBar barre;
		JMenu principal, edition;

        barre = new JMenuBar();
		principal = menuPrincipal();
        barre.add(principal);

		return barre;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("Gauffre");
		
		Terrain terrain = new Terrain(4,6);
		
		//Aire de dessin
		AireDeDessin aire = new AireDeDessin(terrain);
		aire.addMouseListener(new EcouteurDeSouris(aire));
		
		
		frame.add(aire);
		
		frame.setJMenuBar(menu());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		
	}

}
