package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    @BeforeAll
    public static void startedAll() {
        System.out.println("Начало теста");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println(" Окончание теста");
    }

    @Test
    public void localeRus() {
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        String expected = localizationService.locale(Country.RUSSIA);
        String actual = "Добро пожаловать";
        Assertions.assertEquals(expected, actual);
    }

    public void localeUS() {
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        String expected = localizationService.locale(Country.USA);
        String actual = "Welcome";
        Assertions.assertEquals(expected, actual);
    }
}