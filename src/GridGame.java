import java.util.Scanner;

public class GridGame {
    private Space[][] board;
    public static Player player;
    private Scanner scanner;
    private int y;
    private int x;
    private Space temp;


    public GridGame() {
        scanner = new Scanner(System.in);
    }

    public void Start() {
        createPlayer();
//        CreatePokemon create = new CreatePokemon();
//        for(int i = 0; i < CreatePokemon.getPokemon().size() ; i ++){
//            System.out.println(CreatePokemon.getPokemon().get(i).getName());
//            System.out.println(CreatePokemon.getPokemon().get(i).getClass());
//        }
        setupBoard();
        play();


    }

    private void createPlayer() {
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine().toUpperCase();
        String introduction =
                "The sun rises over " + coloredText.YELLOW + "Velmara" + coloredText.RESET + ", casting golden light across the land. " +
                "\nToday is the day you've been waiting for, the day you finally begin your journey as a " + coloredText.GREEN + "Pokémon Trainer" + coloredText.RESET + "!" +
                "\nWith your first Pokémon by your side, you set out toward " + coloredText.CYAN + "Crestforge City" + coloredText.RESET + "," +
                "\nwhere a powerful " + coloredText.RED + "Gym Leader" + coloredText.RESET + " awaits. " +
                "\nBut the road won't be easy. Wild Pokémon lurk in the tall grass. To prove yourself, you'll need to train and win battles. " +
                "\nWill you rise to the challenge and claim victory at the gym? Your path to greatness starts now!";
        try {
            for (int i = 0; i < introduction.length(); i++) {
                System.out.print(introduction.charAt(i));
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        player = new Player("😎");
        if (name.equals("DRAGON")) {
            player.party[0]=new Fire(100, 297, "Charizard", "3", "n");
            player.party[1]=new Water(100, 299, "Blastoise", "3", "n");
            player.party[2]=new Grass(100, 301, "Venusaur", "3", "n");
        } else {
            StartWindow x =  new StartWindow();
                try {
                    synchronized (StartWindow.window) { //http://scaler.com/topics/java-wait/
                        while (StartWindow.window.isVisible()) {
                            StartWindow.window.wait(10);
                        }

                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
    }


    private void setupBoard() {
        board=new Space[20][20];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]= new Space("⬜");
            }
        }
        board[0][19]=new Space("\uD83C\uDFDF\uFE0F");
        board[19][0]=player;
        board[19][19]=new Space("🏥");
        for (int i = 1; i < 19; i++) {
            for (int j = 18; j >0; j--) {
                double x = Math.random();
                if (x<=.3) {
                    board[i][j]=new Space("🌿");
                }
            }
        }
    }
    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getSymbol());
            }
            System.out.println();
        }
    }


    // plays the game;
    public void play() {
        setupBoard();
        playerPosition();
        int count=0;
        while (board[0][19] != player) {
            if (board[19][19]!=player) {
                board[19][19]=new Space("🏥");
            }
            printBoard();
                System.out.print("Enter a direction(W, A, S, D): ");
                String move = scanner.nextLine().toUpperCase();
                if (move.equals("W")) {
                    if (y != 0) {
                        checkPokemon("W");
                        if (count>=1 && temp.getSymbol().equals("🌿")) {
                            board[y][x] = new Space("🌿");
                        } else {
                            board[y][x] = new Space("⬜");
                        }
                        temp = board[y - 1][x];
                        board[y - 1][x] = player;
                        playerPosition();
                        count++;
                    } else {
                        System.out.println("Out of bounds");
                    }
                }
                if (move.equals("A")) {
                    if (x != 0) {
                        checkPokemon("A");

                        if (count>=1 && temp.getSymbol().equals("🌿")) {
                            board[y][x] = new Space("🌿");
                        } else {
                            board[y][x] = new Space("⬜");
                        }
                        temp = board[y][x - 1];
                        board[y][x - 1] = player;
                        playerPosition();
                        count++;
                    } else {
                        System.out.println("Out of bounds");
                    }
                }
                if (move.equals("S")) {
                    if (y != 19) {
                        checkPokemon("S");

                        if (count>=1 && temp.getSymbol().equals("🌿")) {
                            board[y][x] = new Space("🌿");
                        } else {
                            board[y][x] = new Space("⬜");
                        }
                        temp = board[y + 1][x];
                        board[y + 1][x] = player;
                        playerPosition();
                        count++;
                    } else {
                        System.out.println("Out of bounds");
                    }
                }
                if (move.equals("D")) {
                    if (x != 19) {
                        checkPokemon("D");

                        if (count>=1 && temp.getSymbol().equals("🌿")) {
                            board[y][x] = new Space("🌿");
                        } else {
                            board[y][x] = new Space("⬜");
                        }
                        temp = board[y][x + 1];
                        board[y][x + 1] = player;
                        playerPosition();
                        count++;
                    } else {
                        System.out.println("Out of bounds");
                    }
                }
            if (move.equals("WWSSADADBA")) { //funny konami code cheat code
                if (temp!=null) {
                    board[y][x] = temp;
                } else {
                    board[y][x]=new Space("⬜");
                }
                for (int i = 0; i < 6 && player.party[i]!=null; i++) {
                    player.party[i].setXp(25502500);
                    player.party[i].checkLevelUp();
                    player.party[i].setCurrentHealth(player.party[i].getHealth());
                    board[19][0]=new Space("⬜");
                    board[0][18]=player;
                    playerPosition();
                    count++;
                }
                temp=board[y][x];
                count--;
            }
            if (board[y][x]==board[19][19]) {
                System.out.print("Do you want to enter the Pokecenter?(y/n): ");
                String check = scanner.nextLine().toLowerCase();
                if (check.equals("y")) {
                    PokeCenter pokeCenter = new PokeCenter("🏥");
                }
                System.out.println("Come back soon");
                board[19][18]=player;
                board[19][19]=new Space("🏥");
                playerPosition();
            }
        }
        try {
            Thread.sleep(500);
            System.out.print("You see the gym leader");
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        ASCIIART.gymLeader();
        System.out.println();
        String gymDialogue =
                        coloredText.RED + "Gym Leader" + coloredText.RESET + ": Took you long enough. I was starting to think you got lost.\n" +
                        coloredText.GREEN + "Trainer" + coloredText.RESET + ": Had to take a few detours. Some Pokémon on the way wouldn’t let me pass without a battle.\n" +
                        coloredText.RED + "Gym Leader" + coloredText.RESET + ": That’s how it goes. Every step forward should be earned, not given. And now you’re here, facing the final obstacle.\n" +
                        coloredText.GREEN + "Trainer" + coloredText.RESET + ": I didn’t come all this way to turn back now.\n" +
                        coloredText.RED + "Gym Leader" + coloredText.RESET + ": Good. Because I don’t hold back, and I don’t expect my challengers to, either. This isn’t just about raw strength—it’s about" +
                                          "\n            how well you and your Pokémon work together under pressure.\n" +
                        coloredText.GREEN + "Trainer" + coloredText.RESET + ": We’ve been through plenty already. We’re ready for whatever you throw at us.\n" +
                        coloredText.RED + "Gym Leader" + coloredText.RESET + ": Then let’s find out if you’ve really got what it takes.\n" +
                        coloredText.GREEN + "Trainer" + coloredText.RESET + ": Let’s battle!\n";
        try {
            for (int i = 0; i < gymDialogue.length(); i++) {
                System.out.print(gymDialogue.charAt(i));
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Gym gym = new Gym();
    }
    private void checkPokemon(String move) {
        playerPosition();
        if (move.equals("W")) {
            if (board[y-1][x].getSymbol().equals("🌿")) {
               grassCheck();
            }
        }
        if (move.equals("A")) {
            if (board[y][x-1].getSymbol().equals("🌿")) {
                grassCheck();
            }
        }
        if (move.equals("S")) {
            if (board[y+1][x].getSymbol().equals("🌿")) {
               grassCheck();
            }
        }
        if (move.equals("D")) {
            if (board[y][x+1].getSymbol().equals("🌿")) {
              grassCheck();
            }
        }
    }

    public void grassCheck() {
        int x=(int)(Math.random()*10);
        if (x==0) {
            encounter();
        }
    }

    public void encounter() {//wip
       FightWindow x = new FightWindow(RandomEncounter.getEncounter());
       x.createGameScreen();
        try {
            synchronized (this) {
                while (FightWindow.screen.isVisible()) {
                    this.wait(10);
                }

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void playerPosition() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (player==board[i][j]) {
                    y=i;
                    x=j;
                }
            }
        }
    }

    private void gymFight() {
        //construct gym thing
    }
}
