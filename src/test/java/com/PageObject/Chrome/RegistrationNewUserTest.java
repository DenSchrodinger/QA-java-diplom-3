package com.PageObject.Chrome;
import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.RegisterPage;
import org.junit.Test;
import org.junit.After;
import io.qameta.allure.junit4.DisplayName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationNewUserTest{
    private final MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private final LoginPage loginPage = page(LoginPage.class);
    private final RegisterPage registerPage = page(RegisterPage.class);

    @After
    public void tearDown(){
        getWebDriver().quit();
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void newProfileSuccessRegistrationTest(){
        mainPage.personalProfileButtonClick();
        loginPage.registerNewProfileButtonClick();
        String name = registerPage.getRandomName();
        String email = registerPage.getRandomEmail();
        String password = registerPage.getRandomPassword();
        registerPage.fillUserDataAndClickRegister(name, email, password);
        loginPage.recoveryButtonAndEnterButtonShouldBeVisible();
    }

    @Test
    @DisplayName("Регистрация с паролем менее 6 символов и получение сообщения об ошибке")
    public void registrationWithWrongPasswordTest(){
        mainPage.personalProfileButtonClick();
        loginPage.registerNewProfileButtonClick();
        String name = registerPage.getRandomName();
        String email = registerPage.getRandomEmail();
        String password = registerPage.getWrongRandomPassword();
        registerPage.fillUserDataAndClickRegister(name, email, password);
        registerPage.wrongPasswordControlCheck();
    }

}