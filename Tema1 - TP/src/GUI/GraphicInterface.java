package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.*;

public class GraphicInterface extends JFrame implements ActionListener {

	JButton button1 = new JButton("Get Polinom 1");
	JButton button2 = new JButton("Get Polinom 2");
	JButton button3 = new JButton("Derivate");
	JButton button4 = new JButton("Integrate");
	JButton button5 = new JButton("Add");
	JButton button6 = new JButton("Subtract");
	JButton button7 = new JButton("Multiply");
	JButton button8 = new JButton("Division");
	JTextField textField1 = new JTextField(40);
	JTextField textField2 = new JTextField(40);
	JTextField textField3 = new JTextField(40);
	JTextField textField4 = new JTextField(40);
	JLabel label1 = new JLabel("OPERATIONS");
	JLabel label2 = new JLabel("Operation result");
	JLabel label3 = new JLabel("Remainder (for Division)");
	String polinom1, polinom2;
	Polinom p1 = new Polinom();
	Polinom p2 = new Polinom();

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new GraphicInterface().setVisible(true);

		/*
		 * Tests without GUI
		 */
		Polinom p1 = new Polinom();
		Polinom p2 = new Polinom();
		Polinom pSum = new Polinom();
		Polinom pDif = new Polinom();
		Polinom p1Deriv = new Polinom();
		Polinom p1Int = new Polinom();
		Polinom p1Mul = new Polinom();
		Polinom p1Div = new Polinom();
		Polinom p1Mod = new Polinom();

		p1.addMonom(new Monom(1, 2));
		p1.addMonom(new Monom(4, 1));
		p1.addMonom(new Monom(-8, 0));

		p2.addMonom(new Monom(1, 1));
		p2.addMonom(new Monom(-2, 0));

		/*BinaryOperation suma1 = new Add();
		pSum = suma1.compute(p1, p2);
		BinaryOperation dif1 = new Subtract();
		pDif = dif1.compute(p1, p2);
		UnaryOperation deriv1 = new Derivate();
		p1Deriv = deriv1.compute(p1);
		UnaryOperation int1 = new Integrate();
		p1Int = int1.compute(p1);
		BinaryOperation mul1 = new Multiply();
		p1Mul = mul1.compute(p1, p2);
		BinaryOperation div1 = new Division();
		p1Div = div1.compute(p1, p2);
		p1Mod = div1.getResult(1);*/

		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("Suma: " + pSum.toString());
		System.out.println("Diferenta: " + pDif.toString());
		System.out.println("p1 derivat: " + p1Deriv.toString());
		System.out.println("p1 integrat: " + p1Int.toString());
		System.out.println("p1 * p2: " + p1Mul.toString());
		System.out.println("p1 / p2: " + p1Div.toString() + " rest: " + p1Mod.toString());
	}

	private GraphicInterface() {
		super("Polinom");
		JPanel contentPane = new JPanel();
		contentPane.setOpaque(true);
		contentPane.setBackground(Color.gray);
		contentPane.setLayout(null);

		contentPane.add(textField1);
		textField1.setSize(350, 25);
		textField1.setLocation(40, 20);
		contentPane.add(button1);
		button1.setActionCommand("Buton1");
		button1.setSize(120, 30);
		button1.setLocation(400, 15);
		contentPane.add(textField2);
		textField2.setSize(350, 25);
		textField2.setLocation(40, 60);
		contentPane.add(button2);
		button2.setSize(120, 30);
		button2.setLocation(400, 55);
		button2.setActionCommand("Buton2");
		contentPane.add(label1);
		label1.setSize(200, 30);
		label1.setLocation(250, 120);
		contentPane.add(button3);
		button3.setSize(90, 30);
		button3.setLocation(10, 150);
		button3.setActionCommand("Derivate");
		contentPane.add(button4);
		button4.setSize(90, 30);
		button4.setLocation(105, 150);
		button4.setActionCommand("Integrate");
		contentPane.add(button5);
		button5.setSize(70, 30);
		button5.setLocation(200, 150);
		button5.setActionCommand("Add");
		contentPane.add(button6);
		button6.setSize(90, 30);
		button6.setLocation(275, 150);
		button6.setActionCommand("Subtract");
		contentPane.add(button7);
		button7.setSize(90, 30);
		button7.setLocation(370, 150);
		button7.setActionCommand("Multiply");
		contentPane.add(button8);
		button8.setSize(90, 30);
		button8.setLocation(465, 150);
		button8.setActionCommand("Division");
		contentPane.add(label2);
		label2.setSize(170, 30);
		label2.setLocation(10, 200);
		contentPane.add(textField3);
		textField3.setSize(350, 25);
		textField3.setLocation(200, 200);
		contentPane.add(textField4);
		textField4.setSize(350, 25);
		textField4.setLocation(200, 250);
		contentPane.add(label3);
		label3.setSize(170, 30);
		label3.setLocation(10, 250);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		/*
		 * Implementam 2 text field-uri pentru citirea polinoamelor
		 */
		textField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				polinom1 = textField1.getText();
			}
		});
		textField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				polinom2 = textField2.getText();
			}
		});

		setContentPane(contentPane);
		setSize(600, 400);
		setLocationByPlatform(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String button = event.getActionCommand();

		if (button.equals("Buton1")) {
			String polinom1 = textField1.getText();
			p1 = buildPolynomial(polinom1);
		} else if (button.equals("Buton2")) {
			String polinom2 = textField2.getText();
			p2 = buildPolynomial(polinom2);
		} else if (button.equals("Derivate")) {
			// Derivare polinom 1
			UnaryOperation unary1 = new Derivate();
			textField3.setText(unary1.compute(p1).toString());
		} else if (button.equals("Integrate")) {
			// Integrare polinom 1
			UnaryOperation unary2 = new Integrate();
			textField3.setText(unary2.compute(p1).toString());
		} else if (button.equals("Add")) {
			// Aduna polinom1 + polinom2
			BinaryOperation binary1 = new Add();
			textField3.setText(binary1.compute(p1, p2).toString());
		} else if (button.equals("Subtract")) {
			// Diferenta polinom1 - polinom2
			BinaryOperation binary2 = new Subtract();
			textField3.setText(binary2.compute(p1, p2).toString());
		} else if (button.equals("Multiply")) {
			// Inmultire polinom1 * polinom2
			BinaryOperation binary3 = new Multiply();
			textField3.setText(binary3.compute(p1, p2).toString());
		} else if (button.equals("Division")) {
			// Impartire polinom1 / polinom2
			BinaryOperation binary4 = new Division();
			if (binary4.compute(p1, p2) != null){
				textField3.setText(binary4.compute(p1, p2).toString());
				textField4.setText(binary4.getResult(1).toString());
			}
			else {
				textField3.setText("Error! Division by 0.");
			}
		}
	}

	public Polinom buildPolynomial(String s) {
		Polinom builtP = new Polinom();
		String polin;

		polin = s;
		try {
			polin = polin.replace("-", "+-");
			String token[] = polin.split("\\+");
			for (String monom : token) {
				if (!(monom.equals(""))) {
					String parametriiMonom[] = new String[] { "", "" };
					System.out.println(monom);
					if (monom.charAt(0) != 'x') {
						int i = 0;
						while ((i < monom.length()) && (monom.charAt(i) != 'x')) {
							parametriiMonom[0] += monom.charAt(i);
							i++;
						}
						if (parametriiMonom[0].equals("-")) {
							parametriiMonom[0] = "-1";
						}
						if (i == monom.length()){		
							//termenul este de forma "a"
							parametriiMonom[1] += "0";
						}
						else {
							//termenul este de forma "ax^b"
							if (i+1 != monom.length()) {
								if (monom.charAt(i+1) == '^'){
									i += 2;
									while (i < monom.length()) {
										parametriiMonom[1] += monom.charAt(i);
										i++;
									}
								}
								else {
									parametriiMonom[1] = "1";
								}
							}
							else {
								parametriiMonom[1] = "1";
							}
						}
						
					} else {
							//termenul este de forma "(-)x^b"
						if (monom.charAt(0) == '-'){
							parametriiMonom[0] = "-1";
						}
						else {
							parametriiMonom[0] = "1";
						}
						int i = 1;
						if (i == monom.length()){		
							//termenul este de forma "x"
							parametriiMonom[1] += "1";
						}
						else {
							if (monom.charAt(i) == '^') {
								i++;
								while (i < monom.length()) {
									parametriiMonom[1] += monom.charAt(i);
									i++;
								}
							}
							else {
								//termenul este de forma "x"
								parametriiMonom[1] = "1";
							}
						}
					}
					builtP.addMonom(new Monom(Double.parseDouble(parametriiMonom[0]),
							Integer.parseInt(parametriiMonom[1])));
				}
			}
		return builtP;
		}
		catch(Exception e) {
			textField3.setText("Polinom Incorect!");
			return null;
		}
	}
}
