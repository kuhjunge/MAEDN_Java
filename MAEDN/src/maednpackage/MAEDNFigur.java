package maednpackage;

public class MAEDNFigur {
	private int fortschritt = 0;
	
	// Der Aktuelle Fortschritt wird zur�ck gegeben
	public int getFortschritt()
	{
		return fortschritt;
	}
	
	// Schritt wird zum Fortschritt der Figur hinzugerechnet
	public void addFortschritt(int schritt)
	{
		if (fortschritt + schritt < 45 && fortschritt + schritt > 0) // Zahlen kleiner als 0 und �ber 45 nicht m�glich
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
