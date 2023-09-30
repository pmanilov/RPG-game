package Model;

import Exception.InvalidArgumentException;
import java.util.Random;

public class Creature {
    protected String name;
    protected int defence;
    protected int attack;
    protected int health;
    protected int maxHealth;
    protected int minDamage;
    protected int maxDamage;
    protected boolean alive;

    public Creature(String name, int defence, int attack, int maxHealth, int minDamage, int maxDamage) {
        validateDefence(defence);
        validateAttack(attack);
        validateHealth(maxHealth);
        validateMinMaxDamage(minDamage, maxDamage);
        this.name = name;
        this.defence = defence;
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.alive = true;
    }

    public void attack(Creature creature) {
        if(!this.alive){
            return;
        }
        System.out.println(this.name + " attacks "+creature.name);
        int modifier = this.attack - creature.defence + 1;
        Random random = new Random();
        for (int i = 0; i < modifier; i++) {
            int toss = random.nextInt(6);
            if(toss >= 4) {
                creature.health -= random.nextInt(this.maxDamage - this.minDamage + 1) + this.minDamage;
            }
        }
        if(creature.health <= 0) {
            creature.alive = false;
            System.out.println(creature.name + " is dead");
        }
    }

    protected void validateDefence(int value) {
        if(value < 1 || value > 30) {
            throw new InvalidArgumentException("Invalid value of defence");
        }
    }

    protected void validateAttack(int value) {
        if(value < 1 || value > 30) {
            throw new InvalidArgumentException("Invalid value of attack");
        }
    }

    protected void validateHealth(int value) {
        if(value < 1) {
            throw new InvalidArgumentException("Negative value of maximum health");
        }
    }

    protected void validateMinMaxDamage(int minDamage, int maxDamage) {
        if(minDamage < 1 || maxDamage < 1) {
            throw new InvalidArgumentException("Negative value of  damage");
        }
        if(minDamage > maxDamage) {
            throw new InvalidArgumentException("Maximum damage may be more than minimum damage");
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        validateMinMaxDamage(minDamage, this.maxDamage);
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        validateMinMaxDamage(this.minDamage, maxDamage);
        this.maxDamage = maxDamage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        validateDefence(defence);
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        validateAttack(attack);
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        validateHealth(health);
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public  void setMaxHealth(int maxHealth) {
        validateHealth(maxHealth);
        this.maxHealth = maxHealth;
    }
}
