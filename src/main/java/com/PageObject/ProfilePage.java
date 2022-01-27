package com.PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;

public class ProfilePage{

    @FindBy(how = How.XPATH,using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    @Step("Проверка успешного входа в профиль")
    public void correctLoginProfileCheck(){
        exitButton.shouldBe(visible);
    }

    @Step("Нажатие на кнопку Конструктор")
    public void constructorButtonClick(){
        constructorButton.click();
    }

    @Step("Нажатие на кнопку Лого")
    public void logoClick(){
        logo.click();
    }

    @Step("Нажатие на кнопку Выход")
    public void exitButtonClick(){
        exitButton.click();
    }
}