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
		
	// Konstruktor, wird beim Erschaffen des Objektes ausgeführt
	public MAEDNSpieler(int farbe)
	{
		if (farbe > 4 || farbe < 1) farbe = 1; // Sicherheitskontrolle, dass Farbe gültig ist
		sFarbe = farbe; // Farbe des Spielers wird zugewiesen
		String[] colorname = { "Jeder", "Rot", "Blau", "Grün", "Gelb" };
		sFarbeName = colorname[sFarbe];
		sFigur1 = new MAEDNFigur(farbe); // Für jede Spielfigur wird ein Objekt erzeugt
		sFigur2 = new MAEDNFigur(farbe);
		sFigur3 = new MAEDNFigur(farbe);
		sFigur4 = new MAEDNFigur(farbe);
	}
	
	// Name der Farbe zurück geben
	public String getFarbeName()
	{
		return sFarbeName;
	}
	
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
	
	// Wert der Spielfigur zurück geben und umwandeln
	public void kickFigur(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur != null)
		{
			figur.gekickt();
		}
	}
	
	// Wert der Spielfigur zurück geben und umwandeln
	public int getFigurFort(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur == null) return 0;
		return figur.getFortschritt();
	}
	
	// Wert der Spielfigur zurück geben
	private int getFigurFortRaw(int id)
	{
		MAEDNFigur figur =  fig(id);
		if (figur == null) return 0;
		return figur.getFortschrittRaw();
	}
	
	// Addiert die angegebenen Schritte zum Fortschritt der Figur
	public void addFigurFort(int id, int wurf)
	{
		//JOptionPane.showMessageDialog(null, wurf);
		if (!checkcollideInside(id,wurf + getFigurFortRaw(id)))
		{
			MAEDNFigur figur =  fig(id);
			if (figur != null) figur.addFortschritt(wurf);
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
		
    	if (zahl > 0 && zahl < 40)
    	{
	    	for (int i = 1; i < 5; i++)
	    	{
	    		MAEDNFigur figur =  fig(i);
	    		if (figur.collision(zahl)) ret = i;
	    	}
    	}
    	return ret;
    }
	//
}
