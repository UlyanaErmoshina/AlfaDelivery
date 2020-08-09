import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

class AlfaTest {

    @Test
    void ShouldSendRequest() {
        open("http://localhost:7777");
        SelenideElement form = $(".form");
        form.$("[data-test-id=city] input").setValue("Москва");
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = Date.valueOf((LocalDate.now().plusDays(4)));
        String meetingDate = formatter.format(date);
        form.$("[data-test-id=date] input").sendKeys(Keys.CONTROL + "a");
        form.$("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE);
        form.$("[data-test-id=date] input").setValue(meetingDate);
        form.$("[data-test-id=name] input").setValue("Ермошина Ульяна");
        form.$("[data-test-id=phone] input").setValue("+79655657251");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(byText("Успешно!")).waitUntil(visible, 15000);
    }

}
