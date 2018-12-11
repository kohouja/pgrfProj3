package c_02_utery_18_15.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Raster extends JPanel {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private static final int FPS = 1000 / 30;
    private final BufferedImage bi;
    private final Graphics g;

    public Raster() {
        // inicializace image, nastavení rozměrů (nastavení typu - pro nás nedůležité)
        bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = bi.getGraphics();
        setLoop();

//        TODO vytvori metodu raster draw string pro predani parametru atd...
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, null);
        // pro zájemce - co dělá observer - https://stackoverflow.com/a/1684476
    }

    private void setLoop() {
        // časovač, který 30 krát za vteřinu obnoví obsah plátna aktuálním img
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // říct plátnu, aby zobrazilo aktuální img
                repaint();
            }
        }, 0, FPS);
    }

    public void clear() {
        g.setColor(Color.BLACK);
        g.clearRect(0, 0, WIDTH, HEIGHT);
    }

    public void drawPixel(int x, int y, int color) {
        // nastavit pixel do img
        bi.setRGB(x, y, color);
    }

    public int getPixel(int x, int y) {
        return bi.getRGB(x, y);
    }

    public void drawLine(double x1, double y1,
                         double x2, double y2, Color color) {

        g.setColor(color);
        g.drawLine(
                (int) Math.round(x1),
                (int) Math.round(y1),
                (int) Math.round(x2),
                (int) Math.round(y2)
        );
    }
}
