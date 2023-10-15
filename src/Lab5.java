import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab5 extends JFrame {
	//Declaring the necessary variables
	JPanel topPanel = new JPanel();
	JPanel radioPanel = new JPanel();
	JPanel middlePanel = new JPanel();
	JTextField textField1 = new JTextField(10);
	JTextField textField2 = new JTextField(10);


	public JPanel createTopPanel(String label, String radioButtonText) {
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new FlowLayout());
		JLabel numberLabel = new JLabel(label);
		
		numberPanel.add(numberLabel);
		
		//If the radio button is addition, add text field one, or else, add text field 2
		if(radioButtonText == "Addition") {
			textField1.setText("0.0");
			numberPanel.add(textField1);
		} else {
			textField2.setText("0.0");
			numberPanel.add(textField2);
		}
		return numberPanel;
	}
	
	public void buildMainPanel() {
		topPanel.setLayout(new GridLayout(1,2));
		topPanel.add(createTopPanel("Num 1", "Addition"));
		topPanel.add(createTopPanel("Num 2", "Subtraction"));
		
		//Create the radio buttons
		JRadioButton additionRadio = new JRadioButton("Addition");
		JRadioButton subtractionRadio = new JRadioButton("Subtraction");
		
		//Creating a group for the addition and subtraction radio buttons
		ButtonGroup group = new ButtonGroup();
		group.add(additionRadio);
		group.add(subtractionRadio);
		radioPanel.add(additionRadio);
		radioPanel.add(subtractionRadio);
		
		//Adding the calculator display, with an event listener for the radio buttons
		JTextArea calculatorDisplay = new JTextArea(5, 26);
		calculatorDisplay.setEditable(false);
		class RadioButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {	
				//Get the value of the text fields, and append the results to the display
				double textFieldOne = Double.parseDouble(textField1.getText());
				double textFieldTwo = Double.parseDouble(textField2.getText());
				double resultAdd = textFieldOne + textFieldTwo;
				double resultSubtract = textFieldOne - textFieldTwo;
				String additionResult = textFieldOne + " + " + textFieldTwo + " = " +resultAdd + "\n";
				String subtractionResult = textFieldOne + " - " + textFieldTwo + " = " +resultSubtract + "\n";
				
				//If the user clicks the addition radio, add the addition results
				if(e.getSource() == additionRadio) {
					calculatorDisplay.append(additionResult);
				}
				
				//If the user clicks the subtraction radio
				if(e.getSource() == subtractionRadio) {
					calculatorDisplay.append(subtractionResult);
				}
			}		
		}
		
		additionRadio.addActionListener(new RadioButtonListener());
		subtractionRadio.addActionListener(new RadioButtonListener());
		
		
		//Create the scroll bar
		JScrollPane scrollPane = new JScrollPane(calculatorDisplay);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		middlePanel.add(scrollPane);

	}
	
	
	//Constructor
	Lab5(){
		//Sets the title as a simple constructor and defines a set size
		setTitle("Simple Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(320, 220);
		setLayout(new FlowLayout());
		
		//Building the top, radio panel and middle panel
		buildMainPanel();
		add(topPanel);
		add(radioPanel);
		add(middlePanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String[] args){
		//New lab5
		new Lab5();
	}
	

}
