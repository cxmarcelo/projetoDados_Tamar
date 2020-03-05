package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Projeto_Tamar extends JFrame implements ActionListener{

	private JButton btn1, btn2, btn3, btn4;
	private JLabel lbl1, lbl2;

	public Projeto_Tamar() {
		super("Projeto Tamar");
	}

	void Executar() {
		
		Color verdeClaro = new Color(144,238,144);
        getContentPane().setBackground(verdeClaro);

		lbl1 = new JLabel("Bem-Vindo a rede de acesso do Projeto Tamar!", JLabel.CENTER);
		lbl1.setForeground(Color.blue);
		lbl2 = new JLabel("O que você deseja?", JLabel.CENTER);
		lbl2.setForeground(Color.blue);
		btn1 = new JButton("Inserir");
		btn1.setForeground(Color.blue);
		btn2 = new JButton("Deletar");
		btn2.setForeground(Color.blue);
		btn3 = new JButton("Consultar");
		btn3.setForeground(Color.blue);
		btn4 = new JButton("Atualizar");
		btn4.setForeground(Color.blue);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);

		setSize(400,200);
		setLocation(250,150);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(new GridBagLayout());

		AdicionaItem(0, 0, 4, 1, 0, 0, lbl1);
		AdicionaItem(1, 0, 4, 1, 0, 0, lbl2);
		AdicionaItem(2, 0, 1, 1, 0, 0, btn1);
		AdicionaItem(2, 1, 1, 1, 0, 0, btn2);
		AdicionaItem(2, 2, 1, 1, 0, 0, btn3);
		AdicionaItem(2, 3, 1, 1, 0, 0, btn4);

		setVisible(true);
		setResizable(false);
	}

	public void AdicionaItem(int linha, int coluna, int largura, int altura, int escalaX, int escalaY, JComponent Objeto){
		GridBagConstraints ItemGrade = new GridBagConstraints();
		ItemGrade.insets = new Insets(5, 5, 5, 5);
		ItemGrade.gridx = coluna;
		ItemGrade.gridy = linha;
		ItemGrade.gridwidth = largura;
		ItemGrade.gridheight = altura;
		ItemGrade.weightx = escalaX;
		ItemGrade.weighty = escalaY;
		ItemGrade.fill = GridBagConstraints.BOTH;
		ItemGrade.anchor = GridBagConstraints.CENTER;
		getContentPane().add(Objeto, ItemGrade);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btn1)) {
			new Inserir().setVisible(true);
			setVisible(false);

		}
		else if(e.getSource().equals(btn2)) {
			new Deletar().Executar();
			setVisible(false);
		}
		else if(e.getSource().equals(btn3)) {
			setVisible(false);
			PesquisaAnimais frame = new PesquisaAnimais();
			frame.setVisible(true);
			
		}
		else {
			new Update().Executar();
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		setDefaultLookAndFeelDecorated(true);
		new Projeto_Tamar().Executar();
	}
}

