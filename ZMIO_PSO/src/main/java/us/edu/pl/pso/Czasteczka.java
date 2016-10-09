package us.edu.pl.pso;

public class Czasteczka {
	
	private double najlepszaWartosc;
	private Predkosc predkosc;
	private Pozycja pozycja;
	
	public Czasteczka() {
		
	}
	
	public Czasteczka(double najlepszaWartosc, Predkosc predkosc, Pozycja pozycja) {
		this.najlepszaWartosc = najlepszaWartosc;
		this.predkosc = predkosc;
		this.pozycja = pozycja;
	}
	

	public Predkosc getPredkosc() {
		return predkosc;
	}

	public void setPredkosc(Predkosc predkosc) {
		this.predkosc = predkosc;
	}

	public Pozycja getPozycja() {
		return pozycja;
	}

	public void setPozycja(Pozycja pozycja) {
		this.pozycja = pozycja;
	}

	public double getNajlepszaWartosc() {
		najlepszaWartosc = PSOService.oblicz(pozycja);
		return najlepszaWartosc;
	}



}
