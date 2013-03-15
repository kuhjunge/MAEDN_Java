package maednpackage;

public class MAEDNSpieler {
	private int sFarbe;
	private String sFarbeName;
	//private String sSpielerName = "Spieler";
	
	// die Spielfiguren
	private MAEDNFigur sFigur1; 
	private MAEDNFigur sFigur2;
	private MAEDNFigur sFigur3;
	private MAEDNFigur sFigur4;
		
	// Konstruktor, wird beim Erschaffen des Objektes ausgef�hrt
	public MAEDNSpieler(int farbe)
	{
		if (farbe > 4 || farbe < 1) farbe = 1; // Sicherheitskontrolle, dass Farbe g�ltig ist
		sFarbe = farbe; // Farbe des Spielers wird zugewiesen
		String[] colorname = { "Jeder", "Rot", "Blau", "Gr�n", "Gelb" };
		sFarbeName = colorname[sFarbe];
		sFigur1 = new MAEDNFigur(farbe); // F�r jede Spielfigur wird ein Objekt erzeugt
		sFigur2 = new MAEDNFigur(farbe);
		sFigur3 = new MAEDNFigur(farbe);
		sFigur4 = new MAEDNFigur(farbe);
	}
	
	// Name der Farbe zur�ck geben
	public String getFarbeName()
	{
		return sFarbeName;
	}
	
	// Gibt das Objekt der ausgew�hlten Spielfigur zur�ck
	private MAEDNFigur fig(int id)
	{
		MAEDNFigur figur = null;
		switch(id)
		{
		case 1:
			figur = sFigur1;
			break;
		case 2:
			figur = sFigur2;
			break;
		case 3:
			figur = sFigur3;
			break;
		case 4:
			figur = sFigur4;
			break;
		}
		return figur;
	}
	
	// Wert der Spielfigur zur�ck geben und umwandeln
	public void kickFigur(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur != null)
		{
			figur.gekickt(); // Die ausgew�hlte Figur wird rausgeschmissen
		}
	}
	
	// Wert der Spielfigur zur�ck geben und umwandeln
	public int getFigurFort(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur == null) return 0; // Sicherheit bei ung�ltiger Objektabfrage
		return figur.getFortschritt();
	}
	
	// Wert der Spielfigur zur�ck geben ohne Farbumrechnung
	public int getFigurFortRaw(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur == null) return 0; // Sicherheit bei ung�ltiger Objektabfrage
		return figur.getFortschrittRaw();
	}
	
	// Addiert die angegebenen Schritte zum Fortschritt der Figur
	public void addFigurFort(int id, int wurf)
	{
		//JOptionPane.showMessageDialog(null, wurf);
		MAEDNFigur figur =  fig(id);
		if (figur != null && wurfmoeglich(id,  wurf)) figur.addFortschritt(wurf); // addiert den Wurf dazu wenn die Regeln es erlauben
	}
	
    // Kollisionsdetection im Objekt
    private boolean checkcollideInside(int id, int value)
    {
    	boolean ret = false;
    	if (value > 0)
    	{
	    	for (int i = 1; i < 5; i++)
	    	{
	    		MAEDNFigur figur =  fig(i);
	    		if (id != i) ret = figur.collisionRaw(value);
	    		if (ret) break;
	    	}
    	}
    	return ret;
    }
    
    // Kollisionsdetection auserhalb des Objektes
    public int checkcollide(int zahl)
    {
    	int ret = 0;
    	//JOptionPane.showMessageDialog(null, zahl);
    	if (zahl > 0 && zahl < 41)
    	{
	    	for (int i = 1; i < 5; i++)
	    	{
	    		MAEDNFigur figur =  fig(i);
	    		if (figur.collision(zahl))
	    		{
	    			ret = i;
	    			break;
	    		}
	    	}
    	}
    	return ret;
    }
    
    // Guckt nach wieviele Figuren sich im Haus befinden
    //Wert zwischen eins und null
    /*
     * 
     * */
    private int getFigurImHaus()
    {
    	int geswert = 0;
    	for (int i= 1; i < 5;i++)
    	{
    		if (getFigurFortRaw(i)==0)
    		geswert++;
    	}
    	return geswert;
    }
    
    // Z�hlt alle Figurenwerte zusammen (maxr�ckgabewert: 170)
    private int getGesamtFigurWert()
    {
    	int geswert = 0;
    	for (int i= 1; i < 5;i++)
    	{
    		geswert = geswert + getFigurFortRaw(i);
    	}
    	return geswert;
    }
    
    // gibt die Anzahl der Wurfversuche zur�ck
    public int wurfAnzahl()
    {
    	int draussen = 4 - getFigurImHaus();
    	int gesamt = getGesamtFigurWert();
    	int wurfanzahl = 1; // Normalerweise einen Wurf
    	
        if (draussen == 0) wurfanzahl = 0; //3 mal W�rfeln wenn keine Figur auf dem Feld ist
        if (draussen == 1 && gesamt == 44) wurfanzahl = 0; // 3 mal W�rfeln da eine Figuren im im Ziel und drei im Haus sind
        else if (draussen == 2 && gesamt == 87) wurfanzahl = 0; //3 mal W�rfeln da zwei Figuren im im Ziel und zwei im Haus sind
        else if (draussen == 3 && gesamt == 129) wurfanzahl = 0; // 3 mal W�rfeln da drei Figuren im im Ziel und eine im Haus sind
        else if (gesamt == 170) wurfanzahl = 0;  // Spiel zuende
        return wurfanzahl;
    }
    
    // pr�ft ob die zahl in irgendeiner Spielfigur dieser Farbe enthalten ist
    // Wert NULL wenn keine Figur der eigenen Farbe auf dem Feld steht oder Wert 1 wenn eine Figur der eigenen Farbe auf dem Feld steht
    private int enthalten(int zahl)
    {
    	int erg = 0;
    	for (int i= 1; i < 5;i++)
    	{
    		if (zahl == getFigurFortRaw(i))
    		{
    			erg++;
    		}
    	}
 
    	return erg;
    }
    
    // pr�ft ob der Zug m�glich ist
	private boolean wurfmoeglich(int id, int wurf)
	{
		boolean wurfmoeglich = true;
		int startZahl = getFigurFortRaw(id);
		int wurfZahl = startZahl + wurf;// Die theoretisch zu ziehende Zahl ermitteln
        int minzahl = 44;
        for (int i = 0; i < 4; i++)
        {
            if (getFigurFortRaw(i) < minzahl)
                minzahl = getFigurFortRaw(i);
        }
        
		//Wenn �ber 44 = Zug nicht m�glich
    	if (wurfZahl > 44) 
    	{
    		wurfmoeglich =false;
    	}
    	
    	// Wenn erster Zug und Startfeld besetzt
		if (startZahl == 0 && checkcollideInside(id,1)) // Kollision mit der eigenen Farbe?
		{
			wurfmoeglich = false;
		}
		
    	// Wenn Farbe von eigener Farbe besetzt = zug nicht m�glich
    	else if (checkcollideInside(id,wurfZahl)) // Kollision mit der eigenen Farbe?
		{
			wurfmoeglich = false;
		}

		// und der W�rfel nicht 6 ist und man sich im Haus befindet
    	if (wurf != 6 && startZahl == 0) 
		{
			wurfmoeglich = false;
		}

        // Kritischer Zug vor dem Ziel
    /*	if (enthalten(wurfZahl) > 0 && wurfZahl != startZahl && wurfZahl == minzahl)
    	{
    		wurfmoeglich = false;
    	}*/
    	
    	// Bei 6 muss eine Figur aus dem Haus genommen werden.
    	// W
    /*	if (getFigurImHaus() > 0 && wurf == 6 && enthalten(1) > 0)
    	{
    		wurfmoeglich = false;
    	}
    	
    	// Ist das Startfeld frei
    	if (getFigurImHaus() > 0 && startZahl != 1 && enthalten(1) > 0)  //Wenn eine Figur im Haus ist und
    	{
    		if (enthalten(1 + wurf) > 0 && wurfZahl != 1 + wurf)
            { // Wenn Startfeld + W�rfel belegt ist
                wurfmoeglich = false;
            }
            else if (enthalten(1 + wurf + wurf) > 0 && wurfZahl != 1 + wurf + wurf)
            {
            	wurfmoeglich = false;
         */
    	return wurfmoeglich;
	}
	//
}
