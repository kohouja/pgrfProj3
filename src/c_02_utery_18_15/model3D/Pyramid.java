package c_02_utery_18_15.model3D;

import transforms.Point3D;

import java.awt.*;

public class Pyramid extends Solid{
    public Pyramid() {
        this.isAxe = false;
        this.color = Color.WHITE;
        vertices.add(new Point3D(-1, -1, -1));
        vertices.add(new Point3D(1, -1, -1));
        vertices.add(new Point3D(1, 1, -1));
        vertices.add(new Point3D(-1, 1, -1));
        vertices.add(new Point3D(0, 0, 1));

        indices.add(0); indices.add(1);
        indices.add(1); indices.add(2);
        indices.add(2); indices.add(3);
        indices.add(3); indices.add(0);

        indices.add(0); indices.add(4);
        indices.add(1); indices.add(4);
        indices.add(2); indices.add(4);
        indices.add(3); indices.add(4);



    }
}
