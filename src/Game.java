import java.util.Scanner;
import java.lang.Math;

public class Game {
    private Player player;
    private Dot dot1;
    private Dot dot2;
    private Dot dot3;
    private Exit exit;
    private Enemy enemy;
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int chances = 0;
        System.out.print("Initial x: ");
        int x = scanner.nextInt();
        while (chances < 2 && x < 0){
            System.out.println("Must not be negative.");
            System.out.print("Initial x: ");
            x = scanner.nextInt();
            chances++;
        }
        if (chances == 2 && x < 0){
            System.out.println("Too many errors. Exiting.");
        }
        else{
            chances = 0;
            System.out.print("Initial y: ");
            int y = scanner.nextInt();
            while (chances < 2 && y < 0){
                System.out.println("Must not be negative.");
                System.out.print("Initial y: ");
                y = scanner.nextInt();
                chances++;
            }
             if (chances == 2 && y < 0){
                System.out.println("Too many errors. Exiting.");
             }
             else{
                 Game game = new Game(x, y);
                 game.start();
             }
        }
    }

    public Game(int initX, int initY){
        player = new Player(initX, initY);
        dot1 = new Dot(1, 1);
        dot2 = new Dot(2, 2);
        dot3 = new Dot(3, 3);
        exit = new Exit(4, 4);
        if (initX == 5){
            enemy = new Enemy(5, 5);
        }
    }
    
    public void move(int dx, int dy){
        player.move(dx, dy);
        player.collect(dot1);
        player.collect(dot2);
        player.collect(dot3);
        if (enemy != null){
            if ((enemy.getX() - player.getX()) > (enemy.getY() - player.getY())){
                if (enemy.getX() > player.getX()){
                    enemy.move(-1, 0);
                }
                else{
                    enemy.move(1, 0);
                }
            }
            else if ((enemy.getY() - player.getY()) > (enemy.getX() - player.getX())){
                if (enemy.getY() > player.getY()){
                    enemy.move(0, -1);
                }
                else{
                    enemy.move(0, 1);
                }
            }
            else{
                enemy.move(0, 0);
            }
        }
    }
    
    private void start(){
        //move(0, 0);
        while (exit.isNotOpen() && player.isNotKilled()){
            System.out.println(this);
            input();
            if ((player.getX() == exit.getX() && player.getY() == exit.getY()) && player.getDots() == 3){
                if (enemy != null && (player.getX() == enemy.getX() && player.getY() == enemy.getY())){
                    exit.openExit();
                    System.out.println(this);
                    System.out.println("You win!");
                }
                else{
                    exit.openExit();
                    System.out.println(this);
                    System.out.println("You win!");
                }
            }
            else if (player.getX() == enemy.getX() && player.getY() == enemy.getY()){
                player.killed();
                System.out.println(this);
                System.out.println("You lose!");
            }
            else if ((Math.abs(enemy.getX() - player.getX()) == 1) && enemy.getY() == player.getY()){
                player.killed();
                System.out.println(this);
                System.out.println("You lose!");
            }
            else if ((Math.abs(enemy.getY() - player.getY()) == 1) && enemy.getX() == player.getX()){
                player.killed();
                System.out.println(this);
                System.out.println("You lose!");
            }
        }
    }
    
    private void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Move (l/r/u/d): ");
        String move = scanner.nextLine();
        switch(move){
            case "l": move(-1, 0); break;
            case "r": move(1, 0); break;
            case "u": move(0, -1); break;
            case "d": move(0, 1); break;
            default : System.out.println("Invalid move");
        }
    }
    
    @Override
    public String toString(){
        if (enemy == null){
            return player + " " + dot1 + " " + dot2 + " " + dot3 + " " + exit;
        }
        return player + " " + dot1 + " " + dot2 + " " + dot3 + " " + exit + " " + enemy; 
    }
}