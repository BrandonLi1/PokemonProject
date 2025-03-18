public class PokemonType {
    //general code for the pokemon, add children classes of fire/water/grass
    private int accuracy;
    private int level;
    private int health;
    private String name;
    private int power;
    private double xp;
    private double requiredXP;
    private int currentHealth;
    private boolean burning;
    public PokemonType(int level, int health, String name, boolean burning) {
        this.level=level;
        this.health=health;
        this.name=name;
        burning=false;
        requiredXP = Math.pow(level, 3);
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

    public double getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void checkLevelUp() {
        if (xp > requiredXP) {
            level++;
            xp -= requiredXP;
            requiredXP = Math.pow(level, 3);
        }
    }
    //make xp formula bruv

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean isBurning() {
        return burning;
    }

    public void setBurning(boolean burning) {
        this.burning = burning;
    }

    public boolean checkHit() {
        int x=(int) (Math.random()*100);
        if (x<accuracy) {
            return true;
        }
        return false;
    }

    public int checkDamage() {
        int x=0;
        x=(int)((((2.0*level)/5.0+2.0)*power)/50);
        return x;
    }

    public void Restore(PokemonType self) {
        setCurrentHealth(currentHealth+(int)(health*.5));
    }
}
