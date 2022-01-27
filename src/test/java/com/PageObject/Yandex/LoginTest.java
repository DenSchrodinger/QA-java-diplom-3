package com.PageObject.Yandex;
import com.PageObject.ForgotPasswordPage;
import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.RegisterPage;
import com.codeborne.selenide.Configuration;
import com.userActions;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginTest{
    private userActions userActions;
    private final MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private final LoginPage loginPage = page(LoginPage.class);
    private final RegisterPage registerPage = page(RegisterPage.class);
    private final ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
    final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
        userActions = new userActions();
    }

    @After
    public void tearDown(){
        userActions.delete();
        getWebDriver().quit();
    }

    @Test
    @DisplayName("Вход в ЛК по кнопке Войти в аккаунт на главной")
    public void enterFromMainPageEnterProfileButtonTest() {
        Map<String, String> userData = userActions.register();
        mainPage.enterProfileButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.saucesAndFillingTextCheck();
        assertTrue(mainPage.isMainPageLoggedAuthorised());
    }

    @Test
    @DisplayName("Вход в ЛК через кнопку Личный кабинет")
    public void enterFromMainPageProfileButtonTest(){
        mainPage.personalProfileButtonClick();
        String actualUrl = url();
        assertEquals("Не прошел переход на страницу логина", actualUrl, LOGIN_URL);
    }

    @Test
    @DisplayName("Входа в ЛК по кнопке в форме регистрации")
    public void enterFromRegisterPageEnterButtonTest(){
        mainPage.personalProfileButtonClick();
        loginPage.registerNewProfileButtonClick();
        registerPage.clickProfileEnterButton();
        String actualUrl = url();
        assertEquals("Не прошел переход на страницу логина", actualUrl, LOGIN_URL);
    }

    @Test
    @DisplayName("Вход в ЛК по кнопке в форме восстановления пароля")
    public void enterFromProfilePageRecoveryButtonTest(){
        mainPage.personalProfileButtonClick();
        loginPage.clickOnRecoveryButton();
        forgotPasswordPage.enterButtonClick();
        String actualUrl = url();
        assertEquals("Не прошел переход на страницу логина", actualUrl, LOGIN_URL);
    }

}