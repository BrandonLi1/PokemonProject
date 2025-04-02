public class Gym{
    public static boolean gymFight=true;
    //test
    public Gym() {
        FightWindow fight1 = new FightWindow(new Fire(100, 999, "Charizard", "3", "n"));
        fight1.createGameScreen();
        pause();
        if (alive()) {
            FightWindow fight2 = new FightWindow(new Fire(30, 100, "Charizard", "3", "n"));
            fight2.createGameScreen();
            pause();
        }
     /*  if (alive()) {
            FightWindow fight3 = new FightWindow(new Water());
            fight3.createGameScreen();
            pause();
        }
       if (alive()) {
            FightWindow fight4 = new FightWindow(new Water());
            pause();
        }
       if (alive()) {
            FightWindow fight5 = new FightWindow(new Grass());
            pause();
        }
       if (alive()) {
            FightWindow fight6 = new FightWindow(new Grass());
        }*/
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
