package com.PageObject.Yandex;
import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.ProfilePage;
import com.codeborne.selenide.Configuration;
import com.userActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProfileTest{
    private userActions userActions;
    private final MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private final LoginPage loginPage = page(LoginPage.class);
    private final ProfilePage profilePage = page(ProfilePage.class);

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
        userActions = new userActions();
        Map<String, String> userData = userActions.register();
        mainPage.enterProfileButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.personalProfileButtonClick();
    }

    @After
    public void tearDown(){
        userActions.delete();
        getWebDriver().quit();
    }

    @Test
    @DisplayName("Переход в ЛК по нажатию кнопки войти в аккаунт")
    public void profileLoginTest() {
        profilePage.correctLoginProfileCheck();
    }

    @Test
    @DisplayName("Переход по нажатию на Конструктор из ЛК")
    public void profileLoginAndConstructorClickTest(){
        profilePage.constructorButtonClick();
        mainPage.saucesAndFillingTextCheck();
        assertTrue(mainPage.isMainPageLoggedAuthorised());
    }

    @Test
    @DisplayName("Переход по Лого в Конструктор из ЛК")
    public void profileLoginAndClickLogoTest(){
        profilePage.logoClick();
        assertTrue(mainPage.isMainPageLoggedAuthorised());
    }

    @Test
    @DisplayName("Вход и выход из ЛК")
    public void profileLoginAndLogoutTest(){
        profilePage.exitButtonClick();
        loginPage.recoveryButtonAndEnterButtonShouldBeVisible();
        assertTrue(loginPage.loginIsOpen());
    }

}