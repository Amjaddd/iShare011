package com.example.husam_pc.myishare;

/**
 * Created by husam_pc on 05/01/2018.
 */

public class ModelRouteList {
    protected String userName;
    protected int routeId;

    public ModelRouteList(String userName, int routeId) {
        this.userName = userName;
        this.routeId = routeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
}
