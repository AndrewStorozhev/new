package selenium;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import selenium.pagepbject.MainPage;
import selenium.pagepbject.OrderPage;
import selenium.pagepbject.RentPage;

@RunWith(Parameterized.class)

public class OrderTest extends BaseTest {
    private final String orderButtons;
    private final String name;
    private final String surname;
    private final String addressOrder;
    private final String station;
    private final String telephone;
    private final String date;
    private final String rentalPeriod;
    private final String colorScooter;
    private final String message;

    public OrderTest(String orderButtons, String name, String surname, String addressOrder, String station, String telephone, String date, String rentalPeriod, String colorScooter, String message) {
        this.orderButtons = orderButtons;
        this.name = name;
        this.surname = surname;
        this.addressOrder = addressOrder;
        this.station = station;
        this.telephone = telephone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.colorScooter = colorScooter;
        this.message = message;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderParam() {
        return new Object[][]{
                {"Верхняя кнопка", "Джек", "Воробей", "Карибы", "Речной вокзал", "13131313666", "13.10.2023", "сутки", "чёрный жемчуг", "Капитан Джек Воробей!"},
                {"Нижняя нижняя", "Шляпник", "Безумный", "Страна чудес", "Цветной бульвар", "10610610610", "10.06.2023", "трое суток", "серая безысходность", "Безумцы всех умней!"},
        };
    }

    @Test
    public void makeOrder() {
        new MainPage(webDriver)
                .clickCookieButton()
                .clickOrderButton(orderButtons);
        new OrderPage(webDriver)
                .writeName(name)
                .writeSurname(surname)
                .writeAddress(addressOrder)
                .setInputMetro(station)
                .writeTelephone(telephone)
                .clickNext();
        new RentPage(webDriver)
                .writeDate(date)
                .clickRentalPeriod()
                .setRentalPeriod(rentalPeriod)
                .setSelectColor(colorScooter)
                .writeMessage(message)
                .makeOrderButton()
                .valideOrder()
                .checkOrderNumber();

    }

}




