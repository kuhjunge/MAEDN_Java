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
	
	// Würfel
	MAEDNWuerfel wuerfel = new MAEDNWuerfel();
    
	// Liste für die Upzudatenen Figuren
	private List<String> zugList = new ArrayList<String>();
	
	// Aktueller Fortschritt der Figur
    public int getFigurFort(int farbe, int id)
    {
    	MAEDNSpieler sp = getSpieler(farbe);
    	 return sp.getFigurFort(id);
    }
	
    // Würfel benutzen
    public void wuerfeln()
    {
    	System.out.println("Würfeln");
    	wuerfel.resetWurf();
    	wuerfel.wurf();
    }
    
    public void com(String com)
    {
    	System.out.println("Kommando gefeuert");
    	wuerfel.setWurf(6);
    	if (com == "wurf")
    	{
    		wuerfel.setWurf(6);
			System.out.println("Kommando 2");
    	}
    }
    
	// Der Zug wird ausgeführt
    public int zug(int farbe, int id)
    {
    	System.out.println("KLICK!");
    	MAEDNSpieler sp = getSpieler(farbe); // Farbe auswählen
    	if (sp == null) return 0; // Wenn fehlerhafte Farbe ausgewählt wurde
    	if (spieleramzug == farbe || spieleramzug == 0) // Wenn Spieler drann ist 
    	{
    		System.out.println("Spieler :" + spieleramzug);
    		if (spieleramzug == 0) spieleramzug = farbe; // Spielerfarbe beim ersten Zug setzen
	    	int vorher = sp.getFigurFort(id); // Zahl die zuvor gespielt wurde merken
	    	// Zug 
	    	sp.addFigurFort(id, wuerfel.getWurf()); // Addiert den Fortschritt zur Figur
	    	if (wuerfel.getWurf() != 6 && wuerfel.getWurf() != 0) spieleramzug++; // Bei 6 Spieler nicht weiter setzten
	    	// Rausschmeißcheck 
	    	int[] kick = new int[2]; // Variable zum Rausschmeißen
	    	//kick[1] = 0;
	    	kick = kickcheck(farbe,sp.getFigurFort(id)); // Es wird geprüft welche Figur rausgeschmissen werden können
	    	if (kick[1] > 0) 
	    	{
	    		System.out.println("Spieler wird rausgeschmissen");
	    		MAEDNSpieler spk = getSpieler(kick[0]); //Die entsprechende Figur
	    		spk.kickFigur(kick[1]); //  wird wieer auf 0 zurück gesetzt (also rausgeschmissen)
	    		zugList.add(kick[0]+"-"+kick[1]); // Und die Figur wird auf die Liste der veränderten Figuren gesetzt
	    	}
	
	    	if (vorher != sp.getFigurFort(id))
    		{
    			wuerfel.resetWurf(); // Wenn der Zug stattgefunden hat, wird der Würfel zurückgesetzt
    			System.out.println("Würfel reseten");
    		}
	    	if (spieleramzug == 5) spieleramzug = 1; // Korrektur, dass nach Spieler 4 Spieler 1 kommt
    	}
    	return sp.getFigurFort(id); // Gibt den aktuellen Spielfigurenfortschritt zurück
    }
    
    // List mit zu ziehenden Figuren (außerhalb der geklickten Figuren)
    public List<String> getMoveList()
    {
    	List <String> rlist = zugList;
    	return rlist;
    }
    
    // löscht die Liste mit den noch zu tätigen Zügen auf dem Spielfeld 
    public void clearMoveList()
    {
    	zugList.clear(); 
    }
    
    // Spielerobjekt ausgeben
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
    
    // Überprüfen ob eine Spielfigur rausgeschmissen werden kann
    public int[] kickcheck(int req, int val)
    { //req = request -> derjenige, der den Zug gemacht hat
    	int[]ret = new int[2];
    	ret[0] = 0; // Farbe der rauszuschmeißenden Figur
    	ret[1] = 0; // ID der rauszuschmeißenden Figur
    	for (int i= 1; i < 5;i++)
    	{
    		if (i != req)
    		{
    			MAEDNSpieler sp = getSpieler(i);
    			ret[1] = sp.checkcollide(val); // ID des Opfer setzen
    			if (ret[1] > 0) 
    			{
    				ret[0] = i;
    				break;
    			}
    		}
    	}
    	return ret;
    }
   
    // Gibt den aktuellen Wurf des Würfels zurück
    public int getWurf()
    {
    	return wuerfel.getWurf();
    }
    
    // Prüft ob ein Zug möglich ist
	public int wurfki(int farbe,int  wurf)
	{
		// Spieler & Gegner einlesen
    	//Prüfen ob Wurf über 0
    	if (wurf > 0)
    	{
    		// für jede Figur
        	for (int i= 1; i < 5;i++)
        	{
        		
        	}
    	}
    	return 0; // Rückgabe der ziehbaren ID, Wenn 0 Kein Zug möglich(platzhalter) 
	}
	// Ende
}
