import Model.Monster;
import Model.Player;

import Exception.InvalidArgumentException;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidArgumentException {
        System.out.println("Enter your name:");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        System.out.println("""
                Please, select a class:
                1)Heavy knight(high defence, low attack)
                2)Rogue(high attack, low defence)
                3)Balanced warrior(medium attack and defence)""");
        int playerClass = in.nextInt();
        Player player;
        if(playerClass == 1) {
            player = new Player(name, 20, 10, 100, 10, 20);
        } else if (playerClass == 2) {
            player = new Player(name, 10, 20, 100, 20, 30);
        } else if (playerClass == 3) {
            player = new Player(name, 15, 15, 100, 15, 25);
        } else {
            System.out.println("Incorrect class, try again");
            return;
        }
        int n = 0;
        Random random = new Random();
        while (player.isAlive()) {
            System.out.println("Your HP: " + player.getHealth());
            System.out.println("Healing left: " + (4 - player.getHealCount()));
            System.out.println(name + ", you meet monster. Enter 1 to fight, 2 to heal");
            int action = in.nextInt();
            if(action == 2) {
                player.heal();
                continue;
            } else if(action != 1) {
                System.out.println("Incorrect action");
                continue;
            }
            n++;
            Monster monster = new Monster("Monster " + n,
                    player.getAttack() - random.nextInt(3) - 1,
                    player.getDefence() + random.nextInt(3) + 1,
                    random.nextInt(100) + 1,
                    random.nextInt(5) + 1,
                    random.nextInt(7) + 5);
            while (player.isAlive() && monster.isAlive()) {
                player.attack(monster);
                monster.attack(player);
            }
        }
        System.out.println(name + ", you have defeated " + (n - 1) + " monsters");
    }
}