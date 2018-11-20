package BL;

import Player.Player;
import Sort.SortByName;
import Sort.SortByAttack;
import Sort.SortByDefense;
import Sort.SortByHP;
import Sort.SortByItemAmount;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class PlayerModel extends AbstractTableModel {

    private LinkedList<Player> players = new LinkedList<>();
    private String[] colNames = {"Type", "Name", "Attack", "Defense", "HP"};

    public void add(Player p) {
        players.add(p);
        fireTableDataChanged();
    }

    public void delete(Player p) {
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
            oos.writeObject(player);
        }
        oos.flush();
        oos.close();
    }

    public void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try {
            Player p;
            while ((p = (Player) ois.readObject()) != null) {
                add(p);
            }
        } catch (EOFException eof) {

        }
    }
    
    public void SortByName(){
        Collections.sort(players, new SortByName());
        fireTableDataChanged();
    }
    public void SortByItemAmount(){
        Collections.sort(players, new SortByItemAmount());
        fireTableDataChanged();
    }
    public void SortByHP(){
        Collections.sort(players,new SortByHP());
        fireTableDataChanged();
    }
    public void SortByAttack(){
        Collections.sort(players, new SortByAttack());
        fireTableDataChanged();
    }
    public void SortByDefense(){
        Collections.sort(players, new SortByDefense());
        fireTableDataChanged();
    }

}
