package BL;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class PlayerRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Player p = (Player)value;
        JLabel label = new JLabel();
        label.setOpaque(true);
        if(p==null) return label;
        
        switch(column){
            case 0: label.setText(""+p.getName());break;
            case 1: label.setText(""+p.getAttack());break;
            case 2: label.setText(""+p.getDefense());break;
            case 3: label.setText(""+p.getHp());break;
        }
        
        return label;
        
    }

}
