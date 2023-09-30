package Model;

public class Player extends Creature{
    private int healCount;

    public Player(String name, int defence, int attack, int maxHealth, int minDamage, int maxDamage) {
        super(name, defence, attack, maxHealth, minDamage, maxDamage);
        this.healCount = 0;
    }

    public void heal() {
        if(!this.alive){
            return;
        }
        if(healCount < 4) {
            this.health += this.maxHealth * 0.3;
            healCount++;
            if (this.health > this.maxHealth) {
                this.health = this.maxHealth;
            }
        } else {
            System.out.println("The number of healing has been exhausted");
        }
    }

    public int getHealCount() {
        return healCount;
    }
}