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
    Font textFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font statFont = new Font("Times New Roman", Font.PLAIN, 20);

    JTextArea mainTextArea, ownStats, enemyStats;

    choiceHandler choiceHandler = new choiceHandler();

    String move1Name, move2Name, move3Name, move4Name, pokemon1Name,
            pokemon2Name,pokemon3Name,pokemon4Name,pokemon5Name,pokemon6Name;//make it name the moves based on the ints

    static PokemonType pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, enemy, activePokemon;


    public static void main(String[] args) {
        enemy= new Fire(1, 100, "Bulbasaur", "1", "y");
        FightWindow x = new FightWindow(enemy);
        x.createGameScreen();
    }

    public FightWindow(PokemonType enemy) {//construct the Strings and stuff of the like
        this.enemy=enemy;
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
        activePokemon=pokemon1;
        moveSetter(pokemon1);
    }


    public void switchScreen() {
        switchPanel = new JPanel();
        switchPanel.setBounds(0, 0, 400, 800);
        switchPanel.setBackground(Color.blue);
        switchPanel.setLayout(new GridLayout(3, 2));
        switchPanel.setVisible(true);
        if (pokemon1!=null) {
            buttonSetter(pokemon1Button, pokemon1Name, switchPanel);
        }
        if (pokemon2!=null)
        buttonSetter(pokemon2Button, pokemon2Name, switchPanel);
        if (pokemon3!=null)
        buttonSetter(pokemon3Button, pokemon3Name, switchPanel);
        if (pokemon4!=null)
        buttonSetter(pokemon4Button, pokemon4Name, switchPanel);
        if (pokemon5!=null)
        buttonSetter(pokemon5Button, pokemon5Name, switchPanel);
        if (pokemon6!=null)
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

        pokemonPanel=new JPanel();
        pokemonPanel.setBounds(0, 0, 800, 600);
        pokemonPanel.setBackground(Color.blue);
        pokemonPanel.setVisible(false);

        mainTextPanel=new JPanel();
        mainTextPanel.setBounds(0, 700, 600, 300);;
        mainTextPanel.setBackground(Color.white);
        con.add(mainTextPanel);

        ownStatsPanel = new JPanel();
        ownStatsPanel.setBounds(0, 300, 200, 100);
        ownStatsPanel.setBackground(Color.white);
        con.add(ownStatsPanel);

        enemyStatsPanel=new JPanel();
        enemyStatsPanel.setBounds(1000, 0, 200, 100);
        enemyStatsPanel.setBackground(Color.white);
        con.add(enemyStatsPanel);

        //textAreas
        mainTextArea=new JTextArea();
        mainTextArea.setText("What will you do?");
        mainTextArea.setBounds(0, 700, 600, 300);
        mainTextArea.setBackground(Color.white);
        mainTextArea.setForeground(Color.black);
        mainTextArea.setFont(textFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        ownStats = new JTextArea();
        ownStats.setText(pokemon1Name + "     Level " + pokemon1.getLevel() + "\n\n Health: " +
                pokemon1.getCurrentHealth() + "/" + pokemon1.getHealth());
        ownStats.setBounds(0, 300, 200, 100);
        ownStats.setBackground(Color.white);
        ownStats.setForeground(Color.black);
        ownStats.setFont(statFont);
        ownStats.setLineWrap(true);
        ownStatsPanel.add(ownStats);

        enemyStats= new JTextArea();
        enemyStats.setText(enemy.getName() +"     Level " + enemy.getLevel() +  "\n\n Health: " +
                enemy.getCurrentHealth() + "/" + enemy.getHealth());
        enemyStats.setBounds(1000, 0, 200, 100);
        enemyStats.setBackground(Color.white);
        enemyStats.setForeground(Color.black);
        enemyStats.setFont(statFont);
        enemyStats.setLineWrap(true);
        enemyStatsPanel.add(enemyStats);

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
                activePokemon=pokemon1;
            }
            else if (e.equals(pokemon2Name.toLowerCase())) {
                pokemon2Switch();
                activePokemon=pokemon2;
            }
            else if (e.equals(pokemon3Name.toLowerCase())) {
                pokemon3Switch();
                activePokemon=pokemon3;
            }
            else if (e.equals(pokemon4Name.toLowerCase())) {
                pokemon4Switch();
                activePokemon=pokemon4;
            }
            else if (e.equals(pokemon5Name.toLowerCase())) {
                pokemon5Switch();
                activePokemon=pokemon5;
            }
            else if (e.equals(pokemon6Name.toLowerCase())) {
                pokemon6Switch();
                activePokemon=pokemon6;
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
        String x= move1Name;
        mainTextArea.setText(activePokemon.getName() + " used "  + x);
        if (x.equals("Restore")) {
            activePokemon.Restore(activePokemon);
        }
        if (activePokemon.getClass()==Fire.class) {
            if (x.equals("Flamethrower")) {
                ((Fire) activePokemon).Flamethrower(enemy);
            }
            if (x.equals("BlazingTorque")) {
                ((Fire) activePokemon).BlazingTorque(enemy);
            }
            if (x.equals("Eruption")) {
                ((Fire)activePokemon).Eruption(enemy);
            }
            if (x.equals("Inferno")) {
                ((Fire)activePokemon).Inferno(enemy);
            }
            if (x.equals("BlueFlare")) {
                ((Fire)activePokemon).BlueFlare(enemy);
            }
            if (x.equals("HeatWave")) {
                ((Fire)activePokemon).HeatWave(enemy);
            }
        }
        if (activePokemon.getClass()==Water.class) {

        }
        if (activePokemon.getClass()==Grass.class) {

        }
        enemyStats.setText(enemy.getName() +"     Level " + enemy.getLevel() +  "\n\n Health: " +
                enemy.getCurrentHealth() + "/" + enemy.getHealth());
    }
    public void move2() {

    }
    public void move3() {

    }
    public void move4() {

    }
    public void pokemon1Switch() {
        moveSetter(pokemon1);
        ownStats.setText(pokemon1Name +"     Level" + pokemon1.getLevel() + "\n\n Health: " +
                pokemon1.getCurrentHealth() + "/" + pokemon1.getHealth());
    }
    public void pokemon2Switch() {
        moveSetter(pokemon2);
        ownStats.setText(pokemon2Name + "     Level" + pokemon2.getLevel() +"\n\n Health: " +
                pokemon2.getCurrentHealth() + "/" + pokemon2.getHealth());
    }
    public void pokemon3Switch() {
        moveSetter(pokemon3);
        ownStats.setText(pokemon3Name + "     Level" + pokemon3.getLevel() +"\n\n Health: " +
                pokemon3.getCurrentHealth() + "/" + pokemon3.getHealth());
    }
    public void pokemon4Switch() {
        moveSetter(pokemon4);
        ownStats.setText(pokemon4Name + "     Level" + pokemon4.getLevel() +"\n\n Health: " +
                pokemon4.getCurrentHealth() + "/" + pokemon4.getHealth());
    }
    public void pokemon5Switch() {
        moveSetter(pokemon5);
        ownStats.setText(pokemon5Name + "     Level" + pokemon5.getLevel() +"\n\n Health: " +
                pokemon5.getCurrentHealth() + "/" + pokemon5.getHealth());
    }
    public void pokemon6Switch() {
        moveSetter(pokemon6);
        ownStats.setText(pokemon6Name + "     Level" + pokemon6.getLevel() +"\n\n Health: " +
                pokemon6.getCurrentHealth() + "/" + pokemon6.getHealth());
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
    private void movesButtonSetter(JButton button, String name, String inputName, JPanel buttonPanel) {
        button=new JButton(name);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(buttonFont);
        button.setFocusPainted(false);
        buttonPanel.add(button);
        button.setActionCommand(inputName.toLowerCase());
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

        moveSetter(pokemon1);
        movesButtonSetter(move1, move1Name,"move1", movePanel);
        movesButtonSetter(move2, move2Name,"move2",  movePanel);
        movesButtonSetter(move3, move3Name,"move3", movePanel);
        movesButtonSetter(move4, move4Name,"move4", movePanel);
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
            System.out.println("water");
            int count = 1;
            for (int i = 0; i < 4; i++) {
                if (pokemon.moveList[i] == 1) {
                    if (count == 1) {
                        move1Name = "Aquajet";
                    }
                    if (count == 2) {
                        move2Name = "Aquajet";
                    }
                    if (count == 3) {
                        move3Name = "Aquajet";
                    }
                    if (count == 4) {
                        move4Name = "Aquajet";
                    }
                }
                if (pokemon.moveList[i] == 2) {
                    if (count == 1) {
                        move1Name = "Aquaring";
                    }
                    if (count == 2) {
                        move2Name = "Aquaring";
                    }
                    if (count == 3) {
                        move3Name = "Aquaring";
                    }
                    if (count == 4) {
                        move4Name = "Aquaring";
                    }
                }
                if (pokemon.moveList[i] == 3) {
                    if (count == 1) {
                        move1Name = "Bubble";
                    }
                    if (count == 2) {
                        move2Name = "Bubble";
                    }
                    if (count == 3) {
                        move3Name = "Bubble";
                    }
                    if (count == 4) {
                        move4Name = "Bubble";
                    }
                }
                if (pokemon.moveList[i] == 4) {
                    if (count == 1) {
                        move1Name = "Hydropump";
                    }
                    if (count == 2) {
                        move2Name = "Hydropump";
                    }
                    if (count == 3) {
                        move3Name = "Hydropump";
                    }
                    if (count == 4) {
                        move4Name = "Hydropump";
                    }
                }
                if (pokemon.moveList[i] == 5) {
                    if (count == 1) {
                        move1Name = "Bubblebeam";
                    }
                    if (count == 2) {
                        move2Name = "Bubblebeam";
                    }
                    if (count == 3) {
                        move3Name = "Bubblebeam";
                    }
                    if (count == 4) {
                        move4Name = "Bubblebeam";
                    }
                }
                if (pokemon.moveList[i] == 6) {
                    if (count == 1) {
                        move1Name = "Razorshell";
                    }
                    if (count == 2) {
                        move2Name = "Razorshell";
                    }
                    if (count == 3) {
                        move3Name = "Razorshell";
                    }
                    if (count == 4) {
                        move4Name = "Razorshell";
                    }
                }
                if (pokemon.moveList[i] == 7) {
                    if (count == 1) {
                        move1Name = "Restore";
                    }
                    if (count == 2) {
                        move2Name = "Restore";
                    }
                    if (count == 3) {
                        move3Name = "Restore";
                    }
                    if (count == 4) {
                        move4Name = "Restore";
                    }
                }
                count++;
            }
        }
        if (pokemon.getClass()==Grass.class) {
            System.out.println("grass");
            int count = 1;
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
