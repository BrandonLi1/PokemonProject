public class Water extends PokemonType{
    public Water(int level, int health, String name) {
        super(level, health, name,false);
    }


    public void Aquajet(PokemonType target){
        setAccuracy(100);
        if (checkHit()) {
            setPower(40);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);//returns number for damage
        }
    }
    public void Aquaring(PokemonType target){
        setAccuracy(100);
        if (checkHit()) {
            setHealth(getHealth() + 10);
        }
    }
    public void Bubble(PokemonType target){
        setAccuracy(100);
        if(checkHit()){
            setPower(40);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);

        }
    }
    public void Hydropump(PokemonType target){
        setAccuracy(80);
        if(checkHit()){
            setPower(110);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
        }
    }
    public void Bubblebeam(PokemonType target){
        setAccuracy(100);
        if(checkHit()){
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);setPower(65);
        }
    }
    public void Razorshell(PokemonType target){
        setAccuracy(95);
        if(checkHit()){
            setPower(95);
            int damage=(int)(checkDamage()*checkEffective(target));
            target.setCurrentHealth(target.getCurrentHealth()-damage);
        }
    }
    private double checkEffective(PokemonType target){
        if(target instanceof Fire){
            return 2;
        } else if (target instanceof  Grass){
            return 0.5;
        } else {
            return 1;
        }
    }
}
