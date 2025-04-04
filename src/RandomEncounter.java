import java.util.ArrayList;


public class RandomEncounter {
    public RandomEncounter() {
    }
    public static PokemonType getEncounter(){
        CreatePokemon create = new CreatePokemon();
        int random = (int)((Math.random()*100) + 1);
        ArrayList<PokemonType> poke = CreatePokemon.getPokemon();
        ArrayList<PokemonType> third = new ArrayList<>();
        ArrayList<PokemonType> second = new ArrayList<>();
        ArrayList<PokemonType> first = new ArrayList<>();
        for (int i = 0; i < poke.size(); i++) {
            if(poke.get(i).getStage().equals("3")){
                third.add(poke.get(i));
            }else if (poke.get(i).getStage().equals("2")){
                second.add(poke.get(i));
            } else {
                first.add(poke.get(i));
            }
        }
        if(random >= 5){
            int random3 = (int)((Math.random()*third.size()) + 0);
            return (third.get(random3));
        } else if(random >= 30){
            int random2 = (int)((Math.random()*second.size()) + 0);
            return (second.get(random2));
        } else {
            int random1 = (int)((Math.random()*first.size()) + 0);
            return (first.get(random1));
        }
    }
}
