package com.example.consulting;

public class MedicalAdapter {

    String MID;
    String MGender;
    String MName;
    String MDOB;
    String MPass;
    String MEmail;
    String PhoneNo;
    String Description;
    String permission;

    public MedicalAdapter(){

    }

    public MedicalAdapter(String MID, String MGender, String MName, String MDOB, String MPass, String MEmail, String phoneNo, String description,String permission) {
        this.MID = MID;
        this.MGender = MGender;
        this.MName = MName;
        this.MDOB = MDOB;
        this.MPass = MPass;
        this.MEmail = MEmail;
        PhoneNo = phoneNo;
        Description = description;
        this.permission=permission;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getMID() {
        return MID;
    }

    public String getMGender() {
        return MGender;
    }

    public String getMName() {
        return MName;
    }

    public String getMDOB() {
        return MDOB;
    }

    public String getMPass() {
        return MPass;
    }

    public String getMEmail() {
        return MEmail;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public String getDescription() {
        return Description;
    }

    public void setMID(String MID) {
        this.MID = MID;
    }

    public void setMGender(String MGender) {
        this.MGender = MGender;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public void setMDOB(String MDOB) {
        this.MDOB = MDOB;
    }

    public void setMPass(String MPass) {
        this.MPass = MPass;
    }

    public void setMEmail(String MEmail) {
        this.MEmail = MEmail;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
