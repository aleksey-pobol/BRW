package com.autotesting.framework.screens;

import com.autotesting.framework.utils.PropertiesReader;
import com.autotesting.framework.utils.WebDriverRunner;
import com.autotesting.framework.utils.WebDriverWrapper;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

public class IBBaseScreen {

    protected static final Logger log = Logger.getLogger(WebDriver.class);
    protected WebDriverWrapper driver = new WebDriverRunner().getDriver();

    private String user_password;
    private static final String URL_FOR_TEST = "http://192.168.14.61:8080/rwcash";
    private static final String URL_EPF = "http://192.168.51.83:8080/rwetd";
    private static final String LOGIN_PAGE_LOGIN_FIELD_XPATH = "//input[@id='j_username']";
    private static final String LOGIN_PAGE_PASSWORD_FIELD_XPATH = "//input[@id='j_password']";
    private static final String LOGIN_PAGE_BUTTON_XPATH = "//button[@id='submit']";

    private static final String BUTTON = "//button[@id='index:btnOffline']";
    private static final String BUTTON1 = "//button[@id='index:btnOnline']";
    private static final String BUTTIN2 = "//button[@id='index:j_id_12']";

    private static final String ButtonStatus = "//button[@id='form:btnState']";

    private static final String ButtonResume = "//button[@id='index:j_id_v']/span[@class='ui-button-text ui-c']";

    private static final String PLACE_FIELD_XPATH = "//input[@id='form:tabViewId:tabOperanionsViewId:mainArrival_input']";
    private static final String ButtonSearch = "//button[@id='form:tabViewId:tabOperanionsViewId:mainSearch']";
    private static final String ButtonStation = "//div[@id='form:tabViewId:tabOperanionsViewId:mainArrival_panel']";
    private static final String ButtonDate = "//button[@class='buts_day but_tomorrow']";
    private static final String ButtonChoice = "//div[@class='desc_route selectRoute']";
    private static final String ButtonPayment = "//button[@class='but_pay_cash cash-pay']";
    private static final String ButtonPaymentCash = "//button[@id='form:pay-button']";

    private static final String ButtonBalance = "//li[@class='ui-state-default ui-corner-left cash-balance-icon']";
    private static final String ButtonAddCash = "//button[@id='form:tabViewId:cashBalanceBtnAdd']";
    private static final String ADD_CASH_FIELD_XPATH = "//input[@id='form:cashBalanceIn_input']";
    private static final String ButtonAdd = "//button[@id='form:BtnBalanceAdd']";

    private static final String ButtonRemoveCash = "//button[@id='form:tabViewId:cashBalanceBtnRemove']";
    private static final String REMOVE_CASH_FIELD_XPATH = "//input[@id='form:cashBalanceOut_input']";
    private static final String ButtonRem = "//button[@id='form:BtnBalanceRemove']";


    public IBBaseScreen openLoginPageScreen() {
        try {
            log.info(String.format("Открываем в браузере страницу логина по адресу %s", URL_FOR_TEST));
            driver.get(URL_FOR_TEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public IBBaseScreen inputLogin(){
        try {
            log.info(String.format("Вводим логин: '%s'", PropertiesReader.getPropertiesReader().getLogin()));
            driver.enterTextByXpath(LOGIN_PAGE_LOGIN_FIELD_XPATH, PropertiesReader.getPropertiesReader().getLogin());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public IBBaseScreen inputPassword(){
        try {
            user_password = PropertiesReader.getPropertiesReader().getPassword();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(String.format("Вводим пароль: '%s'", user_password));
        try {
            driver.enterTextByXpath(LOGIN_PAGE_PASSWORD_FIELD_XPATH, PropertiesReader.getPropertiesReader().getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public IBBaseScreen submitAuthorizationMailForm(){
        log.info(String.format("Отправляем форму кликом по кнопке 'Войти'"));
        driver.clickByXpath(LOGIN_PAGE_BUTTON_XPATH);
        return this;
    }

    /*public IBBaseScreen inputSessionKey(){
        log.info(String.format("Отправляем форму кликом по кнопке 'Войти в систему'"));
        driver.enterTextByXpath(SESSION_KEY_XPATH, "1234");
        return this;
    }*/

    public IBBaseScreen clickButtonAuthSubmit(){
        driver.clickByXpath(BUTTON);
        return this;
    }
    public IBBaseScreen clickButtonContinue(){
        driver.clickByXpath(BUTTIN2);
        return this  ;
    }

    public IBBaseScreen clickButtonStatus(){
        driver.clickByXpath(ButtonStatus);
        return this;
    }

    public IBBaseScreen clickButtonAuthSubmit1(){
        driver.clickByXpath(BUTTON1);
        return this;
    }

    public IBBaseScreen clickButtonResume(){
        driver.clickByXpath(BUTTIN2);
        return this;
    }

    public IBBaseScreen inputPlace(){
        try {
            log.info(String.format("Вводим станцию: '%s'", PropertiesReader.getPropertiesReader().getPlace()));
            driver.enterTextByXpath(PLACE_FIELD_XPATH, PropertiesReader.getPropertiesReader().getPlace());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public IBBaseScreen clickButtonStation(){
        driver.clickByXpath(ButtonStation);
        return this;
    }
    public IBBaseScreen clickButtonSearch(){
        driver.clickByXpath(ButtonSearch);
        return this;
    }

    public IBBaseScreen clickButtonDate(){
        driver.clickByXpath(ButtonDate);
        return this;
    }

    public IBBaseScreen clickButtonChoice(){
        driver.clickByXpath(ButtonChoice);
        return this;
    }

    public IBBaseScreen clickButtonPayment(){
        driver.clickByXpath(ButtonPayment);
        return this;
    }

    public IBBaseScreen clickButtonPaymentCash(){
        driver.clickByXpath(ButtonPaymentCash);
        return this;
    }

    public IBBaseScreen clickButtonBalance(){
        driver.clickByXpath(ButtonBalance);
        return this;
    }

    public IBBaseScreen clickButtonAddCash(){
        driver.clickByXpath(ButtonAddCash);
        return this;
    }

    public IBBaseScreen clickButtonRemoveCash(){
        driver.clickByXpath(ButtonRemoveCash);
        return this;
    }

    public IBBaseScreen inputSumAdd(){
        try {
            log.info(String.format("Вводим сумму добавления: '%s'", PropertiesReader.getPropertiesReader().getSumAdd()));
            driver.enterTextByXpath(ADD_CASH_FIELD_XPATH, PropertiesReader.getPropertiesReader().getSumAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public IBBaseScreen inputSumRemove(){
        try {
            log.info(String.format("Вводим сумму выдачи: '%s'", PropertiesReader.getPropertiesReader().getSumRemove()));
            driver.enterTextByXpath(REMOVE_CASH_FIELD_XPATH, PropertiesReader.getPropertiesReader().getSumRemove());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public IBBaseScreen clickButtonAdd(){
        driver.clickByXpath(ButtonAdd);
        return this;
    }

    public IBBaseScreen clickButtonRemove(){
        driver.clickByXpath(ButtonRem);
        return this;
    }

    public IBBaseScreen mailCloseBrowser()
    {
        WebDriverRunner.closeBrowser();
        return this;
    }
}
