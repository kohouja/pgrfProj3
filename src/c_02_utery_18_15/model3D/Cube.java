package c_02_utery_18_15.model3D;

import transforms.Point3D;

import java.awt.*;

public class Cube extends Solid {

    public Cube() {
        this(Color.GREEN);
    }

    public Cube(Color color) {
        this.isAxe = false;
        this.color = color;
        vertices.add(new Point3D(-1,-1,1));
        vertices.add(new Point3D(1,-1,1));
        vertices.add(new Point3D(1,1,1));
        vertices.add(new Point3D(-1,1,1));

        vertices.add(new Point3D(-1,-1,-1));
        vertices.add(new Point3D(1,-1,-1));
        vertices.add(new Point3D(1,1,-1));
        vertices.add(new Point3D(-1,1,-1));

        indices.add(0); indices.add(1);
        indices.add(1); indices.add(2);
        indices.add(2); indices.add(3);
        indices.add(3); indices.add(0);

        indices.add(4); indices.add(5);
        indices.add(5); indices.add(6);
        indices.add(6); indices.add(7);
        indices.add(7); indices.add(4);

        indices.add(0); indices.add(4);
        indices.add(1); indices.add(5);
        indices.add(2); indices.add(6);
        indices.add(3); indices.add(7);
    }

}
