package maednpackage;

public class MAEDNWuerfel {
	
	private int wurf = 0; // Hier wird der Würfelwert gespeichert
	
	// Zufallszahl erzeugen
	private static int myRandom(double low, double high) {
		double rndd = Math.round(Math.random() * (high - low) + low);
		int value = new Double(rndd).intValue();
		return value;
	}
	
	// Simuliert einen Würfelwurf
	public void wurf()
	{
		if (wurf == 0) wurf = myRandom(1,6); // Würfelzahl zurück geben
	}
	
	// Setzt den Würfel zurück
	public void resetWurf()
	{
		wurf = 0; // Würfelzahl zurück geben
	}
	
	// Gibt den Würfelwert zurück
	public int getWurf()
	{
		return wurf; // Würfelzahl zurück geben
	}
}
