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
        setupBoard();
        play();
    }
    private void createPlayer() {
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        player = new Player(name);
        if (name.equals("Z")) {
            player.party[0]=new PokemonType(100, 297, "Charizard", false);
            player.party[1]=new PokemonType(100, 299, "Blastoise", false);
            player.party[2]=new PokemonType(100, 301, "Venusaur", false);
        } else {
            StartWindow x =  new StartWindow();
                try {
                    synchronized (StartWindow.window) {
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
                board[i][j]= new Space("_");
            }
        }
        board[0][19]=new Space("G");
        board[19][0]=player;
        board[19][19]=new Space("P");
        for (int i = 1; i < 19; i++) {
            for (int j = 18; j >0; j--) {
                double x = Math.random();
                if (x<=.3) {
                    board[i][j]=new Space("#");
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
        while (board[0][19] != player) {
            printBoard();
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter a direction(W, A, S, D): ");
                String move = scanner.nextLine().toUpperCase();

                if (move.equals("W")) {
                    if (y != 0) {
                        checkPokemon("W");
                        temp=board[y-1][x];
                        validInput = true;
                    } else {
                        System.out.println("You will go out of bounds!");
                    }
                } else if (move.equals("A")) {
                    if (y != 0) {
                        checkPokemon("A");
                        temp=board[y][x-1];
                        validInput = true;
                    } else {
                        System.out.println("You will go out of bounds!");
                    }
                } else if (move.equals("S")) {
                    if (y != 19) {
                        checkPokemon("S");
                        temp=board[y+1][x];
                        validInput = true;
                    } else {
                        System.out.println("You will go out of bounds!");
                    }
                } else if (move.equals("D")) {
                    if (x != 19) {
                        checkPokemon("D");
                        temp=board[y][x+1];
                        validInput = true;
                    } else {
                        System.out.println("You will go out of bounds!");
                    }
                } else {
                    System.out.println("INVALID MOVE! Try again.");
                }

                if (temp.equals("#")) {
                    board[]
                } else {

                }
                board[]
            }

            /*
            if (move.equals("W")) {
                if (y != 0) {
                    checkPokemon("W");
                    temp=board[y-1][x];
                    if (temp.getSymbol().equals("#")) {
                        board[y][x] = new Space("#");
                    } else {
                        board[y][x]= new Space("_");
                    }
                    board[y-1][x] = player;
                } else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("A")) {
                if (x != 0) {
                    checkPokemon("A");
                    temp=board[y][x-1];
                    if (temp.getSymbol().equals("#")) {
                        board[y][x] = new Space("#");
                    } else {
                        board[y][x]= new Space("_");
                    }
                    board[y][x - 1] = player;

                }else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("S")) {
                if (y != 19) {
                    checkPokemon("S");
                    temp=board[y+1][x];
                    if (temp.getSymbol().equals("#")) {
                        board[y][x] = new Space("#");
                    } else {
                        board[y][x]= new Space("_");
                    }
                    board[y+1][x] = player;
                }else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("D")) {
                if (x != 19) {
                    checkPokemon("D");
                    temp=board[y-1][x+1];
                    if (temp.getSymbol().equals("#")) {
                        board[y][x] = new Space("#");
                    } else {
                        board[y][x]= new Space("_");
                    }
                    board[y][x + 1] = player;
                }else {
                    System.out.println("Out of bounds");
                }
            }
*/
            if (move.equals("WWSSADADBA")) { //funny konami code cheat code
                System.out.println(player.party[0].getName());
            }
        }
        //run the gym fight
    }
    private void checkPokemon(String move) {
        playerPosition();
        int x= (int)(Math.random()*10);
        if (move.equals("W")) {
            if (board[y-1][x].getSymbol().equals("#")) {
               grassCheck();
            }
        }
        if (move.equals("A")) {
            if (board[y][x-1].getSymbol().equals("#")) {
                grassCheck();
            }
        }
        if (move.equals("S")) {
            if (board[y+1][x].getSymbol().equals("#")) {
               grassCheck();
            }
        }
        if (move.equals("D")) {
            if (board[y][x+1].getSymbol().equals("#")) {
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

    public void encounter() {
        //window for fight
    }

    private int playerY() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c].equals(player)) {
                    return r;
                }
            }
        }
    }

    private int playerX() {
        for (Space[] spaces : board) {
            for (int c = 0; c < board[0].length; c++) {
                if (spaces[c].equals(player)) {
                    return c;
                }
            }
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



}
