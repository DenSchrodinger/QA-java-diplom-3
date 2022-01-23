package com.PageObject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;

public class LoginPage{

    @FindBy(how = How.XPATH,using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']//form//button[text()='Войти']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH,using = ".//div[@class='input__container']//div/input[@type='text']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = ".//div[@class='input__container']//div/input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj'][text()='Восстановить пароль']")
    private SelenideElement newPasswordButton;

    @Step("Клик по кнопке Зарегистрироваться")
    public void registerNewProfileButtonClick(){
        registerButton.click();
    }

    @Step("Проверить видимость кнопки Восстановить пароль и Войти")
    public void recoveryButtonAndEnterButtonShouldBeVisible(){
        newPasswordButton.shouldBe(visible);
        loginButton.shouldBe(visible, enabled);
    }

    @Step("Нажатие на кнопку Войти")
    public void loginButtonClick(){
        loginButton.click();
    }

    @Step("Заполнение полей регистрации и вход по кнопке Войти")
    public void setRegistrationDataAndClickEnter(String email, String password){
        emailField.setValue(email);
        passwordField.setValue(password);
        loginButtonClick();
    }

    @Step("Нажатие на кнопку восстановить пароль")
    public void clickOnRecoveryButton(){
        newPasswordButton.click();
    }
}