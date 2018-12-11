package c_02_utery_18_15.controller;

import c_02_utery_18_15.model3D.Cube;
import c_02_utery_18_15.model3D.Pyramid;
import c_02_utery_18_15.model3D.Solid;
import c_02_utery_18_15.renderer.Renderer3D;
import c_02_utery_18_15.view.Raster;
import transforms.*;

import javax.swing.*;
import java.awt.event.*;
import java.security.Key;

public class PgrfController3D {

    private Raster raster;
    private Renderer3D renderer3D;
    private Solid cube;
    private Solid pyramid;
    private Camera camera;

    private int mx, my;

    public PgrfController3D(Raster raster) {
        this.raster = raster;
        initObjects();
        initListeners();
    }

    private void initObjects() {
        cube = new Cube();
        pyramid = new Pyramid();
        renderer3D = new Renderer3D(raster);
        renderer3D.add(cube, pyramid);
        resetCamera();
    }

    private void resetCamera() {
        camera = new Camera(
                new Vec3D(0, -5, 2),
                Math.toRadians(90),
                Math.toRadians(-25),
                1, true
        );
        renderer3D.setView(camera.getViewMatrix());
    }

    private void initListeners() {
        raster.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mx = e.getX();
                my = e.getY();
            }
        });
        raster.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    double diffX = (mx - e.getX()) / 100.0;
                    double azimuth = camera.getAzimuth() + diffX;
                    camera = camera.withAzimuth(azimuth);
                    renderer3D.setView(camera.getViewMatrix());

                    double diffY = (my - e.getY()) / 100.0;
                    double zenit = camera.getZenith() + diffY;
                    camera =  camera.withZenith(zenit);
                    renderer3D.setView(camera.getViewMatrix());


                }else if(SwingUtilities.isRightMouseButton(e) && !e.isShiftDown()) {
                    double rotX = (mx - e.getX()) / -200.0;
                    double rotY = (my - e.getY()) / -200.0;
                    Mat4 rot = renderer3D.getModel().mul(new Mat4RotXYZ(rotY, 0, rotX));
                    renderer3D.setModel(rot);
                }else if(SwingUtilities.isRightMouseButton(e) && e.isShiftDown()){
//                    TODO rotace pouze teles
                    double rotX = (mx - e.getX()) / -200.0;
                    double rotY = (my - e.getY()) / -200.0;
                    renderer3D.setRotation(rotX, rotY);

                }
                // dodělat posunutí
                mx = e.getX();
                my = e.getY();
            }
        });
        raster.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(e.getWheelRotation() > 0){
                    renderer3D.setScale(1.1);
                    System.out.println(e.getWheelRotation());
                }else if(e.getWheelRotation() < 0){
                    renderer3D.setScale(0.9);
                    System.out.println(e.getWheelRotation());
                }else{
                    System.out.println("Wrong scale!");
                }
            }
        });
        raster.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(!e.isShiftDown()){
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                        case KeyEvent.VK_W:
                            camera = camera.forward(1);
                            renderer3D.setView(camera.getViewMatrix());
                            break;
                        case KeyEvent.VK_DOWN:
                        case KeyEvent.VK_S:
                            camera = camera.backward(1);
                            renderer3D.setView(camera.getViewMatrix());
                            break;
                        case KeyEvent.VK_LEFT:
                        case KeyEvent.VK_A:
                            camera = camera.left(1);
                            renderer3D.setView(camera.getViewMatrix());
                            break;
                        case KeyEvent.VK_RIGHT:
                        case KeyEvent.VK_D:
                            camera = camera.right(1);
                            renderer3D.setView(camera.getViewMatrix());
                            break;

                    }
                }else if(e.isShiftDown()){
                    Mat4 move;
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_A:
                        case KeyEvent.VK_LEFT:
                            double translationSpeed = -0.1;
                            renderer3D.setMove(translationSpeed, "x");
                        break;

                        case KeyEvent.VK_D:
                        case KeyEvent.VK_RIGHT:
                            translationSpeed = 0.1;
                            renderer3D.setMove(translationSpeed, "x");
                        break;

                        case KeyEvent.VK_W:
                            translationSpeed = 0.1;
                            renderer3D.setMove(translationSpeed, "y");
                        break;

                        case KeyEvent.VK_S:
                            translationSpeed = -0.1;
                            renderer3D.setMove(translationSpeed, "y");
                        break;

                        case KeyEvent.VK_UP:
                            translationSpeed = 0.1;
                            renderer3D.setMove(translationSpeed, "z");
                        break;

                        case KeyEvent.VK_DOWN:
                            translationSpeed = -0.1;
                            renderer3D.setMove(translationSpeed, "z");
                        break;
                    }
                }

            }
        });
    }


}
