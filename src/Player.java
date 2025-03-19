public class Player extends Space {
    private String name;
    public PokemonType[] party;

    public Player(String name) {
        super(name.substring(0, 1)); // symbol is first initial
        party = new PokemonType[6];
    }


    public PokemonType[] getParty() {
        return party;
    }
}
