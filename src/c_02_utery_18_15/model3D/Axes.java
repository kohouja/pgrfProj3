package c_02_utery_18_15.model3D;

import transforms.Point3D;

import java.awt.*;

public class Axes extends Solid{
    public Axes() {
        color = Color.YELLOW;
// todo tri instance a tri ruzne barvy os
        vertices.add(new Point3D(0,0,0));
        vertices.add(new Point3D(1,0,0));
        vertices.add(new Point3D(0,-1,0));
        vertices.add(new Point3D(0,0,1));

        indices.add(0); indices.add(1);
        indices.add(0); indices.add(2);
        indices.add(0); indices.add(3);
    }
}
