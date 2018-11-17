package BL;

public abstract class Item {

    private double deltaAttack;
    private double deltaDefense;

    public Item(double deltaAttack, double deltaDefense) {
        this.deltaAttack = deltaAttack;
        this.deltaDefense = deltaDefense;
    }

    public double getDeltaAttack() {
        return deltaAttack;
    }

    public double getDeltaDefense() {
        return deltaDefense;
    }

    public void setDeltaAttack(double deltaAttack) {
        this.deltaAttack = deltaAttack;
    }

    public void setDeltaDefense(double deltaDefense) {
        this.deltaDefense = deltaDefense;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f,%.2f)", this.getClass().getSimpleName(), this.deltaAttack, this.deltaDefense);
    }

}
