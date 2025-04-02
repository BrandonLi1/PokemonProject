public class Gym{
    public static boolean gymFight=true;
    public Gym() {
        FightWindow fight1 = new FightWindow(new Fire());
        FightWindow fight2 = new FightWindow(new Fire());
        FightWindow fight3 = new FightWindow(new Water());
        FightWindow fight4 = new FightWindow(new Water());
        FightWindow fight5 = new FightWindow(new Grass());
        FightWindow fight6 = new FightWindow(new Grass());
    }

}
