import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class Eje8_sofi
{
	static JTextField campoTxt1 = new JTextField();
	static JTextField campoTxt2 = new JTextField();
	//--------------------------------------------------------------------------------
	static JButton bottonMAY = new JButton("MAY");
	static JButton bottonMIN = new JButton("MIN");
	static JButton bottonBORRAR = new JButton("BORRAR");

	public static void main(String[] args){

		JFrame frame = new JFrame ("Convertir Mayúsculas y Minúsculas"); //jframe
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(10,10));
  	frame.setSize(380,250);
		bottonBORRAR.setForeground(Color.RED);

		frame.add(campoTxt1,BorderLayout.NORTH); //texto de arriba
		frame.add(bottonMAY,BorderLayout.WEST);
		frame.add(bottonMIN,BorderLayout.CENTER);
		frame.add(bottonBORRAR,BorderLayout.EAST);
		frame.add(campoTxt2,BorderLayout.SOUTH); //texto de abajo


		bottonMAY.addActionListener(new ActionListener(){ //convertir a Mayuscula
			 @Override
			 public void actionPerformed(ActionEvent e){
						campoTxt2.setText(campoTxt1.getText().toUpperCase());
						//pantalla texto set text de escirito, y getText to MAY
						//if(bottonMIN.isSelected()).getText().toLowerCase();
				}
			});

		bottonMIN.addActionListener(new ActionListener(){ //convertir a minuscula
			 @Override
			 public void actionPerformed(ActionEvent e)		{
				 	campoTxt2.setText(campoTxt1.getText().toLowerCase());
			  }
			});

		bottonBORRAR.addActionListener(new ActionListener()	{ //Botton para borrar
			@Override
			 public void actionPerformed(ActionEvent e)		{
						campoTxt1.setText("");
						campoTxt2.setText("");
				}
			});


		frame.setVisible(true);

	}
}
