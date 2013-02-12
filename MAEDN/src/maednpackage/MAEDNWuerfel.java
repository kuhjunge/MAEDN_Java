package maednpackage;

public class MAEDNWuerfel {
	
	private int wurf = 0; // Hier wird der W�rfelwert gespeichert
	
	// Zufallszahl erzeugen
	private static int myRandom(double low, double high) {
		double rndd = Math.round(Math.random() * (high - low) + low);
		int value = new Double(rndd).intValue();
		return value;
	}
	
	// Simuliert einen W�rfelwurf
	public void wurf()
	{
		if (wurf == 0) wurf = myRandom(1,6); // W�rfelzahl zur�ck geben
	}
	
	// Setzt den W�rfel zur�ck
	public void resetWurf()
	{
		wurf = 0; // W�rfelzahl zur�ck geben
	}
	
	// Gibt den W�rfelwert zur�ck
	public int getWurf()
	{
		return wurf; // W�rfelzahl zur�ck geben
	}
}
