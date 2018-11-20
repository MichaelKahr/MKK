package Player;

import Player.Player;
import java.io.Serializable;
import java.util.Random;

public class Orc extends Player implements Serializable{

    public Orc(String name) {
        super(name, 69.0, 60.0, 155.0);
    }

}
