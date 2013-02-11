package maednpackage;

import java.awt.Point;

public class MADENPositions {
	// positionierungen
    private static int figX = 23; // Figur Größe der X Achse
    private static int figY = 23; // Figur Größe der Y Achse
    private static int zx = 290; // SpielfeldMitte X Achse
    private static int zy = 290; // SpielfeldMitte Y Achse
    private static int zadd = 52; // Schrittgröße der SpielfeldQuadrate
    
	// Funktion gibt die Position der aktuel geklickten farbe zurück
    public static Point place(int farbe, int id, int zahl)
    { // Positionen Ermitteln Spielfeld oder farbenspezifische Positionen
        if (zahl > 0 && zahl < 41) // Wenn die Position im Spielverlauf ist
        {
            Point[] ort = {
            new Point(zx, zy), // 0
            new Point(zx  - (zadd *1) , zy + (zadd * 5)), // 1
            new Point(zx  - (zadd *1) , zy + (zadd * 4)), // 2
            new Point(zx  - (zadd *1) , zy + (zadd * 3)), // 3
            new Point(zx  - (zadd *1) , zy + (zadd * 2)),  // 4
            new Point(zx  - (zadd *1) , zy + (zadd * 1)), // 5 (ecke) 
            new Point(zx  - (zadd *2) , zy + (zadd * 1)), // 6
            new Point(zx  - (zadd *3) , zy + (zadd * 1)), // ...
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
            return new Point(ort[zahl].x - figX, ort[zahl].y - figY); // Rückgabe des ermittelten Punktes
        }
        else // Wenn die Person am Start oder am Ende ist
        {
            Point ort = new Point(1, 1);
            switch (farbe)
            {
                case 1: // Rot
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
                case 2: // Blau
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
                case 3: // Gruen
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
                case 4: // Gelb
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
            return new Point(ort.x - figX, ort.y - figY); // Rückgabe des ermittelten Punktes
        }
    }
	
}
