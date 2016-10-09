package us.edu.pl.pso;

public class Parametry {
	
	int WIELKOSC_ROJU;
	int LICZBA_ITERACJI;
	int ROZMIAR_PROBLEMU = 2;	//liczba niewiadomych
	double C1 = 2.0;
	double C2 = 2.0;
	double W_MAX = 1.0;//inercja
	double W_MIN = 0.0;
	
	
	public int getWielkoscRoju() {
		return WIELKOSC_ROJU;
	}
	public void setWielkoscRoju(int wielkoscRoju) {
		this.WIELKOSC_ROJU = wielkoscRoju;
	}
	public int getLiczbaIteracji() {
		return LICZBA_ITERACJI;
	}
	public void setLiczbaIteracji(int liczbaIteracji) {
		this.LICZBA_ITERACJI = liczbaIteracji;
	}

}
