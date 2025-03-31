import java.util.ArrayList;
public class Player extends Space {
    private String name;
    public static PokemonType[] party;
    public static ArrayList<Items> itembag = new ArrayList<>();

    public Player(String name) {
        super(name.substring(0, 1)); // symbol is first initial
        party = new PokemonType[6];
        for (int i = 0; i < 5; i++) {
            party[i] = new PokemonType(0, 0, "test");
        }
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
    public static void addItemBag(Items item ){
        itembag.add(item);
    }
    public static int pokeballamt(){
        int amunt = 0;
        for (int i = 0; i < itembag.size(); i++) {
            if(itembag.get(i).getItemName().equals("Pokeball")){
                amunt++;
            }
        }
        return amunt;
    }
    public static int currentpartysize(){
        int temp = 0;
        for (int i = 0; i < party.length; i++) {
            if(party[i] != null){
                temp++;
            }
        }
        return temp;
    }



}
