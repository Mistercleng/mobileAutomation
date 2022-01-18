import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class App {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        File apk = new File("src/main/resources/Ton_base.apk");

//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
//        capabilities.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());


        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5556");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"appium");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());
        desiredCapabilities.setCapability("newCommandTimeout", 2000);

        URL urlConnection = new URL("http://127.0.1.1:4723/wd/hub");
        AppiumDriver driver = new AppiumDriver<>(urlConnection, desiredCapabilities);

        driver.findElementById("permission_allow_button").click();

    }
}
