public class Game {
    public static void main(String[] args) {
        Player player = new Player(20,5,100,5,20);
        Monster monster = new Monster(15,5,70,3,15);

        int damage = player.attack();
        if (damage > 0){
            monster.takeDamage(damage);
            monster.heal();
        }
    }
}
