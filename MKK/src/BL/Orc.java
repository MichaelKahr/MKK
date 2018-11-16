package BL;

public class Orc extends Player{

    public Orc(String name) {
        super(name,30,60,180);
    }

    @Override
    public void fight(Player p) {
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
