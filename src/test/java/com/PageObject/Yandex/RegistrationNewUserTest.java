package com.PageObject.Yandex;
import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationNewUserTest{
    private final MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private final LoginPage loginPage = page(LoginPage.class);
    private final RegisterPage registerPage = page(RegisterPage.class);

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
    }

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