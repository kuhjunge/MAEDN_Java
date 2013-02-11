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
	
	// Wert der Spielfigur zurück geben
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
	
	// Addiert die angegebenen Schritte zum Fortschritt der Figur
	public void addFigurFort(int id, int wurf)
	{
		//JOptionPane.showMessageDialog(null, wurf);
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
	//
}
