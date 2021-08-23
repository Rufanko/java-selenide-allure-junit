package ru.auto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    @Step("проверяем результаты запроса {request}")
    public void checkResult(String requst) throws InterruptedException {
        List<SelenideElement> resultList = new ArrayList<>();
        List<SelenideElement> nextButtons = $$x("//span[@class='Button__text'][text()='Следующая, Ctrl ']");
        if (nextButtons.size() > 0) {
            SelenideElement nextButton = $x("//span[@class='Button__text'][text()='Следующая, Ctrl ']");
            List<SelenideElement> disabledButton = $$x("//span[@class='Button__text'][text()='Следующая, Ctrl ']//..//..//..//a[contains(@class, 'disabled ')][contains(@class, 'next')]");
            while (disabledButton.size() == 0) {
                $(By.xpath("//a[@class='Link ListingItemTitle__link']")).should(Condition.exist);
                resultList.addAll($$(By.xpath("//a[@class='Link ListingItemTitle__link']")));
                nextButton.click();
                disabledButton = $$x("//span[@class='Button__text'][text()='Следующая, Ctrl ']//..//..//..//a[contains(@class, 'disabled ')][contains(@class, 'next')]");
            }
        } else {
            $(By.xpath("//a[@class='Link ListingItemTitle__link']")).should(Condition.exist);
            resultList.addAll($$(By.xpath("//a[@class='Link ListingItemTitle__link']")));
        }
        resultList.forEach(x -> System.out.println(x.getText()));
        resultList.forEach(x -> Assertions.assertTrue(x.getText().contains(requst)));
    }
}
