public class Pokemon extends Space {
    private PokemonType pokemonType;

    public Pokemon(String symbol, PokemonType pokemonType) {
        super(symbol);
        this.pokemonType=pokemonType;
    }

    public Pokemon(String symbol) {
        super(symbol);
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }
}
