public class Gym{
    public static boolean gymFight;
    //test
    public Gym() {
        gymFight=true;
        FightWindow fight1 = new FightWindow(new Fire(18, 43, "Charmander", "1", "y"));
        fight1.createGameScreen();
        pause();

       if (alive()) {
            FightWindow fight3 = new FightWindow(new Water(13, 30, "Squirtle", "1", "y"));
            fight3.createGameScreen();
            pause();
        }
       if (alive()) {
            FightWindow fight2 = new FightWindow(new Fire(20, 38, "Cyndaquil", "1", "y"));
            fight2.createGameScreen();
            pause();
       }
       if (alive()) {
            FightWindow fight5 = new FightWindow(new Grass(21, 50, "Grovyle", "2", "y"));
            fight5.createGameScreen();
            pause();
       }
       if (alive()) {
            FightWindow fight6 = new FightWindow(new Grass(22, 90, "Tortera", "3", "n"));
            fight6.createGameScreen();
            pause();
       }
       if (alive()) {
           FightWindow fight4 = new FightWindow(new Water(19, 100, "Kyogre(suppressed)", "2", "y"));
           fight4.createGameScreen();
           pause();
       }

        if (fight1.checkLose()) {
            System.out.println("You have failed");
            System.exit(0);
        } else {
            System.out.println("You beat the gym leader!");
            System.exit(0);
        }
    }

    private boolean alive() {
        for (int i = 0; i < 6; i++) {
            if (!Player.party[i].getName().equals("test") && Player.party[i].getCurrentHealth()>=1) {
                return true;
            }
        }
        return false;
    }

    private void pause() {
        try {
            synchronized (this) {
                while (FightWindow.screen.isVisible()) {
                    this.wait(10);
                    if (!alive()) {
                        System.out.println("You have failed");
                        System.exit(0);
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
