package com.PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;

public class ForgotPasswordPage{
    @FindBy(how = How.XPATH,using = ".//a[@class='Auth_link__1fOlj'][text()='Войти']")
    private SelenideElement enterButton;

    @Step("Нажать на кнопку Войти")
    public void enterButtonClick(){
        enterButton.click();
    }
}