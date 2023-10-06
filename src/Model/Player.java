package Model;

import Exception.InvalidArgumentException;

public class Player extends Creature {
    private int healCount;

    public Player(String name, int defence, int attack, int maxHealth, int minDamage, int maxDamage) throws InvalidArgumentException {
        super(name, defence, attack, maxHealth, minDamage, maxDamage);
        this.healCount = 0;
    }

    public void heal() {
        if(!this.isAlive()){
            return;
        }
        if(healCount < 4) {
            int healthAfterHealing = (int) (this.getHealth() + this.getMaxHealth() * 0.3);
            healCount++;
            if (healthAfterHealing > this.getMaxHealth()) {
                healthAfterHealing = this.getMaxHealth();
            }
            this.setHealth(healthAfterHealing);
        } else {
            System.out.println("The number of healing has been exhausted");
        }
    }

    public int getHealCount() {
        return healCount;
    }
}