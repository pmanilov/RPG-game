package Model;

import Exception.InvalidArgumentException;
import java.util.Random;

public class Creature {
    private String name;
    private int defence;
    private int attack;
    private int health;
    private int maxHealth;
    private int minDamage;
    private int maxDamage;
    private boolean alive;

    public Creature(String name, int defence, int attack, int maxHealth, int minDamage, int maxDamage) {
        this.name = name;
        this.setDefence(defence);
        this.setAttack(attack);
        this.setMaxHealth(maxHealth);
        this.setHealth(maxHealth);
        this.validateMinMaxDamage(minDamage, maxDamage);
        this.setMinDamage(minDamage);
        this.setMaxDamage(maxDamage);
        this.alive = true;
    }

    public void attack(Creature creature) {
        if(!this.alive){
            return;
        }
        System.out.println(this.name + " attacks "+ creature.name);
        int modifier = this.attack - creature.defence >= 0 ? this.attack - creature.defence + 1 : 1;
        Random random = new Random();
        for (int i = 0; i < modifier; i++) {
            int toss = random.nextInt(6);
            if(toss >= 4) {
                creature.health -= random.nextInt(this.maxDamage - this.minDamage + 1) + this.minDamage;
                break;
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

    protected void validateDamage(int damage) {
        if(damage < 1){
            throw new InvalidArgumentException("Negative value of  damage");
        }
    }

    protected void validateMinMaxDamage(int minDamage, int maxDamage) {
        if(minDamage > maxDamage) {
            throw new InvalidArgumentException("Maximum damage may be more than minimum damage");
        }
    }

    public boolean isAlive() {
        return alive;
    }

    protected void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getMinDamage() {
        return minDamage;
    }

    protected void setMinDamage(int minDamage) {
        validateDamage(minDamage);
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    protected void setMaxDamage(int maxDamage) {
        validateDamage(maxDamage);
        this.maxDamage = maxDamage;
    }

    public int getDefence() {
        return defence;
    }

    protected void setDefence(int defence) {
        validateDefence(defence);
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    protected void setAttack(int attack) {
        validateAttack(attack);
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        validateHealth(health);
        if(health > maxHealth) {
            throw new InvalidArgumentException("Health can`t be more than maximum health");
        }
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    protected  void setMaxHealth(int maxHealth) {
        validateHealth(maxHealth);
        this.maxHealth = maxHealth;
    }
}
