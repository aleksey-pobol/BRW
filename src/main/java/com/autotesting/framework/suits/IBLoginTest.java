package com.autotesting.framework.suits;

import com.autotesting.framework.screens.IBLoginPageScreen;
import com.autotesting.framework.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.*;

public class IBLoginTest {

    protected static IBLoginPageScreen ibLoginPageScreen;

    @BeforeMethod(description = "Переход на главную страницу авторизации")
    public void openPage() {
        ibLoginPageScreen = new IBLoginPageScreen();
        ibLoginPageScreen.openLoginPageScreen();
    }

    @Test(description = "Тестирование оффлайн авторизации", priority = 0)
    public void authorizationTestOffline() {
        ibLoginPageScreen.inputLogin();
        ibLoginPageScreen.inputPassword();
        ibLoginPageScreen.submitAuthorizationMailForm();
        ibLoginPageScreen.clickButtonAuthSubmit();
        try {
            Assert.assertEquals(ibLoginPageScreen.getUserLoginText(), "Сидорова Ольга Федоровна", "Имена не совпадают");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Тестирование онлайн авторизации", priority = 0)
    public void authorizationTestOnline() {
        ibLoginPageScreen.inputLogin();
        ibLoginPageScreen.inputPassword();
        ibLoginPageScreen.submitAuthorizationMailForm();
        ibLoginPageScreen.clickButtonAuthSubmit1();
        try {
            Assert.assertEquals(ibLoginPageScreen.getUserInformation(), "МИНСК-ПАССАЖИРСКИЙ", "Станция не совпадает");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Тестирование состояния БПМ", priority = 0)
    public void StatusTestOffline() {
        ibLoginPageScreen.inputLogin();
        ibLoginPageScreen.inputPassword();
        ibLoginPageScreen.submitAuthorizationMailForm();
        ibLoginPageScreen.clickButtonAuthSubmit();
        ibLoginPageScreen.clickButtonResume();
        ibLoginPageScreen.clickButtonStatus();
        try {
            Assert.assertEquals(ibLoginPageScreen.getInformationOfStatus(), "12", "ОШИБКА");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(description = "Тестирование оформления ПД", priority = 0)
    public void TicketRegistrationTestOffline() {
        ibLoginPageScreen.inputLogin();
        ibLoginPageScreen.inputPassword();
        ibLoginPageScreen.submitAuthorizationMailForm();
        ibLoginPageScreen.clickButtonAuthSubmit();
        ibLoginPageScreen.clickButtonResume();
        ibLoginPageScreen.inputPlace();
        ibLoginPageScreen.clickButtonStation();
        ibLoginPageScreen.clickButtonSearch();
        //ibLoginPageScreen.clickButtonDate();
        ibLoginPageScreen.clickButtonChoice();
        ibLoginPageScreen.clickButtonPayment();
        ibLoginPageScreen.clickButtonPaymentCash();
        try {
            Assert.assertEquals(ibLoginPageScreen.getInformationOfStatusPayment(), "ОПЕРАЦИЯ не ЗАВЕРШЕНА", "ОШИБКА");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "Тестирование операции увеличения баланса", priority = 0)
    public void OperationsWithAddBalanceTestOffline() {
        ibLoginPageScreen.inputLogin();
        ibLoginPageScreen.inputPassword();
        ibLoginPageScreen.submitAuthorizationMailForm();
        ibLoginPageScreen.clickButtonAuthSubmit();
        ibLoginPageScreen.clickButtonResume();
        ibLoginPageScreen.clickButtonBalance();
        ibLoginPageScreen.clickButtonAddCash();
        ibLoginPageScreen.inputSumAdd();
        ibLoginPageScreen.clickButtonAdd();
        /*try {
            Assert.assertEquals(ibLoginPageScreen.getInformationOfStatusPayment(), "ОПЕРАЦИЯ ЗАВЕРШЕНА", "ОШИБКА");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    @Test(description = "Тестирование операции уменьшения баланса", priority = 0)
    public void OperationsWithRemoveBalanceTestOffline() {
        ibLoginPageScreen.inputLogin();
        ibLoginPageScreen.inputPassword();
        ibLoginPageScreen.submitAuthorizationMailForm();
        ibLoginPageScreen.clickButtonAuthSubmit();
        ibLoginPageScreen.clickButtonResume();
        ibLoginPageScreen.clickButtonBalance();
        ibLoginPageScreen.clickButtonRemoveCash();
        ibLoginPageScreen.inputSumRemove();
        ibLoginPageScreen.clickButtonRemove();
    }

    /*@AfterMethod(description = "Выход из браузера. Закрытие драйвера")
    public void closeBrowser(){
        ibLoginPageScreen.mailCloseBrowser();
    }*/
}