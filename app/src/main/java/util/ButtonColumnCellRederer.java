
package util;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

public class ButtonColumnCellRederer extends DefaultTableCellRenderer{
    
    private String buttonType;
    
    public ButtonColumnCellRederer(String buttonType){
        this.buttonType = buttonType;
    }
    
    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
 
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(table, value,  isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(CENTER);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/"+ buttonType + ".png")));
        return label;
    }   
}
