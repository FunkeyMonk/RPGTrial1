
	
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
		ehp = 10;
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
	
	
	public void north() {
		position = "north";
		mainTextArea.setText("There is a potion on the floor! \nDrink it and return to crossroad?");
		choice1.setText("Yes (+2 hp)");
		choice2.setText("No");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void east() {
		position ="east";
		mainTextArea.setText("Found a HEAVY AXE! \n(Obtained HEAVY AXE)");
		weapon = "Heavy Axe";
		weaponLabelName.setText(weapon);
		choice1.setText("Return to crossroad");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}

	public void west() {
		position = "west";
		mainTextArea.setText("Encountered slimy dude! \nWhat will you do?");
		choice1.setText("Fight");
		choice2.setText("Return to crossroad");
		choice3.setText("");
		choice4.setText("");
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
		mainTextArea.setText("BATTLE MENU \nEnemy health is " + ehp + ". \nWhat will you do?");
		choice1.setText("Attacks");
		choice2.setText("Items");
		choice3.setText("Recoveries");
		choice4.setText("Run");
	}
	
	//Battle Systems
	public void attackMenu() {
		position = "attackMenu";
		mainTextArea.setText("ATTACK MENU \nEnemy health is " + ehp + ". \nWhat will you do?");
		choice1.setText("Attack");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("<");
	}
	
	public void itemMenu() {
		position = "itemMenu";
		mainTextArea.setText("ITEM MENU \nEnemy health is " + ehp + ". \nWhat will you do?");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("<");
	}
	
	public void recoveryMenu() {
		position = "recoveryMenu";
		mainTextArea.setText("RECOVERY MENU \nEnemy health is " + ehp + ". \nWhat will you do?");
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("<");
	}
	
	public void playerAttack() {
		position = "playerAttack";
		
		int playerDamage = 0;
		
		if(weapon.equals("Axe")) {
			playerDamage = new java.util.Random().nextInt(5);
		}
		
		else if(weapon.equals("Heavy Axe")) {
			playerDamage = new java.util.Random().nextInt(8);
		}
		
		mainTextArea.setText("You dealt " + playerDamage + " damage!");
		
		ehp = ehp - playerDamage;
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void enemyAttack() {
		position = "enemyAttack";
		
		int enemyDamage = 0;
		enemyDamage = new java.util.Random().nextInt(4);
		
		mainTextArea.setText("Enemy dealt " + enemyDamage + " damage!");
		
		php = php - enemyDamage;
		hpLabelNumber.setText("" + php);
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
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
			//----------Guard Choices----------
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
				case "c1": north(); break;
				case "c2": east(); break;
				case "c3": townGate(); break;
				case "c4": west(); break;
				}
				break;
			//-------------crossRoad Choices--------
			case "north":
				switch(yourChoice) {
				case "c1": php = php + 2; hpLabelNumber.setText(""+php); crossRoad(); break;
				case "c2": crossRoad(); break;
				}
				break;
			case "east":
				switch(yourChoice) {
				case "c1": crossRoad(); break;
				}
				break;
			case "west":
				switch(yourChoice) {
				case "c1": battleGuard(); break;
				case "c2": crossRoad(); break;
				}
				break;
				
				
			//-------Battle System--------
			case "battleGuard":
				switch(yourChoice) {
				case "c1": attackMenu(); break;
				case "c2": itemMenu(); break;
				case "c3": recoveryMenu(); break;
				case "c4": crossRoad(); break;
				}
				break;
			case "attackMenu":
				switch(yourChoice) {
				case "c1": playerAttack(); break;
				case "c2": break;
				case "c3": break;
				case "c4": battleGuard(); break;
				}
				break;
			case "playerAttack":
				switch(yourChoice) {
				case "c1": enemyAttack(); break;
				}
				break;
			case "enemyAttack":
				switch(yourChoice) {
				case "c1": battleGuard(); break;
				}
				break;
			case "itemMenu":
				switch(yourChoice) {
				case "c1": break;
				case "c2": break;
				case "c3": break;
				case "c4": battleGuard(); break;
				}
				break;
			case "recoveryMenu":
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
