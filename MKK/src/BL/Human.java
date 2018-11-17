package BL;

import java.util.Random;

public class Human extends Player{
    
    public Human(String name) {
        super(name,93.0,40.0,150.0);
    }

    @Override
    public void fight(Player p) {
        Random rand = new Random();
        if(rand.nextInt(2-1+1)==1){
            double dmg = this.getAttack();
            p.setHp((p.getHp()-(dmg-p.getDefense())));
            dmg = p.getAttack();
            this.setHp((this.getHp()-(dmg-this.getDefense())));
        }else{
            double dmg = p.getAttack();
            this.setHp((this.getHp()-(dmg-this.getDefense())));
            dmg = this.getAttack();
            p.setHp((p.getHp()-(dmg-p.getDefense())));
        }
    }

    @Override
    public void addItem(Item i) {
        this.getItems().add(i);
    }

    @Override
    public void removeItem(Item i) {
        this.getItems().remove(i);
    }
    
}
