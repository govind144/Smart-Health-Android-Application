package com.example.consulting;

public class DoctorAdapter {

    public String doctorID;
    public String doctorGender;
    public String doctorType;
    public String doctorsymtm;
    public String doctorDOB;
    public String doctorPass;
    public String doctorEmail;
    public String phoneNo;
    public String description;
    public String doctorName;

    public DoctorAdapter(){

    }

    public DoctorAdapter(String doctorID, String doctorGender, String doctorType, String doctorsymtm, String doctorDOB, String doctorPass, String doctorEmail, String phoneNo, String description, String doctorName) {
        this.doctorID = doctorID;
        this.doctorGender = doctorGender;
        this.doctorType = doctorType;
        this.doctorsymtm = doctorsymtm;
        this.doctorDOB = doctorDOB;
        this.doctorPass = doctorPass;
        this.doctorEmail = doctorEmail;
        this.phoneNo = phoneNo;
        this.description = description;
        this.doctorName = doctorName;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getDoctorGender() {
        return doctorGender;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public String getDoctorsymtm() {
        return doctorsymtm;
    }

    public String getDoctorDOB() {
        return doctorDOB;
    }

    public String getDoctorPass() {
        return doctorPass;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getDescription() {
        return description;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public void setDoctorsymtm(String doctorsymtm) {
        this.doctorsymtm = doctorsymtm;
    }

    public void setDoctorDOB(String doctorDOB) {
        this.doctorDOB = doctorDOB;
    }

    public void setDoctorPass(String doctorPass) {
        this.doctorPass = doctorPass;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
