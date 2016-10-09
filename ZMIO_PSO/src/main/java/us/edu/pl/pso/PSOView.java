package us.edu.pl.pso;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class PSOView extends JFrame{
	
	private JRadioButton funkcja1Radio, funkcja2Radio, funkcja3Radio, funkcja4Radio;
	private ButtonGroup funkcjaGroup;
	private JTextField wzorFunkcjiField, liczbaIteracjiField;
	private JSlider liczbaOsobnikowSLider;	
	private JLabel label1, label2, label3;
	private JButton startButton;
	private JTextArea textArea;
	
	
	public PSOView () {
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Minimalizacja funkcji za pomocą PSO");
		
		JPanel thePanel = new JPanel();				
		thePanel.setLayout(new GridBagLayout());
		
		funkcja1Radio = new JRadioButton("Himmelblau");
		funkcja2Radio = new JRadioButton("Matyas");
		funkcja3Radio = new JRadioButton("Beales");
		funkcja4Radio = new JRadioButton("Booths");
		funkcjaGroup = new ButtonGroup();
		funkcjaGroup.add(funkcja1Radio);
		funkcjaGroup.add(funkcja2Radio);
		funkcjaGroup.add(funkcja3Radio);
		funkcjaGroup.add(funkcja4Radio);
		
		
				
		JPanel funkcjaPanel = new JPanel();
		TitledBorder funkcjaBorder = BorderFactory.createTitledBorder("Wybierz funkcje: ");		
		funkcjaPanel.setBorder(funkcjaBorder);
		funkcjaPanel.add(funkcja1Radio);
		funkcjaPanel.add(funkcja2Radio);		
		funkcjaPanel.add(funkcja3Radio);	
		funkcjaPanel.add(funkcja4Radio);	
		//funkcja1Radio.setSelected(true);	
		funkcjaPanel.setPreferredSize(new Dimension(495, 58));
		addComp(thePanel, funkcjaPanel, 0, 0, 2, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);

		JPanel wzorPanel = new JPanel();
		TitledBorder wzorBorder = BorderFactory.createTitledBorder("Wzór funkcji: ");
		wzorPanel.setBorder(wzorBorder);
		wzorFunkcjiField = new JTextField(40);
		wzorFunkcjiField.setEnabled(false);		
		wzorPanel.add(wzorFunkcjiField);
		addComp(thePanel, wzorPanel, 2, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		
		
		JPanel wlascPanel = new JPanel();
		
		JPanel osobnikiPanel = new JPanel();
		//SoftBevelBorder osobnikiBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);
		//osobnikiPanel.setBorder(osobnikiBorder);		
		label1 = new JLabel("Liczba osobników:");
		liczbaOsobnikowSLider = new JSlider(25, 100, 25);
		liczbaOsobnikowSLider.setPreferredSize(new Dimension(169, 20));
		label2 = new JLabel(""+liczbaOsobnikowSLider.getMinimum());		
		label2.setPreferredSize(new Dimension(22,20));
		//liczbaOsobnikowSLider.setMinorTickSpacing(1);
		//liczbaOsobnikowSLider.setMajorTickSpacing(10);
		//liczbaOsobnikowSLider.setPaintTicks(true);
		//liczbaOsobnikowSLider.setPaintLabels(true);
		//ListenForSlider lForSlider = new ListenForSlider();
		//liczbaOsobnikowSLider.addChangeListener(lForSlider);
		osobnikiPanel.add(label1);
		osobnikiPanel.add(label2);
		osobnikiPanel.add(liczbaOsobnikowSLider);		
		
		JPanel iteracjePanel = new JPanel();
		SoftBevelBorder iteracjeBorder = new SoftBevelBorder(SoftBevelBorder.LOWERED);
		iteracjePanel.setBorder(iteracjeBorder);	
		label3 = new JLabel("Liczba iteracji: ");
		liczbaIteracjiField = new JTextField("0", 4);	
		iteracjePanel.add(label3);
		iteracjePanel.add(liczbaIteracjiField);
		
		wlascPanel.add(osobnikiPanel);
		wlascPanel.add(iteracjePanel);
		TitledBorder wlascBorder = BorderFactory.createTitledBorder("Właściwości: ");
		wlascPanel.setBorder(wlascBorder);
		addComp(thePanel, wlascPanel, 0, 1, 3, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
		
		JPanel buttonPanel = new JPanel();
		TitledBorder buttonBorder = BorderFactory.createTitledBorder("");
		buttonPanel.setBorder(buttonBorder);
		startButton = new JButton("Start");
		buttonPanel.add(startButton);
		addComp(thePanel, buttonPanel, 2, 1, 3, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
		
		textArea = new JTextArea(20, 40);
		textArea.setLineWrap(true);		
		textArea.setWrapStyleWord(true);		
		JScrollPane scrollbar1 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		addComp(thePanel, scrollbar1, 0, 2, 2, 3, GridBagConstraints.CENTER, GridBagConstraints.NONE);

		
		
		this.add(thePanel);
		this.pack();
		this.setVisible(true);
		
	}
	
	
	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int place, int stretch){
			
			GridBagConstraints gridConstraints = new GridBagConstraints();
			
			gridConstraints.gridx = xPos;
			gridConstraints.gridy = yPos;
			gridConstraints.gridwidth = compWidth;
			gridConstraints.gridheight = compHeight;
			//gridConstraints.weightx = 100;
			//gridConstraints.weighty = 100;
			gridConstraints.insets = new Insets(5,5,5,5);
			gridConstraints.anchor = place;
			gridConstraints.fill = stretch;
			
			thePanel.add(comp, gridConstraints);
			
		}
	
	public void addFunkcja1RadioListener(ActionListener funkcjaRadioListener ) {
		funkcja1Radio.addActionListener(funkcjaRadioListener);
	}
	public void addFunkcja2RadioListener(ActionListener funkcjaRadioListener ) {
		funkcja2Radio.addActionListener(funkcjaRadioListener);
	}	
	public void addFunkcja3RadioListener(ActionListener funkcjaRadioListener ) {
		funkcja3Radio.addActionListener(funkcjaRadioListener);
	}	
	public void addFunkcja4RadioListener(ActionListener funkcjaRadioListener ) {
		funkcja4Radio.addActionListener(funkcjaRadioListener);
	}
	public void addLiczbaOsobnikowSliderListener(ChangeListener liczbaOsobnikowSliderListener) {
		liczbaOsobnikowSLider.addChangeListener(liczbaOsobnikowSliderListener);
	}
	public void addLiczbaIteracjiFieldListener(ActionListener liczbaIteracjiFieldListener) {
		liczbaIteracjiField.addActionListener(liczbaIteracjiFieldListener);
	}
	public void addStartButtonListener(ActionListener startButtonListener) {
		startButton.addActionListener(startButtonListener);
	}
	
	
	
	
	
	
	
//	
//	private class ListenForSlider implements ChangeListener {
//
//		public void stateChanged(ChangeEvent e) {
//			
//			if(e.getSource()==liczbaOsobnikowSLider) {
//				label2.setText(""+liczbaOsobnikowSLider.getValue());
//			}
//			
//		}		
//	}








	public JRadioButton getFunkcja1Radio() {
		return funkcja1Radio;
	}


	public JRadioButton getFunkcja2Radio() {
		return funkcja2Radio;
	}


	public JRadioButton getFunkcja3Radio() {
		return funkcja3Radio;
	}


	public JRadioButton getFunkcja4Radio() {
		return funkcja4Radio;
	}


	public JTextField getWzorFunkcjiField() {
		return wzorFunkcjiField;
	}


	public JTextField getLiczbaIteracjiField() {
		return liczbaIteracjiField;
	}


	public JSlider getLiczbaOsobnikowSLider() {
		return liczbaOsobnikowSLider;
	}


	public JLabel getLabel2() {
		return label2;
	}


	public JButton getStartButton() {
		return startButton;
	}


	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	

}
