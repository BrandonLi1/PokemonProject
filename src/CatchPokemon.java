public class CatchPokemon {
    public CatchPokemon(){
    }
    public boolean capture(){
        if (Player.pokeballamt() > 0){
            // calculates if the capture was succesful or not
            int random = (int )(Math.random() * 100) + 1;
            if (random > 25) {
                return false;
            } else {
                Player.party[Player.currentpartysize()+1] = new PokemonType(FightWindow.enemy.getLevel(),
                        FightWindow.enemy.getHealth(),
                        FightWindow.enemy.getName());
                return true;
            }
        }
        return false;
    }
}
