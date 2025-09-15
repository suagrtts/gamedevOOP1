package game;

public class Narrator {
    public void prologue() {
        System.out.println("[System] You have entered a world already written. But the gods are watching. Your role is not yet fixed.");
        System.out.println("World premise: Humanity is being tested through “Scenarios” created by the Olympians.");
    }

    public void godSelection() {
        System.out.println("[System] Choose your sponsor constellation.");
    }

    public void godChosen(God god) {
        System.out.printf("[System] You are chosen by %s. %s%n", god.name, god.desc);
    }

    public void systemMessage(String msg) { System.out.println("[System] " + msg); }
    public void narrate(String msg) { System.out.println(msg); }
    public void combatPrompt(Player player, Enemy enemy) {
        System.out.printf("Your HP: %d | %s HP: %d%n", player.getHp(), enemy.getName(), enemy.getHp());
        System.out.println("1. Attack  2. Defend  3. Skill  4. Item");
    }
    public void attackSuccess(int dmg, Enemy enemy) {
        System.out.printf("You dealt %d damage to %s.%n", dmg, enemy.getName());
    }
    public void damage(int dmg, int hp) {
        if (hp > 0)
            System.out.printf("You took %d damage. [HP: %d]%n", dmg, hp);
        else
            System.out.println("You were defeated. The gods yawn.");
    }
    public void heal(int amount, int hp) {
        System.out.printf("Apollo’s blessing activates! You heal %d HP. [HP: %d]%n", amount, hp);
    }
    public void enemyAttack(Enemy enemy, int dmg, Player player) {
        System.out.printf("%s attacks you for %d damage!%n", enemy.getName(), dmg);
    }
    public void favorUpdate(God god, int amount, int total) {
        System.out.printf("%s approves! [Favor +%d] (Total Favor: %d)%n", god.name, amount, total);
    }
    public void blessingUnlocked(Blessing blessing) {
        System.out.printf("New Blessing Unlocked: %s - %s%n", blessing.getName(), blessing.getDesc());
    }
    public void death() {
        System.out.println("[System] You have died. The story ends here.");
    }
    public void ending(Player player) {
        System.out.println("You have completed all Scenarios! Your fate: To be continued...");
    }
}