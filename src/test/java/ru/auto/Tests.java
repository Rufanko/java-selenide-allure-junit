package ru.auto;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Tests extends BaseTest {

    @Feature("Первый тест")
    @Test
    @DisplayName("Проверка результатов поиска")
    public void firstTest() throws InterruptedException {
        new MainPage().fillSearchField("Mark 2")
                .checkResult("Toyota Mark");
    }

    @Feature("Второй тест")
    @Test
    @DisplayName("Создание нового объявления")
    public void secnodTest() throws InterruptedException {
        new MainPage().sellMyCar()
                .showAllMakes()
                .selectMake("Nissan")
                .showAllModels()
                .selectModel("Skyline")
                .selectYear("2011")
                .selectBody("Седан")
                .selectGeneration("XII (V36) Рестайлинг")
                .selectDrive("Задний")
                .selectMod("225")
                .checkInfo("2011", "Седан", "XII (V36) Рестайлинг");
    }
}
