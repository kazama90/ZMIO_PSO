package us.edu.pl.pso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PSOController {
	
	private PSOView view;
	private PSOModel model;
	
	public PSOController(PSOView view, PSOModel model) {
		this.model = model;
		this.view = view;
		
		this.view.addFunkcja1RadioListener(new FunkcjaRadioListener());
		this.view.addFunkcja2RadioListener(new FunkcjaRadioListener());
		this.view.addFunkcja3RadioListener(new FunkcjaRadioListener());
		this.view.addFunkcja4RadioListener(new FunkcjaRadioListener());
		this.view.addLiczbaOsobnikowSliderListener(new LiczbaOsobnikowSliderListener());
		this.view.addLiczbaIteracjiFieldListener(new LiczbaIteracjiFieldListener());
		this.view.addStartButtonListener(new StartButtonListener());
	}
	
	
	private class FunkcjaRadioListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if(view.getFunkcja1Radio().isSelected()) {
				view.getWzorFunkcjiField().setText(Funkcje.Himmelblau.getWzor());
				model.setFunkcja(Funkcje.Himmelblau);
			}
			if(view.getFunkcja2Radio().isSelected()) {
				view.getWzorFunkcjiField().setText(Funkcje.Matyas.getWzor());
				model.setFunkcja(Funkcje.Matyas);
			}
			if(view.getFunkcja3Radio().isSelected()) {
				view.getWzorFunkcjiField().setText(Funkcje.Beales.getWzor());
				model.setFunkcja(Funkcje.Beales);
			}
			if(view.getFunkcja4Radio().isSelected()) {
				view.getWzorFunkcjiField().setText(Funkcje.Booths.getWzor());
				model.setFunkcja(Funkcje.Booths);
			}
		}		
	};
	
	private class LiczbaOsobnikowSliderListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			view.getLabel2().setText(""+view.getLiczbaOsobnikowSLider().getValue());
			model.setWielkoscRoju(view.getLiczbaOsobnikowSLider().getValue());
			
		}
		
	};
	
	private class LiczbaIteracjiFieldListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			model.setLiczbaIteracji(Integer.parseInt(view.getLiczbaIteracjiField().getText()));			
		}
		
	};
	
	private class StartButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			model.setWielkoscRoju(view.getLiczbaOsobnikowSLider().getValue());
			model.setLiczbaIteracji(Integer.parseInt(view.getLiczbaIteracjiField().getText()));		
			model.setOutput("");
			model.start();			
			view.getTextArea().setText(model.getOutput());
		}
		
	};
	
	
	

}
