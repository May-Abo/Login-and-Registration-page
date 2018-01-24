
package com.test.beans;

public class UserLog {
   
    private String userName;
    private String ipAddress;
    private String operation;
    private String time;

    public UserLog() {
    }

    public UserLog(String userName, String ipAddress, String operation, String time) {
        this.userName = userName;
        this.ipAddress = ipAddress;
        this.operation = operation;
        this.time = time;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserLog{" + "userName=" + userName + ", ipAddress=" + ipAddress + ", operation=" + operation + ", time=" + time + '}';
    }
    
    
    
    
    
}
