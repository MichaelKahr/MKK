package Items;

import java.io.Serializable;

public class Shield extends Item implements Serializable{

    public Shield(double deltaAttack, double deltaDefense) {
        super(deltaAttack, deltaDefense);
    }

}
