package BL;

import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class PlayerModel extends AbstractTableModel{
    private LinkedList<Player> players = new LinkedList<>();
    private String[]colNames = {"Name","Attack","Defense","HP"};

    public void add(Player p){
        players.add(p);
        fireTableDataChanged();
    }
    
    
    @Override
    public int getRowCount() {
        return players.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return players.get(rowIndex);
    }
    

}
