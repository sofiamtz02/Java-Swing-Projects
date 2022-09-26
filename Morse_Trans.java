import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;


public class Morse_Trans{
		static JTextField textJ;
		static JTextField morseField;
		static JButton convertTxAMorse;
		static JButton convButtonInvers;
		static JScrollPane scrollPanel;

	public static void main(String[] args){
			char[] alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
			String[] codigoMorse = { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--", "-..-", "-.--", "--.."," ",};

			JFrame frame = new JFrame("Traductor Morse");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null); //layers
			frame.setSize(700, 400);
			frame.setResizable(false);
			// frame.setVisible(true);


			JLabel lblTEXTO = new JLabel("Texto");
			frame.getContentPane().add(lblTEXTO);
			lblTEXTO.setBounds(15, 21, 46, 14);

			//con Jtextfield no se puede poner scroll
			/*JTextField textJ = new JTextField();
			frame.getContentPane().add(textJ);
			textJ.setBounds(11, 37, 220, 160);
			// textJ.setRows(5);
		  textJ.setColumns(20);*/

			JTextArea textJ = new JTextArea();
			frame.getContentPane().add(textJ);
			textJ.setBounds(11, 37, 220, 160);
			textJ.setRows(5);
			textJ.setLineWrap(true);
			textJ.setColumns(10);
			// Panel3.add(new JScrollPane(textJ));
      // JScrollPane scrollPane = new JScrollPane(textJ);
      // this.add(scrollPane, BorderLayout.CENTER);



			JButton convertTxAMorse = new JButton("T-->M");
			frame.getContentPane().add(convertTxAMorse);
			convertTxAMorse.setBounds(234, 65, 100, 25);

			JButton convButtonInvers = new JButton("T<--M");
			frame.getContentPane().add(convButtonInvers); //agregar Panel
			convButtonInvers.setBounds(234, 100, 100, 25);

			JLabel lblMorseCode = new JLabel("Morse");
			frame.getContentPane().add(lblMorseCode);
			lblMorseCode.setBounds(353, 21, 98, 14);

			//con JTEXTFIELD no se puede poner scroll
			/*JTextField morseField = new JTextField();
			frame.getContentPane().add(morseField);
			morseField.setBounds(349, 37, 220, 160);
			// morseField.setRows(5);
			morseField.setColumns(10);*/

			JTextArea morseField = new JTextArea();
			frame.getContentPane().add(morseField);
			morseField.setBounds(349, 37, 220, 160);
		  morseField.setRows(5);
			morseField.setColumns(10);
			morseField.setLineWrap(true);
		  morseField.setWrapStyleWord(true);

			convertTxAMorse.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					    if(e.getSource() == convertTxAMorse) {
					        String obtener = textJ.getText().toLowerCase();
					        String morse = "";
					        char[] obtenerArray = obtener.toCharArray();

					        for (int i = 0; i < obtenerArray.length; i++) {
					          for (int j = 0; j < alfabeto.length; j++) {
											if(obtenerArray[i] == alfabeto[j]) {
												morse += codigoMorse[j]+ " ";
												// morse+="bb";
					             }
					          }
					          morseField.setText(morse); //agregar la traducción en el texto de morse
					        }
						}
					}
		  });

			convButtonInvers.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
							if(e.getSource() == convButtonInvers) {
									String obtener = morseField.getText().toLowerCase();
									String esp = "";
									// String[] array = obtener.split("   ");
									String[] array = obtener.split("(?<! ) | (?<= {3})");


									for (int i = 0; i < array.length; i++) {
										for (int j = 0; j < codigoMorse.length; j++) {
												if (array[i].equals(codigoMorse[j])  && codigoMorse[j]!="  ") {
													// esp += ((char)(j+'a'));
													esp += alfabeto[j];
													// System.out.print((char)(j + 'a') + " ");
										     }
												 else if(array[i].equals(codigoMorse[j])  && codigoMorse[j]=="  "){
													 esp += alfabeto[j]+" ";
													 // esp += ((char)(j+'a')+ " ");
												 }
									  }
							    	textJ.setText(esp); //agregar la traducción en el texto de morse
						      }

					}
				}
			});

				frame.setVisible(true);


			}
}
