package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int php;
	int ehp;
	String weapon, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main (String[] args) {
		new Game();
	}
	
	public Game() {
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("RPG Trial 1");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300,400,200,100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		
		window.setVisible(true);
	}
	
	public void createGameScreen(){
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100,100,600,250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("The button worked! I'm very suprised! I wonder if the text will wrap?");
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250,350,300,150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		//----------Button List--------------
		choice1 = new JButton("Choice1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		//---------------Text on top of screen------------
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetup();
		
	}
	
	public void playerSetup() {
		php = 15;
		weapon = "Axe";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + php);
		townGate();
	}
	
	//Sequences
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("You have entered the gate of the town! \nSomeone greets you. \nWhat do you do?");
		choice1.setText("Talk to them");
		choice2.setText("Attack them");
		choice3.setText("Leave");
		choice4.setText("");
	}
	
	public void crossRoad() {
		position = "crossRoad";
		mainTextArea.setText("You are outside the town at a crossroad. \n South will bring you back to the town.");
		choice1.setText("Go North");
		choice2.setText("Go East");
		choice3.setText("Go South");
		choice4.setText("Go West");
	}
	
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Stranger: What are you looking at? \nYou're not welcome here.");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Guard: You trying to fight me? \nCome at me!");
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void battleGuard() {
		position = "battleGuard";
		ehp = 10;
		mainTextArea.setText("BATTLE MENU \nGuard's health is " + ehp + ". \nWhat will you do?");
		choice1.setText("Attacks");
		choice2.setText("Items");
		choice3.setText("Recoveries");
		choice4.setText("Run");
	}
	
	//Battle Systems
	public void attackMenu() {
		position = "attackMenu";
		ehp = 10;
		mainTextArea.setText("ATTACK MENU \nGuard's health is " + ehp + ". \nWhat will you do?");
		choice1.setText("Stab (-5 hp, -5 sp)");
		choice2.setText("Slash (-7 hp, -10 sp)");
		choice3.setText("???");
		choice4.setText("<");
		
	}
	
	//Button Presses
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand(); //actionCommand to differentiate choice 1 for different sequences
			
			//switch is similar to if statement
			switch(position) { //where are they?
			case "townGate": //if in town gate...
				switch(yourChoice) {
				case "c1": talkGuard(); break;
				case "c2": attackGuard(); break;
				case "c3": crossRoad(); break;
				}
				break;
			case "talkGuard":
				switch(yourChoice) {
				case "c1": townGate(); break;
				}
				break;
			case "attackGuard":
				switch(yourChoice) {
				case "c1": battleGuard(); break;
				}
				break;
			case "crossRoad":
				switch(yourChoice) {
				case "c1": break;
				case "c2": break;
				case "c3": townGate(); break;
				case "c4": break;
				}
				break;
			case "battleGuard":
				switch(yourChoice) {
				case "c1": attackMenu(); break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				break;
			case "attackMenu":
				switch(yourChoice) {
				case "c1": break;
				case "c2": break;
				case "c3": break;
				case "c4": battleGuard(); break;
				}
				break;
			}
		}
	}
}
