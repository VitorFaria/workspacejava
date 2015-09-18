package Relogio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI implements ActionListener{
	
	Maquina maquina;
	
	JFrame frame;
	JTextField horaCampo;
	JTextField minutoCampo;
	JTextField segundoCampo;
	JButton botaoAcerta;
	
	JFrame frameAcerta;
	JTextField horaCampo2;
	JTextField minutoCampo2;
	JTextField segundoCampo2;
	JButton botaoRoda;

	public GUI(Maquina maquina) {
		super();
		this.maquina = maquina;
		
		frame = new JFrame("Relógio");
		horaCampo = new JTextField(2);
		horaCampo.setText("00");
		horaCampo.setEditable(false);
		minutoCampo = new JTextField(2);
		minutoCampo.setText("00");
		minutoCampo.setEditable(false);
		segundoCampo = new JTextField(2);
		segundoCampo.setText("00");
		segundoCampo.setEditable(false);
		botaoAcerta = new JButton("Acertar");
		
		frameAcerta = new JFrame("Acerto");
		horaCampo2 = new JTextField(2);
		horaCampo2.setText("00");
		minutoCampo2 = new JTextField(2);
		minutoCampo2.setText("00");
		segundoCampo2 = new JTextField(2);
		segundoCampo2.setText("00");
		botaoRoda = new JButton("Voltar");
		// TODO Auto-generated constructor stub
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	
	public JTextField getHoraCampo() {
		return horaCampo;
	}

	public void setHoraCampo(JTextField horaCampo) {
		this.horaCampo = horaCampo;
	}

	public JTextField getMinutoCampo() {
		return minutoCampo;
	}

	public void setMinutoCampo(JTextField minutoCampo) {
		this.minutoCampo = minutoCampo;
	}

	public JTextField getSegundoCampo() {
		return segundoCampo;
	}

	public void setSegundoCampo(JTextField segundoCampo) {
		this.segundoCampo = segundoCampo;
	}

	public void constroiJanela(){ 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(horaCampo);
		frame.getContentPane().add(minutoCampo);
		frame.getContentPane().add(segundoCampo);
		botaoAcerta.addActionListener(this);
		frame.getContentPane().add(botaoAcerta);
		frame.setVisible(true);	
		
		frameAcerta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAcerta.setSize(200, 100);
		frameAcerta.setLocationRelativeTo(null);
		frameAcerta.setResizable(false);
		frameAcerta.getContentPane().setLayout(new FlowLayout());
		frameAcerta.getContentPane().add(horaCampo2);
		frameAcerta.getContentPane().add(minutoCampo2);
		frameAcerta.getContentPane().add(segundoCampo2);
		botaoRoda.addActionListener(this);
		frameAcerta.getContentPane().add(botaoRoda);
		frameAcerta.setVisible(false);	
	}

	private void acertaRelogio(){
		maquina.setSegundos(Integer.valueOf(segundoCampo2.getText()));
		maquina.setMinutos(Integer.valueOf(minutoCampo2.getText()));
		maquina.setHoras(Integer.valueOf(horaCampo2.getText()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == botaoAcerta){
			frame.setVisible(false);
			frameAcerta.setVisible(true);
		}
		if(e.getSource() == botaoRoda){
			acertaRelogio();
			frameAcerta.setVisible(false);
			frame.setVisible(true);
		}
	}


}
