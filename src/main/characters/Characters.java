package main.characters;

import java.util.Objects;

public abstract class Characters implements Attack {

    private String name;
    private int strength;
    private int dexterity;
    private int stamina;
    private int health;
    private int xp;
    private int gold;

    public Characters(String name, int strength, int dexterity, int stamina, int heals, int xp, int gold) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.stamina = stamina;
        this.health = heals;
        this.xp = xp;
        this.gold = gold;
    }

    @Override
    public int attackTheEnemy() {
        if (dexterity * 3 > getRandom()) {
            return strength;
        } else {
            return 0;
        }
    }

    public int getRandom() {
        return (int) (Math.random() * 100);
    }

//    @Override
//    public String toString() {
//        return "Characters {" +
//                "name='" + name + '\'' +
//                ", strength=" + strength +
//                ", dexterity=" + dexterity +
//                ", stamina=" + stamina +
//                ", heals=" + heals +
//                ", xp=" + xp +
//                ", gold=" + gold +
//                '}';
//    }

    @Override
    public String toString() {
        return String.format("%s, здоровье: %d", name, health);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Characters that = (Characters) o;
        return strength == that.strength &&
                dexterity == that.dexterity &&
                stamina == that.stamina &&
                health == that.health &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, strength, dexterity, stamina, health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
