package br.com.ton.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {

    public final AppiumDriver driver;
    private static AppiumDriverConfig _instance;


    public static AppiumDriverConfig Instance(){
        if(AppiumDriverConfig._instance == null) {
            AppiumDriverConfig._instance = new AppiumDriverConfig();
        }
        return AppiumDriverConfig._instance;
    }


    public AppiumDriverConfig(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        File apk = new File("src/main/resources/Ton_base.apk");

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
        desiredCapabilities.setCapability("newCommandTimeout", 2000);
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL urlConnection = null;
        try {
            urlConnection = new URL("http://127.0.1.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AppiumDriver<>(urlConnection, desiredCapabilities);
    }
}
