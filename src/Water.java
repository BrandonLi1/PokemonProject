public class Water extends PokemonType{
    public Water(int level, int health, String name) {
        super(level, health, name);
    }


    public void Aquajet(){
        setAccuracy(100);
        if (checkHit()) {
            setPower(40);
            checkDamage();//returns number for damage
        }
    }
    public void Aquaring(){
        setAccuracy(100);
        if (checkHit()) {
            setHealth(getHealth() + 10);
        }
    }
    public void Bubble(){
        setAccuracy(100);
        if(checkHit()){
            setPower(40);
            checkDamage();

        }
    }
    public void Hydropump(){
        setAccuracy(80);
        if(checkHit()){
            setPower(110);
            checkDamage();
        }
    }
    public void Bubblebeam(){
        setAccuracy(100);
        if(checkHit()){
            setPower(65);
        }
    }
    public void Razorshell(){
        setAccuracy(95);
        if(checkHit()){
            setPower(95);
            checkDamage();
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
