package storage.component;

import java.awt.Component;
import java.awt.Graphics;

public interface Icon {
    public void paintIcon (Component cmpnt, Graphics grphcs, int i, int il);
    
    public int getIconWidth();
    
    public int getIconHeight();
}
