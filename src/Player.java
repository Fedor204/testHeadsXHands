public class Player extends Creature {
    private int maxHealth;
    private int healCount;

    public Player(int attack, int defense, int health, int minDamage, int maxDamage, int maxHealth, int healCount) {
        super(attack, defense, health, minDamage, maxDamage);
        if (maxHealth < 1  || healCount < 0 || healCount > 4) {
            throw new IllegalArgumentException("Неверные аргументы функции для игрока.");
        }
        this.maxHealth = maxHealth;
        this.healCount = healCount;
    }

    public void heal() {
        if (healCount > 0 && getHealth() > 0) {
            int healAmount = (int) (maxHealth * 0.3);
            setHealth(Math.min(getHealth() + healAmount, maxHealth));
            healCount--;
        }
    }
}
