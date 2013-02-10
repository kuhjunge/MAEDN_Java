package maednpackage;

public class MAEDNWuerfel {
	
	// Zufallszahl erzeugen
	private static int myRandom(double low, double high) {
		double rndd = Math.round(Math.random() * (high - low) + low);
		int value = new Double(rndd).intValue();
		return value;
	}
	
	public static int wurf()
	{
		return myRandom(1,6); // Würfelzahl zurück geben
	}
}
