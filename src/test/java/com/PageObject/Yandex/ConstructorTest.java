package com.PageObject.Yandex;
import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.userActions;
import java.util.Map;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ConstructorTest{
    private com.userActions userActions;
    private final MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private final LoginPage loginPage = page(LoginPage.class);

    @Before
    public void setUp(){
        userActions = new userActions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
    }

    @After
    public void tearDown(){
        userActions.delete();
        getWebDriver().quit();
    }

    @Test
    @DisplayName("Переключение вкладок конструктора")
    public void correctJumpBetweenTabsConstructorTest(){
        Map<String, String> userData = userActions.register();
        mainPage.bunR2D3ShouldBeVisible();
        mainPage.enterProfileButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.correctJumpBetweenTabsCheck();
    }

}