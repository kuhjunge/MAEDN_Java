package maednpackage;

public class MAEDNFigur {
	private int fFortschritt = 0; // Fortschritt der Figur wird hier gespeichert
	private int fFarbe = 1; // Farbe der Figur wird hier gespeichert
	
	// Konstruktor: Initialisiert das Objekt -> setzt die Farbe
	public MAEDNFigur(int farbe)
	{
		fFarbe = farbe; // Setzt die Farbe der Figur
	}
	
	// Der Aktuelle Fortschritt wird zurück gegeben
	public int getFortschritt()
	{
		return convertToFarbe(fFortschritt); // Befor der Fortschritt zurück gegeben wird, wird der Wrt umgewandelt in die Farbe der Spielfigur
	}
	
	// Gibt den aktuellen Fortschritt zurück ohne die Farbdifferenzu umzurechnen
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
	
	// Kollisionserkennung der Figur für die eigene Farbe
	public boolean collisionRaw(int value)
	{
		if (value == fFortschritt) return true;
		else return false;
	}
	
	// Wandelt den Spielfeldwert in den Internen Fortschritt um
	private int convertToFarbe(int zahl)
    {
		// Werte zwischen 1 und 40 werden versetzt damit die Farbe auf dem richtigen Feld im Spielfeld steht
        if (fFarbe == 3) // Grün Startfeld: 21
        {
            if (zahl > 0 && zahl < 21)
                zahl = zahl + 20;
            else if (zahl > 20 & zahl < 41)
                zahl = zahl - 20;
        }

        else if (fFarbe == 2) // Blau Startfeld 11
        {
            if (zahl > 0 && zahl < 31)
                zahl = zahl + 10;
            else if (zahl > 30 & zahl < 41)
                zahl = zahl - 30;
        }

        else if (fFarbe == 4) // Gelb Startfeld 31
        {
            if (zahl > 0 && zahl < 11)
                zahl = zahl + 30;
            else if (zahl > 10 & zahl < 41)
                zahl = zahl - 10;
        }
		// Rot wird nicht mit abgefragt, da Rot auf dem Feld 1 Startet und somit nicht umgerechnet werden muss
        return zahl;
    }
	// Ende
}
