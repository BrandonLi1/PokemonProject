public class Fire extends PokemonType{
    int move1;
    int move2;
    int move3;
    int move4;

    public Fire(int level, int health, String name,String stage, String evolve) {
        super(level, health, name,stage);
        move1=moveList[0];
        move2=moveList[1];
        move3=moveList[2];
        move4=moveList[3];
    }

    //moves as methods

    public void Flamethrower(PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(90);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
            if (Math.random()*10==0 && !(target instanceof Fire)) {
                target.setBurning(true);
            }
        }
    }

    public void BlazingTorque (PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(80);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
            if (Math.random()*10<=2 && !(target instanceof Fire)) {
                target.setBurning(true);
            }
        }
    }

    public void Eruption(PokemonType target) {
        setAccuracy(100);
        if (checkHit()) {
            setPower(150);
            int damage = (int)((checkDamage()*((double)getHealth()/getCurrentHealth())*checkEffective(target)));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
        }
    }

    public void Inferno( PokemonType target) {
        setAccuracy(50);
        if (checkHit()) {
            setPower(100);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
            if (!(target instanceof Fire)) {
                target.setBurning(true);
            }
        }
    }

    public void BlueFlare( PokemonType target) {
        setAccuracy(85);
        if (checkHit()) {
            setPower(130);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
            if (Math.random()*10<=1 && !(target instanceof Fire)) {
                target.setBurning(true);
            }
        }
    }

    public void HeatWave( PokemonType target) {
        setAccuracy(90);
        if (checkHit()) {
            setPower(95);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
            if (Math.random()*10==0 && !(target instanceof Fire)) {
               target.setBurning(true);
            }
        }
    }

    private double checkEffective(PokemonType target) {
       if (target instanceof Grass) {
           return 2;
       }
       if (target instanceof Water) {
           return .5;
       }
       return 1;
    }


}
