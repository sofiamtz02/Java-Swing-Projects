import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Font;
import java.util.Arrays;
import java.util.Scanner;

public class Conjuntos{
	public static void main(String[] args){
		JFrame frame = new JFrame("Conjuntos:");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,690);
		frame.setLayout(null);

		//font -----------------------------
		Font fn = new Font("SansSerif", Font.PLAIN, 18);
		Font h = new Font("Helvetica", Font.PLAIN, 16);

		// cuadritos Conjuntos ----------------------------------
		JTextArea textA = new JTextArea();
		textA.setBounds(0,0,245,225);
		frame.add(textA);
		textA.setFont(h);

		JTextArea textB = new JTextArea();
		textB.setBounds(255,0,245,225);
		frame.add(textB);
		textB.setFont(h);

		//Botones -----------------------------
		String [] opciones = {"A", "B", "A \u2229 B", "A \u222A B", "A - B", "B - A"};
		JRadioButton btn[] = new JRadioButton[6];
		ButtonGroup grpBtn = new ButtonGroup();

		JPanel panelBTN = new JPanel();
		panelBTN.setLayout(new GridLayout(3,2)); //3 x 2
		panelBTN.setBounds(0,235,245,220);

		for (int i=0; i<6; i++){
			btn[i] = new JRadioButton(opciones[i]);
			grpBtn.add(btn[i]);
			panelBTN.add(btn[i]);
		}

		frame.add(panelBTN);

		// imagenes de conjuntos----------------------

		JLabel pic = new JLabel( new ImageIcon(Conjuntos.class.getResource("/ED.png")));
			//cuadrito para imagenes
			JPanel panelPIC = new JPanel();
			panelPIC.setLayout(new GridLayout());
			panelPIC.setBounds(255,235,245,220);
			panelPIC.add(pic);
			frame.add(panelPIC);

			ImageIcon [] ima = new ImageIcon[6];
			 for (int i=0; i<6;i++){
					ima[i] = new ImageIcon(Conjuntos.class.getResource("/E"+(i+1)+".png"));
				}

	// cuadritos Conjuntos IMPRIMIR----------------------------------
		JTextArea textR = new JTextArea(" Introduzca elementos separados por espacios \n en cada conjunto y seleccione una operación. ");
		textR.setBounds(0,460,500,200);
		frame.add(textR);
		textR.setFont(fn);

//_______________BOTONES ACTION LISTENE__________________________--

		//------- A ----------------
		btn[0].addActionListener(new ActionListener() {
		 @Override
				public void actionPerformed(ActionEvent e) {
					// pic.setIcon(new ImageIcon (Conjuntos.class.getResource("/E1.png")));
					pic.setIcon(ima[0]);
					TreeSet<String> setA = new TreeSet<>();
					String conj_A = textA.getText();

					String[] pal_textA = conj_A.split( " " ); //separar
					for ( int i= 0; i<pal_textA.length; i++ ) {
						setA.add (pal_textA[i]);
					}

					// String todo_a = setA.toString();
					String todo_a = String.valueOf(setA);
					textR.setText(todo_a);
			  }
	 	});


		//------- B ----------------
		btn[1].addActionListener(new ActionListener() {
		 @Override
				public void actionPerformed(ActionEvent e) {
					// pic.setIcon (new ImageIcon (Conjuntos.class.getResource("/E2.png")));
					pic.setIcon(ima[1]);
					TreeSet<String> setB = new TreeSet<>();
					String conj_B = textB.getText();

					String[] pal_textB = conj_B.split( " " ); //separar
					for ( int i= 0; i<pal_textB.length; i++ ) {
						setB.add (pal_textB[i]); //juntar
					}

					String todo_b = setB.toString();
					textR.setText(todo_b);
				}
		});

		//------- A n b ------------ interseccion
		btn[2].addActionListener(new ActionListener() {
		 @Override
				public void actionPerformed(ActionEvent e) {
					// pic.setIcon (new ImageIcon (Conjuntos.class.getResource("/E3.png")));
					pic.setIcon(ima[2]);
					String conj_A = textA.getText();
					String conj_B = textB.getText();

					//-> parte A
						TreeSet<String> setA = new TreeSet<>();
						String[] pal_textA = conj_A.split( " " ); //separar
						for ( int i=0; i<pal_textA.length; i++ ) {
							setA.add (pal_textA[i]);
						}
						String todo_a = setA.toString();
						textR.setText(todo_a);

					 //-> obtener la parte B
						TreeSet<String> setB = new TreeSet<>();
						String[] pal_textB = conj_B.split( " " ); //separar
						for ( int i= 0; i<pal_textB.length; i++ ) {
							setB.add(pal_textB[i]);
						}
						String todo_b = setB.toString();
						textR.setText(todo_b);

				//-> obtener interseccion
					TreeSet<String> n = new TreeSet<>();
					n.addAll(setA); //todo A
					n.retainAll(setB); //permite eliminar todos los elementos de la lista que no le indiquemos en la colección

					String inter = n.toString();
					// String inter = String.valueOf(n);
					textR.setText(inter);

			  }
	 	});

		//------- A u B ------------ union

		btn[3].addActionListener(new ActionListener() {
		 @Override
				public void actionPerformed(ActionEvent e) {
					// pic.setIcon (new ImageIcon (Conjuntos.class.getResource("/E4.png")));
					pic.setIcon(ima[3]);
					String conj_A = textA.getText();
					String conj_B = textB.getText();

					//-> parte A
				  	TreeSet<String> setA = new TreeSet<>();
						String[] pal_textA = conj_A.split( " " ); //separar
						for ( int i=0; i<pal_textA.length; i++ ) {
							setA.add (pal_textA[i]);
						}
						String todo_a = setA.toString();
						textR.setText(todo_a);

					 //-> obtener la parte B
					  TreeSet<String> setB = new TreeSet<>();
						String[] pal_textB = conj_B.split( " " ); //separar
						for ( int i= 0; i<pal_textB.length; i++ ) {
							setB.add (pal_textB[i]);
						}
						String todo_b = setB.toString();
						textR.setText(todo_b);

				//-> obtener union
					TreeSet<String> u = new TreeSet<>(); //-> agregar todo
					u.addAll(setA); //todo A
					u.addAll(setB); //todo B

				  String union = u.toString();
					// String union = String.valueOf(u);
					textR.setText(union);
			  }
	 	});


		//------- A - B ------------ solo A sin B

		btn[4].addActionListener(new ActionListener() {
		 @Override
				public void actionPerformed(ActionEvent e) {
					// pic.setIcon (new ImageIcon (Conjuntos.class.getResource("/E5.png")));
					pic.setIcon(ima[4]);
					String conj_A = textA.getText();
					String conj_B = textB.getText();

					//-> parte A
				  	TreeSet<String> setA = new TreeSet<>();
						String[] pal_textA = conj_A.split( " " ); //separar
						for ( int i=0; i<pal_textA.length; i++ ) {
							setA.add (pal_textA[i]);
						}
						String todo_a = setA.toString();
						textR.setText(todo_a);

					 //-> obtener la parte B
					  TreeSet<String> setB = new TreeSet<>();
						String[] pal_textB = conj_B.split( " " ); //separar
						for ( int i= 0; i<pal_textB.length; i++ ) {
							setB.add (pal_textB[i]);
						}
						String todo_b = setB.toString();
						textR.setText(todo_b);

				//-> obtener diferencia de a - b
					TreeSet<String> a_minus_b = new TreeSet<>();
					a_minus_b.addAll(setA); //todo A
					a_minus_b.removeAll(setB); // eliminar todo B

				  String dif = a_minus_b.toString();
					// String dif = String.valueOf(setA);
					textR.setText(dif);
			  }
	 	});


		//------- B - A ------------ solo B sin A

		btn[5].addActionListener(new ActionListener() {
		 @Override
				public void actionPerformed(ActionEvent e) {
					// pic.setIcon (new ImageIcon (Conjuntos.class.getResource("/E6.png")));
					pic.setIcon(ima[5]);
					String conj_A = textA.getText();
					String conj_B = textB.getText();

					//-> parte A
				  	TreeSet<String> setA = new TreeSet<>();
						String[] pal_textA = conj_A.split( " " ); //separar
						for ( int i=0; i<pal_textA.length; i++ ) {
							setA.add (pal_textA[i]); //Juntar
						}
						String todo_a = setA.toString();
						textR.setText(todo_a);

					 //-> parte B
					  TreeSet<String> setB = new TreeSet<>();
						String[] pal_textB = conj_B.split( " " ); //separar
						for ( int i= 0; i<pal_textB.length; i++ ) {
							setB.add (pal_textB[i]);
						}
						String todo_b = setB.toString();
						textR.setText(todo_b);

				//-> obtener diferencia de b - a
					TreeSet<String> b_quitar_a = new TreeSet<>();
					b_quitar_a.addAll(setB); //todo B
					b_quitar_a.removeAll(setA); // eliminar todo A

				  String dif2 = b_quitar_a.toString();
					// String dif = String.valueOf(setA);
					textR.setText(dif2); //IMPRIMIR EN TEXTR
			  }
	  	});

			frame.setVisible(true);

 }
}

//-----------------------------

//tree set, guardra cadenas de izq,
// conjunto
// el de abajo otro conjunto.

/*
if (jRadioButton1.isSelected())
	 {
		 JTextArea.append("-  ");
	 }
*/

//usar treeset para el último y los otros dos pueden ser hashset.

//unicode (U+229).
