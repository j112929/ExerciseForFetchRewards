package com.example.demo.controller.request;

import java.io.Serializable;

public class PointsRouteRequest implements Serializable {

    private static final long serialVersionUID = -2385078759244558431L;
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
