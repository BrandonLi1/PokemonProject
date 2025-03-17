public class Player extends Space {
    private String name;
    private PokemonType[] party;

    public Player(String name) {
        super(name.substring(0, 1)); // symbol is first initial

    }

}
