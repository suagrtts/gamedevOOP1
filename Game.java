package game;

import java.util.*;

public class Game {
    private Player player;
    private Narrator narrator = new Narrator();
    private List<Scenario> scenarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        narrator.prologue();
        godSelection();
        createScenarios();
        for (Scenario scenario : scenarios) {
            scenario.play(player, narrator, scanner);
            if (player.isDead()) {
                narrator.death();
                return;
            }
        }
        narrator.ending(player);
    }

    private void godSelection() {
        narrator.godSelection();
        God god = God.choose(scanner);
        narrator.godChosen(god);
        player = new Player(god, narrator);
    }

    private void createScenarios() {
        scenarios.add(new Scenario1());
        scenarios.add(new Scenario2());
        // You can add more Scenario objects here for further story progression
    }
}