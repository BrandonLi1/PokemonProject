import java.util.Scanner;


public class GridGame {
    private Space[][] board;
    private Player player;
    private Scanner scanner;
    private int y;
    private int x;


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
        for (int i = 1; i < 18; i++) {
            if (Math.random()>=.2) {
                board[i][(int) (Math.random()*19)] = new Pokemon("#");
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
            System.out.print("Enter a direction(W, A, S, D): ");
            String move = scanner.nextLine();
            if (move.equals("W")) {
                if (y != 0) {
                    checkPokemon("W");
                    board[y][x] = new Space(tile(y, x-1));
                    board[y-1][x] = player;
                } else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("A")) {
                if (x != 0) {
                    checkPokemon("A");
                    board[y][x] = new Space(tile(y, x-1));
                    board[y][x - 1] = player;

                }else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("S")) {
                if (y != 19) {
                    checkPokemon("S");
                    board[y][x] = new Space(tile(y, x-1));
                    board[y+1][x] = player;
                }else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("D")) {
                if (x != 19) {
                    checkPokemon("D");
                    board[y][x] = new Space(tile(y, x-1));
                    board[y][x + 1] = player;
                }else {
                    System.out.println("Out of bounds");
                }
            }

            if (move.equals("WWDDLRLRBA")) { //funny konami code cheat code

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

    private String tile(int y, int x) {
        return board[x][y].getSymbol();
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
