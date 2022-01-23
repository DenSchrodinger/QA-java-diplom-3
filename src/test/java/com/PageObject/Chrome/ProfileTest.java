package com.PageObject.Chrome;
import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.ProfilePage;
import com.userActions;
import java.util.Map;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProfileTest{
    private userActions userActions;
    private final MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private final LoginPage loginPage = page(LoginPage.class);
    private final ProfilePage profilePage = page(ProfilePage.class);

    @Before
    public void setUp(){
        userActions = new userActions();
    }

    @After
    public void tearDown(){
        userActions.delete();
        getWebDriver().quit();
    }

    @Test
    @DisplayName("Переход в ЛК по нажатию кнопки войти в аккаунт")
    public void profileLoginTest(){
        Map<String, String> userData = userActions.register();
        mainPage.enterProfileButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.personalProfileButtonClick();
        profilePage.correctLoginProfileCheck();
    }

    @Test
    @DisplayName("Переход по нажатию на Конструктор из ЛК")
    public void profileLoginAndConstructorClickTest(){
        Map<String, String> userData = userActions.register();
        mainPage.enterProfileButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.personalProfileButtonClick();
        profilePage.constructorButtonClick();
        mainPage.saucesAndFillingTextCheck();
    }

    @Test
    @DisplayName("Переход по Лого в Конструктор из ЛК")
    public void profileLoginAndClickLogoTest(){
        Map<String, String> userData = userActions.register();
        MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        mainPage.enterProfileButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.personalProfileButtonClick();
        profilePage.logoClick();
        mainPage.saucesAndFillingTextCheck();
    }

    @Test
    @DisplayName("Вход и выход из ЛК")
    public void profileLoginAndLogoutTest(){
        Map<String, String> userData = userActions.register();
        mainPage.enterProfileButtonClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.personalProfileButtonClick();
        profilePage.exitButtonClick();
        loginPage.recoveryButtonAndEnterButtonShouldBeVisible();
    }

}