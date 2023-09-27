import java.util.Random;

public class Entity {

    private int attack;
    private int defense;
    private int health;
    private int damageMin;
    private int damageMax;


    public Entity(int attack, int defense, int health, int damageMin, int damageMax){
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be < 0");
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public int attack() {
        int attackModifier = attack - defense + 1;
        attackModifier = Math.max(attackModifier, 1);
        Random random = new Random();
        int damage = random.nextInt(damageMax - damageMin + 1) + damageMin;
        return (random.nextInt(6) < 2) ? attackModifier * damage : 0;
    }

    public void heal() {
        int maxHealth = 100;
        int healAmount = (int) (maxHealth * 0.3);
        if (health + healAmount > maxHealth) {
            health = maxHealth;
        } else {
            health += healAmount;
        }
    }

    public int getHealth(){
        return health;
    }
}