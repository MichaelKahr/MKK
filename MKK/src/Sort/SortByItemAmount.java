package Sort;

import Player.Player;
import java.util.Comparator;

public class SortByItemAmount implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {
        if(o1.getItems().size()<o1.getItems().size()){
            return 1;
        }else if(o1.getItems().size()>o2.getItems().size()){
            return -1;
        }else{
            return 0;
        }
    }



}
