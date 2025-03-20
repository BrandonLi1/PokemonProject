import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightWindow {
    JFrame screen;

    JPanel fightPanel, runPanel, bagPanel, move1Panel, move2Panel, move3Panel, move4Panel, ownStatsPanel, enemyStatsPanel, pokemonPanel;

    JButton fight, run, bag, move1, move2, move3, move4, pokemon;

    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font textFont = new Font("Tiems New Roman", Font.PLAIN, 30);

    JTextArea mainTextArea, ownStats, enemyStats;

    choiceHandler choiceHandler = new choiceHandler();

    String move1Name, move2Name, move3Name, move4Name,
            pokemon1Name,pokemon2Name,pokemon3Name,pokemon4Name,pokemon5Name,pokemon6Name;//make it name the moves based on the ints


    public void createGameScreen() {



        //buttons section
        createButtons();
    }

    private class choiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String e = event.getActionCommand();
            if (e.equals("bag")) {
                bag();
            } else if (e.equals("pokemon")) {
                Switch();
            } else if (e.equals("run")) {
                run();
            } else if (e.equals("fight")) {
                fight();
            } else if (e.equals("move1")) {
                move1();
            } else if (e.equals("move2")) {
                move2();
            } else if (e.equals("move3")) {
                move3();
            } else if (e.equals("move4")) {
                move4();
            }
        }
    }
    public void run() {

    }
    public void bag() {

    }
    public void fight() {

    }
    public void Switch() {

    }
    public void move1() {

    }
    public void move2() {

    }
    public void move3() {

    }
    public void move4() {

    }

    private void buttonSetter(JButton button, String name, JPanel buttonPanel) {
        button=new JButton(name);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(buttonFont);
        button.setFocusPainted(false);
        buttonPanel.add(button);
        button.setActionCommand(name.toLowerCase());
        button.addActionListener(choiceHandler);
    }

    private void createButtons() {
        fight=new JButton("Fight");
        fight.setBackground(Color.red);
        fight.setForeground(Color.white);
        fight.setFont(buttonFont);
        fight.setFocusPainted(false);
        fightPanel.add(fight);
        fight.setActionCommand("fight");
        fight.addActionListener(choiceHandler);

        run=new JButton("Run");
        run.setBackground(Color.blue);
        run.setForeground(Color.white);
        run.setFont(buttonFont);
        run.setFocusPainted(false);
        runPanel.add(fight);
        run.setActionCommand("run");
        run.addActionListener(choiceHandler);

        bag=new JButton("Bag");
        bag.setBackground(Color.orange);
        bag.setForeground(Color.white);
        bag.setFont(buttonFont);
        bag.setFocusPainted(false);
        bagPanel.add(bag);
        bag.setActionCommand("bag");
        bag.addActionListener(choiceHandler);

        pokemon=new JButton("Pokemon");
        pokemon.setBackground(Color.green);
        pokemon.setForeground(Color.white);
        pokemon.setFont(buttonFont);
        pokemon.setFocusPainted(false);
        pokemonPanel.add(pokemon);
        pokemon.setActionCommand("pokemon");
        pokemon.addActionListener(choiceHandler);


        buttonSetter(move1, move1Name, move1Panel);
        buttonSetter(move2, move2Name, move2Panel);
        buttonSetter(move3, move3Name, move3Panel);
        buttonSetter(move4, move4Name, move4Panel);
    }

}
