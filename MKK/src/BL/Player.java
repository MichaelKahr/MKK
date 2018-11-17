package BL;

import GUI.MkkGUI;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;

public abstract class Player {

    protected double attack;
    protected double defense;
    protected double hp;
    protected String name;
    protected LinkedList<Item> items = new LinkedList<>();
    protected static ImageIcon icon;

    public Player(String name, double attack, double defense, double hp) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;

    }

    public void fight(Player p) throws Exception{
        
        if(this.getHp()==0.0||p.getHp()==0.0){
            throw new Exception("One player is dead, you can't fight with them");
        }
        Random rand = new Random();
        if (rand.nextInt(2 - 1 + 1) == 1) {
            double dmg = this.getAttack();
            p.setHp((p.getHp() - (dmg - p.getDefense())));
            dmg = p.getAttack();
            this.setHp((this.getHp() - (dmg - this.getDefense())));
        } else {
            double dmg = p.getAttack();
            this.setHp((this.getHp() - (dmg - this.getDefense())));
            dmg = this.getAttack();
            p.setHp((p.getHp() - (dmg - p.getDefense())));
        }
        if (this.getHp() < 0.0) {
            this.setHp(0.0);
        }
        if (p.getHp() < 0.0) {
            p.setHp(0.0);
        }
    }

    public void addItem(Item i) {
        this.getItems().add(i);
        this.setAttack(this.attack + i.getDeltaAttack());
        this.setDefense(this.defense + i.getDeltaDefense());
        MkkGUI.model.fireTableDataChanged();
    }

    public void removeItem(Item i) {
        this.getItems().remove(i);
        this.setAttack(this.attack - i.getDeltaAttack());
        this.setDefense(this.defense - i.getDeltaDefense());
        MkkGUI.model.fireTableDataChanged();
    }

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
