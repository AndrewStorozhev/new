package selenium.pagepbject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final By fieldName = By.xpath(".//input[@placeholder='* Имя']");
    private final By fieldSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By fieldStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By fieldTelephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    WebDriver webDriver;

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OrderPage writeName(String name) {
        webDriver.findElement(fieldName).sendKeys(name);
        return this;
    }

    public OrderPage writeSurname(String surname) {
        webDriver.findElement(fieldSurname).sendKeys(surname);
        return this;
    }

    public OrderPage writeAddress(String orderAddress) {
        webDriver.findElement(fieldAddress).sendKeys(orderAddress);
        return this;
    }

    public OrderPage setInputMetro(String metro) {
        WebElement element = webDriver.findElement(fieldStation);
        element.click();
        element.sendKeys(metro);
        webDriver.findElement(By.xpath(".//button/div[text() = '" + metro + "']")).click();
        return this;
    }

    public OrderPage writeTelephone(String telephone) {
        webDriver.findElement(fieldTelephone).sendKeys(telephone);
        return this;
    }

    public OrderPage clickNext() {
        webDriver.findElement(buttonNext).click();
        return this;
    }
}
