import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class CreatePokemon {
    private static ArrayList<PokemonType> pokemon = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public CreatePokemon() {
        try {
            File myFile = new File("src\\Copy of indexable pokedex - Pokedex.csv");
            Scanner fileScanner = new Scanner(myFile);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] splitdata = data.split(",");
                String name = splitdata[0];
                String health = splitdata[2];
                String type = splitdata[3];
                String stage = splitdata[4];
                String evolve = splitdata[5];
                if (type.equals("Fire")) {
                    pokemon.add(new Fire((int)(Math.random()*18+1), Integer.parseInt(health), name, stage, evolve));
                } else if (type.equals("Water")) {
                    pokemon.add(new Water((int)(Math.random()*18+1), Integer.parseInt(health), name, stage, evolve));
                } else {
                    pokemon.add(new Grass((int)(Math.random()*18+1), Integer.parseInt(health), name, stage, evolve));
                }
            }
            fileScanner.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static ArrayList<PokemonType> getPokemon() {
        return pokemon;
    }
}






