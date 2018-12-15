package c_02_utery_18_15.model3D;

import transforms.Point3D;

import java.awt.*;
public class Spiral extends Solid {

    public Spiral(){
        this.isAxe = false;
        int i = 0;
        for (double a = -1; a<= 2; a += 0.05){
            double x = a;
            double y = x*Math.sin(1/x);
            double z = 0;
            vertices.add(new Point3D(x, z, y));
            if(a > 0){
                indices.add(i);
                indices.add(++i);
            }

        }
        color = Color.magenta;
    }


}
