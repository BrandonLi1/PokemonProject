import java.util.Scanner;
public class PokeCenter extends Space{
    Scanner scanner = new Scanner(System.in);
    public PokeCenter(String symbol){
        super(symbol);
        System.out.print("Do you want to visit the shop or heal?(s/h): ");
        String x =scanner.nextLine().toLowerCase();
        if (x.equals("s")) {
            buyItems();
        } else if (x.equals("h")) {
            healPokemon();
        } else {
            System.out.println("invalid");
        }
    }

    public void healPokemon(){
        String response = "";
        System.out.print("Do you want me to heal all your pokemon?(yes / no):");
        response = scanner.nextLine();
        if(response.equals("yes")){
            System.out.println("I will now heal all your pokemon");
            for (int i = 0; i < 6; i++) {
                if (Player.party[i]!=null && !Player.party[i].getName().equals("test")) {
                    Player.party[i].setCurrentHealth(Player.party[i].getHealth());
                }
            }
        } else if(response.equals("no")){
            System.out.println("please come again");
        } else {
            System.out.println("invalid entry");
        }
    }

    public void buyItems(){
        String response = "";
        int response2 = 0;
        System.out.print("Do you wish to see our catalog of items?(yes / no): ");
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
        } else if(response.equals("no")){
            System.out.println("please come again");
        } else {
            System.out.println("invalid entry");
        }

    }
}
