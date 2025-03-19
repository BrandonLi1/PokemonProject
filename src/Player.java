import java.util.ArrayList;
public class Player extends Space {
    private String name;
    public PokemonType[] party;
    public static ArrayList<Items> itembag = new ArrayList<>();

    public Player(String name) {
        super(name.substring(0, 1)); // symbol is first initial
        party = new PokemonType[6];
    }


    public PokemonType[] getParty() {
        return party;
    }
    public void printItemBag(){
        for (int i = 0; i < itembag.size(); i++) {
            itembag.get(i).getItemName();
            System.out.print(", ");
        }
    }
    public static void addItemBad(Items item ){
        itembag.add(item);
    }

}
