package Model;

import Exception.InvalidArgumentException;

public class Monster extends Creature {
    public Monster(String name, int defence, int attack, int maxHealth, int minDamage, int maxDamage) throws InvalidArgumentException {
       super(name, defence, attack, maxHealth, minDamage, maxDamage);
    }
}