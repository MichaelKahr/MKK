package BL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class PlayerModel extends AbstractTableModel {

    private LinkedList<Player> players = new LinkedList<>();
    private String[] colNames = {"Type", "Name", "Attack", "Defense", "HP"};

    public void add(Player p) {
        players.add(p);
        fireTableDataChanged();
    }

    public void delte(Player p) {
        players.remove(p);
        fireTableDataChanged();
    }

    public void fight(Player p1, Player p2) throws Exception {
        p1.fight(p2);
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

    public LinkedList<Player> getPlayers() {
        return players;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return players.get(rowIndex);
    }

    public void save(File f) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Player player : players) {
            oos.writeObject(oos);
        }
        oos.flush();
        oos.close();
    }

    public void load(File f) {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals("Orc")) {
                    add(new Orc(""));
                }
                add(new Human(""));
                fireTableDataChanged();
            }

        } catch (Exception e) {

        }
        System.out.println("test");
    }

}
