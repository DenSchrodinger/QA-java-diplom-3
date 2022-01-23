package com.PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;

public class MainPage{
    public final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement enterProfileButton;

    @FindBy(how = How.XPATH,using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalProfileButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunTab;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'current')]/span[text()='Булки']")
    private SelenideElement selectedBunTab;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceTab;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'current')]/span[text()='Соусы']")
    private SelenideElement selectedSauceTab;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingTab;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'current')]/span[text()='Начинки']")
    private SelenideElement selectedFillingTab;

    @FindBy(how = How.XPATH,using = "//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement bunR2D3;

    @Step("Вход в аккаунт")
    public void enterProfileButtonClick(){
        enterProfileButton.click();
    }

    @Step ("Вход на страницу Личного кабинета")
    public void personalProfileButtonClick(){
        personalProfileButton.click();
    }

    @Step("Проверка наличия текста Соусы и Начинки")
    public void saucesAndFillingTextCheck(){
        sauceTab.shouldBe(visible);
        fillingTab.shouldBe(visible);
    }

    @Step("Проверка видимости вкладок и переход по ним в конструкторе")
    public void correctJumpBetweenTabsCheck(){
        sauceTab.click();
        selectedSauceTab.shouldBe(visible);
        bunTab.click();
        selectedBunTab.shouldBe(visible);
        fillingTab.click();
        selectedFillingTab.shouldBe(visible);
    }

    @Step("Проверка наличия булки 'Флюоресцентная булка R2-D3'.")
    public void bunR2D3ShouldBeVisible(){
        bunR2D3.shouldBe(visible, enabled);
    }
}