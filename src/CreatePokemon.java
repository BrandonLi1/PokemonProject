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
            File myFile = new File("Copy of indexable pokedex - Pokedex.csv");
            Scanner fileScanner = new Scanner(myFile);
            fileScanner.nextLine();
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] splitdata = data.split(",");
                String name = splitdata[0];
                String pokedex = splitdata[1];
                String health = splitdata[2];
                String type = splitdata[3];
                String stage = splitdata[4];
                String evolve = splitdata[5];
                if (type.equals("Fire")) {
                    pokemon.add(new Fire(0, Integer.parseInt(health), name, stage, evolve));
                } else if (type.equals("Water")) {
                    pokemon.add(new Water(0, Integer.parseInt(health), name, stage, evolve));
                } else {
                    pokemon.add(new Grass(0, Integer.parseInt(health), name, stage, evolve));
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






