package maednpackage;

import java.util.List; // Liste verwenden
import java.util.ArrayList; // Liste verwenden

public class MAEDNGame {

	//Spieler
	private MAEDNSpieler sp1 = new MAEDNSpieler(1);
	private MAEDNSpieler sp2 = new MAEDNSpieler(2);
	private MAEDNSpieler sp3 = new MAEDNSpieler(3);
	private MAEDNSpieler sp4 = new MAEDNSpieler(4);
	
	// W�rfel
	MAEDNWuerfel wuerfel = new MAEDNWuerfel();
    
	// Liste f�r die Upzudatenen Figuren
	private List<String> zugList = new ArrayList<String>();
	
	// Aktueller Fortschritt der Figur
    public int getFigurFort(int farbe, int id)
    {
    	MAEDNSpieler sp = getSpieler(farbe);
    	 return sp.getFigurFort(id);
    }
	
    // W�rfel benutzen
    public void wuerfeln()
    {
    	wuerfel.resetWurf();
    	wuerfel.wurf();
    }
    
	// Der Zug wird ausgef�hrt
    public int zug(int farbe, int id)
    {
    	MAEDNSpieler sp = getSpieler(farbe); // Farbe ausw�hlen
    	if (sp == null) return 0; // Wenn fehlerhafte Farbe ausgew�hlt wurde
    	int vorher = sp.getFigurFort(id); // Zahl die zuvor gespielt wurde merken
    	// Zug 
    	sp.addFigurFort(id, wuerfel.getWurf()); // Addiert den Fortschritt zur Figur
    	// Rausschmei�check 
    	int[] kick = new int[2]; // Variable zum Rausschmei�en
    	//kick[1] = 0;
    	kick = kickcheck(farbe,sp.getFigurFort(id)); // Es wird gepr�ft welche Figur rausgeschmissen werden k�nnen
    	if (kick[1] > 0) 
    	{
    		MAEDNSpieler spk = getSpieler(kick[0]); //Die entsprechende Figur
    		spk.kickFigur(kick[1]); //  wird wieer auf 0 zur�ck gesetzt (also rausgeschmissen)
    		zugList.add(kick[0]+"-"+kick[1]); // Und die Figur wird auf die Liste der ver�nderten Figuren gesetzt
    	}

    	if (vorher != sp.getFigurFort(id)) wuerfel.resetWurf(); // Wenn der Zug stattgefunden hat, wird der W�rfel zur�ckgesetzt
    	return sp.getFigurFort(id); // Gibt den aktuellen Spielfigurenfortschritt zur�ck
    }
    
    // List mit zu ziehenden Figuren (au�erhalb der geklickten Figuren)
    public List<String> getMoveList()
    {
    	List <String> rlist = zugList;
    	return rlist;
    }
    
    // l�scht die Liste mit den noch zu t�tigen Z�gen auf dem Spielfeld 
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
    
    // �berpr�fen ob eine Spielfigur rausgeschmissen werden kann
    public int[] kickcheck(int req, int val)
    { //req = request -> derjenige, der den Zug gemacht hat
    	int[]ret = new int[2];
    	ret[0] = 0; // Farbe der rauszuschmei�enden Figur
    	ret[1] = 0; // ID der rauszuschmei�enden Figur
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
   
    // Gibt den aktuellen Wurf des W�rfels zur�ck
    public int getWurf()
    {
    	return wuerfel.getWurf();
    }
    
    // Pr�ft ob ein Zug m�glich ist
	public int wurfki(int farbe,int  wurf)
	{
		// Spieler & Gegner einlesen
    	//Pr�fen ob Wurf �ber 0
    	if (wurf > 0)
    	{
    		// f�r jede Figur
        	for (int i= 1; i < 5;i++)
        	{
        		
        	}
    	}
    	return 0; // R�ckgabe der ziehbaren ID, Wenn 0 Kein Zug m�glich(platzhalter) 
	}
	// Ende
}
