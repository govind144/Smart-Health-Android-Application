package com.example.consulting;

public class UserAdapter {
    String UserID;
    String UserName;
    String UserGender;
    String UserDOB;
    String PhoneNo;

    public UserAdapter(String userID, String userName, String userGender, String userDOB, String phoneNo) {
        UserID = userID;
        UserName = userName;
        UserGender = userGender;
        UserDOB = userDOB;
        PhoneNo = phoneNo;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setUserGender(String userGender) {
        UserGender = userGender;
    }

    public void setUserDOB(String userDOB) {
        UserDOB = userDOB;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getUserID() {
        return UserID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserGender() {
        return UserGender;
    }

    public String getUserDOB() {
        return UserDOB;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public UserAdapter()
    {

    }
}
