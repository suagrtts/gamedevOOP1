package game;

import java.util.*;

public class Combat {
    private Player player;
    private Narrator narrator;
    private Scanner scanner;

    public Combat(Player player, Narrator narrator, Scanner scanner) {
        this.player = player;
        this.narrator = narrator;
        this.scanner = scanner;
    }

    public void fightWave(String enemyName, int enemyHp, int waves) {
        for (int i = 1; i <= waves; i++) {
            narrator.narrate("Wave " + i + ": " + enemyName + " appears!");
            Enemy enemy = new Enemy(enemyName, enemyHp);
            while (!enemy.isDead() && !player.isDead()) {
                narrator.combatPrompt(player, enemy);
                int choice = Utils.readInt(scanner, 1, 4); // 1=Attack, 2=Defend, etc.
                switch (choice) {
                    case 1: // Attack
                        int dmg = 15 + godBonusDamage(player.getGod());
                        enemy.takeDamage(dmg);
                        narrator.attackSuccess(dmg, enemy);
                        break;
                    case 2: // Defend
                        narrator.narrate("You brace for impact. Slightly less damage this turn.");
                        break;
                    case 3: // Skill
                        useSkill(enemy);
                        break;
                    case 4: // Item
                        narrator.narrate("No items in inventory.");
                        break;
                }
                if (!enemy.isDead()) {
                    int enemyDmg = 10;
                    if (choice == 2) enemyDmg -= 4;
                    if (enemyDmg < 0) enemyDmg = 0;
                    player.takeDamage(enemyDmg);
                    narrator.enemyAttack(enemy, enemyDmg, player);
                }
            }
            if (player.isDead()) {
                narrator.narrate("You fell in battle. The gods are disappointed.");
                return;
            }
        }
    }

    private int godBonusDamage(God god) {
        if (god == God.ZEUS || god == God.ARES) return 5;
        return 0;
    }

    private void useSkill(Enemy enemy) {
        God god = player.getGod();
        switch (god) {
            case APOLLO:
                narrator.narrate("Apollo's light restores you!");
                player.heal(12);
                break;
            case HADES:
                narrator.narrate("Hades drains the enemy's life!");
                enemy.takeDamage(7);
                player.heal(7);
                break;
            case ATHENA:
                narrator.narrate("Athena's wisdom lets you anticipate the next attack.");
                break;
            default:
                narrator.narrate("No special skills unlocked yet.");
        }
    }
}