package com.fowobi.networking.dto;


public class KeepAlive {
    private String host;
    private String department;

    public KeepAlive(String host, String department) {
        this.host = host;
        this.department = department;
    }

    public KeepAlive() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
