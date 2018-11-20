package Player;

import java.io.Serializable;
import java.util.Random;

public class Human extends Player implements Serializable{

    public Human(String name) {
        super(name, 93.0, 40.0, 150.0);
    }

}
