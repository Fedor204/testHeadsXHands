import java.util.Random;

public class Creature {
    private int attack;
    private int defense;
    private int health;
    private int minDamage;
    private int maxDamage;

    public Creature(int attack, int defense, int health, int minDamage, int maxDamage) {
        setAttack(attack);
        setDefense(defense);
        setHealth(health);
        setMinDamage(minDamage);
        setMaxDamage(maxDamage);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Урон не может быть отрицательным");
        }

        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public int calculateAttackModifier(Creature target) {
        return Math.max(getAttack() - target.getDefense() + 1, 1);
    }

    public int calculateDamage() {
        Random random = new Random();
        return random.nextInt(getMaxDamage() - getMinDamage() + 1) + getMinDamage();
    }

    public boolean attemptAttack(Creature target) {
        int attackModifier = calculateAttackModifier(target);
        int numCube = Math.max(attackModifier, 1);
        Random random = new Random();

        for (int i = 0; i < numCube; i++) {
            int roll = random.nextInt(6) + 1;
            if (roll >= 5) {
                int damage = calculateDamage();
                target.takeDamage(damage);
                return true;
            }
        }
        return false;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 1 || attack > 30) {
            throw new IllegalArgumentException("Неверное значение для атаки");
        }
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if (defense < 1 || defense > 30) {
            throw new IllegalArgumentException("Неверное значение для защиты");
        }
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("Здоровье не может быть отрицательным");
        }
        this.health = health;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        if (minDamage < 1) {
            throw new IllegalArgumentException("Минимальный урон не может быть меньше 1");
        }
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        if (maxDamage < 1 || maxDamage < minDamage) {
            throw new IllegalArgumentException("Неверное значение для максимального урона");
        }
        this.maxDamage = maxDamage;
    }
}
