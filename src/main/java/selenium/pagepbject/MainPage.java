package selenium.pagepbject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static selenium.config.AppConfig.APP_URL;

public class MainPage {
    private final By cookieButton = By.className("App_CookieButton__3cvqF");
    private final By topOrderButton = By.className("Button_Button__ra12g");
    private final By bottomOrderButton = By.xpath(".//div[@class = 'Header_Header__214zg']//button[text() = 'Заказать']");
    private final By importantQuestions = By.className("accordion__button");
    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    public MainPage clickCookieButton() {
        webDriver.findElement(cookieButton).click();
        return this;
    }

    public MainPage clickOrderButton(String buttons) {

            if (buttons.contains("Верхняя кнопка")) {
                webDriver.findElement(topOrderButton).click();
            }
            if (buttons.contains("Нижняя нижняя")) {
                WebElement element = webDriver.findElement(bottomOrderButton);
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
                webDriver.findElement(bottomOrderButton).click();
            }
            return this;
        }



    public MainPage scrollToQuestions() {
        WebElement element = webDriver.findElement(importantQuestions);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }


    public MainPage checkAnswer(String questions, String answer, String expectedAnswer) {
        webDriver.findElement(By.xpath(".//div[@id= '" + questions + "']")).click();
        String actualAnswer = webDriver.findElement(By.xpath(".//div[@id= '" + answer + "']")).getText();
        Assert.assertEquals(expectedAnswer, actualAnswer);
        return this;
    }

}


