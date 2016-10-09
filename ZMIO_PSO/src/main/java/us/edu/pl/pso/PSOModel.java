package us.edu.pl.pso;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;



public class PSOModel extends Parametry {
	
	private Funkcje funkcja;	
	
	private ArrayList<Czasteczka> czasteczki = new ArrayList<Czasteczka>();
	private double[] pbest; //najlepsza pozycja czasteczki
	private ArrayList<Pozycja> pbestPozycja = new ArrayList<Pozycja>(); 
	private double gbest; //najlepsza globalna pozycja
	private Pozycja gbestPozycja;
	private double[] listaNajlepszychPozycji; 
	
	private String output = "";
	
	Random random = new Random();
	
	public void start() {
		PSOService.funkcja = funkcja;
		pbest = new double[WIELKOSC_ROJU];
		listaNajlepszychPozycji = new double[WIELKOSC_ROJU];
		
		
		inicjalizujRoj();
		zaktualizujListeNajlepszychPozycji();		
		
		for(int i = 0; i < WIELKOSC_ROJU; i++) {
			pbest[i] = listaNajlepszychPozycji[i];
			pbestPozycja.add(czasteczki.get(i).getPozycja());
		}
		
		int t = 0;			//iteracje
		double w;			//dodatkowy wspolczynnik do rownania na predksosc czasteczki, maleje z czasem (eksploracja globalna/lokalna) - incercja
							// duza inercja - ekploracja globalna, mala inercja - przeszukiwanie lokalne
		//double err = 9999;
		
		while(t < LICZBA_ITERACJI) { // && err > PSOService.TOLERANCJA_WYNIKU) {
			
			//aktualizacja pbest
			for(int i = 0; i < WIELKOSC_ROJU; i++) {
				if(listaNajlepszychPozycji[i] < pbest[i]) {
					pbest[i] = listaNajlepszychPozycji[i];
					pbestPozycja.set(i, czasteczki.get(i).getPozycja());
				}				
			}
			
			//aktualizacja gbest
			int indexNajlepszejCzasteczki = PSOService.getMinPos(listaNajlepszychPozycji);
			if(t == 0 || listaNajlepszychPozycji[indexNajlepszejCzasteczki] < gbest) {
				gbest = listaNajlepszychPozycji[indexNajlepszejCzasteczki];
				gbestPozycja = czasteczki.get(indexNajlepszejCzasteczki).getPozycja();
			}
			
			w = W_MAX - (((double) t) / LICZBA_ITERACJI) * (W_MAX - W_MIN);
			
			for(int i = 0; i < WIELKOSC_ROJU; i++) {
				double r1 = random.nextDouble(); //losowe wartosci U(0,1)
				double r2 = random.nextDouble();
				
				Czasteczka p = czasteczki.get(i);
				
				//aktualizcja predkosci
				double[] nowaPredkosc = new double[ROZMIAR_PROBLEMU];			
				nowaPredkosc[0] = 	(w * p.getPredkosc().getPredkosc()[0]) + 
									(r1 * C1) * (pbestPozycja.get(i).getPozycja()[0] - p.getPozycja().getPozycja()[0]) +
									(r2 * C2) * (gbestPozycja.getPozycja()[0] - p.getPozycja().getPozycja()[0]);
				nowaPredkosc[1] = 	(w * p.getPredkosc().getPredkosc()[1]) + 
									(r1 * C1) * (pbestPozycja.get(i).getPozycja()[1] - p.getPozycja().getPozycja()[1]) +
									(r2 * C2) * (gbestPozycja.getPozycja()[1] - p.getPozycja().getPozycja()[1]);
				Predkosc predkosc = new Predkosc(nowaPredkosc);
				p.setPredkosc(predkosc);
				
				// aktualizacja pozycji
				double[] nowaPozycja = new double[ROZMIAR_PROBLEMU];
				nowaPozycja[0] = p.getPozycja().getPozycja()[0] + nowaPredkosc[0];
				nowaPozycja[1] = p.getPozycja().getPozycja()[1] + nowaPredkosc[1];
				Pozycja pozycja = new Pozycja(nowaPozycja);
				p.setPozycja(pozycja);					
			}
			
			//err = PSOService.oblicz(gbestPozycja) - 0; // wynik funkcji zmierza do 0
			
			System.out.println("Iteracja " + t + ": ");
			output += "\n\n Iteracja " + t + ": ";
			
			System.out.println("     Najlepszy X: " + gbestPozycja.getPozycja()[0]);
			output += "\n     Najlepszy X: " + gbestPozycja.getPozycja()[0];
			
			System.out.println("     Najlepszy Y: " + gbestPozycja.getPozycja()[1]);
			output += "\n     Najlepszy Y: " + gbestPozycja.getPozycja()[1];
			
			System.out.println("     Wynik: " + PSOService.oblicz(gbestPozycja));
			output += "\n     Wynik: " + PSOService.oblicz(gbestPozycja);
			
			t++;
			zaktualizujListeNajlepszychPozycji();			
		}
		
		System.out.println("\nRozwiązanie znalezione w liczbie iteracji " + (t - 1) + ", rozwiązanie:");
		output += "\n\n Rozwiązanie znalezione w liczbie iteracji " + (t - 1) + ", rozwiązanie:";
		
		System.out.println("     Najlepszy X: " + gbestPozycja.getPozycja()[0]);
		output += "\n     Najlepszy X: " + gbestPozycja.getPozycja()[0];
		
		System.out.println("     Najlepszy Y: " + gbestPozycja.getPozycja()[1]);	
		output += "\n     Najlepszy Y: " + gbestPozycja.getPozycja()[1];
		
	}	
	





	private void inicjalizujRoj() {
		Czasteczka p;
		for(int i = 0; i< WIELKOSC_ROJU; i++) {
			p = new Czasteczka();
			
			//losowe polozenie poczatkowe czasteczki
			double[] loc = new double[ROZMIAR_PROBLEMU];
			loc[0] = PSOService.POZYCJA_X_MIN + random.nextDouble() * (PSOService.POZYCJA_X_MAX - PSOService.POZYCJA_X_MIN);
			loc[1] = PSOService.POZYCJA_Y_MIN + random.nextDouble() * (PSOService.POZYCJA_Y_MAX - PSOService.POZYCJA_Y_MIN);
			Pozycja pozycja = new Pozycja(loc);
			
			//losowa predkosc poczatkowa czasteczki
			double[] v = new double[ROZMIAR_PROBLEMU];
			v[0] = PSOService.PREDKOSC_MIN + random.nextDouble() * (PSOService.PREDKOSC_MAX - PSOService.PREDKOSC_MIN);
			v[1] = PSOService.PREDKOSC_MIN + random.nextDouble() * (PSOService.PREDKOSC_MAX - PSOService.PREDKOSC_MIN);
			Predkosc predkosc = new Predkosc(v);
			
			p.setPozycja(pozycja);
			p.setPredkosc(predkosc);
			czasteczki.add(p);			
		}		
	}
	
	private void zaktualizujListeNajlepszychPozycji() {
		for(int i =0; i < WIELKOSC_ROJU; i++) {
			listaNajlepszychPozycji[i] = czasteczki.get(i).getNajlepszaWartosc();
		}
		
	}





	public Funkcje getFunkcja() {
		return funkcja;
	}

	public void setFunkcja(Funkcje funkcja) {
		this.funkcja = funkcja;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}
