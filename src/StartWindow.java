import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow{
    static JFrame window;
    Container con;
    JPanel titleNamePanel;
    JPanel startButtonPanel;
    JPanel mainTextPanel;
    JPanel choiceButtonPanel;
    JLabel titleNameLabel;
    Font titleFont=new Font("Times New Roman", Font.BOLD, 90);
    Font normalFont=new Font("Times New Roman", Font.PLAIN, 30);
    Font pickFont = new Font("Times New Roman", Font.BOLD, 40);
    JButton startButton;
    JButton choice1, choice2, choice3;
    JTextArea mainTextArea;

    TitleScreenHandler tsHandler=new TitleScreenHandler();
    choiceHandler choiceHandler = new choiceHandler();


    public static void main(String[] args) {

        new StartWindow();
    }

    public StartWindow() {

        window=new JFrame();
        window.setSize(800, 600);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null); //necessary to create custom layout
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel=new JPanel(); //box for title
        titleNamePanel.setBounds(100, 100, 600, 150); //top left is (0,0): height goes down
        titleNamePanel.setBackground(Color.black);
        titleNameLabel=new JLabel("(Not)Pokemon"); //title itself
        titleNameLabel.setForeground(Color.yellow);
        titleNameLabel.setFont(titleFont);

        startButtonPanel=new JPanel(); //adding button makes window broken: go fullscreen then unfullscreen
        startButtonPanel.setBounds(300, 400, 200, 50);
        startButtonPanel.setBackground(Color.black);

        startButton =new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);


        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    public void createGameScreen() {

        mainTextPanel=new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Choose your (not)Pokemon starter");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(pickFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.red);
        choiceButtonPanel.setLayout(new GridLayout(3, 1));
        con.add(choiceButtonPanel);

        choice1=new JButton("Charmander");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choiceButtonPanel.add(choice1);
        choice1.setActionCommand("charmander");
        choice1.addActionListener(choiceHandler);

        choice2=new JButton("Bulbasaur");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("bulbasaur");
        choiceButtonPanel.add(choice2);

        choice3=new JButton("Squirtle");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("squirtle");
        choiceButtonPanel.add(choice3);


    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            titleNamePanel.setVisible(false);
            titleNameLabel.setVisible(false);
            startButton.setVisible(false);
            createGameScreen();
        }
    }

    public void charmander() {
        mainTextArea.setText("You have chosen Charmander");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        GridGame.player.party[0]=new PokemonType(5, 39, "Charmander", false);
        window.dispose();
    }
    public void bulbasaur() {
        mainTextArea.setText("You have chosen Bulbasaur");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        GridGame.player.party[0]=new PokemonType(5, 45, "Bulbasaur", false);
        window.dispose();
    }
    public void squirtle() {
        mainTextArea.setText("You have chosen Squirtle");
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        GridGame.player.party[0]=new PokemonType(5, 44, "Squirtle", false);
        window.dispose();
    }

    public class choiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String position= e.getActionCommand();
            if (position.equals("charmander")) {
                charmander();
            } else if (position.equals("squirtle")) {
                squirtle();
            } else if (position.equals("bulbasaur")) {
                bulbasaur();
            }
        }
    }
}

