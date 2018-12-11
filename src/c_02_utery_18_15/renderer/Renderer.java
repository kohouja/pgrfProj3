package c_02_utery_18_15.renderer;

import c_02_utery_18_15.model.Point;
import c_02_utery_18_15.view.Raster;
import transforms.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Renderer {

    private Raster raster;

    public Renderer(Raster raster) {
        this.raster = raster;
    }

    public void drawLine(int x1, int y1, int x2, int y2, int color) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        float k = dy / (float) dx;
        // https://www.google.com/search?q=java+dividing+two+integers
        float q = y1 - k * x1;

        if (Math.abs(k) < 1) {
            // řídící osa X

            if (x2 < x1) {
                int x3 = x2;
                x2 = x1;
                x1 = x3;
            }

            for (int x = x1; x <= x2; x++) {
                float y = k * x + q;
                int ry = Math.round(y);
                raster.drawPixel(x, ry, color);
            }
        } else {
            // řídící osa Y

        }
    }

    public void drawDDA(int x1, int y1, int x2, int y2, int color) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        float x, y, k, h, g;

        k = dy / (float) dx;
        if (Math.abs(k) < 1) {
            // řídící osa X
            g = 1;
            h = k;
            if (x1 > x2) {
                x1 = x2;
                y1 = y2;
            }
        } else {
            // řídící osa Y
            g = 1 / k;
            h = 1;
            if (y1 > y2) {
                x1 = x2;
                y1 = y2;
            }
        }

        x = x1;
        y = y1;

        for (int i = 0; i <= Math.max(Math.abs(dx), Math.abs(dy)); i++) {
            raster.drawPixel(Math.round(x), Math.round(y), color);
            x += g;
            y += h;
        }
    }

    public void drawPolygon(List<Point> polygonPoints, int color) {
        for (int i = 0; i < polygonPoints.size() - 1; i++) {
            drawDDA(polygonPoints.get(i).x,
                    polygonPoints.get(i).y,
                    polygonPoints.get(i + 1).x,
                    polygonPoints.get(i + 1).y,
                    color
            );
        }
        // spoj poslední a první
        drawDDA(polygonPoints.get(0).x,
                polygonPoints.get(0).y,
                polygonPoints.get(polygonPoints.size() - 1).x,
                polygonPoints.get(polygonPoints.size() - 1).y,
                color
        );
    }

    public void drawLines(List<Point2D> linePoints, int color) {
        for (int i = 0; i < linePoints.size() - 1; i += 2) {
            drawDDA((int) linePoints.get(i).getX(),
                    (int) linePoints.get(i).getY(),
                    (int) linePoints.get(i + 1).getX(),
                    (int) linePoints.get(i + 1).getY(),
                    color
            );
        }
    }

    public List<Point> clip(List<Point> polygon, List<Point> clipPolygon) {
        // in - seznam vtcholů ořezávaného polygonu (na tabuli je ten černý)
        // clipPoints - seznam vrcholů ořezávacího polygonu (na tabuli ten zelený)
        // out - seznam vrcholů ořezaného polygonu (na tabuli ten čárkovaný)

        List<Point> in = polygon;

        Point p1 = null; // vlož poslední clip point
        for (Point p2 : clipPolygon) {
            List<Point> out = new ArrayList<>();
            // vytvoř hranu z bodů p1 a p2
            // Point v1 = in.last
            for (Point v2 : in) {
                // TODO algoritmus
            }
            p1 = p2;
            in = out; // aktualizuj ořezávaný polygon
        }

        return in;
    }
}
