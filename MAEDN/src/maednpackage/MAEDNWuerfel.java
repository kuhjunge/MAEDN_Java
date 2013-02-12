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
		wurf = myRandom(1,6); // Würfelzahl zurück geben
	}
	
	// Gibt den Würfelwert zurück
	public int getInfoWurf()
	{
		return wurf; // Würfelzahl zurück geben
	}
	
	// Gibt den Würfelwert zurück, setzt dabei den Würfel wieder auf 0
	public int getWurf()
	{
		int w = wurf;
		wurf = 0;
		return w; // Würfelzahl zurück geben
	}
}
