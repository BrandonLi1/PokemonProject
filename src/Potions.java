public class Potions extends Items{
    private static int heal = 0;
    public Potions(int price , int amount, int heal){
        super(price , amount);
        this.heal = heal;
    }
    public static int getHeal(){
        return heal;
    }
    public void setHeal(int amt){
        heal = amt;
    }
}
