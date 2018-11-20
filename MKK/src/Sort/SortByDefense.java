package Sort;

import Player.Player;
import java.util.Comparator;

public class SortByDefense implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getDefense() < o2.getDefense()) {
            return 1;
        } else if (o1.getDefense() > o2.getDefense()) {
            return -1;
        } else {
            return 0;
        }
    }

}
