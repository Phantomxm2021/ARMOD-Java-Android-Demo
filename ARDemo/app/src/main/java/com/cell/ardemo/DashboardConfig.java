package com.cell.ardemo;


public class DashboardConfig {

    private String dashboardGateway;
    private String token;
    private int timeout;
    private int maximumDownloadSize;
    public void setDashboardGateway(String dashboardGateway) {
        this.dashboardGateway = dashboardGateway;
    }
    public String getDashboardGateway() {
        return dashboardGateway;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    public int getTimeout() {
        return timeout;
    }

    public void setMaximumDownloadSize(int maximumDownloadSize) {
        this.maximumDownloadSize = maximumDownloadSize;
    }
    public int getMaximumDownloadSize() {
        return maximumDownloadSize;
    }

}
