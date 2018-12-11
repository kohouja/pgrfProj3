package c_02_utery_18_15.utils;

import c_02_utery_18_15.model3D.Solid;
import transforms.Mat4RotXYZ;
import transforms.Mat4Scale;
import transforms.Mat4Transl;
import transforms.Point3D;

public class Utils {

    // method which changes the scale
    public static void setScale(Solid solid, double scale){
        for (int i = 0; i < solid.getVertices().size(); i++) {
            //current point
            Point3D point3D = solid.getVertices().get(i);
            // multiplication point by scale
            Point3D newPoint = point3D.mul(new Mat4Scale(scale));
            //set new location of point into solid
            solid.getVertices().set(i, newPoint);
        }
    }

    public static void setMoveX(Solid solid, double moveSpeed){
        for (int i = 0; i < solid.getVertices().size(); i++) {
            //current point
            Point3D point3D = solid.getVertices().get(i);
            // multiplication point by scale
            Point3D newPoint = point3D.mul(new Mat4Transl(moveSpeed, 0, 0));
            //set new location of point into solid
            solid.getVertices().set(i, newPoint);
        }
    }

    public static void setMoveY(Solid solid, double moveSpeed){
        for (int i = 0; i < solid.getVertices().size(); i++) {
            //current point
            Point3D point3D = solid.getVertices().get(i);
            // multiplication point by scale
            Point3D newPoint = point3D.mul(new Mat4Transl(0, moveSpeed, 0));
            //set new location of point into solid
            solid.getVertices().set(i, newPoint);
        }
    }

    public static void setMoveZ(Solid solid, double moveSpeed){
        for (int i = 0; i < solid.getVertices().size(); i++) {
            //current point
            Point3D point3D = solid.getVertices().get(i);
            // multiplication point by scale
            Point3D newPoint = point3D.mul(new Mat4Transl(0, 0, moveSpeed));
            //set new location of point into solid
            solid.getVertices().set(i, newPoint);
        }
    }

    public static void setRotation(Solid solid,double rotX, double rotY){
        for (int i = 0; i < solid.getVertices().size(); i++) {
            //current point
            Point3D point3D = solid.getVertices().get(i);
            // multiplication point by scale
            Point3D newPoint = point3D.mul(new Mat4RotXYZ(rotY, 0, rotX));
            //set new location of point into solid
            solid.getVertices().set(i, newPoint);
        }
    }
}
