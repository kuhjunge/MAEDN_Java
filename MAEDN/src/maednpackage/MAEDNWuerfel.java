package maednpackage;

public class MAEDNWuerfel {
	
	private int wurf = 0; // Hier wird der Würfelwert gespeichert
	private int wurfzaehler = 0;
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
		wurfzaehler++;
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
