package view;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import javax.swing.JComponent;

public class teste
{
	private JFormattedTextField vData;

	public JComponent tela() throws ParseException
	{
		javax.swing.JPanel painel=new javax.swing.JPanel();
		painel.setLayout(new java.awt.FlowLayout());
		vData=new JFormattedTextField(new MaskFormatter("##/##/####"));
		vData.setValue(null);
		vData.setColumns(6);

		painel.add(vData);
		return painel;
	}

	public static void main(String[] args)
	{
		javax.swing.JFrame frame=new javax.swing.JFrame();
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		teste d=new teste();
		try
		{
			frame.add(d.tela());
		}
		catch(ParseException pe)
		{pe.printStackTrace();}
		frame.setSize(100,100);
		frame.setVisible(true);
	}
}