package com.aerochinquihue.model;

public enum Avion {
    CESSNA310(5, new int[]{2, 3}),
    CESSNA208(9, new int[]{1, 2, 2, 2, 2}),
    LET410(19, new int[]{2, 2, 2, 2, 2, 2, 2, 2, 3});

    private final int[] distribucion;

    Avion(int totalAsientos, int[] distribucion) {
        this.distribucion = distribucion;
    }

    public int[] getDistribucion() {
        return distribucion;
    }
    
}
