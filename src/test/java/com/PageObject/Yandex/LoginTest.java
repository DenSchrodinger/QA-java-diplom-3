package com.PageObject.Yandex;
import com.PageObject.ForgotPasswordPage;
import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.RegisterPage;
import com.userActions;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginTest{
    private userActions userActions;
    private final MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private final LoginPage loginPage = page(LoginPage.class);
    private final RegisterPage registerPage = page(RegisterPage.class);
    private final ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);

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
    @DisplayName("Вход в ЛК по кнопке Войти в аккаунт на главной")
    public void enterFromMainPageEnterProfileButtonTest() {
        Map<String, String> userData = userActions.register();
        mainPage.enterProfileButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.saucesAndFillingTextCheck();
    }

    @Test
    @DisplayName("Вход в ЛК через кнопку Личный кабинет")
    public void enterFromMainPageProfileButtonTest(){
        Map<String, String> userData = userActions.register();
        mainPage.personalProfileButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.saucesAndFillingTextCheck();
    }

    @Test
    @DisplayName("Входа в ЛК по кнопке в форме регистрации")
    public void enterFromRegisterPageEnterButtonTest(){
        Map<String, String> userData = userActions.register();
        mainPage.personalProfileButtonClick();
        loginPage.registerNewProfileButtonClick();
        registerPage.clickProfileEnterButton();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.saucesAndFillingTextCheck();
    }

    @Test
    @DisplayName("Вход в ЛК по кнопке в форме восстановления пароля")
    public void enterFromProfilePageRecoveryButtonTest(){
        Map<String, String> userData = userActions.register();
        mainPage.personalProfileButtonClick();
        loginPage.clickOnRecoveryButton();
        forgotPasswordPage.enterButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.saucesAndFillingTextCheck();
    }

}