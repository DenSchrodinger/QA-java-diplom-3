package com.PageObject.Chrome;
import com.PageObject.MainPage;
import com.codeborne.selenide.Configuration;
import com.userActions;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ConstructorTest{
    private com.userActions userActions;
    private final MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);

    @Before
    public void setUp(){
        Configuration.startMaximized = true;
        userActions = new userActions();
    }

    @After
    public void tearDown(){
        userActions.delete();
        getWebDriver().quit();
    }

    @Test
    @DisplayName("Переключение вкладок конструктора")
    public void correctJumpBetweenTabsConstructorTest(){
        mainPage.correctJumpBetweenTabsCheck();
    }

}