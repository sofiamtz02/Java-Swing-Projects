import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class PizzaT5{

	//--------------------------------------------------------------------------------

	// static String nam[] = {"Pepperoni","Jamon","Pina"};
	//static JCheckBox pizzas[] = new JCheckBox[3]; //arreglo de botones

	//static String num[] = {"Cola","Manzana","Naranja"};
	// static JRadioButton refr[] = new JRadioButton[3];

	static String saborDeREFRESCO;
	static String saborDePIZZA;

	//PizzaT5.saborDeREFRESCO = new String("seleccione el sabor de su preferencia...");
	// PizzaT5.saborDePIZZA = new String("de puro queso");


	static int ordenPIZZA, ordRefresco;

	public static void main(String[] args){

		JFrame frame = new JFrame("Su orden dentro de la Pizzeria"); //Título
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new GridLayout(5, 3)); //5 x 3

	//PRIMER LINEA
	JLabel lineaTXT = new JLabel(" > La orden es:                                                ");
	JLabel espacioY = new JLabel (" ");
	JLabel Espacio_1 = new JLabel ("      ");
		frame.add(lineaTXT);
		frame.add(espacioY);
		frame.add(Espacio_1);

	//SEGUNDA LINEA
	JTextField TXTordenarPI = new JTextField();
	JLabel linea2 = new JLabel("  Pizzas");
	JButton btnLISTO = new JButton("Listo");
		frame.add(TXTordenarPI);
		frame.add(linea2);
		frame.add(btnLISTO);

	//TERCERA LINEA
	JCheckBox chkPepper = new JCheckBox("Pepperoni");
	JCheckBox chkJAM = new JCheckBox("Jamon");
	JCheckBox chkPINA = new JCheckBox("Pina");
		frame.add(chkPepper); //agregar el boton chk de pepperoni
		frame.add(chkJAM); //agregar el boton chk de jamon
		frame.add(chkPINA);

	//CUARTA LINEA
	JTextField TXTordenarREFR = new JTextField();
	JLabel linea4 = new JLabel("  Refrescos");
	JLabel Espacio_2 = new JLabel("    ");
		frame.add(TXTordenarREFR);
		frame.add(linea4);
		frame.add(Espacio_2);

	//QUINTA LINEA
	JRadioButton btnCOLA = new JRadioButton("Cola");
	JRadioButton btnMANZ = new JRadioButton("Manzana");
	JRadioButton btnNARANJ = new JRadioButton("Naranja");
		frame.add(btnCOLA);
		frame.add(btnMANZ);
		frame.add(btnNARANJ);



		//-------------------ActionListener----------------------
		btnLISTO.addActionListener(new ActionListener() {
	  	@Override
			 	public void actionPerformed(ActionEvent e) {
					try { PizzaT5.ordenPIZZA = Integer.parseInt(TXTordenarPI.getText());
					} catch (NumberFormatException a) {
							PizzaT5.ordenPIZZA = 0;
					}
					//-----
					try { PizzaT5.ordRefresco = Integer.parseInt(TXTordenarREFR.getText());
					} catch (NumberFormatException b) {
							PizzaT5.ordRefresco = 0;
					}*/
						//-------------

						//CUANDO NO PIDIO NADA
						if (PizzaT5.ordenPIZZA == 0 && PizzaT5.ordRefresco == 0) {
								lineaTXT.setText(" No ha pedido nada... seleccione su orden");
						}

						//CUANDO SOLAMENTE ES UNA PIZZA
						else if (PizzaT5.ordenPIZZA == 1 && PizzaT5.ordRefresco == 0) {
								lineaTXT.setText(" 1 pizza " + PizzaT5.saborDePIZZA );
						}

						//CUANDO SOLAMENTE SON UNA O MÁS PIZZAS Y NO REFRESCO
						else if (PizzaT5.ordenPIZZA > 1 && PizzaT5.ordRefresco == 0) {
								lineaTXT.setText(" " + PizzaT5.ordenPIZZA + " pizzas " + PizzaT5.saborDePIZZA + ".");
						}

						//CUANDO SOLAMENTE ES UN REFRESCO
						else if (PizzaT5.ordRefresco == 1 && PizzaT5.ordenPIZZA == 0) {
								lineaTXT.setText(" 1 refresco " + PizzaT5.saborDeREFRESCO + ".");
						}

						//CUANDO SOLO SON MÁS DE 1 REFRESCO Y NO PIZZA
						else if (PizzaT5.ordenPIZZA == 0 && PizzaT5.ordRefresco > 1) {
								lineaTXT.setText(" " + PizzaT5.ordRefresco + " refrescos " + PizzaT5.saborDeREFRESCO + ".");
						}
						//PARA CUANDO ES 1 PIZZA Y 1  REFESCOS
						else if (PizzaT5.ordenPIZZA == 1 && PizzaT5.ordRefresco == 1) {
								lineaTXT.setText(" 1 pizza " + PizzaT5.saborDePIZZA);
								espacioY.setText(" y un refresco " + PizzaT5.saborDeREFRESCO + ".");
						}

						//Cuando es 1 pizza y mas de 1 refresco
						else if (PizzaT5.ordenPIZZA == 1 && PizzaT5.ordRefresco > 1) {
								lineaTXT.setText(" 1 pizza " + PizzaT5.saborDePIZZA);
								espacioY.setText(" y " + PizzaT5.ordRefresco + " refrescos " + PizzaT5.saborDeREFRESCO+ ".");
						}

						//CUANDO ES 1 REFRESCO Y MAS DE 1 PIZZA
						else if (PizzaT5.ordenPIZZA > 1 && PizzaT5.ordRefresco == 1) {
								lineaTXT.setText(" " + PizzaT5.ordenPIZZA + " pizzas " + PizzaT5.saborDePIZZA);
								espacioY.setText(" y un refresco " + PizzaT5.saborDeREFRESCO + ".");
						}

						//CUANDO ES MAS DE 1 PIZZA Y MAS DE 1 REFRESCO
						else if (PizzaT5.ordenPIZZA > 1 && PizzaT5.ordRefresco > 1) {
								lineaTXT.setText(" " + PizzaT5.ordenPIZZA + " pizzas " + PizzaT5.saborDePIZZA);
								espacioY.setText(" y " + PizzaT5.ordRefresco + " refrescos " + PizzaT5.saborDeREFRESCO + ".");
						}
				}
		});

		btnCOLA.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	          if (btnCOLA.isSelected()==true) {
	            //deseleccionar los otros botones
	              btnMANZ.setSelected(false);
	              btnNARANJ.setSelected(false);
	              PizzaT5.saborDeREFRESCO = "de cola";
	          }
	          if (!btnCOLA.isSelected() && !btnMANZ.isSelected() && !btnNARANJ.isSelected()  ){
	              PizzaT5.saborDeREFRESCO = "seleccione el sabor de su preferencia...";
	          }
	      }

	      }
	    );

	    btnMANZ.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (btnMANZ.isSelected()==true) {
	                btnCOLA.setSelected(false);
	                btnNARANJ.setSelected(false);
	                PizzaT5.saborDeREFRESCO = "de manzana";
	            }
	            if (!btnNARANJ.isSelected() && !btnCOLA.isSelected() && !btnMANZ.isSelected()) {
	                PizzaT5.saborDeREFRESCO = "seleccione el sabor de su preferencia...";
	            }
	        }
	    });
	    btnNARANJ.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (btnNARANJ.isSelected()==true) {
	                btnMANZ.setSelected(false);
	                btnCOLA.setSelected(false);
	                PizzaT5.saborDeREFRESCO = "de naranja";
	            }
	            if (!btnNARANJ.isSelected() && !btnCOLA.isSelected() && !btnMANZ.isSelected()) {
	                PizzaT5.saborDeREFRESCO = "seleccione el sabor de su preferencia...";
	            }
	        }
	    });

		/*
		ActionListener btnREFRsbr = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!btnNARANJ.isSelected() && !btnCOLA.isSelected() && !btnMANZ.isSelected()) {
							PizzaT5.saborDeREFRESCO = "seleccione el sabor de su preferencia...";
					}
					if (btnCOLA.isSelected()) {
							btnMANZ.setSelected(false);
							btnNARANJ.setSelected(false);
							PizzaT5.saborDeREFRESCO = "de cola";
					} else if (btnMANZ.isSelected()) {
							btnCOLA.setSelected(false);
							btnNARANJ.setSelected(false);
							PizzaT5.saborDeREFRESCO = "de manzana";
					} else if (btnNARANJ.isSelected()) {
								btnMANZ.setSelected(false);
								btnCOLA.setSelected(false);
								PizzaT5.saborDeREFRESCO = "de naranja";
						}
				}
			};

			btnCOLA.addActionListener(btnREFRsbr);
			btnMANZ.addActionListener(btnREFRsbr);
			btnNARANJ.addActionListener(btnREFRsbr);

*/
		ActionListener chkPizzaIngr = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
						if (!chkPepper.isSelected() && !chkPINA.isSelected() && !chkJAM.isSelected()) { //Si ninguna es seleccionada entonces es de puro queso
								PizzaT5.saborDePIZZA = "sólo de queso";
						}
						if (chkPepper.isSelected() && !chkPINA.isSelected() && !chkJAM.isSelected()) {
								PizzaT5.saborDePIZZA = "de pepperoni";
						}
						if (chkPepper.isSelected() && chkPINA.isSelected() && !chkJAM.isSelected()) {
								PizzaT5.saborDePIZZA = "de pepperoni y piña";
						}
						if (chkPepper.isSelected() && chkJAM.isSelected() && !chkPINA.isSelected()) {
								PizzaT5.saborDePIZZA = "de pepperoni y jamon";
						}
						if (!chkPepper.isSelected() && !chkPINA.isSelected() && chkJAM.isSelected()) {
								PizzaT5.saborDePIZZA = "de jamon";
						}
						if (!chkPepper.isSelected() && chkPINA.isSelected() && chkJAM.isSelected()) {
								PizzaT5.saborDePIZZA = "de jamon y piña";
						}
						if (!chkPepper.isSelected() && chkPINA.isSelected() && !chkJAM.isSelected()) {
								PizzaT5.saborDePIZZA = "de piña";
						}
						if (chkPepper.isSelected() && chkPINA.isSelected() && chkJAM.isSelected()) {
								PizzaT5.saborDePIZZA = "de pepperoni, de jamon y piña";
						}
				}
			};

			chkPepper.addActionListener(chkPizzaIngr);
			chkPINA.addActionListener(chkPizzaIngr);
			chkJAM.addActionListener(chkPizzaIngr);


//-----------------

		frame.pack();
		frame.setVisible(true);

	}
}
