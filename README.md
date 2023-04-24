# ARMOD-Java-Android-Demo
This project is used to demonstrate how AR MOD and Native app can be used together.


# How to use it?
1. Download the ARMOD-Framework(Java)
2. Import ARMOD-Framework(all `*.arr` files) to `ARDemo/app/libs` directory.
3. Write your AR-MOD Token to the `ARMOD-Java-Android-Demo/ARDemo/app/src/main/res/values/strings.xml `
    ```diff
        <string name="config">{
	\"engineType\": \"Native\",
	\"AppModel\": \"Online\",
	\"dashboardConfig\": {
		\"dashboardGateway\": \"https://phantomsxr.com/api/v2/client/getarresources\",
		\"exceptionCollectorUrl\": \"\",
	+	\"token\": \"YOUR_TOKEN\",
		\"timeout\": 30,
		\"maximumDownloadSize\": 30
	},
	\"imageCloudRecognizerConfig\": {
		\"gateway\": \"\",
		\"maximumOfRetries\": 5,
		\"frequencyOfScan\": 5
	},
	\"customConfig\": {
		\"config\": \"\"
	}
}
        </string>
    ```
3. Build

If you want to learn more, please go to the [documentation](https://docs.phantomsxr.com/native-app-embed/android-embed-java)
