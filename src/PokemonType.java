public class PokemonType {
    //general code for the pokemon, add children classes of fire/water/grass
    private int accuracy;
    private int level;
    private int health;
    private String name;
    public PokemonType(int level, int health, String name) {
        this.level=level;
        this.health=health;
        this.name=name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public boolean checkHit() {
        int x=(int) (Math.random()*100);
        if (x<accuracy) {
            return true;
        }
        return false;
    }
}
