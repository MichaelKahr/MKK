package BL;

import java.util.LinkedList;

public abstract class Player {
    protected double attack;
    protected double defense;
    protected double hp;
    protected String name;
    protected LinkedList<Item> items = new LinkedList<>();

    public Player(String name,double attack, double defense, double hp) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        
    }
    
    public abstract void fight(Player p);
    
    public abstract void addItem(Item i);
    
    public abstract void removeItem(Item i);

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Item> getItems() {
        return items;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }
    
    
}
