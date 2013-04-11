package maednpackage;

public class MAEDNWuerfel {
	
	// Variabeln
	private int wurf = 0; // Hier wird der Würfelwert gespeichert
	private int wurfzaehler = 0;
	private int wurfversuch = 0;
	private boolean forceenable = false;
	
	// Methoden
	/**
	* Zufallszahl erzeugen
	* @param Die niedrigste Zahl
	* @param Die höchste Zahl
	* @return Eine Zufallszahl zwischen den angegebenen low - high Werten
	*/
	private static int zufallszahl(double low, double high) {
		double rndd = Math.round(Math.random() * (high - low) + low);
		int value = new Double(rndd).intValue();
		return value;
	}
	
	/**
	* Simuliert einen Würfelwurf
	*/
	public void wurf()
	{
		if (wurf == 0 || forceenable) wurf = zufallszahl(1,6); // Würfelzahl zurück geben
		wurfzaehler++;
		wurfversuch++;
		forceenable = false;
		System.out.println("Würfel: "+ wurf + " Versuch" + wurfversuch + " Gesamt: " + wurfzaehler);
	}
	
	/**
	* Setzt den Würfel zurück
	*/
	public void resetWurf()
	{
		wurf = 0; // Wurf auf Null zurücksetzen
	}
	
	/**
	* Setzt den Wert des Würfels manuell (Debug / Cheat)
	* @param Die gewünschte Würfelzahl
	*/
	public void setWurf(int swurf)
	{
		 wurf = swurf; // Wert des Wurfes ändern
	}
	
	/**
	* Gibt den Würfelwert zurück
	* @return Gibt den Würfelwert zurück
	*/
	public int getWurf()
	{
		return wurf; // Würfelzahl zurück geben
	}
	
	/**
	* Gibt den Würfelzähler zurück
	* @return Gibt den Würfelzähler zurück
	*/
	public int getWurfzaheler()
	{
		return wurfzaehler; // Würfelzähler zurück geben
	}
	
	/**
	*  Versuche zurücksetzen
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
		return wurfversuch; // gibt die versuche zurück
	}
	
	/**
	* Ermöglicht den Wurf obwohl der Würfel noch einen Wert besitzt 
	* (Workaround für die fehlende anzeige des dritten Würfelversuches)
	*/
	public void enable()
	{
		forceenable = true;
	}
}
