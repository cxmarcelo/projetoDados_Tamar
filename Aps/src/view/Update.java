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
import model.Tartaruga;


@SuppressWarnings("serial")
public class Update extends JFrame implements ActionListener{

	private JButton btn1, btn2;
	private JTextField txt1, txt2, txt3, txt4, txt5;
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5;

	public Update() {
		super("Atualizar Tartaruga");
	}

	void Executar() {
		
		Color verdeClaro = new Color(144,238,144);
        getContentPane().setBackground(verdeClaro);

		lbl1 = new JLabel("Id:");
		lbl1.setForeground(Color.blue);

		txt1 = new JTextField(20);
		txt1.setEditable(true);

		lbl2 = new JLabel("Especie:");
		lbl2.setForeground(Color.blue);

		txt2 = new JTextField(20);

		lbl3 = new JLabel("Nome popular :");
		lbl3.setForeground(Color.blue);

		txt3 = new JTextField(20);

		lbl4 = new JLabel("Tipo de localizador:");
		lbl4.setForeground(Color.blue);

		txt4 = new JTextField(20);

		lbl5 = new JLabel("Risco de extincao :");
		lbl5.setForeground(Color.blue);

		txt5 = new JTextField(20);

		btn1 = new JButton("Atualizar");
		btn1.setForeground(Color.blue);
		btn2 = new JButton("Voltar");
		btn2.setForeground(Color.blue);

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		setSize(400,260);
		setLocation(250,150);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(new GridBagLayout());

		AdicionaItem(0, 0, 1, 1, 0, 0, lbl1);
		AdicionaItem(0, 1, 1, 1, 0, 0, txt1);

		AdicionaItem(1, 0, 1, 1, 0, 0, lbl2);
		AdicionaItem(1, 1, 3, 1, 0, 0, txt2);

		AdicionaItem(2, 0, 1, 1, 0, 0, lbl3);
		AdicionaItem(2, 1, 3, 1, 0, 0, txt3);

		AdicionaItem(3, 0, 1, 1, 0, 0, lbl4);
		AdicionaItem(3, 1, 3, 1, 0, 0, txt4);

		AdicionaItem(4, 0, 1, 1, 0, 0, lbl5);
		AdicionaItem(4, 1, 3, 1, 0, 0, txt5);

		AdicionaItem(5, 0, 1, 1, 0, 0, btn2);
		AdicionaItem(5, 1, 3, 1, 0, 0, btn1);

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
				new AnimalDB().Update(id, txt2.getText(), txt3.getText(), txt4.getText(), txt5.getText());
				new TartarugaTxt().update(id, new Tartaruga(id, txt2.getText(), txt3.getText(), txt4.getText(), txt5.getText()));
				JOptionPane.showMessageDialog(null, "Atualizado");
				new Projeto_Tamar().Executar();
				
			}catch (Exception exp) {
				JOptionPane.showMessageDialog(null, "O id deve ser um número inteiro");
				return;
			}
			setVisible(false);

		}
		else {
			new Projeto_Tamar().Executar();
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		setDefaultLookAndFeelDecorated(true);
		new Update().Executar();
	}
}