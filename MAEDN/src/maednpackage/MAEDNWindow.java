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
					MAEDNWindow window = new MAEDNWindow(); // Fenster �ffnen
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
		frmMenschaergereDich.setBounds(100, 100, 600, 620); // Gr��e
		frmMenschaergereDich.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Weg bei X
		frmMenschaergereDich.getContentPane().setLayout(null);//Layoutmanager
		
		final MAEDNGame maedn = new MAEDNGame();
		ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("images/hintergrund.png")); // Spielfeld
		ImageIcon imgBlau = new ImageIcon(this.getClass().getResource("images/maennchenblau.png")); //Blaue Spielfigur
		final JLabel lblMBlue1 = new JLabel(imgBlau); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue1.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				//lblMBlue1.setBounds(lblMBlue1.getBounds().x+5, lblMBlue1.getBounds().y+5, 45, 45); // Setze Spielfigur 5 Schritte weiter
				
				int i = maedn.zug(2,1);
				lblMBlue1.setLocation(MADENPositions.place(2, 1,i)) ;
			}
		});
		lblMBlue1.setBounds(10, 10, 45, 45); // Startposition
		frmMenschaergereDich.getContentPane().add(lblMBlue1); // Und Ferig, ab aufs Spielfeld mit dir
		
		JLabel lblBackground = new JLabel(imgBackground); // Backgroundimage Zuweisen
		lblBackground.setBounds(0, 0, 580, 580); // Gr��e
		frmMenschaergereDich.getContentPane().add(lblBackground); // An den Frame anheften
	}
}
