package maednpackage;

public class MAEDNGame {

	//Spieler
	MAEDNSpieler sp1 = new MAEDNSpieler(1);
	MAEDNSpieler sp2 = new MAEDNSpieler(2);
	MAEDNSpieler sp3 = new MAEDNSpieler(3);
	MAEDNSpieler sp4 = new MAEDNSpieler(4);
    
    // Spielzug durchführen
    public int zug(int farbe, int id, int wurf)
    {
    	MAEDNSpieler sp = getSpieler(farbe);
    	if (sp == null) return 0; // Wenn fehlerhafte Farbe ausgewählt wurde
    	sp.addFigurFort(id, wurf);
    	int[] kick = new int[2];
    	//kick[1] = 0;
    	kick = kickcheck(farbe,sp.getFigurFort(id) + wurf);
    	if (kick[1] > 0) 
    	{
    		MAEDNSpieler spk = getSpieler(kick[0]);
    		spk.kickFigur(kick[1]);
    	}
    	return sp.getFigurFort(id);
    }
    
    public int[] kickcheck(int req, int wurf)
    {
    	int[]ret = new int[2];
    	ret[0] = 0;
    	ret[1] = 0;
    	for (int i= 1; i < 5;i++)
    	{
    		if (i != req)
    		{
    			MAEDNSpieler sp = getSpieler(i);
    			ret[1] = sp.checkcollide(sp.getFigurFort(wurf));
    			if (ret[1] > 0) ret[0] = i;
    		}
    	}
    	return ret;
    }
    
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
}
