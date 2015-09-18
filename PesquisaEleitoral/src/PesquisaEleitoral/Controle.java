package PesquisaEleitoral;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Controle implements ActionListener{
	
	Listas cidades;
	
	
	Questionario questAtual; 
	Cidade cidadeAtual;
	
	JFrame frame;
	JButton botao = new JButton("Inicio");
	JButton botaoFinal = new JButton("Fim");
	JLabel rotulo1 = new JLabel("Começar questinário: ");
	JLabel rotuloCidade = new JLabel("Nome da cidade: ");
	JTextField textoCidade = new JTextField(15);
	
	JFrame frameQuest;
	JLabel rotuloCandidato = new JLabel("Nome do candidato: ");
	JTextField textoCandidato = new JTextField(15);
	JComboBox comboSex = new JComboBox();
	JComboBox comboEsq = new JComboBox();
	JComboBox comboEt = new JComboBox();
	JComboBox comboRend = new JComboBox();
	JButton botaoProxQuest = new JButton("Submeter questionário");
	JButton botaoFimCidade = new JButton("Fim da cidade");
	
	JFrame frameResposta;

	public Controle() {
		super();
		cidades = new Listas();
		// TODO Auto-generated constructor stub
	}

	public Listas getCidades() {
		return cidades;
	}

	public void setCidades(Listas cidades) {
		this.cidades = cidades;
	}
	
	public void inicioGeral(){
		frame = new JFrame("Pesquisa");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setLocation(200, 200);
		frame.setResizable(false);
		frame.getContentPane().setLayout(new FlowLayout());
		
		botao.addActionListener(this);
		
		frame.getContentPane().add(rotuloCidade);
		frame.getContentPane().add(textoCidade);
		frame.getContentPane().add(botao);
		frame.getContentPane().add(botaoFinal);
		
		frame.setVisible(true);	
		
		frameQuest = new JFrame("Questionário");
		frameQuest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameQuest.setSize(400, 250);
		frameQuest.setLocation(200, 200);
		frameQuest.setResizable(false);
		frameQuest.getContentPane().setLayout(new GridLayout(6,1));
		comboSex.addItem("Masculino");
		comboSex.addItem("Feminino");
		comboEsq.addItem("Não escolarizado");
		comboEsq.addItem("Primeiro grau completo");
		comboEsq.addItem("Segundo grau completo");
		comboEsq.addItem("Terceiro grau completo");
		comboEt.addItem("Menos de 20 anos de idade");
		comboEt.addItem("Menos de 30, mais de 20");
		comboEt.addItem("Menos de 40, mais de 30");
		comboEt.addItem("Menos de 50, mais de 40");
		comboEt.addItem("Mais de 50 anos de idade");
		comboRend.addItem("Menos de 3 salarios minimos");
		comboRend.addItem("Mais de 3 salarios minimos, menos de 5");
		comboRend.addItem("Mais de 5 salarios minimos");
		
		
		frameQuest.getContentPane().add(rotuloCandidato);
		frameQuest.getContentPane().add(textoCandidato);
		frameQuest.add(new JLabel("Gênero do entrevistado:"));
		frameQuest.getContentPane().add(comboSex);
		frameQuest.add(new JLabel("Escolaridade do entrevistado:"));
		frameQuest.getContentPane().add(comboEsq);
		frameQuest.add(new JLabel("Idade do entrevistado:"));
		frameQuest.getContentPane().add(comboEt);
		frameQuest.add(new JLabel("Renda do entrevistado:"));
		frameQuest.getContentPane().add(comboRend);
		
		frameQuest.getContentPane().add(botaoProxQuest);
		botaoProxQuest.addActionListener(this);
		frameQuest.getContentPane().add(botaoFimCidade);
		botaoFimCidade.addActionListener(this);
		
		frameResposta = new JFrame("Resultado");
		frameResposta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameResposta.setSize(500, 500);
		frameResposta.setLocation(200, 200);
		//frameResposta.se
		frameResposta.getContentPane().setLayout(new FlowLayout());
		botaoFinal.addActionListener(this);
	}
	
	private Questionario preencheQuestionario(){
		
		
		Questionario questionario = new Questionario();
		
		questionario.setCandidato(textoCandidato.getText());
		questionario.setSexo(comboSex.getSelectedIndex());
		questionario.setEscolaridade(comboEsq.getSelectedIndex());
		questionario.setFaixaEt(comboEt.getSelectedIndex());
		questionario.setFaixaSal(comboRend.getSelectedIndex());
		
		
		//JOptionPane.showMessageDialog(null, questionario.getCandidato());
		return questionario;
	}
	
	private void preencheCandidatos(){
		for(int i =0; i<cidades.size();i++){
			Cidade cidadeAnalizada = ((Cidade) cidades.get(i));
			for(int j =0; j < cidadeAnalizada.getQuests().size(); j++){
				//JOptionPane.showMessageDialog(null, cidadeAnalizada.getQuests().size());
				Questionario questAnalizado = ((Questionario)(cidadeAnalizada.getQuests().get(j)));
				
				String nomeCandidato = questAnalizado.getCandidato();
				boolean igual = false;
				for(int k = 0; k < cidadeAnalizada.getCandidatos().size(); k++){
					Candidatos candidatoConferido = (Candidatos)cidadeAnalizada.getCandidatos().get(k);
					if(candidatoConferido.getNome().equals(nomeCandidato)){
						igual = true;
						candidatoConferido.atualiza(questAnalizado);
					}
				}
				
				if(igual==false){
					Candidatos novoCandidato = new Candidatos();
					novoCandidato.setNome(nomeCandidato);
					novoCandidato.atualiza(questAnalizado);
					cidadeAnalizada.getCandidatos().add(novoCandidato);
				}
			}
		}
	}
	
	private void formulaResposta(){
		JPanel painelTotal = new JPanel();
		painelTotal.setLayout(new GridLayout(10,1));
		JScrollPane painelBarras = new JScrollPane();
		painelBarras.setPreferredSize(new Dimension(480,460));
		for(int i =0; i<cidades.size();i++){
			JPanel painelCidade = new JPanel();
			painelCidade.setLayout(new FlowLayout());
			Cidade cidadeAnalizada = ((Cidade) cidades.get(i));
			painelCidade.add(new JLabel("Cidade: "+cidadeAnalizada.getNome()+": \n"));
			for(int j =0; j < cidadeAnalizada.getCandidatos().size(); j++){
				Candidatos candidatoAnalizado = (Candidatos)cidadeAnalizada.getCandidatos().get(j);
				JPanel painelCandidato = new JPanel();
				painelCandidato.setLayout(new GridLayout(20,2));
				painelCandidato.add(new JLabel("Candidato: "+candidatoAnalizado.getNome()+": \n"));
				painelCandidato.add(new JLabel(""));
				candidatoSpecs(candidatoAnalizado, painelCandidato);
				painelCidade.add(painelCandidato);
			
								
			}
			painelTotal.add(painelCidade);
		}
		painelBarras.getViewport().add(painelTotal);
		frameResposta.add(painelBarras, BorderLayout.CENTER);
	}
	
	private void candidatoSpecs(Candidatos candidato, JPanel painel){
		painel.add(new JLabel("Número de eleitores: "+candidato.getEleitores()));
		painel.add(new JLabel("Número de eleitoras: "+candidato.getEleitoras()));
		
		painel.add(new JLabel("Faixas salariais: "));
		painel.add(new JLabel("Menos de 3 salarios mínimos: " + candidato.getFaixasSalarial()[0]));
		painel.add(new JLabel("Mais de 3 salarios mínimos, menos de 5: " + candidato.getFaixasSalarial()[1]));
		painel.add(new JLabel("Mais de 5 salarios mínimos: " + candidato.getFaixasSalarial()[2]));
		
		painel.add(new JLabel("Faixas etárias: "));
		painel.add(new JLabel("Menos de 20 anos: "+candidato.getFaixasEtaria()[0]));
		painel.add(new JLabel("Menos de 30 anos, mais de 20 anos: "+candidato.getFaixasEtaria()[1]));
		painel.add(new JLabel("Menos de 40 anos, mais de 30 anos: "+candidato.getFaixasEtaria()[2]));
		painel.add(new JLabel("Menos de 50 anos, mais de 40 anos: "+candidato.getFaixasEtaria()[3]));
		painel.add(new JLabel("Mais de 50 anos: "+candidato.getFaixasEtaria()[4]));
		
		painel.add(new JLabel("Faixas de escolaridade: "));
		painel.add(new JLabel("Sem escolaridade: "+candidato.getFaixasEscolaridade()[0]));
		painel.add(new JLabel("Primeiro grau completo: "+candidato.getFaixasEscolaridade()[1]));
		painel.add(new JLabel("Segundo grau completo: "+candidato.getFaixasEscolaridade()[2]));
		painel.add(new JLabel("Terceiro grau completo: "+candidato.getFaixasEscolaridade()[3]));





	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botao){
			JOptionPane.showMessageDialog(null, "Inicio do preenchimento dos formulários para a cidade de: "+" "+textoCidade.getText()+".");
			//inicioCidade(textoCidade.getText());
			Cidade cidade = new Cidade();
			cidade.setNome(textoCidade.getText());
			cidadeAtual = cidade;
			textoCidade.setText(null);
			frame.setVisible(false);	
			frameQuest.setVisible(true);
			
			}
		if (e.getSource() == botaoProxQuest){
			questAtual = preencheQuestionario();
			cidadeAtual.getQuests().add(questAtual);
			JOptionPane.showMessageDialog(null, "Intenção de voto contabilizada para "+" "+questAtual.getCandidato()+ "." );
			textoCandidato.setText(null);
			comboSex.setSelectedIndex(0);
			comboEsq.setSelectedIndex(0);
			comboEt.setSelectedIndex(0);
			comboRend.setSelectedIndex(0);
			
		}
		if (e.getSource() == botaoFimCidade){
			
			boolean igual = false;
			for(int k = 0; k < cidades.size(); k++){
				Cidade cidadeConferida = (Cidade)cidades.get(k);
				if(cidadeConferida.getNome().equals(cidadeAtual.getNome())){
					igual = true;
					cidadeConferida.getQuests().addAll(cidadeAtual.getQuests());
				}
			}
			
			if(!igual)cidades.add(cidadeAtual);
			frameQuest.setVisible(false);
			frame.setVisible(true);
			
		}
		if (e.getSource() == botaoFinal){
			frameQuest.setVisible(false);
			frame.setVisible(false);
			preencheCandidatos();
			formulaResposta();
			frameResposta.setVisible(true);
			
		}
		
	}

}
