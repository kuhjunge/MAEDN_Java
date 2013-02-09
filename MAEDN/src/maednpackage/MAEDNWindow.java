package maednpackage;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color; // Farben
import java.awt.event.MouseAdapter; // Mausevent
import java.awt.event.MouseEvent; // Mausevent

public class MAEDNWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { // Versuche
					MAEDNWindow window = new MAEDNWindow(); // Fenster öffnen
					window.frame.setVisible(true); // Sichtbar machen
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
		frame = new JFrame(); // Objekt wird deklariert & initalisiert
		frame.getContentPane().setBackground(new Color(240, 230, 140)); // HintergrundOrange
		frame.setBounds(100, 100, 600, 630); // Größe
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Weg bei X
		frame.getContentPane().setLayout(null);//Layoutmanager
		
		ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("images/hintergrund.png")); // Spielfeld
		ImageIcon imgBlau = new ImageIcon(this.getClass().getResource("images/maennchenblau.png")); //Blaue Spielfigur
		
		final JLabel lblMBlue1 = new JLabel(imgBlau); // Blaue Spielfigur wird Bild zugewiesen
		lblMBlue1.addMouseListener(new MouseAdapter() { // Klickevent
			@Override
			public void mouseClicked(MouseEvent arg0) { // Klickevent
				lblMBlue1.setBounds(lblMBlue1.getBounds().x+5, lblMBlue1.getBounds().y+5, 45, 45); // Setze Spielfigur 5 Schritte weiter
			}
		});
		lblMBlue1.setBounds(10, 10, 45, 45); // Startposition
		frame.getContentPane().add(lblMBlue1); // Und Ferig, ab aufs Spielfeld mit dir
		
		JLabel lblBackground = new JLabel(imgBackground); // Backgroundimage Zuweisen
		lblBackground.setBounds(0, 0, 580, 580); // Größe
		frame.getContentPane().add(lblBackground); // An den Frame anheften
	}
}
