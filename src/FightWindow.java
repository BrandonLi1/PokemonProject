import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FightWindow {//https://www.youtube.com/playlist?list=PL_QPQmz5C6WUMB0xEMZosWbyQo_Kil0Fb : whole class- built based off StartWindow
    JFrame screen;
    Container con;

    JPanel actionPanel, movePanel, ownStatsPanel, enemyStatsPanel,
            mainTextPanel, switchPanel, itemPanel, backPanel;

    JButton fight, run, bag, move1, move2, move3, move4, pokemon, pokemon1Button,
            pokemon2Button, pokemon3Button, pokemon4Button, pokemon5Button, pokemon6Button,
            pokeball, potion, backButton;

    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font textFont = new Font("Times New Roman", Font.PLAIN, 30);
    Font statFont = new Font("Times New Roman", Font.PLAIN, 20);

    JTextArea mainTextArea, ownStats, enemyStats;

    choiceHandler choiceHandler = new choiceHandler();

    String move1Name, move2Name, move3Name, move4Name, pokemon1Name,
            pokemon2Name,pokemon3Name,pokemon4Name,pokemon5Name,pokemon6Name,
            enemyMove1Name,enemyMove2Name,enemyMove3Name,enemyMove4Name;//make it name the moves based on the ints
    static PokemonType pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, enemy, activePokemon;


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
        enemyMoveSetter(enemy);
    }


    public void switchScreen() {
        switchPanel.setVisible(true);
        actionPanel.setVisible(false);
        movePanel.setVisible(false);
        if (pokemon1!=null && !pokemon1Name.equals("test") && activePokemon!=pokemon1) {
            buttonSetter(pokemon1Button, pokemon1Name, switchPanel);
        }
        if (pokemon2!=null && !pokemon2Name.equals("test") && activePokemon!=pokemon2) {
            buttonSetter(pokemon2Button, pokemon2Name, switchPanel);
            }
        if (pokemon3!=null && !pokemon3Name.equals("test") && activePokemon!=pokemon3) {
            buttonSetter(pokemon3Button, pokemon3Name, switchPanel);
            }
        if (pokemon4!=null && !pokemon4Name.equals("test") && activePokemon!=pokemon4) {
            buttonSetter(pokemon4Button, pokemon4Name, switchPanel);
         }
        if (pokemon5!=null && !pokemon5Name.equals("test") && activePokemon!=pokemon5) {
            buttonSetter(pokemon5Button, pokemon5Name, switchPanel);
        }
        if (pokemon6!=null && !pokemon6Name.equals("test") && activePokemon!=pokemon6) {
            buttonSetter(pokemon6Button, pokemon6Name, switchPanel);
        }
        switchPanel.setVisible(true);
        con.add(switchPanel);
        mainTextArea.setText("Who will you switch to");
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

        backPanel=new JPanel();
        backPanel.setBounds(0, 0, 400, 300);
        backPanel.setBackground(Color.black);
        backPanel.setVisible(false);

        switchPanel = new JPanel();
        switchPanel.setBounds(600, 0, 400, 800);
        switchPanel.setBackground(Color.black);
        switchPanel.setLayout(new GridLayout(3, 2));
        switchPanel.setVisible(false);

        //textAreas
        mainTextArea=new JTextArea();
        mainTextArea.setEditable(false);
        mainTextArea.setText("What will you do?");
        mainTextArea.setBounds(0, 700, 600, 300);
        mainTextArea.setBackground(Color.white);
        mainTextArea.setForeground(Color.black);
        mainTextArea.setFont(textFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        ownStats = new JTextArea();
        ownStats.setEditable(false);
        ownStats.setText(pokemon1Name + "     Level " + pokemon1.getLevel() + "\n\n Health: " +
                pokemon1.getCurrentHealth() + "/" + pokemon1.getHealth());
        ownStats.setBounds(0, 300, 200, 100);
        ownStats.setBackground(Color.white);
        ownStats.setForeground(Color.black);
        ownStats.setFont(statFont);
        ownStats.setLineWrap(true);
        ownStatsPanel.add(ownStats);

        enemyStats= new JTextArea();
        enemyStats.setEditable(false);
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
        con.add(movePanel);
        con.add(backPanel);
    }

    private class choiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String e = event.getActionCommand();
            if (e.equals("bag")) {
                backPanel.setVisible(true);
                bag();
            } else if (e.equals("pokemon")) {
                backPanel.setVisible(true);
                Switch();
            } else if (e.equals("run")) {
                if (!Gym.gymFight) {
                    run();
                }
            } else if (e.equals("fight")) {
                backPanel.setVisible(true);
                fight();
            } else if (e.equals("move1")) {
                move1();
                if (enemy.getCurrentHealth()<=0) {
                    mainTextArea.setText("The wild " + enemy.getName() + " fainted! \n"
                            + activePokemon.getName() + " gained " + enemy.getLevel()*10 + " Exp. points");
                    activePokemon.setXp((int) (activePokemon.getXp()+enemy.getLevel()*10));
                    activePokemon.checkLevelUp();
                }
            } else if (e.equals("move2")) {
                move2();
                if (enemy.getCurrentHealth()<=0) {
                    mainTextArea.setText("The wild " + enemy.getName() + " fainted! \n"
                            + activePokemon.getName() + " gained " + enemy.getLevel()*10 + " Exp. points");
                    activePokemon.setXp((int) (activePokemon.getXp()+enemy.getLevel()*10));
                    activePokemon.checkLevelUp();
                }
            } else if (e.equals("move3")) {
                move3();
                if (enemy.getCurrentHealth()<=0) {
                    mainTextArea.setText("The wild " + enemy.getName() + " fainted! \n"
                            + activePokemon.getName() + " gained " + enemy.getLevel()*10 + " Exp. points");
                    activePokemon.setXp((int) (activePokemon.getXp()+enemy.getLevel()*10));
                    activePokemon.checkLevelUp();
                }
            } else if (e.equals("move4")) {
                move4();
                if (enemy.getCurrentHealth()<=0) {
                    mainTextArea.setText("The wild " + enemy.getName() + " fainted! \n"
                            + activePokemon.getName() + " gained " + enemy.getLevel()*10 + " Exp. points");
                    activePokemon.setXp((int) (activePokemon.getXp()+enemy.getLevel()*10));
                    activePokemon.checkLevelUp();
                }
            } else if (e.equals(pokemon1Name.toLowerCase())) {
                if (pokemon1!=null && pokemon1.getCurrentHealth()>0) {
                    activePokemon = pokemon1;
                    pokemon1Switch();
                    switchPanel.setVisible(false);
                    actionPanel.setVisible(true);
                }
            }
            else if (e.equals(pokemon2Name.toLowerCase())) {
                if (pokemon2!=null && pokemon2.getCurrentHealth()>0) {
                    activePokemon = pokemon2;
                    pokemon2Switch();
                    switchPanel.setVisible(false);
                    actionPanel.setVisible(true);
                }
            }
            else if (e.equals(pokemon3Name.toLowerCase())) {
                if (pokemon3!=null && pokemon3.getCurrentHealth()>0) {
                    activePokemon = pokemon3;
                    pokemon3Switch();
                    switchPanel.setVisible(false);
                    actionPanel.setVisible(true);
                }
            }
            else if (e.equals(pokemon4Name.toLowerCase())) {
                if (pokemon4!=null && pokemon4.getCurrentHealth()>0) {
                    activePokemon = pokemon4;
                    pokemon4Switch();
                    switchPanel.setVisible(false);
                    actionPanel.setVisible(true);
                }
            }
            else if (e.equals(pokemon5Name.toLowerCase())) {
                if (pokemon5!=null && pokemon5.getCurrentHealth()>0) {
                    activePokemon = pokemon5;
                    pokemon5Switch();
                    switchPanel.setVisible(false);
                    actionPanel.setVisible(true);
                }
            }
            else if (e.equals(pokemon6Name.toLowerCase())) {
                if (pokemon6!=null && pokemon6.getCurrentHealth()>0) {
                    activePokemon = pokemon6;
                    pokemon6Switch();
                    switchPanel.setVisible(false);
                    actionPanel.setVisible(true);
                }
            }
            else if (e.equals("back")) {
                back();
            }
        }
    }
    public void run() {
        if (Math.random()<=.5) {
            System.out.println();
            System.out.println("Got Away Safely!");
            mainTextArea.setText("Got Away Safely!");
            screen.dispose();
        } else {
            enemyAttack();
        }
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
        moveCheck(activePokemon, enemy, move1Name);
        enemyStats.setText(enemy.getName() +"     Level " + enemy.getLevel() +  "\n\n Health: " +
                enemy.getCurrentHealth() + "/" + enemy.getHealth());
        movePanel.setVisible(false);
        actionPanel.setVisible(true);
        enemyAttack();
    }
    public void move2() {
        moveCheck(activePokemon, enemy, move2Name);
        enemyStats.setText(enemy.getName() +"     Level " + enemy.getLevel() +  "\n\n Health: " +
                enemy.getCurrentHealth() + "/" + enemy.getHealth());
        movePanel.setVisible(false);
        actionPanel.setVisible(true);
        enemyAttack();
    }
    public void move3() {
        moveCheck(activePokemon, enemy, move3Name);
        enemyStats.setText(enemy.getName() +"     Level " + enemy.getLevel() +  "\n\n Health: " +
                enemy.getCurrentHealth() + "/" + enemy.getHealth());

        movePanel.setVisible(false);
        actionPanel.setVisible(true);
        enemyAttack();
    }
    public void move4() {
        moveCheck(activePokemon, enemy, move4Name);
        enemyStats.setText(enemy.getName() +"     Level " + enemy.getLevel() +  "\n\n Health: " +
                enemy.getCurrentHealth() + "/" + enemy.getHealth());

        movePanel.setVisible(false);
        actionPanel.setVisible(true);
        enemyAttack();
    }
    public void pokemon1Switch() {
        moveSetter(activePokemon);
        ownStats.setText(activePokemon.getName() +"     Level " + activePokemon.getLevel() + "\n\n Health: " +
                activePokemon.getCurrentHealth() + "/" + activePokemon.getHealth());
        updateMoves();
        enemyAttack();

    }
    public void pokemon2Switch() {
        moveSetter(pokemon2);
        moveSetter(activePokemon);
        ownStats.setText(activePokemon.getName() +"     Level " + activePokemon.getLevel() + "\n\n Health: " +
                activePokemon.getCurrentHealth() + "/" + activePokemon.getHealth());
        updateMoves();
        enemyAttack();

    }
    public void pokemon3Switch() {
        moveSetter(activePokemon);
        ownStats.setText(activePokemon.getName() +"     Level " + activePokemon.getLevel() + "\n\n Health: " +
                activePokemon.getCurrentHealth() + "/" + activePokemon.getHealth());
        updateMoves();
        enemyAttack();

    }
    public void pokemon4Switch() {
        moveSetter(activePokemon);
        ownStats.setText(activePokemon.getName() +"     Level " + activePokemon.getLevel() + "\n\n Health: " +
                activePokemon.getCurrentHealth() + "/" + activePokemon.getHealth());
        updateMoves();
        enemyAttack();

    }
    public void pokemon5Switch() {
        moveSetter(activePokemon);
        ownStats.setText(activePokemon.getName() +"     Level " + activePokemon.getLevel() + "\n\n Health: " +
                activePokemon.getCurrentHealth() + "/" + activePokemon.getHealth());
        updateMoves();
        enemyAttack();

    }
    public void pokemon6Switch() {
        moveSetter(activePokemon);
        ownStats.setText(activePokemon.getName() +"     Level " + activePokemon.getLevel() + "\n\n Health: " +
                activePokemon.getCurrentHealth() + "/" + activePokemon.getHealth());
        updateMoves();
        enemyAttack();

    }
    public void back() {
        actionPanel.setVisible(true);
        backPanel.setVisible(false);
        switchPanel.setVisible(false);
        itemPanel.setVisible(false);
        movePanel.setVisible(false);
    }

    private void buttonSetter(JButton button, String name, JPanel buttonPanel) {
        button=new JButton(name);
        if (name.equals(pokemon1Name)) {
            pokemon1Button=new JButton(pokemon1Name + "\n" + "Health: " + pokemon1.getCurrentHealth() + "/" + pokemon1.getHealth());
        }
        if (name.equals(pokemon2Name)) {
            pokemon2Button=new JButton(pokemon2Name + "\n" + "Health: " + pokemon2.getCurrentHealth() + "/" + pokemon2.getHealth());
        }
        if (name.equals(pokemon3Name)) {
            pokemon3Button=new JButton(pokemon3Name + "\n" + "Health: " + pokemon3.getCurrentHealth() + "/" + pokemon3.getHealth());
        }
        if (name.equals(pokemon4Name)) {
            pokemon4Button=new JButton(pokemon4Name + "\n" + "Health: " + pokemon4.getCurrentHealth() + "/" + pokemon4.getHealth());
        }
        if (name.equals(pokemon5Name)) {
            pokemon5Button=new JButton(pokemon5Name + "\n" + "Health: " + pokemon5.getCurrentHealth() + "/" + pokemon5.getHealth());
        }
        if (name.equals(pokemon6Name)) {
            pokemon6Button=new JButton(pokemon6Name + "\n" + "Health: " + pokemon6.getCurrentHealth() + "/" + pokemon6.getHealth());
        }
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

        backButton=new JButton("back");
        backButton.setSize(400, 300);
        backButton.setBackground(Color.black);
        backButton.setForeground(Color.white);
        backButton.setFont(buttonFont);
        backButton.setFocusPainted(false);
        backPanel.add(backButton);
        backButton.setActionCommand("back");
        backButton.addActionListener(choiceHandler);

        moveSetter(pokemon1);
        movesButtonSetter(move1, move1Name,"move1", movePanel);
        movesButtonSetter(move2, move2Name,"move2",  movePanel);
        movesButtonSetter(move3, move3Name,"move3", movePanel);
        movesButtonSetter(move4, move4Name,"move4", movePanel);
    }

    private void moveSetter(PokemonType pokemon) {//code with parameter so enemy can also use moves
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
    private void enemyMoveSetter(PokemonType pokemon) {//code with parameter so enemy can also use enemyMoves
        if (pokemon.getClass()==Fire.class) {
            int count=1;
            for (int i = 0; i < 4; i++) {
                if (pokemon.moveList[i]==1) {
                    if (count == 1) {
                        enemyMove1Name="Restore";
                    }
                    if (count == 2) {
                        enemyMove2Name="Restore";
                    }
                    if (count == 3) {
                        enemyMove3Name="Restore";
                    }
                    if (count == 4) {
                        enemyMove4Name="Restore";
                    }
                }
                if (pokemon.moveList[i]==2) {
                    if (count == 1) {
                        enemyMove1Name="Flamethrower";
                    }
                    if (count == 2) {
                        enemyMove2Name="Flamethrower";
                    }
                    if (count == 3) {
                        enemyMove3Name="Flamethrower";
                    }
                    if (count == 4) {
                        enemyMove4Name="Flamethrower";
                    }
                }
                if (pokemon.moveList[i]==3) {
                    if (count == 1) {
                        enemyMove1Name="BlazingTorque";
                    }
                    if (count == 2) {
                        enemyMove2Name="BlazingTorque";
                    }
                    if (count == 3) {
                        enemyMove3Name="BlazingTorque";
                    }
                    if (count == 4) {
                        enemyMove4Name="BlazingTorque";
                    }
                }
                if (pokemon.moveList[i]==4) {
                    if (count == 1) {
                        enemyMove1Name="Eruption";
                    }
                    if (count == 2) {
                        enemyMove2Name="Eruption";
                    }
                    if (count == 3) {
                        enemyMove3Name="Eruption";
                    }
                    if (count == 4) {
                        enemyMove4Name="Eruption";
                    }
                }
                if (pokemon.moveList[i]==5) {
                    if (count == 1) {
                        enemyMove1Name="Inferno";
                    }
                    if (count == 2) {
                        enemyMove2Name="Inferno";
                    }
                    if (count == 3) {
                        enemyMove3Name="Inferno";
                    }
                    if (count == 4) {
                        enemyMove4Name="Inferno";
                    }
                }
                if (pokemon.moveList[i]==6) {
                    if (count == 1) {
                        enemyMove1Name="BlueFlare";
                    }
                    if (count == 2) {
                        enemyMove2Name="BlueFlare";
                    }
                    if (count == 3) {
                        enemyMove3Name="BlueFlare";
                    }
                    if (count == 4) {
                        enemyMove4Name="BlueFlare";
                    }
                }
                if (pokemon.moveList[i]==7) {
                    if (count == 1) {
                        enemyMove1Name="HeatWave";
                    }
                    if (count == 2) {
                        enemyMove2Name="HeatWave";
                    }
                    if (count == 3) {
                        enemyMove3Name="HeatWave";
                    }
                    if (count == 4) {
                        enemyMove4Name="HeatWave";
                    }
                }
                count++;
            }
        }
        if (pokemon.getClass()==Water.class) {
            int count = 1;
            for (int i = 0; i < 4; i++) {
                if (pokemon.moveList[i] == 1) {
                    if (count == 1) {
                        enemyMove1Name = "Aquajet";
                    }
                    if (count == 2) {
                        enemyMove2Name = "Aquajet";
                    }
                    if (count == 3) {
                        enemyMove3Name = "Aquajet";
                    }
                    if (count == 4) {
                        enemyMove4Name = "Aquajet";
                    }
                }
                if (pokemon.moveList[i] == 2) {
                    if (count == 1) {
                        enemyMove1Name = "Aquaring";
                    }
                    if (count == 2) {
                        enemyMove2Name = "Aquaring";
                    }
                    if (count == 3) {
                        enemyMove3Name = "Aquaring";
                    }
                    if (count == 4) {
                        enemyMove4Name = "Aquaring";
                    }
                }
                if (pokemon.moveList[i] == 3) {
                    if (count == 1) {
                        enemyMove1Name = "Bubble";
                    }
                    if (count == 2) {
                        enemyMove2Name = "Bubble";
                    }
                    if (count == 3) {
                        enemyMove3Name = "Bubble";
                    }
                    if (count == 4) {
                        enemyMove4Name = "Bubble";
                    }
                }
                if (pokemon.moveList[i] == 4) {
                    if (count == 1) {
                        enemyMove1Name = "Hydropump";
                    }
                    if (count == 2) {
                        enemyMove2Name = "Hydropump";
                    }
                    if (count == 3) {
                        enemyMove3Name = "Hydropump";
                    }
                    if (count == 4) {
                        enemyMove4Name = "Hydropump";
                    }
                }
                if (pokemon.moveList[i] == 5) {
                    if (count == 1) {
                        enemyMove1Name = "Bubblebeam";
                    }
                    if (count == 2) {
                        enemyMove2Name = "Bubblebeam";
                    }
                    if (count == 3) {
                        enemyMove3Name = "Bubblebeam";
                    }
                    if (count == 4) {
                        enemyMove4Name = "Bubblebeam";
                    }
                }
                if (pokemon.moveList[i] == 6) {
                    if (count == 1) {
                        enemyMove1Name = "Razorshell";
                    }
                    if (count == 2) {
                        enemyMove2Name = "Razorshell";
                    }
                    if (count == 3) {
                        enemyMove3Name = "Razorshell";
                    }
                    if (count == 4) {
                        enemyMove4Name = "Razorshell";
                    }
                }
                if (pokemon.moveList[i] == 7) {
                    if (count == 1) {
                        enemyMove1Name = "Restore";
                    }
                    if (count == 2) {
                        enemyMove2Name = "Restore";
                    }
                    if (count == 3) {
                        enemyMove3Name = "Restore";
                    }
                    if (count == 4) {
                        enemyMove4Name = "Restore";
                    }
                }
                count++;
            }
        }
        if (pokemon.getClass()==Grass.class) {
            int count = 1;
            for (int i = 0; i < 4; i++) {
                if (pokemon.moveList[i]==1) {
                    if (count == 1) {
                        enemyMove1Name="Restore";
                    }
                    if (count == 2) {
                        enemyMove2Name="Restore";
                    }
                    if (count == 3) {
                        enemyMove3Name="Restore";
                    }
                    if (count == 4) {
                        enemyMove4Name="Restore";
                    }
                }
                if (pokemon.moveList[i]==2) {
                    if (count == 1) {
                        enemyMove1Name="Absorb";
                    }
                    if (count == 2) {
                        enemyMove2Name="Absorb";
                    }
                    if (count == 3) {
                        enemyMove3Name="Absorb";
                    }
                    if (count == 4) {
                        enemyMove4Name="Absorb";
                    }
                }
                if (pokemon.moveList[i]==3) {
                    if (count == 1) {
                        enemyMove1Name= "Bullet Seed";
                    }
                    if (count == 2) {
                        enemyMove2Name= "Bullet Seed";
                    }
                    if (count == 3) {
                        enemyMove3Name= "Bullet Seed";
                    }
                    if (count == 4) {
                        enemyMove4Name= "Bullet Seed";
                    }
                }
                if (pokemon.moveList[i]==4) {
                    if (count == 1) {
                        enemyMove1Name= "Magical Leaf";
                    }
                    if (count == 2) {
                        enemyMove2Name="Magical Leaf";
                    }
                    if (count == 3) {
                        enemyMove3Name="Magical Leaf";
                    }
                    if (count == 4) {
                        enemyMove4Name="Magical Leaf";
                    }
                }
                if (pokemon.moveList[i]==5) {
                    if (count == 1) {
                        enemyMove1Name= "Razor Leaf";
                    }
                    if (count == 2) {
                        enemyMove2Name="Razor Leaf";
                    }
                    if (count == 3) {
                        enemyMove3Name="Razor Leaf";
                    }
                    if (count == 4) {
                        enemyMove4Name="Razor Leaf";
                    }
                }
                if (pokemon.moveList[i]==6) {
                    if (count == 1) {
                        enemyMove1Name= "Leaf Tornado";
                    }
                    if (count == 2) {
                        enemyMove2Name="Leaf Tornado";
                    }
                    if (count == 3) {
                        enemyMove3Name="Leaf Tornado";
                    }
                    if (count == 4) {
                        enemyMove4Name="Leaf Tornado";
                    }
                }
                if (pokemon.moveList[i]==7) {
                    if (count == 1) {
                        enemyMove1Name= "Solar Beam";
                    }
                    if (count == 2) {
                        enemyMove2Name="Solar Beam";
                    }
                    if (count == 3) {
                        enemyMove3Name="Solar Beam";
                    }
                    if (count == 4) {
                        enemyMove4Name="Solar Beam";
                    }
                }
                count++;
            }
        }
    }


    private void moveCheck(PokemonType active, PokemonType target, String moveName) {
        checkBurning(active);
        String x= moveName;
        mainTextArea.setText(active.getName() + " used "  + x);
        if (x.equals("Restore")) {
            active.Restore(active);
        }
        if (active.getClass()==Fire.class) {
            if (x.equals("Flamethrower")) {
                ((Fire) active).Flamethrower(target);
            }
            if (x.equals("BlazingTorque")) {
                ((Fire) active).BlazingTorque(target);
            }
            if (x.equals("Eruption")) {
                ((Fire)active).Eruption(target);
            }
            if (x.equals("Inferno")) {
                ((Fire)active).Inferno(target);
            }
            if (x.equals("BlueFlare")) {
                ((Fire)active).BlueFlare(target);
            }
            if (x.equals("HeatWave")) {
                ((Fire)active).HeatWave(target);
            }
        }
        if (active.getClass()==Water.class) {
            if (x.equals("Aquajet")) {
                ((Water) active).Aquajet(target);
            }
            if (x.equals("Aquaring")) {
                ((Water) active).Aquaring(active);
            }
            if (x.equals("Bubble")) {
                ((Water) active).Bubble(target);
            }
            if (x.equals("Hydropump")) {
                ((Water) active).Hydropump(target);
            }
            if (x.equals("Bubblebeam")) {
                ((Water) active).Bubblebeam(target);
            }
            if (x.equals("Razorshell")) {
                ((Water) active).Razorshell(target);
            }
        }
        if (activePokemon.getClass()==Grass.class) {
            if (x.equals("Bullet Seed")) {
                ((Grass) active).bulletSeed(target);
            }
            if (x.equals("Magical Leaf")) {
                ((Grass) active).magicalLeaf(target);
            }
            if (x.equals("Razor Leaf")) {
                ((Grass) active).razorLeaf(target);
            }
            if (x.equals("Leaf Tornado")) {
                ((Grass) active).leafTornado(target);
            }
            if (x.equals("Solar Beam")) {
                ((Grass) active).solarBeam(target);
            }
            if (x.equals("Absorb")) {
                ((Grass) active).absorb(target);
            }
        }
    }
    private void enemyAttack() {
            if (enemy.getCurrentHealth()>0) {
                int x = (int)(Math.random()*4+1);
                if (x==1) {
                    moveCheck(enemy, activePokemon, enemyMove1Name);
                }
                if (x==2) {
                    moveCheck(enemy, activePokemon, enemyMove2Name);
                }
                if (x==3) {
                    moveCheck(enemy, activePokemon, enemyMove3Name);
                }
                if (x==4) {
                    moveCheck(enemy, activePokemon, enemyMove4Name);
                }
                ownStats.setText(activePokemon.getName() +"     Level " + activePokemon.getLevel() +  "\n\n Health: " +
                        activePokemon.getCurrentHealth() + "/" + activePokemon.getHealth());
            }
            if (activePokemon.getCurrentHealth()<=0) {
                if (!checkLose()) {
                    actionPanel.setVisible(false);
                    switchPanel.setVisible(true);
                    mainTextArea.setText("Who will you switch to");
                } else {
                    mainTextArea.setText("You lose");
                    //say more stuff for lose
                }
            }
    }
    private boolean checkLose() {
        if (pokemon1==null || pokemon1.getCurrentHealth()<=0
        && (pokemon2==null || pokemon2.getCurrentHealth()<=0)
        && (pokemon3==null || pokemon3.getCurrentHealth()<=0)
        && (pokemon4==null || pokemon4.getCurrentHealth()<=0)
        && (pokemon5==null || pokemon5.getCurrentHealth()<=0)
        && (pokemon6==null || pokemon6.getCurrentHealth()<=0)) {
            return true;
        }
        return false;
    }

    private void checkBurning(PokemonType target) {
        if (target.isBurning()) {
            target.setCurrentHealth(target.getCurrentHealth()-(int)(target.getHealth()*.1));
        }
    }

    private void updateMoves() {
        movePanel= new JPanel();
        movePanel.setBounds(600, 700, 900, 300);
        movePanel.setBackground(Color.black);
        movePanel.setLayout(new GridLayout(2, 2));
        movePanel.setVisible(false);
        movesButtonSetter(move1, move1Name,"move1", movePanel);
        movesButtonSetter(move2, move2Name,"move2",  movePanel);
        movesButtonSetter(move3, move3Name,"move3", movePanel);
        movesButtonSetter(move4, move4Name,"move4", movePanel);
        con.add(movePanel);
        movePanel.repaint();
    }
}
