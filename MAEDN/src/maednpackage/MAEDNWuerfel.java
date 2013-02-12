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
		wurf = myRandom(1,6); // W�rfelzahl zur�ck geben
	}
	
	// Gibt den W�rfelwert zur�ck
	public int getInfoWurf()
	{
		return wurf; // W�rfelzahl zur�ck geben
	}
	
	// Gibt den W�rfelwert zur�ck, setzt dabei den W�rfel wieder auf 0
	public int getWurf()
	{
		int w = wurf;
		wurf = 0;
		return w; // W�rfelzahl zur�ck geben
	}
}
