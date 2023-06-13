package it.unipv.po.progettogamemanager.view;

import javax.swing.*;
import java.awt.*;

public class ColourLabel extends JLabel {
    public ColourLabel(String stringa, Color colore){
        super(stringa);
        setOpaque(true);
        setBackground(colore);
    }

}
