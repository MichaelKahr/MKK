package BL;

import Player.Human;
import Player.Orc;
import Player.Player;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class PlayerRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Player p = (Player) value;
        JLabel label = new JLabel();
        label.setOpaque(true);
        if (p == null) {
            return label;
        }

        if (p instanceof Orc) {
            label.setBackground(Color.lightGray);
        } else {
            label.setBackground(new Color(152, 251, 152));
        }
        if (p.getHp() == 0.0) {
            label.setBackground(Color.red);
        }
        if (isSelected) {
            label.setBackground(new Color(100, 149, 237));
        }

        switch (column) {
            case 0:
                if(p instanceof Human){
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Human.jpg")));
                }
                else if(p instanceof Orc){
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Orc.png")));
                }
                break;
            case 1:
                label.setText("" + p.getName());
                break;
            case 2:
                label.setText("" + p.getAttack());
                break;
            case 3:
                label.setText("" + p.getDefense());
                break;
            case 4:
                label.setText("" + p.getHp());
                break;
        }

        return label;

    }

}
