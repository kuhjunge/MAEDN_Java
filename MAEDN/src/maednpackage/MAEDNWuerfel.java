package maednpackage;

public class MAEDNWuerfel {
	
	// Variabeln
	private int wurf = 0; // Hier wird der W�rfelwert gespeichert
	private int wurfzaehler = 0;
	private int wurfversuch = 0;
	private boolean forceenable = false;
	
	// Methoden
	/**
	* Zufallszahl erzeugen
	* @param Die niedrigste Zahl
	* @param Die h�chste Zahl
	* @return Eine Zufallszahl zwischen den angegebenen low - high Werten
	*/
	private static int zufallszahl(double low, double high) {
		double rndd = Math.round(Math.random() * (high - low) + low);
		int value = new Double(rndd).intValue();
		return value;
	}
	
	/**
	* Simuliert einen W�rfelwurf
	*/
	public void wurf()
	{
		if (wurf == 0 || forceenable) wurf = zufallszahl(1,6); // W�rfelzahl zur�ck geben
		wurfzaehler++;
		wurfversuch++;
		forceenable = false;
		System.out.println("W�rfel: "+ wurf + " Versuch" + wurfversuch + " Gesamt: " + wurfzaehler);
	}
	
	/**
	* Setzt den W�rfel zur�ck
	*/
	public void resetWurf()
	{
		wurf = 0; // Wurf auf Null zur�cksetzen
	}
	
	/**
	* Setzt den Wert des W�rfels manuell (Debug / Cheat)
	* @param Die gew�nschte W�rfelzahl
	*/
	public void setWurf(int swurf)
	{
		 wurf = swurf; // Wert des Wurfes �ndern
	}
	
	/**
	* Gibt den W�rfelwert zur�ck
	* @return Gibt den W�rfelwert zur�ck
	*/
	public int getWurf()
	{
		return wurf; // W�rfelzahl zur�ck geben
	}
	
	/**
	* Gibt den W�rfelz�hler zur�ck
	* @return Gibt den W�rfelz�hler zur�ck
	*/
	public int getWurfzaheler()
	{
		return wurfzaehler; // W�rfelz�hler zur�ck geben
	}
	
	/**
	*  Versuche zur�cksetzen
	*/
	public void resetVersuche()
	{
		wurfversuch = 0; // Versuche auf Null setzen
	}
	
	/**
	* Versuche auslesen
	* @return Anzahl der Versuche
	*/
	public int getVersuche()
	{
		return wurfversuch; // gibt die versuche zur�ck
	}
	
	/**
	* Erm�glicht den Wurf obwohl der W�rfel noch einen Wert besitzt 
	* (Workaround f�r die fehlende anzeige des dritten W�rfelversuches)
	*/
	public void enable()
	{
		forceenable = true;
	}
}
