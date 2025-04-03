public class CatchPokemon {
    public CatchPokemon(){
        capture();
    }
    public static boolean capture(){
        if (Player.pokeballamt() > 0){
            // calculates if the capture was successful or not
            int random = (int )(Math.random() * 100) + 1;
            if (random > 25) {
                System.out.println("failed to catch pokemon");
                return false;
            } else {
                int x = 7;
                for (int i = 0; i < 6; i++) {
                    if (Player.party[i].getName().equals("test")) {
                        x=i;
                        break;
                    }
                }
                if (x<=5 && Player.party[x].getName().equals("test")) {
                    Player.party[x] = FightWindow.enemy;
                    Player.removepokeball();
                    System.out.println("Caught the pokemon");
                    return true;
                }
            }
        }
        System.out.println("you don't have any pokeballs");
        return false;
    }
}
