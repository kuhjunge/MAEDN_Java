package maednpackage;

public class MAEDNGame {

	//Spieler
	MAEDNSpieler sp1 = new MAEDNSpieler(1);
	MAEDNSpieler sp2 = new MAEDNSpieler(2);
	MAEDNSpieler sp3 = new MAEDNSpieler(3);
	MAEDNSpieler sp4 = new MAEDNSpieler(4);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
    // Spielzug durchführen
    public int zug(int farbe, int id, int wurf)
    {
		switch(farbe)
		{
		case 1:
	    	sp1.addFigurFort(id, wurf);
	    	return sp1.getFigurFort(id);
			//break;
		case 2:
	    	sp2.addFigurFort(id, wurf);
	    	return sp2.getFigurFort(id);
			//break;
		case 3:
	    	sp3.addFigurFort(id, wurf);
	    	return sp3.getFigurFort(id);
			//break;
		case 4:
	    	sp4.addFigurFort(id, wurf);
	    	return sp4.getFigurFort(id);
			//break;
	    default:
	    	return 0;
		}
    }
}
