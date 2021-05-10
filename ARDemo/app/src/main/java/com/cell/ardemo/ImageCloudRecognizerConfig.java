package com.cell.ardemo;


public class ImageCloudRecognizerConfig {

    private String gateway;
    private int maximumOfRetries;
    private int frequencyOfScan;
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }
    public String getGateway() {
        return gateway;
    }

    public void setMaximumOfRetries(int maximumOfRetries) {
        this.maximumOfRetries = maximumOfRetries;
    }
    public int getMaximumOfRetries() {
        return maximumOfRetries;
    }

    public void setFrequencyOfScan(int frequencyOfScan) {
        this.frequencyOfScan = frequencyOfScan;
    }
    public int getFrequencyOfScan() {
        return frequencyOfScan;
    }

}
