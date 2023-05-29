package selenium.pagepbject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RentPage {
    private final By fieldDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By fieldRentalPeriod = By.xpath(".//span[@class='Dropdown-arrow']");
    private final By oneDayRentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    private final By twoDayRentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");
    private final By threeDayRentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='трое суток']");
    private final By fourDayRentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='четверо суток']");
    private final By fiveDayRentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='пятеро суток']");
    private final By sixDayRentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='шестеро суток']");
    private final By sevenDayRentalPeriod = By.xpath(".//div[@class='Dropdown-option' and text()='семеро суток']");
    private final By selectBlackColor = By.xpath(".//input[@id='black']");
    private final By selectGreyColor = By.xpath(".//input[@id='grey']");
    private final By fieldMessageСourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By buttonValideOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private final By orderNumber = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");
    WebDriver webDriver;

    public RentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public RentPage writeDate(String date) {
        webDriver.findElement(fieldDate).sendKeys(date);
        return this;
    }

    public RentPage clickRentalPeriod() {
        webDriver.findElement(fieldRentalPeriod).click();
        return this;
    }

    public RentPage setRentalPeriod(String day) {
        if (day.contains("сутки")) {
            webDriver.findElement(oneDayRentalPeriod).click();
        }
        if (day.contains("двое суток")) {
            webDriver.findElement(twoDayRentalPeriod).click();
        }
        if (day.contains("трое суток")) {
            webDriver.findElement(threeDayRentalPeriod).click();
        }
        if (day.contains("четверо суток")) {
            webDriver.findElement(fourDayRentalPeriod).click();
        }
        if (day.contains("пятеро суток")) {
            webDriver.findElement(fiveDayRentalPeriod).click();
        }
        if (day.contains("шестеро суток")) {
            webDriver.findElement(sixDayRentalPeriod).click();
        }
        if (day.contains("семеро суток")) {
            webDriver.findElement(sevenDayRentalPeriod).click();
        }
        return this;
    }


    public RentPage setSelectColor(String color) {
        if (color.contains("чёрный жемчуг")) {
            webDriver.findElement(selectBlackColor).click();
        }
        if (color.contains("серая безысходность")) {
            webDriver.findElement(selectGreyColor).click();
        }
        return this;
    }

    public RentPage writeMessage(String message) {
        webDriver.findElement(fieldMessageСourier).sendKeys(message);
        return this;
    }

    public RentPage makeOrderButton() {
        webDriver.findElement(buttonOrder).click();
        return this;
    }

    public RentPage valideOrder() {
        webDriver.findElement(buttonValideOrder).click();
        return this;
    }

    public RentPage checkOrderNumber() {
        boolean isDisplayed = webDriver.findElement(orderNumber).isDisplayed();
        assertTrue(isDisplayed);
        return this;
    }
}