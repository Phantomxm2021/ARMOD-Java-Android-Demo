package com.cell.ardemo;

public class Config {

    private DashboardConfig dashboardConfig;
    private ImageCloudRecognizerConfig imageCloudRecognizerConfig;
    public void setDashboardConfig(DashboardConfig dashboardConfig) {
        this.dashboardConfig = dashboardConfig;
    }
    public DashboardConfig getDashboardConfig() {
        return dashboardConfig;
    }

    public void setImageCloudRecognizerConfig(ImageCloudRecognizerConfig imageCloudRecognizerConfig) {
        this.imageCloudRecognizerConfig = imageCloudRecognizerConfig;
    }
    public ImageCloudRecognizerConfig getImageCloudRecognizerConfig() {
        return imageCloudRecognizerConfig;
    }

}