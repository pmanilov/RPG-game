package Model;

import Exception.InvalidArgumentException;
import java.util.Random;

public class Creature {
    private final String name;
    private int defence;
    private int attack;
    private int health;
    private int maxHealth;
    private int minDamage;
    private int maxDamage;
    private boolean alive;

    public Creature(String name, int defence, int attack, int maxHealth, int minDamage, int maxDamage) throws InvalidArgumentException {
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

    protected void validateMinMaxDamage(int minDamage, int maxDamage) throws InvalidArgumentException {
        if(minDamage > maxDamage) {
            throw new InvalidArgumentException("Maximum damage may be more than minimum damage");
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public String getName() {
        return name;
    }

    public int getMinDamage() {
        return minDamage;
    }

    protected void setMinDamage(int minDamage) throws InvalidArgumentException {
        if(minDamage < 1){
            throw new InvalidArgumentException("Negative value of  damage");
        }
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    protected void setMaxDamage(int maxDamage) throws InvalidArgumentException{
        if(maxDamage < 1){
            throw new InvalidArgumentException("Negative value of  damage");
        }
        this.maxDamage = maxDamage;
    }

    public int getDefence() {
        return defence;
    }

    protected void setDefence(int defence) throws InvalidArgumentException {
        if(defence < 1 || defence > 30) {
            throw new InvalidArgumentException("Invalid value of defence");
        }
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    protected void setAttack(int attack) throws InvalidArgumentException {
        if(attack < 1 || attack > 30) {
            throw new InvalidArgumentException("Invalid value of attack");
        }
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) throws InvalidArgumentException {
        if(health < 1) {
            throw new InvalidArgumentException("Negative value of maximum health");
        }
        if(health > this.maxHealth) {
            throw new InvalidArgumentException("Health can`t be more than maximum health");
        }
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    protected  void setMaxHealth(int maxHealth) throws InvalidArgumentException {
        if(maxHealth < 1) {
            throw new InvalidArgumentException("Negative value of maximum health");
        }
        this.maxHealth = maxHealth;
    }
}