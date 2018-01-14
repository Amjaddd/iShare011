package com.example.husam_pc.myishare;

/**
 * Created by arabi_000 on 1/9/2018.
 */


public class ContactsSelectionModel {
    String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }



    private String contact;
    private boolean isChecked;
}
