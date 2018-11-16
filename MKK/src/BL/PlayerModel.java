package BL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    public void save(File f) throws FileNotFoundException, IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Player player : players) {
            oos.writeObject(oos);
        }
        oos.flush();
        oos.close();
    }
    public void load(File f) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream iis = new ObjectInputStream(new FileInputStream(f));
        Player p;
        while((p = (Player) iis.readObject())!=null){
            add(p);
        }
    }

}
