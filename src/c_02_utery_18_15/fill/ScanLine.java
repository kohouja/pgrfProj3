package c_02_utery_18_15.fill;

import c_02_utery_18_15.model.Edge;
import c_02_utery_18_15.model.Point;
import c_02_utery_18_15.view.Raster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScanLine implements Filler {

    private Raster raster;
    private List<Point> points;
    private int fillColor, edgeColor;

    @Override
    public void setRaster(Raster raster) {
        this.raster = raster;
    }

    @Override
    public void fill() {
        scanline();
    }

    public void init(List<Point> points, int fillColor, int edgeColor){
        this.points = points;
        this.fillColor = fillColor;
        this.edgeColor = edgeColor;
    }

    private void scanline() {

        List<Edge> edges = new ArrayList<>();
        // projet všechny body a vytvořit z nich hrany (jako polygon)
        // 0. a 1. bod budou první hrana; 1. a 2. bod budou druhá hrana
        // ...; poslední a 0. bod budou poslední hrana
        // ignorovat vodorovné hrany
        // vytvořené hrany zorientovat a přidat do seznamu

        // najít minimum a maximum pro Y
        int minY = points.get(0).y;
        int maxY = minY;
        // projet všechny body a najít minimální a maximální Y

        // pro všechna Y od min do max včetně
        for (int y = minY; y <= maxY; y++) {

            List<Integer> intersections = new ArrayList<>();
            // projít všechny hrany
            // pokud hrana má průsečík pro dané Y
            // tak vypočítáme průsečík a uložíme hodnotu do seznamu

            Collections.sort(intersections);
            // nebo volitelně implementovat vlastní algoritmus na seřazení

            // vybarvení mezi průsečíky
            // spojení vždy sudého s lichým
            // 0. a 1.; 2. a 3.;...
        }

        // obtáhnutí hranice
        //renderer.drawPolygon(points, edgeColor);
    }
}
