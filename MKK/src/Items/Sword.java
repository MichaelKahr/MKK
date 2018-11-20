package Items;

import java.io.Serializable;

public class Sword extends Item implements Serializable{

    public Sword(double deltaAttack, double deltaDefense) {
        super(deltaAttack, deltaDefense);
    }

}
