package maednpackage;

public class MAEDNFigur {
	private int fortschritt = 0;
	
	// Der Aktuelle Fortschritt wird zurück gegeben
	public int getFortschritt()
	{
		return fortschritt;
	}
	
	// Schritt wird zum Fortschritt der Figur hinzugerechnet
	public void addFortschritt(int schritt)
	{
		if (fortschritt + schritt < 45 && fortschritt + schritt > 0) // Zahlen kleiner als 0 und über 45 nicht möglich
		fortschritt = fortschritt+ schritt; // Fortschritt zur Figur addieren
	}
	
	// Figur wurde rausgeschmissen
	public void gekickt(int schritt)
	{
		fortschritt = 0;
	}
	
	// Kollisionserkennung der Figur
	public boolean collision(int value)
	{
		if (value == fortschritt) return true;
		else return false;
	}
}
