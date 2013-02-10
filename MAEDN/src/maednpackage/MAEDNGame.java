package maednpackage;

import java.awt.Point;

public class MAEDNGame {

    private static int figX = 23;
    private static int figY = 26;
    private static int zx = 300;
    private static int zy = 300;
    private static int zadd = 54;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Funktion gibt die Position der aktuel geklickten farbe zurück
    public static Point place(int farbe, int id, int zahl)
    { // Positionen Ermitteln Spielfeld oder farbenspezifische Positionen

        if (farbe != 1)
            zahl = convertToFarbe(zahl, farbe);
        if (zahl > 0 && zahl < 41)
        {
            Point[] ort = {
            new Point(zx, zy),
            new Point(zx  - (zadd *1) , zy + (zadd * 5)),
            new Point(zx  - (zadd *1) , zy + (zadd * 4)),
            new Point(zx  - (zadd *1) , zy + (zadd * 3)),
            new Point(zx  - (zadd *1) , zy + (zadd * 2)), 
            new Point(zx  - (zadd *1) , zy + (zadd * 1)),//e
            new Point(zx  - (zadd *2) , zy + (zadd * 1)),
            new Point(zx  - (zadd *3) , zy + (zadd * 1)),
            new Point(zx  - (zadd *4) , zy + (zadd * 1)), 
            new Point(zx  - (zadd *5) , zy + (zadd * 1)),
            new Point(zx - (zadd * 5), zy ), // Vor Blau
            new Point(zx  - (zadd *5) , zy - (zadd * 1)),
            new Point(zx  - (zadd *4) , zy - (zadd * 1)),
            new Point(zx  - (zadd *3) , zy - (zadd * 1)),
            new Point(zx  - (zadd *2) , zy - (zadd * 1)), //
            new Point(zx  - (zadd *1) , zy - (zadd * 1)),
            new Point(zx  - (zadd *1) , zy - (zadd * 2)),
            new Point(zx  - (zadd *1) , zy - (zadd * 3)),
            new Point(zx  - (zadd *1) , zy - (zadd * 4)),
            new Point(zx  - (zadd *1) , zy - (zadd * 5)),
            new Point(zx  , zy - (zadd * 5)), // Vor Gruen
            new Point(zx  + (zadd *1) , zy - (zadd * 5)),
            new Point(zx  + (zadd *1) , zy - (zadd * 4)),
            new Point(zx  + (zadd *1) , zy - (zadd * 3)),
            new Point(zx  + (zadd *1) , zy - (zadd * 2)),
            new Point(zx  + (zadd *1) , zy - (zadd * 1)),
            new Point(zx  + (zadd *2) , zy - (zadd * 1)),
            new Point(zx  + (zadd *3) , zy - (zadd * 1)),
            new Point(zx  + (zadd *4) , zy - (zadd * 1)),
            new Point(zx  + (zadd *5) , zy - (zadd * 1)),
            new Point(zx  + (zadd *5) , zy),// Vor Gelb
            new Point(zx  + (zadd *5) , zy + (zadd * 1)),
            new Point(zx  + (zadd *4) , zy + (zadd * 1)),
            new Point(zx  + (zadd *3) , zy+(zadd * 1)),
            new Point(zx  + (zadd *2) , zy+(zadd * 1)),
            new Point(zx  + (zadd *1) , zy+(zadd * 1)),
            new Point(zx  + (zadd *1) , zy+(zadd * 2)),
            new Point(zx  + (zadd *1) , zy+(zadd * 3)),
            new Point(zx  + (zadd *1) , zy+(zadd * 4)),
            new Point(zx  + (zadd *1) , zy+(zadd * 5)),
            new Point(zx, zy+(zadd * 5)) // Vor Rot 
            };
            return new Point(ort[zahl].x - figX, ort[zahl].y - figY);
        }
        else
        {
            Point ort = new Point(1, 1);
            switch (farbe)
            {
                case 1:
                    switch (zahl)
                    {
                        case 41:
                            ort = new Point(zx, zy + (zadd * 4));
                            break;
                        case 42:
                            ort = new Point(zx, zy + (zadd * 3));
                            break;
                        case 43:
                            ort = new Point(zx, zy + (zadd * 2));
                            break;
                        case 44:
                            ort = new Point(zx, zy + (zadd * 1));
                            break;
                        default:
                            if (id == 1) ort = new Point(zx - (zadd * 5), zy + (zadd * 5));
                            else if (id == 2) ort = new Point(zx - (zadd * 4), zy + (zadd * 5));
                            else if (id == 3) ort = new Point(zx - (zadd * 5), zy + (zadd * 4));
                            else if (id == 4) ort = new Point(zx - (zadd * 4), zy + (zadd * 4));
                            break;
                    }
                    break;
                case 2:
                    switch (zahl)
                    {
                        case 41:
                            ort = new Point(zx - (zadd * 4), zy);
                            break;
                        case 42:
                            ort = new Point(zx - (zadd * 3), zy);
                            break;
                        case 43:
                            ort = new Point(zx - (zadd * 2), zy);
                            break;
                        case 44:
                            ort = new Point(zx - (zadd * 1), zy);
                            break;
                        default:
                            if (id == 1) ort = new Point(zx - (zadd * 5), zy - (zadd * 5));
                            else if (id == 2) ort = new Point(zx - (zadd * 4), zy - (zadd * 5));
                            else if (id == 3) ort = new Point(zx - (zadd * 5), zy - (zadd * 4));
                            else if (id == 4) ort = new Point(zx - (zadd * 4), zy - (zadd * 4));
                            break;
                    }
                    break;
                case 3:
                    switch (zahl)
                    {
                        case 41:
                            ort = new Point(zx, zy - (zadd * 4));
                            break;
                        case 42:
                            ort = new Point(zx, zy - (zadd * 3));
                            break;
                        case 43:
                            ort = new Point(zx, zy - (zadd * 2));
                            break;
                        case 44:
                            ort = new Point(zx, zy - (zadd * 1));
                            break;
                        default:
                            if (id == 1) ort = new Point(zx + (zadd * 5), zy - (zadd * 5));
                            else if (id == 2) ort = new Point(zx + (zadd * 4), zy - (zadd * 5));
                            else if (id == 3) ort = new Point(zx + (zadd * 5), zy - (zadd * 4));
                            else if (id == 4) ort = new Point(zx + (zadd * 4), zy - (zadd * 4));
                            break;
                    }
                    break;
                case 4:
                    switch (zahl)
                    {
                        case 41:
                            ort = new Point(zx + (zadd * 4), zy);
                            break;
                        case 42:
                            ort = new Point(zx + (zadd * 3), zy);
                            break;
                        case 43:
                            ort = new Point(zx + (zadd * 2), zy);
                            break;
                        case 44:
                            ort = new Point(zx + (zadd * 1), zy);
                            break;
                        default:
                            if (id == 1) ort = new Point(zx + (zadd * 5), zy + (zadd * 5));
                            else if (id == 2) ort = new Point(zx + (zadd * 4), zy + (zadd * 5));
                            else if (id == 3) ort = new Point(zx + (zadd * 5), zy + (zadd * 4));
                            else if (id == 4) ort = new Point(zx + (zadd * 4), zy + (zadd * 4));
                            break;
                    }
                    break;
            }
            return new Point(ort.x - figX, ort.y - figY);
        }
    }
    
    private static int convertToFarbe(int zahl, int farbe)
    {
        if (farbe == 3)
        {
            if (zahl > 0 & zahl < 21)
                zahl = zahl + 20;
            else if (zahl > 20 & zahl < 41)
                zahl = zahl - 20;
        }

        else if (farbe == 2)
        {
            if (zahl > 0 & zahl < 31)
                zahl = zahl + 10;
            else if (zahl > 30 & zahl < 41)
                zahl = zahl - 30;
        }

        else if (farbe == 4)
        {
            if (zahl > 0 & zahl < 11)
                zahl = zahl + 30;
            else if (zahl > 10 & zahl < 41)
                zahl = zahl - 10;
        }
        return zahl;
    }
    
	public static int myRandom(double low, double high) {
		double rndd = Math.round(Math.random() * (high - low) + low);
		int value = new Double(rndd).intValue();
		return value;
	}

}
