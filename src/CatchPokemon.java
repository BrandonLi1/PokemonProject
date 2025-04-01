public class CatchPokemon {
    public CatchPokemon(){
    }
    public boolean capture(){
        if (Player.pokeballamt() > 0){
            // calculates if the capture was successful or not
            int random = (int )(Math.random() * 100) + 1;
            if (random > 25) {
                return false;
            } else {
                Player.party[Player.currentpartysize()+1] = FightWindow.enemy;
                return true;
            }
        }
        return false;
    }
}
