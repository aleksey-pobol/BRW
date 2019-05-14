package com.autotesting.framework.screens;

import org.openqa.selenium.By;

public class IBLoginPageScreen extends IBBaseScreen {

    private static final String USER_NAME_FOR_LOGIN = "Сидорова";
    private static final String EXPECTED_USER_EMAIL_XPATH = "//div/label[@id='index:j_id_g']";
    private static final String Information = "Станция (о.п.) установки БПМ:";
    private static final String EXPECTED_TEXT_XPATH = "//div/label[@id='index:j_id_v']";
    private static final String StatusPayment = "Статус выполнения операции";
    private static final String EXPECTED_Payment_XPATH = "//div[@class='ui-dialog-content ui-widget-content']/div[@class='modal-pay-block']/div[@class='modal-text-icon modal-pay-success-text margin-top-75']";
    private static final String Status = "Состояние БПМ";
    private static final String EXPECTED_STATUS = "//div[@class='ui-growl-message']/span[@class='ui-growl-title']";

    public String getUserLoginText() {
        log.info(String.format("Получаем значение имени пользователя из хедера страницы ИБ: '%s'", USER_NAME_FOR_LOGIN));
        return driver.findElement(By.xpath(EXPECTED_USER_EMAIL_XPATH)).getText();
    }


    public String getUserInformation() {
        log.info(String.format("Получаем текст появившейся страницы: '%s'", Information));
        return driver.findElement(By.xpath(EXPECTED_TEXT_XPATH)).getText();
    }

    public String getInformationOfStatus() {
        log.info(String.format("Получаем текст появившейся страницы: '%s'", Status));
        return driver.findElement(By.xpath(EXPECTED_STATUS)).getText();
    }

    public String getInformationOfStatusPayment() {
        log.info(String.format("Получаем текст появившейся страницы: '%s'", StatusPayment));
        return driver.findElement(By.xpath(EXPECTED_Payment_XPATH)).getText();
    }
}
