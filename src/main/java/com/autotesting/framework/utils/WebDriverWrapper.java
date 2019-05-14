package com.autotesting.framework.utils;

import com.autotesting.framework.screens.IBBaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import java.util.List;

public class WebDriverWrapper extends ChromeDriver{

    public static final int TIMEOUT_FOR_ACTION_SECONDS = 15;
    protected final Logger log = Logger.getLogger(IBBaseScreen.class);


    public void enterTextByXpath(String xpath, String text) {
        log.info(String.format("[ACTION]: Ввод текста '%s' в элемент: '%s'", text, xpath));
        waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
        findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void clickByXpath(String xpath) {
        log.info("[ACTION]: Клик по элементу: '" + xpath + "'");
        waitForElementPresentAndVisible(xpath, TIMEOUT_FOR_ACTION_SECONDS);
        findElement(By.xpath(xpath)).click();
    }

    public void clickByXpathWithSleep(String xpath) {
        log.info("[ACTION]: Клик по элементу: '" + xpath + "'");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElement(By.xpath(xpath)).click();
    }

    public void sendKeysEnter(String xpath) {
        log.info("[ACTION]: нажатие клавиши Enter с клавиатуры");
        findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
    }

    public void sendKeysBackspace(String xpath) {
        log.info("[ACTION]: нажатие клавиши Backspace с клавиатуры");
        findElement(By.xpath(xpath)).sendKeys(Keys.BACK_SPACE);
    }

    public void clearFieldByXpath(String xpath) {
        log.info("[ACTION]: очистка поля");
        findElement(By.xpath(xpath)).clear();
    }

    public boolean isVisible(String xpath) {
        log.info("[ACTION]: проверка элемента на видимость");
        return findElement(By.xpath(xpath)).isDisplayed();
    }

    public String getText(String xpath) {
        log.info("[ACTION]: Получение текста из элемента: '" + xpath + "'");
        return findElement(By.xpath(xpath)).getText();
    }

    private void waitForElementPresentAndVisible(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(this, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public int countElementsPerPage(String xpath) {
        log.info("[ACTION]: подсчет числа элементов на странице");
        List<WebElement> list = findElements(By.xpath(xpath));
        return list.size();
    }
}
