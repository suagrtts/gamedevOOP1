package game;

import java.util.*;

public class Scenario1 extends Scenario {
    @Override
    public void play(Player player, Narrator narrator, Scanner scanner) {
        narrator.systemMessage("Scenario 1: Survive the Trial of Olympus");
        narrator.narrate("Waves of minor monsters appear!");

        Combat combat = new Combat(player, narrator, scanner);
        combat.fightWave("Goblin", 20, 3);

        if (!player.isDead()) {
            narrator.narrate("You survived the first trial! The gods murmur in approval.");
            player.addFavor(10);
        }
    }
}