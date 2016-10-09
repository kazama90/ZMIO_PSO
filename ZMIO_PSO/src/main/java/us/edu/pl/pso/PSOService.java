package us.edu.pl.pso;


public class PSOService {
	
	public static Funkcje funkcja;
	
	public static final double POZYCJA_X_MIN = 1;
	public static final double POZYCJA_X_MAX = 4;
	public static final double POZYCJA_Y_MIN = -1;
	public static final double POZYCJA_Y_MAX = 1;
	public static final double PREDKOSC_MIN = -1;
	public static final double PREDKOSC_MAX = 1;
	
	public static final double TOLERANCJA_WYNIKU = 1E-20;
	
	
	public PSOService(Funkcje funkcja) {
		PSOService.funkcja = funkcja;
	}
	
	
	public static double oblicz(Pozycja pozycja) {
		double wynik = 0;
		double x = pozycja.getPozycja()[0]; // x
		double y = pozycja.getPozycja()[1]; // y
		
		switch (funkcja) {
			case Himmelblau:
				wynik = Math.pow(Math.pow(x, 2) + y - 11, 2) + 
						Math.pow(x + Math.pow(y, 2) - 7, 2);
				break;
			case Matyas:
				wynik = 0.26*(Math.pow(x, 2) + Math.pow(y, 2)) - 
						0.48 * x * y;
				break;
			case Beales:
				wynik = Math.pow(1.5 - x + x * y, 2) +
						Math.pow(2.25 - x + Math.pow(x * y, 2), 2) + 
						Math.pow(2.625 - x + Math.pow(x * y, 3), 2);
				break;
			case Booths:
				wynik = Math.pow(x + 2 * y - 7 , 2) + 
						Math.pow(2 * x + y - 5, 2);
				break;
			default:break;
		}				
		return wynik;
	}

	public Funkcje getFunkcja() {
		return funkcja;
	}

	public void setFunkcja(Funkcje funkcja) {
		PSOService.funkcja = funkcja;
	}
	
	
	public static int getMinPos(double[] list) {
		int pos = 0;
		double minValue = list[0];
		
		for(int i=0; i<list.length; i++) {
			if(list[i] < minValue) {
				pos = i;
				minValue = list[i];
			}
		}
		
		return pos;
	}

}
