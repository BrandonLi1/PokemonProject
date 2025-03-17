public class Fire extends PokemonType{


    public Fire(int level, int health, String name) {
        super(level, health, name);
    }

    //moves as methods

    public void Flamethrower(PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(90);
            checkDamage();//returns number for damage
            if (Math.random()*10==0 && !(target instanceof Fire)) {
                //make it burn
            }
        }
    }

    public void BlaingTorque (PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(80);
            checkDamage();
            if (Math.random()*10<=2) {
                //make burn
            }
        }
    }
}
