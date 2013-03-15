package maednpackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color; // Farben
import java.awt.event.MouseAdapter; // Mausevent
import java.awt.event.MouseEvent;
import java.awt.Point;
import javax.swing.JTextField;
import javax.swing.JButton; // Mausevent


public class MAEDNWindow {

	private JFrame frmMenschaergereDich;
	private JTextField textFieldCom;

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
		System.out.println("Form initialisiert");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Der Rahmen der das Gesammte Java Projekt umgibt
		frmMenschaergereDich = new JFrame();
		frmMenschaergereDich.setResizable(false);
		frmMenschaergereDich.setTitle("Mensch \u00C4rgere Dich Nicht"); // Titel des Fensters
		frmMenschaergereDich.getContentPane().setBackground(new Color(240, 230, 140)); // HintergrundOrange
		frmMenschaergereDich.setBounds(100, 100, 600, 620); // Größe
		frmMenschaergereDich.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Weg bei X
		frmMenschaergereDich.getContentPane().setLayout(null);//Layoutmanager
		
		// Objekt um die Positionen der Figuren zu managen
		final MADENPositions posi = new MADENPositions();
		
		// ---------- Spielfiguren Generieren ----------
		// Figuren Rot
		final JLabel lblMRed1 = new JLabel(posi.getPic(1)); // Blaue Spielfigur wird Bild zugewiesen
		lblMRed1.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMRed1.setLocation(posi.zug(1,1));
			}
		});
		lblMRed1.setSize(46, 46); // Größe
		lblMRed1.setLocation(MADENPositions.place(1, 1,0));// Position
		posi.setLabel(1,1,lblMRed1); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMRed1); // Und Ferig, ab aufs Spielfeld mit dir
		
		final JLabel lblMRed2 = new JLabel(posi.getPic(1)); // Blaue Spielfigur wird Bild zugewiesen
		lblMRed2.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMRed2.setLocation(posi.zug(1,2));
			}
		});
		lblMRed2.setSize(46, 46); // Größe
		lblMRed2.setLocation(MADENPositions.place(1, 2,0));// Position
		posi.setLabel(1,2,lblMRed2); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMRed2);
		
		final JLabel lblMRed3 = new JLabel(posi.getPic(1)); // Blaue Spielfigur wird Bild zugewiesen
		lblMRed3.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent

				lblMRed3.setLocation(posi.zug(1,3));
			}
		});
		lblMRed3.setSize(46, 46); // Größe
		lblMRed3.setLocation(MADENPositions.place(1, 3,0));// Position
		posi.setLabel(1,3,lblMRed3); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMRed3);
		
		final JLabel lblMRed4 = new JLabel(posi.getPic(1)); // Blaue Spielfigur wird Bild zugewiesen
		lblMRed4.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent

				lblMRed4.setLocation(posi.zug(1,4));
			}
		});
		lblMRed4.setSize(46, 46); // Größe
		lblMRed4.setLocation(MADENPositions.place(1, 4,0));// Position
		posi.setLabel(1,4,lblMRed4); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMRed4);
		
		// Figuren Blau
		final JLabel lblMBlue1 = new JLabel(posi.getPic(2)); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue1.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMBlue1.setLocation(posi.zug(2,1));
			}
		});
		lblMBlue1.setSize(46, 46); // Größe
		lblMBlue1.setLocation(MADENPositions.place(2, 1,0));// Position
		posi.setLabel(2,1,lblMBlue1); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMBlue1); // Und Ferig, ab aufs Spielfeld mit dir
		
		final JLabel lblMBlue2 = new JLabel(posi.getPic(2)); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue2.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMBlue2.setLocation(posi.zug(2,2));
			}
		});
		lblMBlue2.setSize(46, 46);// Größe
		lblMBlue2.setLocation(MADENPositions.place(2, 2,0)); // Position
		posi.setLabel(2,2,lblMBlue2); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMBlue2);
		
		final JLabel lblMBlue3 = new JLabel(posi.getPic(2)); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue3.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMBlue3.setLocation(posi.zug(2,3));
			}
		});
		lblMBlue3.setSize(46, 46);// Größe
		lblMBlue3.setLocation(MADENPositions.place(2, 3,0)); // Position
		posi.setLabel(2,3,lblMBlue3); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMBlue3);
		
		final JLabel lblMBlue4 = new JLabel(posi.getPic(2)); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue4.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMBlue4.setLocation(posi.zug(2,4));
			}
		});
		lblMBlue4.setSize(46, 46);// Größe
		lblMBlue4.setLocation(MADENPositions.place(2, 4,0)); // Position
		posi.setLabel(2,4,lblMBlue4); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMBlue4);
		
		// Figuren Grün
		final JLabel lblMGreen1 = new JLabel(posi.getPic(3)); // Blaue Spielfigur wird Bild zugewiesen
		lblMGreen1.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMGreen1.setLocation(posi.zug(3,1));
			}
		});
		lblMGreen1.setSize(46, 46); // Größe
		lblMGreen1.setLocation(MADENPositions.place(3, 1,0));// Position
		posi.setLabel(3,1,lblMGreen1); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMGreen1); // Und Ferig, ab aufs Spielfeld mit dir
		
		final JLabel lblMGreen2 = new JLabel(posi.getPic(3)); // Blaue Spielfigur wird Bild zugewiesen
		lblMGreen2.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMGreen2.setLocation(posi.zug(3,2));
			}
		});
		lblMGreen2.setSize(46, 46); // Größe
		lblMGreen2.setLocation(MADENPositions.place(3, 2,0));// Position
		posi.setLabel(3,2,lblMGreen2); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMGreen2);
		
		final JLabel lblMGreen3 = new JLabel(posi.getPic(3)); // Blaue Spielfigur wird Bild zugewiesen
		lblMGreen3.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMGreen3.setLocation(posi.zug(3,3));
			}
		});
		lblMGreen3.setSize(46, 46); // Größe
		lblMGreen3.setLocation(MADENPositions.place(3, 3,0));// Position
		posi.setLabel(3,3,lblMGreen3); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMGreen3);
		
		final JLabel lblMGreen4 = new JLabel(posi.getPic(3)); // Blaue Spielfigur wird Bild zugewiesen
		lblMGreen4.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMGreen4.setLocation(posi.zug(3,4));
			}
		});
		lblMGreen4.setSize(46, 46); // Größe
		lblMGreen4.setLocation(MADENPositions.place(3, 4,0));// Position
		posi.setLabel(3,4,lblMGreen4); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMGreen4);
		
		// Figuren Gelb
		final JLabel lblMYellow1 = new JLabel(posi.getPic(4)); // Blaue Spielfigur wird Bild zugewiesen
		lblMYellow1.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMYellow1.setLocation(posi.zug(4,1));
			}
		});
		lblMYellow1.setSize(46, 46); // Größe
		lblMYellow1.setLocation(MADENPositions.place(4, 1,0));// Position
		posi.setLabel(4,1,lblMYellow1); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMYellow1); // Und Ferig, ab aufs Spielfeld mit dir
		
		final JLabel lblMYellow2 = new JLabel(posi.getPic(4)); // Blaue Spielfigur wird Bild zugewiesen
		lblMYellow2.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMYellow2.setLocation(posi.zug(4,2));
			}
		});
		lblMYellow2.setSize(46, 46); // Größe
		lblMYellow2.setLocation(MADENPositions.place(4, 2,0));// Position
		posi.setLabel(4,2,lblMYellow2); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMYellow2);
		
		final JLabel lblMYellow3 = new JLabel(posi.getPic(4)); // Blaue Spielfigur wird Bild zugewiesen
		lblMYellow3.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMYellow3.setLocation(posi.zug(4,3));
			}
		});
		lblMYellow3.setSize(46, 46); // Größe
		lblMYellow3.setLocation(MADENPositions.place(4, 3,0));// Position
		posi.setLabel(4,3,lblMYellow3); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMYellow3);
		
		final JLabel lblMYellow4 = new JLabel(posi.getPic(4)); // Blaue Spielfigur wird Bild zugewiesen
		lblMYellow4.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMYellow4.setLocation(posi.zug(4,4));
			}
		});
		lblMYellow4.setSize(46, 46); // Größe
		lblMYellow4.setLocation(MADENPositions.place(4, 4,0));// Position
		posi.setLabel(4,4,lblMYellow4); // Objektreferenz für Positionsklasse übergeben
		frmMenschaergereDich.getContentPane().add(lblMYellow4);
		// ---------- Spielfiguren generieren Ende ----------
		
		final JLabel lblInfo = new JLabel("");
		lblInfo.setBounds(12, 368, 56, 16);
		posi.setWuerfelInfo( lblInfo);
		frmMenschaergereDich.getContentPane().add(lblInfo);
		
		// Würfel 
		JLabel lblWuerfel = new JLabel(posi.getPic(5));
		lblWuerfel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				posi.klickWuerfel();
				
			}
		});
		lblWuerfel.setSize(50, 50); // Größe
		lblWuerfel.setLocation(new Point(265, 265));// Position
		posi.setWuerfel( lblWuerfel); // Würfel an die Posi Klasse übergeben, damit er modifiziert werden kann
		frmMenschaergereDich.getContentPane().add(lblWuerfel);
		
		// Zum Schluss den Hintergrund laden
		JLabel lblBackground = new JLabel(posi.getPic(0)); // Backgroundimage Zuweisen
		lblBackground.setBounds(0, 0, 580, 580); // Größe
		frmMenschaergereDich.getContentPane().add(lblBackground); // An den Frame anheften
		
		textFieldCom = new JTextField();
		textFieldCom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				posi.parsecom(textFieldCom.getText());
			}
		});
		textFieldCom.setBounds(457, 118, 116, 22);
		frmMenschaergereDich.getContentPane().add(textFieldCom);
		textFieldCom.setColumns(10);
	}
}
