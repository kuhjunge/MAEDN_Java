package maednpackage;

public class MAEDNSpieler {
	private int sFarbe;
	private String sFarbeName;
	//private String sSpielerName = "Spieler";
	
	MAEDNFigur sFigur1; 
	MAEDNFigur sFigur2;
	MAEDNFigur sFigur3;
	MAEDNFigur sFigur4;
		
	// Konstruktor, wird beim Erschaffen des Objektes ausgeführt
	public MAEDNSpieler(int farbe)
	{
		if (farbe > 4 || farbe < 1) farbe = 1; // Sicherheitskontrolle, dass Farbe gültig ist
		sFarbe = farbe; // Farbe des Spielers wird zugewiesen
		String[] colorname = { "Jeder", "Rot", "Blau", "Grün", "Gelb" };
		sFarbeName = colorname[sFarbe];
		sFigur1 = new MAEDNFigur(); // Für jede Spielfigur wird ein Objekt erzeugt
		sFigur2 = new MAEDNFigur();
		sFigur3 = new MAEDNFigur();
		sFigur4 = new MAEDNFigur();
	}
	
	// Name der Farbe zurück geben
	public String getFarbeName()
	{
		return sFarbeName;
	}
	
	// Wert der Spielfigur zurück geben und umwandeln
	public int getFigurFort(int id)
	{
		switch(id)
		{
		case 1:
			return convertToFarbe(sFigur1.getFortschritt());
		case 2:
			return convertToFarbe(sFigur2.getFortschritt());
		case 3:
			return convertToFarbe(sFigur3.getFortschritt());
		case 4:
			return convertToFarbe(sFigur4.getFortschritt());
		default:
			return 0;
		}
	}
	
	// Wert der Spielfigur zurück geben
	private int getFigurFortRaw(int id)
	{
		switch(id)
		{
		case 1:
			return sFigur1.getFortschritt();
		case 2:
			return sFigur2.getFortschritt();
		case 3:
			return sFigur3.getFortschritt();
		case 4:
			return sFigur4.getFortschritt();
		default:
			return 0;
		}
	}
	
	// Addiert die angegebenen Schritte zum Fortschritt der Figur
	public void addFigurFort(int id, int wurf)
	{
		//JOptionPane.showMessageDialog(null, wurf);
		if (!checkcollideInside(id,wurf +getFigurFortRaw(id)))
		{
			switch(id)
			{
			case 1:
				sFigur1.addFortschritt(wurf);
				break;
			case 2:
				sFigur2.addFortschritt(wurf);
				break;
			case 3:
				sFigur3.addFortschritt(wurf);
				break;
			case 4:
				sFigur4.addFortschritt(wurf);
				break;
			}
		}
	}
	
	// Wandelt den Spielfeldwert in den Internen Fortschritt um
    private int convertToFarbe(int zahl)
    {
        if (sFarbe == 3)
        {
            if (zahl > 0 & zahl < 21)
                zahl = zahl + 20;
            else if (zahl > 20 & zahl < 41)
                zahl = zahl - 20;
        }

        else if (sFarbe == 2)
        {
            if (zahl > 0 & zahl < 31)
                zahl = zahl + 10;
            else if (zahl > 30 & zahl < 41)
                zahl = zahl - 30;
        }

        else if (sFarbe == 4)
        {
            if (zahl > 0 & zahl < 11)
                zahl = zahl + 30;
            else if (zahl > 10 & zahl < 41)
                zahl = zahl - 10;
        }
        return zahl;
    }
    
    // Kollisionsdetection im Objekt
    private boolean checkcollideInside(int id, int value)
    {
    	boolean ret = false;
    	if (id != 1) ret = sFigur1.collision(value);
    	if (id != 2 && !ret) ret = sFigur2.collision(value);
    	if (id != 3 && !ret) ret = sFigur3.collision(value);
    	if (id != 4 && !ret) ret = sFigur4.collision(value);
    	return ret;
    }
    
    // Kollisionsdetection auserhalb des Objektes
    private int checkcollide(int zahl)
    {
    	int value = convertToFarbe(zahl);
    	int ret = 0;
    	if (sFigur1.collision(value)) ret = 1;
    	if (sFigur2.collision(value)) ret = 2;
    	if (sFigur3.collision(value)) ret = 3;
    	if (sFigur4.collision(value)) ret = 4;
    	return ret;
    }
	//
}
