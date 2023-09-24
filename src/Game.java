public class Game {
    public static void main(String[] args) {
        try {
            Player player = new Player(20, 15, 100, 10, 20, 100, 4);
            Monster monster = new Monster(21, 14, 90, 12, 19);

            while (player.isAlive() && monster.isAlive()) {
                boolean playerAttacked = player.attemptAttack(monster);
                boolean monsterAttacked = monster.attemptAttack(player);

                if (playerAttacked) {
                    System.out.println("Игрок атакует монстра");
                } else {
                    System.out.println("Игрок не попал");
                }

                if (monsterAttacked) {
                    System.out.println("Монстер атакует игрока");
                } else {
                    System.out.println("Монстер не попал");
                }

                System.out.println("Здоровье игрока: " + player.getHealth());
                System.out.println("Здоровье монстра: " + monster.getHealth());

                player.heal();
            }

            if (player.isAlive()) {
                System.out.println("Игрок выиграл!");
            } else {
                System.out.println("Монстер выиграл!");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
