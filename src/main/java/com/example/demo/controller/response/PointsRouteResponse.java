package com.example.demo.controller.response;

import java.io.Serializable;

public class PointsRouteResponse implements Serializable {
    private static final long serialVersionUID = -381843894064408583L;
    private String payer;
    private int points;

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
