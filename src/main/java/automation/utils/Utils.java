package automation.utils;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Base64;

public class Utils {
    public static String decoded64(String encodedStr) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodedStr.getBytes()));
    }

    public static void takeScreenshot(String name) {
        File file = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(file, new File("screenshots/" + name + "-" + LocalTime.now() + ".PNG"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
