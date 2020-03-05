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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.TartarugaTxt;
import model.AnimalDB;

@SuppressWarnings("serial")
public class Deletar extends JFrame implements ActionListener{

	private JLabel lbl1;
	private JTextField txt1;
	private JButton btn1, btn2;

	public Deletar() {
		super("Deletar Tartaruga");
	}

	void Executar() {
		
		Color verdeClaro = new Color(144,238,144);
        getContentPane().setBackground(verdeClaro);

		lbl1 = new JLabel("Id:");
		lbl1.setForeground(Color.blue);

		//Combobox
		txt1 = new JTextField(5);

		btn1 = new JButton("Deletar");
		btn1.setForeground(Color.blue);

		btn2 = new JButton("Voltar");
		btn2.setForeground(Color.blue);

		setSize(275,170);
		setLocation(250,150);

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(new GridBagLayout());

		AdicionaItem(0, 0, 1, 1, 0, 0, lbl1);
		AdicionaItem(0, 1, 1, 1, 0, 0, txt1);

		AdicionaItem(1, 0, 1, 1, 0, 0, btn2);
		AdicionaItem(1, 1, 1, 1, 0, 0, btn1);
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


	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btn1)) {
			int id;
			try {
				id = Integer.parseInt(txt1.getText());
				boolean db = new AnimalDB().delete(id);
				boolean txt = new TartarugaTxt().deletar(id);	
				if( db && txt) {
					JOptionPane.showMessageDialog(null, "Deletado");
				}else if(db) {
					JOptionPane.showMessageDialog(null, "Deletado apenas no DB");
				}else if(txt) {
					JOptionPane.showMessageDialog(null, "Deletado apenas no txt");
				}else {
					JOptionPane.showMessageDialog(null, "Id não encontrado nenhuma tartaruga deletada");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "O id deve ser um número inteiro");
				return; 
			}
		}
		else {
			new Projeto_Tamar().Executar();
			setVisible(false);
		}
	}


	public static void main(String[] args) {
		new Deletar().Executar();
	}
}
