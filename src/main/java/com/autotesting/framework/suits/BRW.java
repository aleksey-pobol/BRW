package com.autotesting.framework.suits;

import com.autotesting.framework.screens.IBLoginPageScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BRW {
    protected static IBLoginPageScreen ibLoginPageScreen;

    @BeforeMethod(description = "Переход на главную страницу авторизации")
    public void openPage() {
        ibLoginPageScreen = new IBLoginPageScreen();
        ibLoginPageScreen.openLoginPageScreen();
    }



    /*@AfterMethod(description = "Выход из браузера. Закрытие драйвера")
    public void closeBrowser(){
        ibLoginPageScreen.mailCloseBrowser();
    }*/
}
