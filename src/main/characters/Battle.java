package main.characters;

public class Battle {

    public void fight(Characters hero, Characters monster) {

        Runnable runnable = () -> {
            int turn = 1;
            boolean isEndOfTheFight = false;

            while (!isEndOfTheFight) {
                System.out.println("Ход: " + turn);

                if (turn++ % 2 != 0) {
                    isEndOfTheFight = makeAnAttack(monster, hero);
                } else {
                    isEndOfTheFight = makeAnAttack(hero, monster);
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private boolean makeAnAttack(Characters defender, Characters attacker) {
        int hitAttack = attacker.attackTheEnemy();
        int healthDamage = defender.getHealth() - hitAttack;

        if (hitAttack != 0) {
            System.out.printf("%s нанес урон в %d %n", attacker.getName(), hitAttack);
            System.out.printf("У %s осталось %d ХП %n", defender.getName(), healthDamage);
        } else {
            System.out.printf("%s промахнулся %n", attacker.getName());
        }

        if (healthDamage <= 0 && defender instanceof MainHero) {
            System.out.println("YOU DIED");
        } else if (healthDamage <= 0) {
            System.out.printf("Вы убили врага: +%d XP +%d Gold %n", defender.getXp(), defender.getGold());
            attacker.setXp(attacker.getXp() + defender.getXp());
            attacker.setGold(attacker.getGold() + defender.getGold());
        } else {
            defender.setHealth(healthDamage);
        }
    }
}
