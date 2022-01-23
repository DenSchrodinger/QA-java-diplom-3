package com.PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import static com.codeborne.selenide.Condition.visible;

public class RegisterPage{

    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[1]")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[2]")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = ".//div[@class='input__container']//div/input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH,using = ".//div[@class='Auth_login__3hAey']//form//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement wrongPasswordControl;

    @FindBy(how = How.XPATH, using = ".//*[text()='Войти']")
    private SelenideElement loginButton;

    @Step("Внесение данных и регистрация")
    public void fillUserDataAndClickRegister(String name, String email, String password){
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
        registerButton.click();
    }

    @Step("Создание имени для регистрации")
    public String getRandomName(){
        return RandomStringUtils.randomAlphabetic(6);
    }

    @Step("Создание пароля для регистрации")
    public String getRandomPassword(){
        return RandomStringUtils.randomAlphabetic(6);
    }

    @Step("Создание почты для регистрации")
    public String getRandomEmail(){
        return RandomStringUtils.randomAlphabetic(5) + "@yandex.ru";
    }

    @Step("Создание пароля менее 6 символов")
    public String getWrongRandomPassword(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    @Step("Проверка, что введен пароль менее 6 символов")
    public void wrongPasswordControlCheck(){
        wrongPasswordControl.shouldBe(visible);
    }

    @Step("Нажатие на кнопку Войти")
    public void clickProfileEnterButton(){
        loginButton.click();
    }

}