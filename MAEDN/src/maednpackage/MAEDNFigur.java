package maednpackage;

public class MAEDNFigur {
	private int fortschritt = 0;
	
	public int getFortschritt()
	{
		return fortschritt;
	}
	
	public void addFortschritt(int schritt)
	{
		if (fortschritt + schritt < 45 && fortschritt + schritt > 0) // Zahlen kleiner als 0 und über 45 nicht möglich
		fortschritt = fortschritt+ schritt; // Fortschritt zur Figur addieren
	}
	
	public void gekickt(int schritt)
	{
		fortschritt = 0;
	}
	
	public boolean collision(int value)
	{
		if (value == fortschritt) return true;
		else return false;
	}
}
