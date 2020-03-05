package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.TartarugaTxt;
import estruturas.ListaLigada;
import model.AnimalDB;
import model.Tartaruga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PesquisaAnimais extends JFrame {

	private JPanel contentPane;
	private ButtonGroup TipoPesquisaGroup = new ButtonGroup();
	private ButtonGroup TipoDadoGroup = new ButtonGroup();
	private JTextField txtBusca;
	private int paginas = 1;
	private int paginaAtual = 1;
	private JRadioButton rdbtnId;
	private JRadioButton rdbtnNome;
	private JRadioButton rdbtnEspecie;
	private JRadioButton rdbtnLocalizador;
	private JRadioButton rdbtnExtincao;
	private JLabel[] lblIds;
	private JLabel[] lblEspecies;
	private JLabel[] lblNomes;
	private JLabel[] lblLocalizador;
	private JLabel[] lblGraudeExtincao;
	private ListaLigada lista;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaAnimais frame = new PesquisaAnimais();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PesquisaAnimais() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700,600);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Color verdeClaro = new Color(144,238,144);
		getContentPane().setBackground(verdeClaro);

		JLabel lblTipopesquisa = new JLabel("Tipo de pesquisa:");
		lblTipopesquisa.setForeground(Color.blue);
		lblTipopesquisa.setBounds(107, 166, 109, 20);
		contentPane.add(lblTipopesquisa);

		JRadioButton rdbtnBancoDeDados = new JRadioButton("Banco de Dados");
		rdbtnBancoDeDados.setForeground(Color.blue);
		rdbtnBancoDeDados.setBackground(verdeClaro);
		rdbtnBancoDeDados.setBounds(238, 165, 127, 23);
		contentPane.add(rdbtnBancoDeDados);
		rdbtnBancoDeDados.setSelected(true);

		JRadioButton rdbtnArquivoDeTexto = new JRadioButton("Arquivo de Texto");
		rdbtnArquivoDeTexto.setForeground(Color.blue);
		rdbtnArquivoDeTexto.setBackground(verdeClaro);
		rdbtnArquivoDeTexto.setBounds(377, 165, 121, 23);
		contentPane.add(rdbtnArquivoDeTexto);

		rdbtnId = new JRadioButton("Id");
		rdbtnId.setForeground(Color.blue);
		rdbtnId.setBackground(verdeClaro);
		rdbtnId.setSelected(true);
		rdbtnId.setBounds(104, 32, 45, 23);
		contentPane.add(rdbtnId);

		rdbtnEspecie = new JRadioButton("Especie");
		rdbtnEspecie.setForeground(Color.blue);
		rdbtnEspecie.setBackground(verdeClaro);
		rdbtnEspecie.setBounds(164, 32, 70, 23);
		contentPane.add(rdbtnEspecie);

		rdbtnNome = new JRadioButton("Nome Popular");
		rdbtnNome.setForeground(Color.blue);
		rdbtnNome.setBackground(verdeClaro);
		rdbtnNome.setBounds(247, 33, 108, 20);
		contentPane.add(rdbtnNome);

		rdbtnLocalizador = new JRadioButton("Localizador");
		rdbtnLocalizador.setForeground(Color.blue);
		rdbtnLocalizador.setBackground(verdeClaro);
		rdbtnLocalizador.setBounds(358, 33, 98, 20);
		contentPane.add(rdbtnLocalizador);

		rdbtnExtincao = new JRadioButton("Grau de Extinção");
		rdbtnExtincao.setForeground(Color.blue);
		rdbtnExtincao.setBackground(verdeClaro);
		rdbtnExtincao.setBounds(458, 33, 121, 20);
		contentPane.add(rdbtnExtincao);

		TipoPesquisaGroup.add(rdbtnArquivoDeTexto);
		TipoPesquisaGroup.add(rdbtnBancoDeDados);

		TipoDadoGroup.add(rdbtnId);
		TipoDadoGroup.add(rdbtnNome);
		TipoDadoGroup.add(rdbtnEspecie);
		TipoDadoGroup.add(rdbtnLocalizador);
		TipoDadoGroup.add(rdbtnExtincao);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.blue);		

		btnPesquisar.setBounds(296, 104, 101, 36);
		contentPane.add(btnPesquisar);

		JPanel panel = new JPanel();
		panel.setBounds(47, 214, 600, 280);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{60, 180, 180, 80, 100, 0};
		gbl_panel.rowHeights = new int[]{35, 35, 35, 35, 35, 35, 35, 35};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);

		JLabel lblId = new JLabel("Id");
		lblId.setForeground(Color.blue);		
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);

		JLabel lblEspecie = new JLabel("Especie");
		lblEspecie.setForeground(Color.blue);
		GridBagConstraints gbc_lblEspecie = new GridBagConstraints();
		gbc_lblEspecie.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspecie.gridx = 1;
		gbc_lblEspecie.gridy = 0;
		panel.add(lblEspecie, gbc_lblEspecie);

		JLabel lblNomeComum = new JLabel("Nome Popular");
		lblNomeComum.setForeground(Color.blue);
		GridBagConstraints gbc_lblNomeComum = new GridBagConstraints();
		gbc_lblNomeComum.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeComum.gridx = 2;
		gbc_lblNomeComum.gridy = 0;
		panel.add(lblNomeComum, gbc_lblNomeComum);

		JLabel lblCategoria = new JLabel("Localizador");
		lblCategoria.setForeground(Color.blue);
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 3;
		gbc_lblCategoria.gridy = 0;
		panel.add(lblCategoria, gbc_lblCategoria);

		lblIds = new JLabel[7];
		lblEspecies = new JLabel[7];
		lblNomes = new JLabel[7];
		lblLocalizador = new JLabel[7];
		lblGraudeExtincao = new JLabel[7];

		GridBagConstraints[] gbc_lblIds = new GridBagConstraints[7];
		GridBagConstraints[] gbc_lblEspecies = new GridBagConstraints[7];
		GridBagConstraints[] gbc_lblNomes = new GridBagConstraints[7];
		GridBagConstraints[] gbc_lblLocalizador = new GridBagConstraints[7];
		GridBagConstraints[] gbc_lblGraudeExtincao = new GridBagConstraints[7];

		for(int x = 0; x < 7; x++) {

			lblIds[x] = new JLabel("");
			gbc_lblIds[x] = new GridBagConstraints();
			gbc_lblIds[x].insets = new Insets(0, 0, 5, 5);
			gbc_lblIds[x].gridx = 0;
			gbc_lblIds[x].gridy = x + 1;
			panel.add(lblIds[x], gbc_lblIds[x]);

			lblEspecies[x] = new JLabel("");
			gbc_lblEspecies[x] = new GridBagConstraints();
			gbc_lblEspecies[x].insets = new Insets(0, 0, 5, 5);
			gbc_lblEspecies[x].gridx = 1;
			gbc_lblEspecies[x].gridy = x + 1;
			panel.add(lblEspecies[x], gbc_lblEspecies[x]);

			lblNomes[x] = new JLabel("");
			gbc_lblNomes[x] = new GridBagConstraints();
			gbc_lblNomes[x].insets = new Insets(0, 0, 5, 5);
			gbc_lblNomes[x].gridx = 2;
			gbc_lblNomes[x].gridy = x + 1;
			panel.add(lblNomes[x], gbc_lblNomes[x]);

			lblLocalizador[x] = new JLabel("");
			gbc_lblLocalizador[x] = new GridBagConstraints();
			gbc_lblLocalizador[x].insets = new Insets(0, 0, 5, 5);
			gbc_lblLocalizador[x].gridx = 3;
			gbc_lblLocalizador[x].gridy = x + 1;
			panel.add(lblLocalizador[x], gbc_lblLocalizador[x]);

			lblGraudeExtincao[x] = new JLabel("");
			gbc_lblGraudeExtincao[x] = new GridBagConstraints();
			gbc_lblGraudeExtincao[x].insets = new Insets(0, 0, 5, 5);
			gbc_lblGraudeExtincao[x].gridx = 4;
			gbc_lblGraudeExtincao[x].gridy = x + 1;
			panel.add(lblGraudeExtincao[x], gbc_lblGraudeExtincao[x]);
		}

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginas = 1;
				paginaAtual = 1;
				resetarTexto();
				if(rdbtnBancoDeDados.isSelected()) {
					buscarBD();
				}else if(rdbtnArquivoDeTexto.isSelected()) {
					buscarTxt();
				}else {
					JOptionPane.showMessageDialog(null, "Selecione o tipo de busca");
				}
				validate();
				repaint();
				
				
			}
		});


		JLabel lblConclusao = new JLabel("Grau de Extinçao");
		GridBagConstraints gbc_lblConclusao = new GridBagConstraints();
		lblConclusao.setForeground(Color.blue);
		gbc_lblConclusao.insets = new Insets(0, 0, 5, 0);
		gbc_lblConclusao.gridx = 4;
		gbc_lblConclusao.gridy = 0;
		panel.add(lblConclusao, gbc_lblConclusao);

		JButton btnPagant = new JButton("PagAnt");
		btnPagant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginaAnterior();
				revalidate();
				repaint();
			}
		});
		btnPagant.setForeground(Color.blue);		
		btnPagant.setBounds(47, 512, 89, 23);
		contentPane.add(btnPagant);

		JButton btnPagseg = new JButton("PagSeg");
		btnPagseg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				paginaSeguinte();
				revalidate();
				repaint();
			}
		});
		btnPagseg.setForeground(Color.blue);		
		btnPagseg.setBounds(558, 512, 89, 23);
		contentPane.add(btnPagseg);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.blue);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Projeto_Tamar().Executar();
				setVisible(false);
			}
		});

		btnVoltar.setBounds(307, 505, 70, 36);
		contentPane.add(btnVoltar);

		txtBusca = new JTextField();
		txtBusca.setColumns(10);
		txtBusca.setBounds(233, 73, 228, 20);
		contentPane.add(txtBusca);

		JLabel lblCampoDaPesquisa = new JLabel("Campo da Pesquisa:");
		lblCampoDaPesquisa.setForeground(Color.blue);
		lblCampoDaPesquisa.setBounds(283, 11, 127, 14);
		contentPane.add(lblCampoDaPesquisa);
	}

	private void paginaAnterior() {
		if(paginaAtual > 1) {
			paginaAtual--;
			for(int x =0; x < 7; x++) {
				int y = x + 7 *( paginaAtual -1) ;
				lblIds[x].setText(Integer.toString(((Tartaruga)lista.pega(y)).getId()));
				lblEspecies[x].setText(((Tartaruga)lista.pega(y)).getEspecie());
				lblNomes[x].setText(((Tartaruga)lista.pega(y)).getNome_popular());
				lblLocalizador[x].setText(((Tartaruga)lista.pega(y)).getTipo_de_localizador());
				lblGraudeExtincao[x].setText(((Tartaruga)lista.pega(y)).getRisco_de_extincao());
			}
		}
	}

	private void paginaSeguinte() {
		if(paginaAtual < paginas) {
			paginaAtual++;

			for(int x = 0 ; x < 7 ; x++) {
				int y = x + 7 *( paginaAtual -1) ;
				if(y >= lista.size()) {
					lblIds[x].setText("");
					lblEspecies[x].setText("");
					lblNomes[x].setText("");
					lblLocalizador[x].setText("");
					lblGraudeExtincao[x].setText("");
				}else {
					lblIds[x].setText(Integer.toString(((Tartaruga)lista.pega(y)).getId()));
					lblEspecies[x].setText(((Tartaruga)lista.pega(y)).getEspecie());
					lblNomes[x].setText(((Tartaruga)lista.pega(y)).getNome_popular());
					lblLocalizador[x].setText(((Tartaruga)lista.pega(y)).getTipo_de_localizador());
					lblGraudeExtincao[x].setText(((Tartaruga)lista.pega(y)).getRisco_de_extincao());
					revalidate();
					repaint();
				}
			}
		}
	}

	private void resetarTexto() {
		for(int x =0; x < 7; x++) {
			lblIds[x].setText("");
			lblEspecies[x].setText("");
			lblNomes[x].setText("");
			lblLocalizador[x].setText("");
			lblGraudeExtincao[x].setText("");
		}
	}

	private void buscarTxt() {
		if(rdbtnId.isSelected()) {
			if(txtBusca.getText() == "" || txtBusca.getText().length() ==  0) {
				lista = new TartarugaTxt().read();
			}else {
				try {
					System.out.println(txtBusca.getText());
					int id = Integer.parseInt(txtBusca.getText());
					lista = new TartarugaTxt().readId(id);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Id deve ser um número");
					txtBusca.setText("");
					return;
				}
			}
		}else if(rdbtnNome.isSelected()) {
			lista = new TartarugaTxt().readNome(txtBusca.getText());
		}else if(rdbtnEspecie.isSelected()){
			lista = new TartarugaTxt().readEspecie(txtBusca.getText());
		}else if(rdbtnLocalizador.isSelected()) {
			lista = new TartarugaTxt().readLocalizador(txtBusca.getText());
		}else if(rdbtnExtincao.isSelected()) {
			lista = new TartarugaTxt().readExtincao(txtBusca.getText());
		}

		if(lista.size() == 0) {
			resetarTexto();
			JOptionPane.showMessageDialog(null, "Nenhuma tartaruga encontrada");
		}

		int contador = lista.size();

		if(lista.size() > 7) {
			paginas =  (int) Math.ceil(((double) lista.size() / 7));
			contador = 7;
		}

		for(int x =0; x < contador; x++) {
			if(lista.pega(x) == null) {
				break;
			}
			lblIds[x].setText(Integer.toString(((Tartaruga) lista.pega(x)).getId()));
			lblEspecies[x].setText(((Tartaruga) lista.pega(x)).getEspecie());
			lblNomes[x].setText(((Tartaruga) lista.pega(x)).getNome_popular());
			lblLocalizador[x].setText(((Tartaruga) lista.pega(x)).getTipo_de_localizador());
			lblGraudeExtincao[x].setText(((Tartaruga) lista.pega(x)).getRisco_de_extincao());
		}
	}

	//Arrumar para listaligada
	private void buscarBD() {

		if(rdbtnId.isSelected()) {
			try {
				if(txtBusca.getText() == "" || txtBusca.getText().length() == 0) {
					lista = new AnimalDB().read();
				}else {
					int id = Integer.parseInt(txtBusca.getText());
					lista = new AnimalDB().readId(id);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Id deve ser um número");
				txtBusca.setText("");
				return;
			}
		}else if(rdbtnNome.isSelected()) {
			lista = new AnimalDB().readNome(txtBusca.getText());
		}else if(rdbtnEspecie.isSelected()){
			lista = new AnimalDB().readEspecie(txtBusca.getText());
		}else if(rdbtnLocalizador.isSelected()) {
			lista = new AnimalDB().readLocalizador(txtBusca.getText());
		}else if(rdbtnExtincao.isSelected()) {
			lista = new AnimalDB().readExtincao(txtBusca.getText());
		}
		
		if(lista.size() == 0) {
			resetarTexto();
			JOptionPane.showMessageDialog(null, "Nenhuma tartaruga encontrada");
		}

		int contador = lista.size();

		if(lista.size() > 7) {
			paginas =  (int) Math.ceil(((double) lista.size() / 7));
			contador = 7;
		}

		for(int x =0; x < contador; x++) {
			if(lista.pega(x) == null) {
				break;
			}
			lblIds[x].setText(Integer.toString(((Tartaruga) lista.pega(x)).getId()));
			lblEspecies[x].setText(((Tartaruga) lista.pega(x)).getEspecie());
			lblNomes[x].setText(((Tartaruga) lista.pega(x)).getNome_popular());
			lblLocalizador[x].setText(((Tartaruga) lista.pega(x)).getTipo_de_localizador());
			lblGraudeExtincao[x].setText(((Tartaruga) lista.pega(x)).getRisco_de_extincao());
		}
	}
}