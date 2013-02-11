package maednpackage;

public class MAEDNFigur {
	private int fFortschritt = 0;
	private int fFarbe = 1;
	
	public MAEDNFigur(int farbe)
	{
		fFarbe = farbe;
	}
	// Der Aktuelle Fortschritt wird zurück gegeben
	public int getFortschritt()
	{
		return convertToFarbe(fFortschritt);
	}
	
	public int getFortschrittRaw()
	{
		return fFortschritt;
	}
	
	// Schritt wird zum Fortschritt der Figur hinzugerechnet
	public void addFortschritt(int schritt)
	{
		if (fFortschritt + schritt < 45 && fFortschritt + schritt > 0) // Zahlen kleiner als 0 und über 45 nicht möglich
		fFortschritt = fFortschritt+ schritt; // Fortschritt zur Figur addieren
	}
	
	// Figur wurde rausgeschmissen
	public void gekickt()
	{
		fFortschritt = 0;
	}
	
	// Kollisionserkennung der Figur
	public boolean collision(int value)
	{
		if (value == convertToFarbe(fFortschritt)) return true;
		else return false;
	}
	
	// Kollisionserkennung der Figur
	public boolean collisionRaw(int value)
	{
		if (value == fFortschritt) return true;
		else return false;
	}
	
	// Wandelt den Spielfeldwert in den Internen Fortschritt um
	private int convertToFarbe(int zahl)
    {
        if (fFarbe == 3)
        {
            if (zahl > 0 && zahl < 21)
                zahl = zahl + 20;
            else if (zahl > 20 & zahl < 41)
                zahl = zahl - 20;
        }

        else if (fFarbe == 2)
        {
            if (zahl > 0 && zahl < 31)
                zahl = zahl + 10;
            else if (zahl > 30 & zahl < 41)
                zahl = zahl - 30;
        }

        else if (fFarbe == 4)
        {
            if (zahl > 0 && zahl < 11)
                zahl = zahl + 30;
            else if (zahl > 10 & zahl < 41)
                zahl = zahl - 10;
        }
        return zahl;
    }
}
