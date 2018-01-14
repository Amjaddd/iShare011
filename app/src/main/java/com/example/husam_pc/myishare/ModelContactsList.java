package com.example.husam_pc.myishare;

import java.util.List;

/**
 * Created by husam_pc on 23/12/2017.
 */

public class ModelContactsList {
    protected int userIconId;
    protected String userNameId;
    protected String userStatus;
    protected String phoneNumber;
    protected List<String> groupList;

    public ModelContactsList(String userNameId, String phoneNumber) {
        this.userNameId = userNameId;
        this.phoneNumber = phoneNumber;
    }

    ModelContactsList(int iconID, String name, String status, String PNum){
        this.userIconId = iconID;
        this.userNameId = name;
        this.userStatus = status;
        this.phoneNumber=PNum;
    }

    ModelContactsList(int userIconId, String userNameId, String userStatus, List<String> groupList) {
        this(userIconId,userNameId,userStatus,"");
        this.groupList = groupList;
    }

    public List<String> getGroupList() {
        return groupList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserIconId() {
        return userIconId;
    }

    public void setUserIconId(int userIconId) {
        this.userIconId = userIconId;
    }

    public String getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(String userNameId) {
        this.userNameId = userNameId;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }


}
