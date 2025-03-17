import java.util.Scanner;
public class PokeCenter extends Space{
    public PokeCenter(String symbol){
        super(symbol);
    }
    public void Healpokemon(){
        String response = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want me to heal all your pokemon? :) (yes / no):");
        response = scanner.nextLine();
        if(response.equals("yes")){
            System.out.println("I will now heal all your pokemon");
            // set all the pokemon in your inventory to have maximum ghealth
        } else if(response.equals("no")){
            System.out.println("please come again");
        } else {
            System.out.println("invalid entry");
        }
    }
}
