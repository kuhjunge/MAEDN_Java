package maednpackage;

public class MAEDNWuerfel {
	
	// Variabeln
	private int wurf = 0; // Hier wird der W�rfelwert gespeichert
	private int wurfzaehler = 0;
	private int wurfversuch = 0;
	private boolean forceenable = false;
	
	// Methoden
	// Zufallszahl erzeugen
	private static int zufallszahl(double low, double high) {
		double rndd = Math.round(Math.random() * (high - low) + low);
		int value = new Double(rndd).intValue();
		return value;
	}
	
	// Simuliert einen W�rfelwurf
	public void wurf()
	{
		if (wurf == 0 || forceenable) wurf = zufallszahl(1,6); // W�rfelzahl zur�ck geben
		wurfzaehler++;
		wurfversuch++;
		forceenable = false;
		System.out.println("W�rfel: "+ wurf + " Versuch" + wurfversuch + " Gesamt: " + wurfzaehler);
	}
	
	// Setzt den W�rfel zur�ck
	public void resetWurf()
	{
		wurf = 0; // Wurf auf Null zur�cksetzen
	}
	
	// Setzt den Wert des W�rfels manuell (Debug / Cheat)
	public void setWurf(int swurf)
	{
		 wurf = swurf; // Wert des Wurfes �ndern
	}
	
	// Gibt den W�rfelwert zur�ck
	public int getWurf()
	{
		return wurf; // W�rfelzahl zur�ck geben
	}
	
	// Gibt den W�rfelz�hler zur�ck
	public int getWurfzaheler()
	{
		return wurfzaehler; // W�rfelz�hler zur�ck geben
	}
	
	// Versuche zur�cksetzen
	public void resetVersuche()
	{
		wurfversuch = 0; // Versuche auf Null setzen
	}
	
	// Versuche auslesen
	public int getVersuche()
	{
		return wurfversuch; // gibt die versuche zur�ck
	}
	
	public void enable()
	{
		forceenable = true;
	}
}
