public class CatchPokemon {
    public CatchPokemon(){
    }
    public static boolean capture(){
        if (Player.pokeballamt() > 0){
            // calculates if the capture was successful or not
            int random = (int )(Math.random() * 100) + 1;
            if (random > 25) {
                System.out.println("false");
                return false;
            } else {
                int x = 0;
                for (int i = 0; i < 6; i++) {
                    if (Player.party[i].getName().equals("test")) {
                        x=i;
                        break;
                    }
                }
                if (Player.party[x].getName().equals("test")) {
                    Player.party[x] = FightWindow.enemy;
                    Player.removepokeball();
                    System.out.println("true");
                    return true;
                }
            }
        }
        System.out.println("false2");
        return false;
    }
}
