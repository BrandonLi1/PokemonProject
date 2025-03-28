public class Grass extends PokemonType{
    public Grass(int level, int health, String name,String stage, String evolve) {
        super(level, health, name);
    }

    public void absorb( PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(20);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
        }
    }

    public void bulletSeed( PokemonType target) {
        int totalDmg = 0;
        int shots = (int) (Math.random() * 4 + 2);
        setAccuracy(25);
        setPower(5);
        while (shots >= 0) {
            if (checkHit()) {
                totalDmg += (int)(checkDamage()*checkEffective(target));
            }
            shots--;
        }
        target.setCurrentHealth(target.getCurrentHealth()-totalDmg);
    }

    public void magicalLeaf( PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(60);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
        }
    }

    public void razorLeaf( PokemonType target) {
        setAccuracy(95);
        if (checkHit()) {
            setPower(55);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
        }
    }

    public void leafTornado( PokemonType target) {
        setAccuracy(90);
        if (checkHit()) {
            setPower(65);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
        }
    }

    public void solarBeam( PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(60);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
        }
    }

    private double checkEffective(PokemonType target) {
        if (target instanceof Water) {
            return 2;
        }
        if (target instanceof Fire) {
            return .5;
        }
        return 1;
    }
}
