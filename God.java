package game;

import java.util.*;

public enum God {
    ZEUS("Zeus", "Aggressive playstyle"),
    ATHENA("Athena", "Tactical & defensive"),
    ARES("Ares", "High offense, berserker"),
    APOLLO("Apollo", "Supportive, healing, ranged"),
    HADES("Hades", "Dark, draining, evasive");

    public final String name;
    public final String desc;

    God(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public static God choose(Scanner scanner) {
        System.out.println("[Choose your sponsor constellation]");
        int i = 1;
        for (God god : God.values()) {
            System.out.printf("%d. %s – %s%n", i++, god.name, god.desc);
        }
        int choice = Utils.readInt(scanner, 1, God.values().length);
        return God.values()[choice - 1];
    }
}