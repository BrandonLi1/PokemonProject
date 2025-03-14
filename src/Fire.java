public class Fire extends PokemonType{


    public Fire(int level, int health, String name) {
        super(level, health, name);
    }

    //moves as methods

    public void Flamethrower() {
        setAccuracy(100);
        if (checkHit()) {
            //do damage or smth idk bruv
        }
    }
}
