package com.autotesting.framework.utils;

import org.apache.log4j.Logger;

public class WebDriverRunner {
    private static WebDriverWrapper driver;
    private static final Logger log = Logger.getLogger(WebDriverRunner.class);

    public WebDriverRunner() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        try {
            driver = new WebDriverWrapper();
        } catch (Exception e) {
            log.error("Ошибка при создании драйвера");
        }
        driver.manage().window().fullscreen();
    }

    public static WebDriverWrapper getDriver(){
        if (driver == null){
            new WebDriverRunner();
        }
        return driver;
    }

    public static void closeBrowser(){
        log.info("Закрываем браузер");
        driver.quit();
    }
}
