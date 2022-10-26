package com.example.demo.controller.request;

import java.io.Serializable;

public class TransactionRoute implements Serializable {

    private static final long serialVersionUID = 6162213169683070793L;
    private int id;
    private String payer;
    private int points;
    private String timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        TransactionRoute cur = (TransactionRoute)obj;
//        String curKey = cur.getPayer()+":"+cur.getTimestamp();
//        String thisKey = this.payer+":"+this.getTimestamp();
//        return curKey.equals(thisKey);
        return cur.getId() == this.id;
    }
}
