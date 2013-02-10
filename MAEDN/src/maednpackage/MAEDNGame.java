package maednpackage;

public class MAEDNGame {

	//Spieler
	MAEDNSpieler sp2 = new MAEDNSpieler(2);
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
    // Spielzug durchführen
    public int zug(int farbe, int id)
    {
    	sp2.addFigurFort(1, 1);
    	return sp2.getFigurFort(1);
    }
}
