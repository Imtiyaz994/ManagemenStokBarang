package storage.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;

public class TableStyler {
    
    public static void style(JTable t) {
        t.getTableHeader().setBackground(new Color(0, 102, 102));
        t.getTableHeader().setForeground(Color.WHITE);
        t.getTableHeader().setPreferredSize(new Dimension(t.getTableHeader().getWidth(), 25));
        t.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        t.getTableHeader().setReorderingAllowed(false);
        t.setDefaultEditor(Object.class, null);
        t.setRowHeight(25);
        t.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        t.setBackground(Color.WHITE); 
        t.setFillsViewportHeight(true);
    }
}