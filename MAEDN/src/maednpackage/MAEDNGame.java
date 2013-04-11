package maednpackage;

import java.util.List; // Liste verwenden
import java.util.ArrayList; // Liste verwenden

public class MAEDNGame {

	//Spieler
	private MAEDNSpieler sp1 = new MAEDNSpieler(1);
	private MAEDNSpieler sp2 = new MAEDNSpieler(2);
	private MAEDNSpieler sp3 = new MAEDNSpieler(3);
	private MAEDNSpieler sp4 = new MAEDNSpieler(4);
	private int spieleramzug = 0;
	
	private MAEDNWuerfel wuerfel = new MAEDNWuerfel(); // W�rfel
	private List<String> zugList = new ArrayList<String>(); // Liste f�r die Upzudatenen Figuren
	
	// Methoden
	/**
	* Aktueller Fortschritt der Figur
	* @param farbe - Die FarbID
	* @param id - Die ID der Figur
	* @return Den Wert der Spielfigur
	*/
    public int getFigurFort(int farbe, int id)
    {
    	MAEDNSpieler sp = getSpieler(farbe);
    	 return sp.getFigurFort(id);
    }
    
	/**
	* W�rfel benutzen
	*/
    public void wuerfeln()
    {
    	System.out.println("W�rfeln");	
    	// Pr�fen ob Zug m�glich
    	if (spieleramzug == 0) spieleramzug++; // Workaround um Endlosklicken beim W�rfel beim Start zu verhindern
    	MAEDNSpieler sp = getSpieler(spieleramzug); // Farbe ausw�hle
    	if(wuerfel.getWurf() == 0) // Normaler Wurf
    	{
    		wuerfel.resetVersuche();
    		wuerfel.wurf();
    		System.out.println("Normaler Wurf");
    	}
    	else if (wuerfel.getWurf() != 6 && sp.mehrfachwurf() && wuerfel.getVersuche() < 3) // 3 Versuche bei Spielbeginn
    	{
    		wuerfel.resetWurf();
    		wuerfel.wurf();
    		System.out.println("3 Mal w�rfeln beim Start");
    		if (wuerfel.getVersuche() == 3) checkzug(); // Letzten Versuch verhauen
    	}
    	else checkzug(); // Wurf wird abgebrochen, wenn kein Zug m�glich ist -> N�chster Spieler
    	System.out.println("Spieler am Zug:" + spieleramzug);
    }
    
	/**
	* Pr�fen ob ein Zug m�glich ist
	*/
    private void checkzug() 
    {
    	MAEDNSpieler sp = getSpieler(spieleramzug); // Farbe ausw�hle
    	if (sp.checkpossibly(wuerfel.getWurf()) == false)
    	{
    		spieleramzug++;
    		if (spieleramzug == 5) spieleramzug = 1; // Korrektur, dass nach Spieler 4 Spieler 1 kommt
    		wuerfel.resetVersuche();
    		wuerfel.resetWurf();
    		wuerfel.enable();
    		System.out.println("W�rfel wird gel�scht -> Blockiersicherung");
    	}	
    }
    
	/**
	* Gibt zur�ck welcher Spieler am Zug ist
	* @return gibt den Wert zur�ck welcher Spieler am Zug ist
	*/
    public int getspieleramzug()
    {
    	return spieleramzug;
    }
    
	/* *
	* F�hrt ein Kommando aus  (Funktion f�r Debug)
	* @param com - Kommando (String)
	* /
    public void com(String com)
    {
    	System.out.println("Kommando");
    	wuerfel.setWurf(6);
    	if (com == "wurf")
    	{
    		wuerfel.setWurf(6);
			System.out.println("Kommando 2");
    	}
    }
    */
    
	/**
	* Der Zug wird ausgef�hrt (KLICK auf Spielfigur)
	* @param farbe - Die FarbID
	* @param id - Die SpielfigurID
	* @return Den Wert der Spielfigur
	*/
    public int zug(int farbe, int id)
    {
    	System.out.println("KLICK!");
    	System.out.println("Spieler :"+ farbe + " == " + spieleramzug);
    	MAEDNSpieler sp = getSpieler(farbe); // Farbe ausw�hlen
    	if (sp == null) return 0; // Wenn fehlerhafte Farbe ausgew�hlt wurde
    	//spieleramzug = 0; // DEBUG - Rundensystem f�r Testzwecke aushebeln
    	if (spieleramzug == farbe || spieleramzug == 0) // Wenn Spieler drann ist 
    	{
    		if (spieleramzug == 0) spieleramzug = farbe; // Spielerfarbe beim ersten Zug setzen
	    	int vorher = sp.getFigurFort(id); // Zahl die zuvor gespielt wurde merken
	    	// Zug 
	    	sp.addFigurFort(id, wuerfel.getWurf()); // Addiert den Fortschritt zur Figur
	    	// Rausschmei�check 
	    	int[] kick = new int[2]; // Variable zum Rausschmei�en
	    	//kick[1] = 0;
	    	kick = kickcheck(farbe,sp.getFigurFort(id)); // Es wird gepr�ft welche Figur rausgeschmissen werden k�nnen
	    	if (kick[1] > 0) 
	    	{
	    		System.out.println("Spieler wird rausgeschmissen");
	    		MAEDNSpieler spk = getSpieler(kick[0]); //Die entsprechende Figur
	    		spk.kickFigur(kick[1]); //  wird wieer auf 0 zur�ck gesetzt (also rausgeschmissen)
	    		zugList.add(kick[0]+"-"+kick[1]); // Und die Figur wird auf die Liste der ver�nderten Figuren gesetzt
	    	}
	    	// Pr�fen ob unterschied zu vorher
	    	if (vorher != sp.getFigurFort(id))
    		{
	    		if (wuerfel.getWurf() != 6 && wuerfel.getWurf() != 0) spieleramzug++; // Bei 6 Spieler nicht weiter setzten
    			wuerfel.resetWurf(); // Wenn der Zug stattgefunden hat, wird der W�rfel zur�ckgesetzt
    			System.out.println("W�rfel reseten");
    			if (spieleramzug == 5) spieleramzug = 1; // Korrektur, dass nach Spieler 4 Spieler 1 kommt
    		}
	    	
    	}
    	return sp.getFigurFort(id); // Gibt den aktuellen Spielfigurenfortschritt zur�ck
    }
    
	/**
	* List mit zu ziehenden Figuren (au�erhalb der geklickten Figuren)
	* Diese Liste hilft alle rausgeschmissenen Figuren mitzubewegen
	* @return Eine Liste mit Spielfiguren die au�erhalb der angeklickten Figur bewegt werden
	*/
    public List<String> getMoveList()
    {
    	List <String> rlist = zugList;
    	return rlist;
    }
    
	/**
	* l�scht die Liste mit den noch zu t�tigen Z�gen auf dem Spielfeld
	*/
    public void clearMoveList()
    {
    	zugList.clear(); 
    }
    
	/**
	* Spielerobjekt ausgeben
	* @param farbe - Die FarbID
	* @return Das Objekt des Spielers
	*/
    private MAEDNSpieler getSpieler(int farbe)
    {
    	MAEDNSpieler sp = null;
		switch(farbe)
		{
		case 1:
			sp = sp1;
			break;
		case 2:
			sp = sp2;
			break;
		case 3:
			sp = sp3;
			break;
		case 4:
			sp = sp4;
			break;
		}
		return sp;
    }
    
	/**
	* �berpr�fen ob eine Spielfigur rausgeschmissen werden kann
	* @param req - Der Rausschmei�er
	* @param val - Der Wert des Feldes
	* @return Array mit Farbe und ID der rauszuschmei�enden Figur
	*/
    private int[] kickcheck(int req, int val)
    { //req = request -> derjenige, der den Zug gemacht hat
    	int[]ret = new int[2];
    	ret[0] = 0; // Farbe der rauszuschmei�enden Figur
    	ret[1] = 0; // ID der rauszuschmei�enden Figur
    	for (int i= 1; i < 5;i++)
    	{
    		if (i != req)
    		{
    			MAEDNSpieler sp = getSpieler(i);
    			ret[1] = sp.checkcollide(val); // ID des Opfers setzen
    			if (ret[1] > 0) 
    			{
    				ret[0] = i;
    				break;
    			}
    		}
    	}
    	return ret;
    }
   
	/**
	* Gibt den aktuellen Wurf des W�rfels zur�ck
	* @return Wurf
	*/
    public int getWurf()
    {
    	return wuerfel.getWurf();
    }
	// Ende
}
