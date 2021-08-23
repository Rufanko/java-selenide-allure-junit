package ru.auto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    @Step("Выбрать производителя {make}")
    public SearchPage chooseMake(String make) {
        $(By.xpath("//div[@class='IndexMarks__show-all']")).click();
        $(By.xpath("//div[@class='IndexMarks__item-name'][text()='" + make + "']")).click();
        return page(SearchPage.class);
    }

    @Step("Показать новые автомобили")
    public void showNewCars() {
        $(By.xpath("//div[@class='IndexSelector__sections']//span[@class='Button__content']//span[text()='Новые']")).click();
    }

    @Step("Показать все автомобили")
    public void showAllCars() {
        $(By.xpath("//div[@class='IndexSelector__sections']//span[@class='Button__content']//span[text()='Все']")).click();
    }

    @Step("Показать автомобили с пробегом")
    public void showUsedCars() {
        $(By.xpath("//div[@class='IndexSelector__sections']//span[@class='Button__content']//span[text()='Все']")).click();
    }

    @Step("Показать легковые автомобили")
    public SearchPage showCars() {
        $x("//li[@data-id='cars']").click();
        return page(SearchPage.class);
    }

    @Step("Показать коммерческие автомобили")
    public SearchPage showTrucks() {
        $x("//li[@data-id='trucks']").click();
        return page(SearchPage.class);
    }

    @Step("Показать мотоциклы")
    public SearchPage showMoto() {
        $x("//li[@data-id='moto']").click();
        return page(SearchPage.class);
    }

    @Step("Показать запчасти")
    public SearchPage showParts() {
        $x("//li[@data-id='parts']").click();
        return page(SearchPage.class);
    }

    @Step("Раздел ПроАвто")
    public SearchPage history() {
        $x("//li[@data-id='history']").click();
        return page(SearchPage.class);
    }

    @Step("Гараж")
    public SearchPage garage() {
        $x("//li[@data-id='garage']").click();
        return page(SearchPage.class);
    }

    @Step("Кредиты")
    public SearchPage credits() {
        $x("//li[@data-id='credits']").click();
        return page(SearchPage.class);
    }

    @Step("Журнал")
    public SearchPage mag() {
        $x("//li[@data-id='mag']").click();
        return page(SearchPage.class);
    }

    @Step("Дилерам")
    public SearchPage dealers() {
        $x("//li[@data-id='dealers']").click();
        return page(SearchPage.class);
    }


    @Step("Ввести поисковый запрос {request} и нажать enter")
    public SearchPage fillSearchField(String request) {
        SelenideElement searchField = $(By.xpath("//div[@class='TextInput__placeholder'][text()='Поиск по объявлениям']//following-sibling::input"));
        searchField.click();
        searchField.setValue(request);
        $(By.xpath("//div[@class='SearchLineSuggest__input']//input[@class='TextInput__control']")).shouldHave(Condition.value(request));
        searchField.pressEnter();
        return page(SearchPage.class);
    }


    @Step("Продать авто")
    public PostAdPage sellMyCar() {
        $(By.xpath("//span[@class='Button__text'][text()='Продать']")).click();
        return page(PostAdPage.class);
    }

}
