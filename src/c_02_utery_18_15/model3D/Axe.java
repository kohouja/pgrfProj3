package c_02_utery_18_15.model3D;

import c_02_utery_18_15.model.Point;
import transforms.Point3D;

import java.awt.*;

public class Axe extends Solid{

    public Axe(Color color, Point3D point1, Point3D point2) {
        this.isAxe = true;
        this.color = color;

        vertices.add(point1);
        vertices.add(point2);

        indices.add(0); indices.add(1);

    }

}
