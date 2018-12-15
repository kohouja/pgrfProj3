package c_02_utery_18_15.view;

import javax.swing.*;
import java.awt.*;

public class PgrfWindow extends JFrame {
    private JButton para, ortho, cube, pyramid, spiral, animation;
    private Raster raster;

    public PgrfWindow() {
        // bez tohoto nastavení se okno zavře, ale aplikace stále běží na pozadí
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Raster.WIDTH, Raster.HEIGHT); // velikost okna
        setLocationRelativeTo(null);// vycentrovat okno
        setTitle("PGRF1 cvičení"); // titulek okna

        raster = new Raster();
        raster.setFocusable(true);
        raster.grabFocus();
        add(raster); // vložit plátno do okna



    }

    public Raster getRaster() {
        return raster;
    }
}
