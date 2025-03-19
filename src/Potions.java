public class Potions extends Items{
    private int heal = 0;
    public Potions(int price , int amount, int heal){
        super(price , amount);
        this.heal = heal;
    }
    public int getHeal(){
        return heal;
    }
    public void setHeal(int amt){
        heal = amt;
    }
    @Override
    public void getItemName(){
        System.out.print("Potion");
    }
}
