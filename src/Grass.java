public class Grass extends PokemonType{
    public Grass(int level, int health, String name) {
        super(level, health, name, false);
    }

    public void absorb(PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(20);
            if (target instanceof Fire) {
                setPower(40);
            } else if (target instanceof Grass) {
                setPower(10);
            }
            checkDamage();//returns number for damage
            target.setHealth((int) (getHealth() + (.5 * checkDamage())));
        }
    }

    public void bulletSeed(PokemonType target) {
        int totalDmg = 0;
        int shots = (int) (Math.random() * 4 + 2);
        setAccuracy(25);
        setPower(5);
        while (shots >= 0) {
            if (checkHit()) {
                totalDmg += checkDamage();
            }
            shots--;
        }
        target.setHealth((int) (getHealth() + (.5 * totalDmg)));
    }

    public void magicalLeaf(PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(60);
            if (target instanceof Fire) {
                setPower(120);
            } else if (target instanceof Grass) {
                setPower(30);
            }
            checkDamage();
            target.setHealth((int) (getHealth() + (.5 * checkDamage())));
        }
    }

    public void razorLeaf(PokemonType target) {
        setAccuracy(95);
        if (checkHit()) {
            setPower(55);
            checkDamage();
            target.setHealth((int) (getHealth() + (.5 * checkDamage())));
        }
    }

    public void leafTornado(PokemonType target) {
        setAccuracy(90);
        if (checkHit()) {
            setPower(65);
            if (target instanceof Fire) {
                setPower(130);
            } else if (target instanceof Grass) {
                setPower(33);
            }
            checkDamage();
            target.setHealth((int) (getHealth() + (.5 * checkDamage())));
        }
    }

    public void solarBeam(PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(60);
            if (target instanceof Fire) {
                setPower(120);
            } else if (target instanceof Grass) {
                setPower(30);
            }
            checkDamage();
            target.setHealth((int) (getHealth() + (.5 * checkDamage())));
        }
    }
}
