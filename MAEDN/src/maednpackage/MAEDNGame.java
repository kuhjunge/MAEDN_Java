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
	
    public void wuerfeln()
    {
    	wuerfel.resetWurf();
    	wuerfel.wurf();
    }
    
	// Der Zug wird ausgef�hrt
    public int zug(int farbe, int id)
    {
    	MAEDNSpieler sp = getSpieler(farbe);
    	if (sp == null) return 0; // Wenn fehlerhafte Farbe ausgew�hlt wurde
    	int vorher = sp.getFigurFort(id);
    	// Regeln
    	
    	
    	// Zug 
    	sp.addFigurFort(id, wuerfel.getWurf());
    	// Rausschmei�check
    	int[] kick = new int[2];
    	//kick[1] = 0;
    	kick = kickcheck(farbe,sp.getFigurFort(id));
    	if (kick[1] > 0) 
    	{
    		MAEDNSpieler spk = getSpieler(kick[0]);
    		spk.kickFigur(kick[1]);
    		zugList.add(kick[0]+"-"+kick[1]);
    	}

    	if (vorher != sp.getFigurFort(id)) wuerfel.resetWurf();
    	return sp.getFigurFort(id);
    }
    
    // List mit zu updatenen Figuren
    public List<String> getMoveList()
    {
    	List <String> rlist = zugList;
    	return rlist;
    }
    
    public void clearMoveList()
    {
    	zugList.clear();
    }
    
    // Spielerobjekt erfassen
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
    /* ------- REGELN ------- */
    
    // �berpr�fen ob eine Spielfigur rausgeschmissen werden kann
    public int[] kickcheck(int req, int val)
    { //req = request -> derjenige, der den Zug gemacht hat
    	int[]ret = new int[2];
    	ret[0] = 0;
    	ret[1] = 0;
    	for (int i= 1; i < 5;i++)
    	{
    		if (i != req)
    		{
    			MAEDNSpieler sp = getSpieler(i);
    			ret[1] = sp.checkcollide(val);
    			if (ret[1] > 0) 
    			{
    				ret[0] = i;
    				break;
    			}
    		}
    	}
    	return ret;
    }
   
    
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
