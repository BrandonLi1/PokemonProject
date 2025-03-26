import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightWindow {
    JFrame screen;
    Container con;

    JPanel actionPanel, movePanel, ownStatsPanel, enemyStatsPanel, pokemonPanel,
            mainTextPanel, switchPanel;

    JButton fight, run, bag, move1, move2, move3, move4, pokemon, pokemon1Button,
            pokemon2Button, pokemon3Button, pokemon4Button, pokemon5Button, pokemon6Button;

    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font textFont = new Font("Tiems New Roman", Font.PLAIN, 100);

    JTextArea mainTextArea, ownStats, enemyStats;

    choiceHandler choiceHandler = new choiceHandler();

    String move1Name, move2Name, move3Name, move4Name, pokemon1Name,
            pokemon2Name,pokemon3Name,pokemon4Name,pokemon5Name,pokemon6Name;//make it name the moves based on the ints

    PokemonType pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6;


    public static void main(String[] args) {
        FightWindow x = new FightWindow(new Fire(1, 100, "Bulbasaur", "1", "y"));
        x.createGameScreen();
    }

    public FightWindow(PokemonType enemy) {//construct the Strings and stuff of the like
        int count=1;
        for (int i = 0; i < 6; i++) {
            if (Player.party[i]!=null) {
                if (count==1) {
                    pokemon1Name=Player.party[i].getName();
                    pokemon1=Player.party[i];
                    moveSetter(pokemon1);
                }
                if (count==2) {
                    pokemon2Name=Player.party[i].getName();
                    pokemon2=Player.party[i];
                }
                if (count==3) {
                    pokemon3Name=Player.party[i].getName();
                    pokemon3=Player.party[i];
                }
                if (count==4) {
                    pokemon4Name=Player.party[i].getName();
                    pokemon4=Player.party[i];
                }if (count==5) {
                    pokemon5Name=Player.party[i].getName();
                    pokemon5=Player.party[i];
                }
                if (count==6) {
                    pokemon6Name=Player.party[i].getName();
                    pokemon6=Player.party[i];
                }
            }
            count++;
        }
    }


    public void switchScreen() {
        switchPanel = new JPanel();
        switchPanel.setBounds(0, 0, 400, 800);
        switchPanel.setBackground(Color.blue);
        switchPanel.setLayout(new GridLayout(3, 2));
        switchPanel.setVisible(true);

        buttonSetter(pokemon1Button, pokemon1Name, switchPanel);
        buttonSetter(pokemon2Button, pokemon2Name, switchPanel);
        buttonSetter(pokemon3Button, pokemon3Name, switchPanel);
        buttonSetter(pokemon4Button, pokemon4Name, switchPanel);
        buttonSetter(pokemon5Button, pokemon5Name, switchPanel);
        buttonSetter(pokemon6Button, pokemon6Name, switchPanel);
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

        //layover or replace action panel
        movePanel= new JPanel();
        movePanel.setBounds(600, 700, 900, 300);
        movePanel.setBackground(Color.black);
        movePanel.setLayout(new GridLayout(2, 2));
        movePanel.setVisible(false);

        //buttons section
        createButtons();
        con.add(actionPanel);
        con.add(movePanel);
        con.add(pokemonPanel);
        con.add(movePanel);
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
            } else if (e.equals(pokemon1Name.toLowerCase())) {
                pokemon1Switch();
            }
            else if (e.equals(pokemon2Name.toLowerCase())) {
                pokemon2Switch();
            }
            else if (e.equals(pokemon3Name.toLowerCase())) {
                pokemon3Switch();
            }
            else if (e.equals(pokemon4Name.toLowerCase())) {
                pokemon4Switch();
            }
            else if (e.equals(pokemon5Name.toLowerCase())) {
                pokemon5Switch();
            }
            else if (e.equals(pokemon6Name.toLowerCase())) {
                pokemon6Switch();
            }
        }
    }
    public void run() {

    }
    public void bag() {

    }
    public void fight() {
        actionPanel.setVisible(false);
        movePanel.setVisible(true);
    }
    public void Switch() {
        switchScreen();
    }
    public void move1() {

    }
    public void move2() {

    }
    public void move3() {

    }
    public void move4() {

    }
    public void pokemon1Switch() {

    }
    public void pokemon2Switch() {

    }
    public void pokemon3Switch() {

    }
    public void pokemon4Switch() {

    }
    public void pokemon5Switch() {

    }
    public void pokemon6Switch() {

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


        buttonSetter(move1, move1Name, movePanel);
        buttonSetter(move2, move2Name, movePanel);
        buttonSetter(move3, move3Name, movePanel);
        buttonSetter(move4, move4Name, movePanel);
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
                        move1Name="Absorb";
                    }
                    if (count == 2) {
                        move2Name="Absorb";
                    }
                    if (count == 3) {
                        move3Name="Absorb";
                    }
                    if (count == 4) {
                        move4Name="Absorb";
                    }
                }
                if (pokemon.moveList[i]==3) {
                    if (count == 1) {
                        move1Name= "Bullet Seed";
                    }
                    if (count == 2) {
                        move2Name= "Bullet Seed";
                    }
                    if (count == 3) {
                        move3Name= "Bullet Seed";
                    }
                    if (count == 4) {
                        move4Name= "Bullet Seed";
                    }
                }
                if (pokemon.moveList[i]==4) {
                    if (count == 1) {
                        move1Name= "Magical Leaf";
                    }
                    if (count == 2) {
                        move2Name="Magical Leaf";
                    }
                    if (count == 3) {
                        move3Name="Magical Leaf";
                    }
                    if (count == 4) {
                        move4Name="Magical Leaf";
                    }
                }
                if (pokemon.moveList[i]==5) {
                    if (count == 1) {
                        move1Name= "Razor Leaf";
                    }
                    if (count == 2) {
                        move2Name="Razor Leaf";
                    }
                    if (count == 3) {
                        move3Name="Razor Leaf";
                    }
                    if (count == 4) {
                        move4Name="Razor Leaf";
                    }
                }
                if (pokemon.moveList[i]==6) {
                    if (count == 1) {
                        move1Name= "Leaf Tornado";
                    }
                    if (count == 2) {
                        move2Name="Leaf Tornado";
                    }
                    if (count == 3) {
                        move3Name="Leaf Tornado";
                    }
                    if (count == 4) {
                        move4Name="Leaf Tornado";
                    }
                }
                if (pokemon.moveList[i]==7) {
                    if (count == 1) {
                        move1Name= "Solar Beam";
                    }
                    if (count == 2) {
                        move2Name="Solar Beam";
                    }
                    if (count == 3) {
                        move3Name="Solar Beam";
                    }
                    if (count == 4) {
                        move4Name="Solar Beam";
                    }
                }
                count++;
            }
        }
    }
}
