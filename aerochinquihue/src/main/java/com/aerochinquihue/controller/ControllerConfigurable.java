package com.aerochinquihue.controller;

public interface ControllerConfigurable {
    void configureController(Object data);
}
/*
 * los que tienen que configurarse de forma dinamica
 * public class ** implements ControllerConfigurable {
    @Override
    public void configureController(Object data) {
     ** lo necesario para cambiar **
    }
}
 */