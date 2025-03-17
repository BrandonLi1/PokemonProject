import java.util.Scanner;


public class GridGame {
    private Space[][] board;
    private Player player;
    private Scanner scanner;
    private int y;
    private int x;


    public GridGame() {
        scanner = new Scanner(System.in);
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
        board=new Space[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]= new Space("_");
            }
        }
        board[0][7]=new Space("X");
        board[7][0]=player;
        for (int i = 1; i < 6; i++) {
            if (Math.random()>=.5) {
                board[i][(int) (Math.random()*8)] = new Pokemon("#", //pokemontype);
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
        while (board[0][7] != player) {
            printBoard();
            System.out.print("Enter a direction(W, A, S, D): ");
            String move = scanner.nextLine();
            if (move.equals("W")) {
                if (y != 0) {
                    checkPokemon("W");
                    player.move();
                    board[y-1][x] = player;
                    board[y][x] = new Space("_");
                } else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("A")) {
                if (x != 0) {
                    checkPokemon("A");
                    player.move();
                    board[y][x - 1] = player;
                    board[y][x] = new Space("_");
                }else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("S")) {
                if (y != 7) {
                    checkPokemon("S");
                    player.move();
                    board[y+1][x] = player;
                    board[y][x] = new Space("_");
                }else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("D")) {
                if (x != 7) {
                    checkPokemon("D");
                    player.move();
                    board[y][x + 1] = player;
                    board[y][x] = new Space("_");
                }else {
                    System.out.println("Out of bounds");
                }
            }
            if (move.equals("WWDDLRLRBA")) { //funny konami code cheat code

            }
        }
        System.out.println("You win!");
        System.out.println("Score: " + player.getScore());
        System.out.println("Moves: " + player.getMoves());
    }
    private void checkPokemon(String move) {
        playerPosition();
        int x= (int)(Math.random()*10);
        if (move.equals("W")) {
            if (board[y-1][x].getSymbol().equals("#")) {
                if (x==0) {

                }
            }
        }
        if (move.equals("A")) {
            if (board[y][x-1].getSymbol().equals("#")) {
                if (x==0) {

                }
            }
        }
        if (move.equals("S")) {
            if (board[y+1][x].getSymbol().equals("#")) {
                if (x==0) {

                }
            }
        }
        if (move.equals("D")) {
            if (board[y][x+1].getSymbol().equals("#")) {
                if (x==0) {

                }
            }
        }
    }

    private void encounter() {

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
