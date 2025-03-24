import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightWindow {
    JFrame screen;
    Container con;

    JPanel actionPanel, movePanel, ownStatsPanel, enemyStatsPanel, pokemonPanel, mainTextPanel;

    JButton fight, run, bag, move1, move2, move3, move4, pokemon;

    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font textFont = new Font("Tiems New Roman", Font.PLAIN, 100);

    JTextArea mainTextArea, ownStats, enemyStats;

    choiceHandler choiceHandler = new choiceHandler();

    String move1Name, move2Name, move3Name, move4Name, pokemon1Name,
            pokemon2Name,pokemon3Name,pokemon4Name,pokemon5Name,pokemon6Name;//make it name the moves based on the ints

    public static void main(String[] args) {
        FightWindow x = new FightWindow(new Fire(1, 100, "Bulbasaur", "1", "y"));
        x.createGameScreen();
    }

    public FightWindow(PokemonType a) {//construct the Strings and stuff of the like
        moveSetter(a);
    }

    public void createGameScreen() {
        screen=new JFrame();
        screen.setSize(1500, 1300);
        screen.getContentPane().setBackground(Color.black);
        screen.setLayout(null); //necessary to create custom layout
        screen.setVisible(true);
        con = screen.getContentPane();

        //panels
        actionPanel= new JPanel();
        actionPanel.setBounds(600, 700, 900, 300);
        actionPanel.setBackground(Color.black);
        actionPanel.setLayout(new GridLayout(2, 2));
        actionPanel.setVisible(true);

        movePanel=new JPanel();
        movePanel.setBounds(400, 400, 200, 200);
        movePanel.setBackground(Color.black);
        movePanel.setVisible(false);

        pokemonPanel=new JPanel();
        pokemonPanel.setBounds(0, 0, 800, 600);
        pokemonPanel.setBackground(Color.blue);
        pokemonPanel.setVisible(false);

        mainTextPanel=new JPanel();
        mainTextPanel.setBounds(0, 700, 600, 300);;
        mainTextPanel.setBackground(Color.white);
        con.add(mainTextPanel);



        //textAreas
        mainTextArea=new JTextArea();
        mainTextArea.setText("What will you do?");
        mainTextArea.setBounds(0, 700, 600, 300);
        mainTextArea.setBackground(Color.white);
        mainTextArea.setForeground(Color.black);
        mainTextArea.setFont(textFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        //buttons section
        createButtons();
        con.add(actionPanel);
        con.add(movePanel);
        con.add(pokemonPanel);
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
        fight.setSize(200, 100);
        fight.setBackground(Color.red);
        fight.setForeground(Color.white);
        fight.setFont(buttonFont);
        fight.setFocusPainted(false);
        actionPanel.add(fight);
        fight.setActionCommand("fight");
        fight.addActionListener(choiceHandler);

        run=new JButton("Run");
        run.setSize(200, 100);
        run.setBackground(Color.blue);
        run.setForeground(Color.white);
        run.setFont(buttonFont);
        run.setFocusPainted(false);
        actionPanel.add(run);
        run.setActionCommand("run");
        run.addActionListener(choiceHandler);

        bag=new JButton("Bag");
        bag.setSize(200, 100);
        bag.setBackground(Color.orange);
        bag.setForeground(Color.white);
        bag.setFont(buttonFont);
        bag.setFocusPainted(false);
        actionPanel.add(bag);
        bag.setActionCommand("bag");
        bag.addActionListener(choiceHandler);

        pokemon=new JButton("Pokemon");
        pokemon.setSize(200, 100);
        pokemon.setBackground(Color.green);
        pokemon.setForeground(Color.white);
        pokemon.setFont(buttonFont);
        pokemon.setFocusPainted(false);
        actionPanel.add(pokemon);
        pokemon.setActionCommand("pokemon");
        pokemon.addActionListener(choiceHandler);


        /*buttonSetter(move1, move1Name, movePanel);
        buttonSetter(move2, move2Name, movePanel);
        buttonSetter(move3, move3Name, movePanel);
        buttonSetter(move4, move4Name, movePanel);*/
    }

    private void moveSetter(PokemonType pokemon) {
        if (pokemon.getClass()==Fire.class) {
            int count=1;
            for (int i = 0; i < 4; i++) {
                if (pokemon.moveList[i]==1) {
                   if (count == 1) {
                       move1Name="Restore";
                   }
                   if (count == 2) {
                       move2Name="Restore";
                   }
                   if (count == 3) {
                       move3Name="Restore";
                   }
                   if (count == 4) {
                       move4Name="Restore";
                   }
                }
                if (pokemon.moveList[i]==2) {
                    if (count == 1) {
                        move1Name="Flamethrower";
                    }
                    if (count == 2) {
                        move2Name="Flamethrower";
                    }
                    if (count == 3) {
                        move3Name="Flamethrower";
                    }
                    if (count == 4) {
                        move4Name="Flamethrower";
                    }
                  }
                if (pokemon.moveList[i]==3) {
                    if (count == 1) {
                         move1Name="BlazingTorque";
                    }
                    if (count == 2) {
                        move2Name="BlazingTorque";
                    }
                    if (count == 3) {
                        move3Name="BlazingTorque";
                    }
                    if (count == 4) {
                        move4Name="BlazingTorque";
                    }
                }
                if (pokemon.moveList[i]==4) {
                    if (count == 1) {
                        move1Name="Eruption";
                    }
                    if (count == 2) {
                        move2Name="Eruption";
                    }
                    if (count == 3) {
                        move3Name="Eruption";
                    }
                    if (count == 4) {
                        move4Name="Eruption";
                    }
                }
                if (pokemon.moveList[i]==5) {
                    if (count == 1) {
                        move1Name="Inferno";
                    }
                    if (count == 2) {
                        move2Name="Inferno";
                    }
                    if (count == 3) {
                        move3Name="Inferno";
                    }
                    if (count == 4) {
                        move4Name="Inferno";
                    }
                  }
                if (pokemon.moveList[i]==6) {
                    if (count == 1) {
                        move1Name="BlueFlare";
                    }
                    if (count == 2) {
                        move2Name="BlueFlare";
                    }
                    if (count == 3) {
                        move3Name="BlueFlare";
                    }
                    if (count == 4) {
                        move4Name="BlueFlare";
                    }
                }
                if (pokemon.moveList[i]==7) {
                    if (count == 1) {
                        move1Name="HeatWave";
                    }
                    if (count == 2) {
                        move2Name="HeatWave";
                    }
                    if (count == 3) {
                        move3Name="HeatWave";
                    }
                    if (count == 4) {
                        move4Name="HeatWave";
                    }
                }
                count++;
            }
        }
        if (pokemon.getClass()==Water.class) {

        }
        if (pokemon.getClass()==Grass.class) {

        }
    }
}
