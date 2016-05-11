package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Test_gaufre implements Runnable {

	final static int WIDTH = 500;
	final static int HEIGHT = 500;
	static JFrame frame;
	static Joueur joueur1;
	static Joueur joueur2;
	static JLabel J1_score;
	static JLabel J2_score;
	static JLabel turn;
	
	public static JMenu menuPrincipal(Moteur moteur,AireDeDessin aire) {
		JMenu principal;
        	JMenuItem item;
		principal = new JMenu("Option");
		item = new JMenuItem("NouveauX");
		item.addActionListener(new Ecouteur("Nouveaux",moteur,aire,J1_score,J2_score,turn));
		principal.add(item);
		item = new JMenuItem("Sauver");
		item.addActionListener(new Ecouteur("Sauver",moteur,aire,J1_score,J2_score,turn));
		principal.add(item);
		item = new JMenuItem("Charger");
		item.addActionListener(new Ecouteur("Charger",moteur,aire,J1_score,J2_score,turn));
		principal.add(item);
		return principal;
	}

	public static JMenuBar menu(Moteur moteur,AireDeDessin aire) {
		JMenuBar barre;
		JMenu principal;

        barre = new JMenuBar();
		principal = menuPrincipal(moteur,aire);
        barre.add(principal);

		return barre;
	}
	
	public static void titleScreen(){
		JPanel panel = new JPanel();
		JLabel joueur1_label = new JLabel ("Joueur1");
		joueur1_label.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel joueur2_label = new JLabel ("Joueur2");
		joueur2_label.setHorizontalAlignment(SwingConstants.CENTER);
		
		joueur1 = new Joueur(false,1);
		joueur2 = new Joueur(false,1);
		
		final JCheckBox j1 = new JCheckBox("IA");
		j1.setSelected(false);
	
		final JCheckBox j2 = new JCheckBox("IA");
		j2.setSelected(false);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		panel2.add(joueur1_label);
		panel2.add(j1);
		j1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {joueur1.setIa(j1.isSelected());
			System.out.println(joueur1.isIa());}
		});
	
		j2.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {joueur2.setIa(j2.isSelected());}
		});
//		frame.add(panel2,BorderLayout.WEST);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		panel3.add(joueur2_label);
		panel3.add(j2);
//		frame.add(panel3,BorderLayout.EAST);
		
	    //Create the radio buttons.
	    JRadioButton ia1 = new JRadioButton("1");
	    ia1.setActionCommand("1");
	    ia1.setSelected(true);		
		
	    JRadioButton ia2 = new JRadioButton("2");
	    ia2.setActionCommand("2");

	    JRadioButton ia3 = new JRadioButton("3");
	    ia3.setActionCommand("3");

	    JRadioButton ia4 = new JRadioButton("4");
	    ia4.setActionCommand("4");
	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(ia1);
	    group.add(ia2);
	    group.add(ia3);
	    group.add(ia4);
	    
	    panel2.add(ia1);
	    panel2.add(ia2);
	    panel2.add(ia3);
	    panel2.add(ia4);
	    
	    //Create the radio buttons.
	    JRadioButton ia5 = new JRadioButton("1");
	    ia5.setActionCommand("1");
	    ia5.setSelected(true);		
		
	    JRadioButton ia6 = new JRadioButton("2");
	    ia6.setActionCommand("2");

	    JRadioButton ia7 = new JRadioButton("3");
	    ia7.setActionCommand("3");

	    JRadioButton ia8 = new JRadioButton("4");
	    ia8.setActionCommand("4");
	    
	    ButtonGroup group2 = new ButtonGroup();
	    group2.add(ia5);
	    group2.add(ia6);
	    group2.add(ia7);
	    group2.add(ia8);

	    panel3.add(ia5);
	    panel3.add(ia6);
	    panel3.add(ia7);
	    panel3.add(ia8);
	    
	    ia1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
                    int i = Integer.parseInt(e.getActionCommand());
                    joueur1.setIaLevel(i);
	    }
	    });
	    ia2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(e.getActionCommand());
            joueur1.setIaLevel(i);
		}
		});
	    ia3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(e.getActionCommand());
            joueur1.setIaLevel(i);
		}
		});       
	    ia4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(e.getActionCommand());
            joueur1.setIaLevel(i);
		}
		});
	    
		ia5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
		    int i = Integer.parseInt(e.getActionCommand());
		    joueur2.setIaLevel(i);
		}
		});
		ia6.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
		    int i = Integer.parseInt(e.getActionCommand());
		    joueur2.setIaLevel(i);
		}
		});
		ia7.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
		    int i = Integer.parseInt(e.getActionCommand());
		    joueur2.setIaLevel(i);
		}
		});
		ia8.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
		    int i = Integer.parseInt(e.getActionCommand());
		    joueur2.setIaLevel(i);
		}
		});
		
		JButton play = new JButton("PLAY");
		panel.add(play, JComponent.CENTER_ALIGNMENT);
//		frame.add(panel, BorderLayout.CENTER);
		
		JPanel test = new JPanel();
		test.setLayout(new BorderLayout());
		test.add(panel2, BorderLayout.WEST);
		test.add(panel, BorderLayout.CENTER);
		test.add(panel3, BorderLayout.EAST);
		frame.setLayout(new GridLayout(3,1));
		frame.add(panel);
		frame.add(test);
		play.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {game();}});
	}
	
	public static void game(){
		frame.setVisible(false);
		frame = new JFrame("Gauffre");
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		Terrain terrain = new Terrain(4,6);
		Moteur moteur = new Moteur(terrain,joueur1,joueur2);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,1,0,2));
		turn = new JLabel("");
		turn.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel align = new JLabel("");
		align.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel J1 = new JLabel("Joueur 1");
		J1.setHorizontalAlignment(SwingConstants.CENTER);
		J1_score = new JLabel(Integer.toString(joueur1.getScore())); // To be implemented
		J1_score.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel J2 = new JLabel("Joueur 2");
		J2.setHorizontalAlignment(SwingConstants.CENTER);
		J2_score = new JLabel(Integer.toString(joueur2.getScore())); // To be implemented
		J2_score.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		//Aire de dessin
		
		AireDeDessin aire = new AireDeDessin(moteur);
		aire.addMouseListener(new EcouteurDeSouris(aire,moteur,J1_score,J2_score,turn,frame));
		

		
		JButton undo = new JButton("Annuler");
		undo.addActionListener(new Ecouteur("Annuler",moteur,aire,J1_score,J2_score,turn));

		JButton redo = new JButton("Refaire");
		redo.addActionListener(new Ecouteur("Refaire",moteur,aire,J1_score,J2_score,turn));

		JPanel boutons = new JPanel();
		boutons.setLayout(new GridLayout(1, 2, 5, 0));
		boutons.add(undo);
		boutons.add(redo);
		
//		panel.add(align);
		panel.add(turn);
		panel.add(J1);
		panel.add(J1_score);
		panel.add(J2);
		panel.add(J2_score);
		panel.add(boutons);
		frame.add(aire);
		frame.add(panel,BorderLayout.EAST);
		frame.setJMenuBar(menu(moteur,aire));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void run(){
		frame = new JFrame("Gaufre");
		
		titleScreen();
		
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Test_gaufre());
	}

}
