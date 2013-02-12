package maednpackage;

// import javax.swing.JOptionPane;

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
	private int getFigurFortRaw(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur == null) return 0; // Sicherheit bei ung�ltiger Objektabfrage
		return figur.getFortschrittRaw();
	}
	
	// Addiert die angegebenen Schritte zum Fortschritt der Figur
	public void addFigurFort(int id, int wurf)
	{
		//JOptionPane.showMessageDialog(null, wurf);
		if (!checkcollideInside(id,wurf + getFigurFortRaw(id))) // Kollision mit der eigenen Farbe?
		{
			MAEDNFigur figur =  fig(id);
			if (figur != null) figur.addFortschritt(wurf); // addiert den Wurd dazu wenn die Figur nicht mit der eigenen Farbe kollidiert
		}
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
	//
}
