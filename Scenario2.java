package game;

import java.util.*;

public class Scenario2 extends Scenario {
    @Override
    public void play(Player player, Narrator narrator, Scanner scanner) {
        narrator.systemMessage("Scenario 2: The Labyrinth of the Minotaur");
        narrator.narrate("A monstrous Minotaur blocks your path. Solve the puzzle or fight!");

        narrator.narrate("Puzzle: What walks on four legs in the morning, two at noon, and three in the evening?");
        String answer = scanner.next().toLowerCase();
        if (answer.contains("man")) {
            narrator.narrate("Athena approves of your wisdom. [Favor +10]");
            player.addFavor(10);
        } else {
            narrator.narrate("Wrong! The Minotaur attacks!");
            Combat combat = new Combat(player, narrator, scanner);
            combat.fightWave("Minotaur", 40, 1);
            if (!player.isDead()) {
                narrator.narrate("You defeated the Minotaur by force!");
                player.addFavor(5);
            }
        }
    }
}