package game;

import java.util.*;

public class Player {
    private God god;
    private int hp = 100;
    private int favor = 0;
    private List<Blessing> blessings = new ArrayList<>();
    private Narrator narrator;

    public Player(God god, Narrator narrator) {
        this.god = god;
        this.narrator = narrator;
    }

    public God getGod() { return god; }
    public int getHp() { return hp; }
    public int getFavor() { return favor; }
    public List<Blessing> getBlessings() { return blessings; }

    public void addFavor(int amount) {
        favor += amount;
        narrator.favorUpdate(god, amount, favor);
    }

    public void heal(int amount) {
        hp = Math.min(100, hp + amount);
        narrator.heal(amount, hp);
    }

    public void takeDamage(int damage) {
        hp -= damage;
        narrator.damage(damage, hp);
    }

    public boolean isDead() { return hp <= 0; }

    public void addBlessing(Blessing blessing) {
        blessings.add(blessing);
        narrator.blessingUnlocked(blessing);
    }
}