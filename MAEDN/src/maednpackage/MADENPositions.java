package maednpackage;

import java.awt.Point;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MADENPositions {
	// positionierungen
    private static int figX = 23; // Figur Größe der X Achse
    private static int figY = 23; // Figur Größe der Y Achse
    private static int zx = 290; // SpielfeldMitte X Achse
    private static int zy = 290; // SpielfeldMitte Y Achse
    private static int zadd = 52; // Schrittgröße der SpielfeldQuadrate
    
    // Bilder
    private ImageIcon imgBackground = new ImageIcon(this.getClass().getResource("images/hintergrund.png")); //Blaue Spielfigur
	private ImageIcon imgBlau = new ImageIcon(this.getClass().getResource("images/maennchenblau.png")); //Blaue Spielfigur
	private ImageIcon imgRot = new ImageIcon(this.getClass().getResource("images/maennchenrot.png")); //Rote Spielfigur
	private ImageIcon imgGruen = new ImageIcon(this.getClass().getResource("images/maennchengruen.png")); //Rote Spielfigur
	private ImageIcon imgGelb = new ImageIcon(this.getClass().getResource("images/maennchengelb.png")); //Rote Spielfigur
	private ImageIcon imgWuerfel = new ImageIcon(this.getClass().getResource("images/wuerfel_n.png")); // Würfel
	private ImageIcon imgWuerfelGl = new ImageIcon(this.getClass().getResource("images/wuerfel_gl.png")); // Würfel Glow
    
	// Spielobjekt
	MAEDNGame maedn = new MAEDNGame(); // Spielmechanik aufrufen
	
	// Rot
	private JLabel lblMRed1 = null;
    private JLabel lblMRed2 = null;
    private JLabel lblMRed3 = null;
    private JLabel lblMRed4 = null;
	// Blau
    private JLabel lblMBlue1 = null;
    private JLabel lblMBlue2 = null;
    private JLabel lblMBlue3 = null;
    private JLabel lblMBlue4 = null;
	// Grün
	private JLabel lblMGreen1 = null;
    private JLabel lblMGreen2 = null;
    private JLabel lblMGreen3 = null;
    private JLabel lblMGreen4 = null;
	// Gelb
	private JLabel lblMYellow1 = null;
    private JLabel lblMYellow2 = null;
    private JLabel lblMYellow3 = null;
    private JLabel lblMYellow4 = null;
    // Würfel
    private JLabel lblWuerfel = null;
    private JLabel lblInfo = null;
    
    // Funktionen
    
    // gibt das Bild, dass angefragt wird zurück
    public ImageIcon getPic(int id)
    {
    	ImageIcon ret = null;
		switch (id)
		{
			case 0:
				ret = imgBackground;
				break;
			case 1:
				ret = imgRot;
				break;
			case 2:
				ret = imgBlau;
				break;
			case 3:
				ret = imgGruen;
				break;
			case 4:
				ret = imgGelb;
				break;
			case 5:
				ret = imgWuerfel;
				break;
			case 6:
				ret = imgWuerfelGl;
				break;
		}
		return ret;
    }
    
    // Setzt das Würfelobjekt
    public void setWuerfel(JLabel label) {
    	lblWuerfel = label;
    }
    
    // Setzt WürfelInfoObjekt
    public void setWuerfelInfo(JLabel label) {
    	lblInfo = label;
    }
    
	// Setzt das Objekt für um die Spielfigur ansprechen zu können
    public void setLabel(int farbe, int id, JLabel label) {
		switch (farbe)
		{
			case 1:
				switch (id)
				{
					case 1:
						lblMRed1 = label;
						break;
					case 2:
						lblMRed2 = label;
						break;
					case 3:
						lblMRed3 = label;
						break;
					case 4:
						lblMRed4 = label;
						break;
				}
				break;
			case 2:
				switch (id)
				{
					case 1:
						lblMBlue1 = label;
						break;
					case 2:
						lblMBlue2 = label;
						break;
					case 3:
						lblMBlue3 = label;
						break;
					case 4:
						lblMBlue4 = label;
						break;
				}
				break;
			case 3:
				switch (id)
				{
					case 1:
						lblMGreen1 = label;
						break;
					case 2:
						lblMGreen2 = label;
						break;
					case 3:
						lblMGreen3 = label;
						break;
					case 4:
						lblMGreen4 = label;
						break;
				}
				break;
			case 4:
				switch (id)
				{
					case 1:
						lblMYellow1 = label;
						break;
					case 2:
						lblMYellow2 = label;
						break;
					case 3:
						lblMYellow3 = label;
						break;
					case 4:
						lblMYellow4 = label;
						break;
				}
				break;
		}
    }
	
	// Gibt das ausgewählte Objekt zurück
	public JLabel getLabel(int farbe, int id) {
	 JLabel label = null;
		switch (farbe)
		{
			case 1:
				switch (id)
				{
					case 1:
						label = lblMRed1;
						break;
					case 2:
						label = lblMRed2;
						break;
					case 3:
						label = lblMRed3;
						break;
					case 4:
						label = lblMRed4;
						break;
				}
				break;
			case 2:
				switch (id)
				{
					case 1:
						label = lblMBlue1;
						break;
					case 2: 
						label = lblMBlue2;
						break;
					case 3:
						label = lblMBlue3;
						break;
					case 4:
						label = lblMBlue4;
						break;
				}
				break;
			case 3:
				switch (id)
				{
					case 1:
						label = lblMGreen1;
						break;
					case 2:
						label = lblMGreen2;
						break;
					case 3:
						label = lblMGreen3;
						break;
					case 4:
						label = lblMGreen4;
						break;
				}
				break;
			case 4:
				switch (id)
				{
					case 1:
						label = lblMYellow1;
						break;
					case 2:
						label = lblMYellow2;
						break;
					case 3:
						label = lblMYellow3;
						break;
					case 4:
						label = lblMYellow4;
						break;
				}
				break;
		}
		return label;
    }
	
	// Zugfunktion
	public Point zug(int farbe, int id)
	{
		Point p = null;
		int i = maedn.zug(farbe,id);
		p = place(farbe, id,i);
		update();
		lblWuerfel.setIcon(imgWuerfel);
		return p;
	}
	
	// Gibt die aktuelle Position einer Figur als Punkt zurück
	public Point pUpdate(int farbe, int id)
	{
		Point p = null;
		int i = maedn.getFigurFort(farbe,id);
		p = place(farbe, id, i);
		return p;
	}
	
	// Updatet alle Figuren aus der Updatelist
	private void update()
	{
		List <String> list = maedn.getMoveList();
		for (String item: list) 
		{
		   String[] itemArray = new String[2];
		   itemArray = item.split("-");
		   JLabel label = getLabel(Integer.parseInt(itemArray[0]),Integer.parseInt(itemArray[1])); // String in Int convertieren
		   label.setLocation(pUpdate(Integer.parseInt(itemArray[0]),Integer.parseInt(itemArray[1]))); // String in Int convertieren
		}
		maedn.clearMoveList();
	}
	
	// Der Würfel wird angeklickt und startet diese Funktion
	public void klickWuerfel()
	{
		maedn.wuerfeln();
		lblInfo.setText( maedn.getWurf() + "");
		lblWuerfel.setIcon(imgWuerfelGl);
	}
	
	public void parsecom(String com)
	{
		maedn.com(com);
	}
	
	// Funktion gibt die Position der aktuel geklickten farbe zurück
    public static Point place(int farbe, int id, int zahl)
    { // Positionen Ermitteln Spielfeld oder farbenspezifische Positionen
        if (zahl > 0 && zahl < 41) // Wenn die Position im Spielverlauf ist
        {
            Point[] ort = {
            new Point(zx, zy), // 0
            new Point(zx  - (zadd *1) , zy + (zadd * 5)), // 1
            new Point(zx  - (zadd *1) , zy + (zadd * 4)), // 2
            new Point(zx  - (zadd *1) , zy + (zadd * 3)), // 3
            new Point(zx  - (zadd *1) , zy + (zadd * 2)),  // 4
            new Point(zx  - (zadd *1) , zy + (zadd * 1)), // 5 (ecke) 
            new Point(zx  - (zadd *2) , zy + (zadd * 1)), // 6
            new Point(zx  - (zadd *3) , zy + (zadd * 1)), // ...
            new Point(zx  - (zadd *4) , zy + (zadd * 1)), 
            new Point(zx  - (zadd *5) , zy + (zadd * 1)),
            new Point(zx - (zadd * 5), zy ), // Vor Blau
            new Point(zx  - (zadd *5) , zy - (zadd * 1)),
            new Point(zx  - (zadd *4) , zy - (zadd * 1)),
            new Point(zx  - (zadd *3) , zy - (zadd * 1)),
            new Point(zx  - (zadd *2) , zy - (zadd * 1)), //
            new Point(zx  - (zadd *1) , zy - (zadd * 1)),
            new Point(zx  - (zadd *1) , zy - (zadd * 2)),
            new Point(zx  - (zadd *1) , zy - (zadd * 3)),
            new Point(zx  - (zadd *1) , zy - (zadd * 4)),
            new Point(zx  - (zadd *1) , zy - (zadd * 5)),
            new Point(zx  , zy - (zadd * 5)), // Vor Gruen
            new Point(zx  + (zadd *1) , zy - (zadd * 5)),
            new Point(zx  + (zadd *1) , zy - (zadd * 4)),
            new Point(zx  + (zadd *1) , zy - (zadd * 3)),
            new Point(zx  + (zadd *1) , zy - (zadd * 2)),
            new Point(zx  + (zadd *1) , zy - (zadd * 1)),
            new Point(zx  + (zadd *2) , zy - (zadd * 1)),
            new Point(zx  + (zadd *3) , zy - (zadd * 1)),
            new Point(zx  + (zadd *4) , zy - (zadd * 1)),
            new Point(zx  + (zadd *5) , zy - (zadd * 1)),
            new Point(zx  + (zadd *5) , zy),// Vor Gelb
            new Point(zx  + (zadd *5) , zy + (zadd * 1)),
            new Point(zx  + (zadd *4) , zy + (zadd * 1)),
            new Point(zx  + (zadd *3) , zy+(zadd * 1)),
            new Point(zx  + (zadd *2) , zy+(zadd * 1)),
            new Point(zx  + (zadd *1) , zy+(zadd * 1)),
            new Point(zx  + (zadd *1) , zy+(zadd * 2)),
            new Point(zx  + (zadd *1) , zy+(zadd * 3)),
            new Point(zx  + (zadd *1) , zy+(zadd * 4)),
            new Point(zx  + (zadd *1) , zy+(zadd * 5)),
            new Point(zx, zy+(zadd * 5)) // Vor Rot 
            };
            return new Point(ort[zahl].x - figX, ort[zahl].y - figY); // Rückgabe des ermittelten Punktes
        }
        else // Wenn die Person am Start oder am Ende ist
        {
            Point ort = new Point(1, 1);
            switch (farbe)
            {
                case 1: // Rot
                    switch (zahl)
                    {
                        case 41:
                            ort = new Point(zx, zy + (zadd * 4));
                            break;
                        case 42:
                            ort = new Point(zx, zy + (zadd * 3));
                            break;
                        case 43:
                            ort = new Point(zx, zy + (zadd * 2));
                            break;
                        case 44:
                            ort = new Point(zx, zy + (zadd * 1));
                            break;
                        default:
                            if (id == 1) ort = new Point(zx - (zadd * 5), zy + (zadd * 5));
                            else if (id == 2) ort = new Point(zx - (zadd * 4), zy + (zadd * 5));
                            else if (id == 3) ort = new Point(zx - (zadd * 5), zy + (zadd * 4));
                            else if (id == 4) ort = new Point(zx - (zadd * 4), zy + (zadd * 4));
                            break;
                    }
                    break;
                case 2: // Blau
                    switch (zahl)
                    {
                        case 41:
                            ort = new Point(zx - (zadd * 4), zy);
                            break;
                        case 42:
                            ort = new Point(zx - (zadd * 3), zy);
                            break;
                        case 43:
                            ort = new Point(zx - (zadd * 2), zy);
                            break;
                        case 44:
                            ort = new Point(zx - (zadd * 1), zy);
                            break;
                        default:
                            if (id == 1) ort = new Point(zx - (zadd * 5), zy - (zadd * 5));
                            else if (id == 2) ort = new Point(zx - (zadd * 4), zy - (zadd * 5));
                            else if (id == 3) ort = new Point(zx - (zadd * 5), zy - (zadd * 4));
                            else if (id == 4) ort = new Point(zx - (zadd * 4), zy - (zadd * 4));
                            break;
                    }
                    break;
                case 3: // Gruen
                    switch (zahl)
                    {
                        case 41:
                            ort = new Point(zx, zy - (zadd * 4));
                            break;
                        case 42:
                            ort = new Point(zx, zy - (zadd * 3));
                            break;
                        case 43:
                            ort = new Point(zx, zy - (zadd * 2));
                            break;
                        case 44:
                            ort = new Point(zx, zy - (zadd * 1));
                            break;
                        default:
                            if (id == 1) ort = new Point(zx + (zadd * 5), zy - (zadd * 5));
                            else if (id == 2) ort = new Point(zx + (zadd * 4), zy - (zadd * 5));
                            else if (id == 3) ort = new Point(zx + (zadd * 5), zy - (zadd * 4));
                            else if (id == 4) ort = new Point(zx + (zadd * 4), zy - (zadd * 4));
                            break;
                    }
                    break;
                case 4: // Gelb
                    switch (zahl)
                    {
                        case 41:
                            ort = new Point(zx + (zadd * 4), zy);
                            break;
                        case 42:
                            ort = new Point(zx + (zadd * 3), zy);
                            break;
                        case 43:
                            ort = new Point(zx + (zadd * 2), zy);
                            break;
                        case 44:
                            ort = new Point(zx + (zadd * 1), zy);
                            break;
                        default:
                            if (id == 1) ort = new Point(zx + (zadd * 5), zy + (zadd * 5));
                            else if (id == 2) ort = new Point(zx + (zadd * 4), zy + (zadd * 5));
                            else if (id == 3) ort = new Point(zx + (zadd * 5), zy + (zadd * 4));
                            else if (id == 4) ort = new Point(zx + (zadd * 4), zy + (zadd * 4));
                            break;
                    }
                    break;
            }
            return new Point(ort.x - figX, ort.y - figY); // Rückgabe des ermittelten Punktes
        }
    }
	
}
