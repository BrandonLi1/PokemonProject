public class Pokeballs extends Items{
    private int successrate;
    public Pokeballs (int price, int amount, int successrate){
        super(price, amount);
        this.successrate = successrate;
    }
@Override
public String getItemName(){
    return("Pokeball");
}
}
