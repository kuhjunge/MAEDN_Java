package maednpackage;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import java.awt.BorderLayout;
import java.awt.Color; // Farben
import java.awt.event.MouseAdapter; // Mausevent
import java.awt.event.MouseEvent; // Mausevent

public class MAEDNWindow {

	private JFrame frmMenschaergereDich;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { // Versuche
					MAEDNWindow window = new MAEDNWindow(); // Fenster öffnen
					window.frmMenschaergereDich.setVisible(true); // Sichtbar machen
				} catch (Exception e) { // Wenn Fehler
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MAEDNWindow() {
		initialize();// Spielfeld erschaffen
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Der Rahmen der das Gesammte Java Projekt umgibt
		frmMenschaergereDich = new JFrame(); // Objekt wird deklariert & initalisiert
		frmMenschaergereDich.setTitle("Mensch \u00C4rgere Dich Nicht"); // Titel des Fensters
		frmMenschaergereDich.getContentPane().setBackground(new Color(240, 230, 140)); // HintergrundOrange
		frmMenschaergereDich.setBounds(100, 100, 600, 620); // Größe
		frmMenschaergereDich.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Weg bei X
		frmMenschaergereDich.getContentPane().setLayout(null);//Layoutmanager
		
		final MAEDNGame maedn = new MAEDNGame(); // Spielmechanik aufrufen
		
		// Bilder laden
		ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("images/hintergrund.png")); // Spielfeld
		ImageIcon imgBlau = new ImageIcon(this.getClass().getResource("images/maennchenblau.png")); //Blaue Spielfigur
		ImageIcon imgRot = new ImageIcon(this.getClass().getResource("images/maennchenrot.png")); //Rote Spielfigur
		ImageIcon imgGruen = new ImageIcon(this.getClass().getResource("images/maennchengruen.png")); //Rote Spielfigur
		ImageIcon imgGelb = new ImageIcon(this.getClass().getResource("images/maennchengelb.png")); //Rote Spielfigur
		
		// Figuren Gelb
				final JLabel lblMYellow1 = new JLabel(imgGelb); // Blaue Spielfigur wird Bild zugewiesen
				lblMYellow1.addMouseListener(new MouseAdapter() { // Klickevent
					@Override
					public void mouseClicked(MouseEvent arg0) { // Klickevent
						int id = 1;
						int farbe = 4;
						int wurf = 1;
						int i = maedn.zug(farbe,id,wurf);
						lblMYellow1.setLocation(MADENPositions.place(farbe, id,i)) ;
					}
				});
				lblMYellow1.setBounds(525, 470, 45, 45); // Startposition
				frmMenschaergereDich.getContentPane().add(lblMYellow1); // Und Ferig, ab aufs Spielfeld mit dir
				
				final JLabel lblMYellow2 = new JLabel(imgGelb); // Blaue Spielfigur wird Bild zugewiesen
				lblMYellow2.addMouseListener(new MouseAdapter() { // Klickevent
					@Override
					public void mouseClicked(MouseEvent arg0) { // Klickevent
						int id = 2;
						int farbe = 4;
						int wurf = 1;
						int i = maedn.zug(farbe,id,wurf);
						lblMYellow2.setLocation(MADENPositions.place(farbe, id,i)) ;
					}
				});
				lblMYellow2.setBounds(475, 528, 45, 45);
				frmMenschaergereDich.getContentPane().add(lblMYellow2);
				
				final JLabel lblMYellow3 = new JLabel(imgGelb); // Blaue Spielfigur wird Bild zugewiesen
				lblMYellow3.addMouseListener(new MouseAdapter() { // Klickevent
					@Override
					public void mouseClicked(MouseEvent arg0) { // Klickevent
						int id = 3;
						int farbe = 4;
						int wurf = 1;
						int i = maedn.zug(farbe,id,wurf);
						lblMYellow3.setLocation(MADENPositions.place(farbe, id,i)) ;
					}
				});
				lblMYellow3.setBounds(525, 528, 45, 45);
				frmMenschaergereDich.getContentPane().add(lblMYellow3);
				
				final JLabel lblMYellow4 = new JLabel(imgGelb); // Blaue Spielfigur wird Bild zugewiesen
				lblMYellow4.addMouseListener(new MouseAdapter() { // Klickevent
					@Override
					public void mouseClicked(MouseEvent arg0) { // Klickevent
						int id = 4;
						int farbe = 4;
						int wurf = 1;
						int i = maedn.zug(farbe,id,wurf);
						lblMYellow4.setLocation(MADENPositions.place(farbe, id,i)) ;
					}
				});
				lblMYellow4.setBounds(475, 470, 45, 45);
				frmMenschaergereDich.getContentPane().add(lblMYellow4);
		
		// Figuren Grün
		final JLabel lblMGreen1 = new JLabel(imgGruen); // Blaue Spielfigur wird Bild zugewiesen
		lblMGreen1.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 1;
				int farbe = 3;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMGreen1.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMGreen1.setBounds(525, 10, 45, 45); // Startposition
		frmMenschaergereDich.getContentPane().add(lblMGreen1); // Und Ferig, ab aufs Spielfeld mit dir
		
		final JLabel lblMGreen2 = new JLabel(imgGruen); // Blaue Spielfigur wird Bild zugewiesen
		lblMGreen2.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 2;
				int farbe = 3;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMGreen2.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMGreen2.setBounds(475, 60, 45, 45);
		frmMenschaergereDich.getContentPane().add(lblMGreen2);
		
		final JLabel lblMGreen3 = new JLabel(imgGruen); // Blaue Spielfigur wird Bild zugewiesen
		lblMGreen3.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 3;
				int farbe = 3;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMGreen3.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMGreen3.setBounds(525, 60, 45, 45);
		frmMenschaergereDich.getContentPane().add(lblMGreen3);
		
		final JLabel lblMGreen4 = new JLabel(imgGruen); // Blaue Spielfigur wird Bild zugewiesen
		lblMGreen4.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 4;
				int farbe = 3;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMGreen4.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMGreen4.setBounds(475, 10, 45, 45);
		frmMenschaergereDich.getContentPane().add(lblMGreen4);
		
		// Figuren Rot
		final JLabel lblMRed1 = new JLabel(imgRot); // Blaue Spielfigur wird Bild zugewiesen
		lblMRed1.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 1;
				int farbe = 1;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMRed1.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMRed1.setBounds(62, 470, 45, 45); // Startposition
		frmMenschaergereDich.getContentPane().add(lblMRed1); // Und Ferig, ab aufs Spielfeld mit dir
		
		final JLabel lblMRed2 = new JLabel(imgRot); // Blaue Spielfigur wird Bild zugewiesen
		lblMRed2.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 2;
				int farbe = 1;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMRed2.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMRed2.setBounds(10, 528, 45, 45);
		frmMenschaergereDich.getContentPane().add(lblMRed2);
		
		final JLabel lblMRed3 = new JLabel(imgRot); // Blaue Spielfigur wird Bild zugewiesen
		lblMRed3.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 3;
				int farbe = 1;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMRed3.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMRed3.setBounds(62, 528, 45, 45);
		frmMenschaergereDich.getContentPane().add(lblMRed3);
		
		final JLabel lblMRed4 = new JLabel(imgRot); // Blaue Spielfigur wird Bild zugewiesen
		lblMRed4.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 4;
				int farbe = 1;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMRed4.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMRed4.setBounds(10, 470, 45, 45);
		frmMenschaergereDich.getContentPane().add(lblMRed4);
		
		// Figuren Blau
		final JLabel lblMBlue1 = new JLabel(imgBlau); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue1.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 1;
				int farbe = 2;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMBlue1.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMBlue1.setBounds(62, 10, 45, 45); // Startposition
		frmMenschaergereDich.getContentPane().add(lblMBlue1); // Und Ferig, ab aufs Spielfeld mit dir
		
		final JLabel lblMBlue2 = new JLabel(imgBlau); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue2.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 2;
				int farbe = 2;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMBlue2.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMBlue2.setBounds(10, 60, 45, 45);
		frmMenschaergereDich.getContentPane().add(lblMBlue2);
		
		final JLabel lblMBlue3 = new JLabel(imgBlau); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue3.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 3;
				int farbe = 2;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMBlue3.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMBlue3.setBounds(62, 60, 45, 45);
		frmMenschaergereDich.getContentPane().add(lblMBlue3);
		
		final JLabel lblMBlue4 = new JLabel(imgBlau); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue4.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				int id = 4;
				int farbe = 2;
				int wurf = 1;
				int i = maedn.zug(farbe,id,wurf);
				lblMBlue4.setLocation(MADENPositions.place(farbe, id,i)) ;
			}
		});
		lblMBlue4.setBounds(10, 10, 45, 45);
		frmMenschaergereDich.getContentPane().add(lblMBlue4);
		
		// Zum Schluss den Hintergrund laden
		JLabel lblBackground = new JLabel(imgBackground); // Backgroundimage Zuweisen
		lblBackground.setBounds(0, 0, 580, 580); // Größe
		frmMenschaergereDich.getContentPane().add(lblBackground); // An den Frame anheften
		
		// Aufräumen
		lblMRed1.setLocation(MADENPositions.place(1, 1,0));
		lblMRed2.setLocation(MADENPositions.place(1, 2,0));
		lblMRed3.setLocation(MADENPositions.place(1, 3,0));
		lblMRed4.setLocation(MADENPositions.place(1, 4,0));
		lblMBlue1.setLocation(MADENPositions.place(2, 1,0));
		lblMBlue2.setLocation(MADENPositions.place(2, 2,0));
		lblMBlue3.setLocation(MADENPositions.place(2, 3,0));
		lblMBlue4.setLocation(MADENPositions.place(2, 4,0));
		lblMGreen1.setLocation(MADENPositions.place(3, 1,0));
		lblMGreen2.setLocation(MADENPositions.place(3, 2,0));
		lblMGreen3.setLocation(MADENPositions.place(3, 3,0));
		lblMGreen4.setLocation(MADENPositions.place(3, 4,0));
		lblMYellow1.setLocation(MADENPositions.place(4, 1,0));
		lblMYellow2.setLocation(MADENPositions.place(4, 2,0));
		lblMYellow3.setLocation(MADENPositions.place(4, 3,0));
		lblMYellow4.setLocation(MADENPositions.place(4, 4,0));
	}
}
