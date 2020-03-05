package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.TartarugaTxt;
import model.AnimalDB;
import model.Tartaruga;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Inserir extends JFrame {

	private JPanel contentPane;
	private ButtonGroup tipoInserir;
	private ButtonGroup tipoTxtBD;
	private boolean painelAtivo = false;
	private JTextField txtId, txtEspecie, txtNome, txtLocalizador, txtRisco;
	private JLabel lblId, lblEspecie, lblNome, lblLocalizador, lblRisco;
	private JRadioButton rdbtnLifo;
	private JRadioButton rdbtnFifo;
	private JRadioButton rdbtnTxt;
	private JRadioButton rdbtnBD;
	private JRadioButton rdbtnAmbos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserir frame = new Inserir();
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
	public Inserir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		Color verdeClaro = new Color(144,238,144);
		contentPane.setBackground(verdeClaro);
		contentPane.setLayout(null);
		

		lblId = new JLabel("Id:");
		lblId.setForeground(Color.blue);
		lblId.setBounds(10, 10, 100, 20);
		contentPane.add(lblId);

		txtId = new JTextField(20);
		txtId.setEditable(true);
		txtId.setBounds(130, 10, 177,20);
		contentPane.add(txtId);


		lblEspecie = new JLabel("Especie:");
		lblEspecie.setForeground(Color.blue);
		lblEspecie.setBounds(10, 40, 100,20);
		contentPane.add(lblEspecie);


		txtEspecie = new JTextField(20);
		txtEspecie.setBounds(130, 40, 177,20);
		contentPane.add(txtEspecie);


		lblNome = new JLabel("Nome popular :");
		lblNome.setForeground(Color.blue);
		lblNome.setBounds(10, 71, 100,20);
		contentPane.add(lblNome);


		txtNome = new JTextField(20);
		txtNome.setBounds(130, 71, 177,20);
		contentPane.add(txtNome);

		lblLocalizador = new JLabel("Tipo de localizador:");
		lblLocalizador.setForeground(Color.blue);
		lblLocalizador.setBounds(10, 102, 100,20);
		contentPane.add(lblLocalizador);


		txtLocalizador = new JTextField(20);
		txtLocalizador.setBounds(130, 102, 177,20);
		contentPane.add(txtLocalizador);

		lblRisco = new JLabel("Risco de extincao :");
		lblRisco.setForeground(Color.blue);
		lblRisco.setBounds(10, 133, 100,20);
		contentPane.add(lblRisco);


		txtRisco = new JTextField(20);
		txtRisco.setBounds(130, 133, 177,20);
		contentPane.add(txtRisco);


		rdbtnBD = new JRadioButton("BD");
		rdbtnBD.setBounds(10, 165, 87, 23);
		rdbtnBD.setSelected(true);
		rdbtnBD.setBackground(verdeClaro);
		contentPane.add(rdbtnBD);

		rdbtnTxt = new JRadioButton("txt");
		rdbtnTxt.setBounds(134, 165, 66, 23);
		rdbtnTxt.setBackground(verdeClaro);
		contentPane.add(rdbtnTxt);

		rdbtnAmbos = new JRadioButton("Ambos");
		rdbtnAmbos.setBounds(241, 165, 66, 23);
		rdbtnAmbos.setBackground(verdeClaro);
		contentPane.add(rdbtnAmbos);

		rdbtnFifo = new JRadioButton("Começo do arquivo");
		rdbtnFifo.setSelected(true);
		rdbtnFifo.setBounds(58, 191, 109, 23);
		rdbtnFifo.setBackground(verdeClaro);
		//contentPane.add(rdbtnFifo);

		rdbtnLifo = new JRadioButton("Final do arquivo");
		rdbtnLifo.setBounds(198, 191, 109, 23);
		rdbtnLifo.setBackground(verdeClaro);
		//contentPane.add(rdbtnLifo);


		tipoTxtBD = new ButtonGroup();
		tipoTxtBD.add(rdbtnTxt);
		tipoTxtBD.add(rdbtnBD);
		tipoTxtBD.add(rdbtnAmbos);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				try {
					id = Integer.parseInt(txtId.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Id deve ser um número inteiro");
					return;
				}

				Tartaruga tar = new Tartaruga(id, txtEspecie.getText(), txtNome.getText(), txtLocalizador.getText(), txtRisco.getText());


				if(rdbtnBD.isSelected()) {
					if(inserirDB(tar)) {
						JOptionPane.showMessageDialog(null, "Tartaruga registrada com sucesso");
					}
				}else if(rdbtnTxt.isSelected()) {
					if(inserirTxt(tar)) {
						JOptionPane.showMessageDialog(null, "Tartaruga registrada com sucesso");
					}
				}else if(rdbtnAmbos.isSelected()) {
					inserirAmbos(tar);
				}


			}
		});
		btnInserir.setBounds(40, 226, 89, 23);
		contentPane.add(btnInserir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Projeto_Tamar().Executar();
			}
		});
		btnVoltar.setBounds(174, 226, 89, 23);
		contentPane.add(btnVoltar);

		tipoInserir = new ButtonGroup();
		tipoInserir.add(rdbtnFifo);
		tipoInserir.add(rdbtnLifo);

		rdbtnTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!painelAtivo) {
					painelAtivo = true;
					contentPane.add(rdbtnFifo);
					contentPane.add(rdbtnLifo);
					repaint();
					revalidate();
				}
			}
		});

		rdbtnAmbos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!painelAtivo) {
					painelAtivo = true;
					contentPane.add(rdbtnFifo);
					contentPane.add(rdbtnLifo);
					repaint();
					revalidate();
				}
			}
		});

		rdbtnBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(painelAtivo) {
					painelAtivo = false;
					contentPane.remove(rdbtnLifo);
					contentPane.remove(rdbtnFifo);
					repaint();
					revalidate();
				}
			}
		});

	}

	private boolean inserirTxt(Tartaruga tar) {
		try {
			boolean retorno = false;
			if(rdbtnFifo.isSelected()) {
				retorno = new TartarugaTxt().inserirInicio(tar);
			}else if(rdbtnLifo.isSelected()) {
				retorno = new TartarugaTxt().inserirFinal(tar);
			}else {
				JOptionPane.showMessageDialog(null, "Escolha um método de inserção");
				retorno = false;
			}
			return retorno;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro para inserir no arquivo.txt");
			return false;
		}
	}

	private boolean inserirDB(Tartaruga tar) {
		return new AnimalDB().create(tar.getId(), tar.getEspecie(), tar.getNome_popular(), tar.getTipo_de_localizador(), tar.getTipo_de_localizador());

	}

	private void inserirAmbos(Tartaruga tar) {
		boolean txt, db;
		txt = inserirTxt(tar);
		db = inserirDB(tar);
		
		if(txt && db) {
			JOptionPane.showMessageDialog(null, "Registro inclúido com sucesso no Banco e no .txt");
		}else if(db && !txt) {
			JOptionPane.showMessageDialog(null, "Falha: Registro inserido apenas no Banco de dados");
		}else if(!db && txt) {
			JOptionPane.showMessageDialog(null, "Falha: Registro inserido apenas no .txt");
		}else {
			JOptionPane.showMessageDialog(null, "Erro: Registro não foi inserido em nenhum dos 2");
		}
	}
}
