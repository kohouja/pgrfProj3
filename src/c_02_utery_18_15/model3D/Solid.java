package c_02_utery_18_15.model3D;

import transforms.Point3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Solid {

    final List<Point3D> vertices = new ArrayList<>();
    final List<Integer> indices = new ArrayList<>();
    Color color;
    boolean isAxe;

    public List<Point3D> getVertices() {
        return vertices;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public Color getColor() {
        return color;
    }

    public boolean isAxe() {
        return isAxe;
    }
}
