import java.util.Scanner;
public class PokeCenter extends Space{
    Scanner scanner = new Scanner(System.in);
    public PokeCenter(String symbol){
        super(symbol);
    }
    public void Healpokemon(){
        String response = "";
        System.out.print("Do you want me to heal all your pokemon? :) (yes / no):");
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
    public void Buyitems(){
        String response = "";
        int response2 = 0;
        System.out.print("Do you wish to se our catalog of items? (yes / no): ");
        response = scanner.nextLine();
        if(response.equals("yes")){
            System.out.println("here is all the items you can buy");
            System.out.println("1. potion");
            System.out.println("2. pokeball");
            System.out.print("type the number of the item you wish to buy: ");
            response2 = scanner.nextInt();
            if(response2 == 1){
                // add potion item to the inventory
                Player.addItemBag(new Potions(0,1,25));
            } else if(response2 == 2){
                Player.addItemBag(new Pokeballs(0,1,25));
                // add pokeball to the inventory
            } else {
                System.out.println("invalid entry");
            }
            // set all the pokemon in your inventory to have maximum ghealth
        } else if(response.equals("no")){
            System.out.println("please come again");
        } else {
            System.out.println("invalid entry");
        }

    }
}
