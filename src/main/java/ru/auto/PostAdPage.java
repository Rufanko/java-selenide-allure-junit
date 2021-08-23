package ru.auto;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PostAdPage {
    @Step("Нажимает кнопку 'все марки'")
    public PostAdPage showAllMakes() {
        $(By.xpath("//span[text()='Все марки']")).click();
        return page(PostAdPage.class);
    }

    @Step("Выбираем марку из списка")
    public PostAdPage selectMake(String make) {
        $(By.xpath("//div[@class='marks-list__list marks-list__list_full marks-list__list_visible']//img[@title='" + make + "']")).click();
        return page(PostAdPage.class);
    }

    @Step("Нажимает кнопку 'все модели'")
    public PostAdPage showAllModels() {
        $x("//span[text()='Все модели']");
        return page(PostAdPage.class);
    }

    @Step("Выбираем модель из списка")
    public PostAdPage selectModel(String model) {
        $x("//div[@class='menu-item menu-item_theme_islands models-list__item i-bem'][text()='" + model + "']").click();
        return page(PostAdPage.class);
    }

    @Step("Выбираем год из списка")
    public PostAdPage selectYear(String year) {
        $x("//button[contains(@class, 'button button_togglable_radio button_t')]//span[text()='" + year + "']").click();
        return page(PostAdPage.class);
    }

    @Step("Выбираем кузов из списка")
    public PostAdPage selectBody(String body) {
        $x("//div[@class='body-radio__text'][text()='" + body + "']//..").should(Condition.exist).click();
        return page(PostAdPage.class);
    }

    @Step("Выбираем поколение из списка")
    public PostAdPage selectGeneration(String gen) {
        $x("//div[@class='generations-list__title'][text()='" + gen + "']").click();
        return page(PostAdPage.class);
    }

    @Step("Выбираем привод из списка")
    public PostAdPage selectDrive(String drive) {
        $x("//span[@class='button__text'][text()='" + drive + "']").click();
        return page(PostAdPage.class);
    }
    @Step("Выбираем модификацию")
    public PostAdPage selectMod(String hp) {
        $x("//div[@class='i-techparams-name__power'][contains(text(), '" + hp + "')]").click();
        return page(PostAdPage.class);
    }

    @Step("Проверяем, что отобразились верные данные в карточке")
    public PostAdPage checkInfo(String year, String body, String gen) {
        Assertions.assertTrue($x("//div[@class='mmm-line__line']//div[contains(@data-bem, '" + year + "')]").exists());
        Assertions.assertTrue($x("//div[@class='mmm-line__line']//div[contains(@data-bem, '" + body + "')]").exists());
        Assertions.assertTrue($x("//div[@class='mmm-line__line']//div[contains(@data-bem, '" + gen + "')]").exists());
        return page(PostAdPage.class);
    }

}
