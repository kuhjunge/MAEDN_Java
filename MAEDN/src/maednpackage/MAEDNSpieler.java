package maednpackage;

public class MAEDNSpieler {
	private int sFarbe; // Spielerfarbe
	private String sFarbeName; // Name der Farbe
	//private String sSpielerName = "Spieler"; // F�r Menu / Netzwerkanzeige oder was auch immer
	
	// die Spielfiguren
	private MAEDNFigur sFigur1; 
	private MAEDNFigur sFigur2;
	private MAEDNFigur sFigur3;
	private MAEDNFigur sFigur4;
		
	/**
	* Konstruktor, wird beim Erschaffen des Objektes ausgef�hrt
	* @param farbe - Die ID der Farbe
	*/
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
	
	/**
	* Gibt den Namen der Farbe zur�ck, die am Zug ist
	* @return Name der Farbe
	*/
	public String getFarbeName()
	{
		return sFarbeName;
	}
	
	/**
	* Gibt das Objekt der ausgew�hlten Spielfigur zur�ck
	* @param id - Die ID der Figur
	* @return Das Objekt der Spielfigur
	*/
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
	
	/**
	* Rausschmissfunktion
	* @param id - Die ID der Figur
	*/
	public void kickFigur(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur != null)
		{
			figur.gekickt(); // Die ausgew�hlte Figur wird rausgeschmissen
		}
	}
	
	/**
	* Wert der Spielfigur zur�ck geben und umwandeln
	* @param id - Die ID der Figur
	* @return Wert der Spielfigur (auf welchen Spielfeld steht sie?)
	*/
	public int getFigurFort(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur == null) return 0; // Sicherheit bei ung�ltiger Objektabfrage
		return figur.getFortschritt();
	}
	
	/**
	* Wert der Spielfigur zur�ck geben ohne Farbumrechnung
	* @param id - Die ID der Figur
	* @return Wert der Spielfigur (Interner Wert / Nicht auf Spieleldwert umgerechnet)
	*/
	public int getFigurFortRaw(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur == null) return 0; // Sicherheit bei ung�ltiger Objektabfrage
		return figur.getFortschrittRaw();
	}
	
	/**
	* Addiert die angegebenen Schritte zum Fortschritt der Figur
	* @param id - Die ID der Figur
	* @param wurf - Der Wert des W�rfels
	*/
	public void addFigurFort(int id, int wurf)
	{
		//JOptionPane.showMessageDialog(null, wurf);
		MAEDNFigur figur =  fig(id);
		if (figur != null && wurfmoeglich(id,  wurf)) figur.addFortschritt(wurf); // addiert den Wurf dazu wenn die Regeln es erlauben
	}
	
	/**
	* Kollisionsdetection Objektintern
	* @param id - Die ID der zu �berpr�fenden Figur (Die Figur die gerade bewegt wird)
	* @param value - Das Spielfeld was �berpr�ft werden soll
	* @return True wenn ein Zug mit irgendeiner Figur m�glich ist, False wenn kein Zug m�glich ist
	*/
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
    
	/**
	* Kollisionsdetection auserhalb des Objektes
	* @param zahl - Die zu �berpr�fende Zahl (Spielfeld)
	* @return Wenn keine Kollision dann 0 Sonst einen Wert �ber 0
	*/
    public int checkcollide(int zahl)
    { // Diese Methode wird als Beispiel in der Dokumentation verwendet
    	int ret = 0;
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
    
	/**
	* Guckt nach wieviele Figuren sich im Haus befinden
	* @return Anzahl der sich im Haus befindlichen Figuren
	*/
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
    
	/**
	* Z�hlt alle Figurenwerte zusammen 
	* @return Gesamtwert aller Figuren (maxr�ckgabewert: 170)
	*/
    private int getGesamtFigurWert()
    {
    	int geswert = 0;
    	for (int i= 1; i < 5;i++)
    	{
    		geswert = geswert + getFigurFortRaw(i);
    	}
    	return geswert;
    }
    
	/**
	* gibt die Anzahl der Wurfversuche zur�ck
	* @return True wenn ein Mehrfachwurf m�glich ist (Alle Figuren im Haus), False wenn nicht
	*/
    public boolean mehrfachwurf()
    {
    	int draussen = 4 - getFigurImHaus();
    	int gesamt = getGesamtFigurWert();
    	boolean mehrfachwurf = false; // Normalerweise einen Wurf
    	
        if (draussen == 0) mehrfachwurf = true; //3 mal W�rfeln wenn keine Figur auf dem Feld ist
        if (draussen == 1 && gesamt == 44) mehrfachwurf = true; // 3 mal W�rfeln da eine Figuren im im Ziel und drei im Haus sind
        else if (draussen == 2 && gesamt == 87) mehrfachwurf = true; //3 mal W�rfeln da zwei Figuren im im Ziel und zwei im Haus sind
        else if (draussen == 3 && gesamt == 129) mehrfachwurf = true; // 3 mal W�rfeln da drei Figuren im im Ziel und eine im Haus sind
       // else if (gesamt == 170) wurfanzahl = 0;  // Spiel zuende
        return mehrfachwurf;
    }
    
    /**
	* pr�ft ob ein Zug m�glich ist
	* @param wurf - Die gew�rfelte Zahl
	* @return True wenn ein Zug mit irgendeiner Figur m�glich ist, False wenn kein Zug m�glich ist
	*/
    public boolean checkpossibly(int wurf)
    {
    	if(wurfmoeglich(1,wurf) ||
    	wurfmoeglich(2,wurf) || 
    	wurfmoeglich(3,wurf) || 
    	wurfmoeglich(4,wurf)) return true;
    	else return false;
    }
    
	/**
	* pr�ft ob auf diesem Feld eine Spielfigur steht
	* @param zahl - Das zu �berpr�fende Spielfeld
	* @return Wenn Null, dann steht keine Figur der eigenen Farbe auf dem Spielfeld. Wenn 1, dann steht eine Figur der eigenen Farbe auf dem Feld
	*/
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
    
	/**
	* pr�ft ob der Zug m�glich ist
	* @param id - Die ID der zu �berpr�fenden Spielfigur
	* @param wurf - Die gew�rfelte Zahl (wurf)
	* @return Wahr wenn ein Spielzug mit dieser Figur m�glich ist
	*/
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
    	if (wurfZahl == startZahl) 
    	{
    		wurfmoeglich =false;
    		System.out.println("W�rfel ist 0!");
    	}
    	
		//Wenn �ber 44 = Zug nicht m�glich
    	if (wurfZahl > 44) 
    	{
    		wurfmoeglich =false;
    		System.out.println("W�rfel �ber 44");
    	}
    	
    	// Wenn erster Zug und Startfeld besetzt
		if (startZahl == 0 && checkcollideInside(id,1)) // Kollision mit der eigenen Farbe?
		{
			wurfmoeglich = false;
			System.out.println("erster Zug und Startfeld besetzt");
		}
		
    	// Wenn Farbe von eigener Farbe besetzt = zug nicht m�glich
    	else if (checkcollideInside(id,wurfZahl)) // Kollision mit der eigenen Farbe?
		{
			wurfmoeglich = false;
			System.out.println("Farbe von eigener Farbe besetzt = zug nicht m�glich");
		}

		// und der W�rfel nicht 6 ist und man sich im Haus befindet
    	if (wurf != 6 && startZahl == 0) 
		{
			wurfmoeglich = false;
			System.out.println("der W�rfel nicht 6 ist und man sich im Haus befindet");
		}

        // Kritischer Zug vor dem Ziel
    	if (enthalten(wurfZahl) > 0 && wurfZahl != startZahl && wurfZahl == minzahl)
    	{
    		wurfmoeglich = false;
    		System.out.println("Zug verworfen da kritisch und kein Zug m�glich");
    	}
    	
    	// Bei 6 muss eine Figur aus dem Haus genommen werden.
    	if (getFigurImHaus() > 0 && wurf == 6 && enthalten(1) == 0 && startZahl != 0)
    	{
    		wurfmoeglich = false;
    		System.out.println("Bei 6 muss eine Figur aus dem Haus genommen werden");
    	}
    	
    	// Ist das Startfeld frei?
        if (startZahl != 1 && getFigurImHaus() > 0 && enthalten(1) > 0)
        { // wenn diese Zahl nicht die auf dem Startfeld ist und das Startfeld belegt ist
        	if (enthalten(1 + wurf) < 1 && wurfZahl != 1 + wurf+ wurf)
            { // Wenn Startfeld + W�rfel belegt ist
            	wurfmoeglich = false;
            	System.out.println("Bitte erst das Startfeld freigeben!");
            }
            else if (enthalten(1 + wurf+ wurf) < 1 && wurfZahl != 1 + wurf+ wurf)
            {
            	wurfmoeglich = false;
                System.out.println("Bitte erst das Startfeld freigeben!");
            }
        }
    	
    	System.out.println("Zug ist m�glich?:" + wurfmoeglich);
    	return wurfmoeglich;
	}
	//
}
