package game;

public class Enemy {
    private String name;
    private int hp;

    public Enemy(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public boolean isDead() { return hp <= 0; }
    public void takeDamage(int dmg) { hp -= dmg; }
}