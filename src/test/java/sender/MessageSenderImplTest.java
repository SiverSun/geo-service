package sender;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageSenderImplTest {
    GeoService geoServiceImpl;
    LocalizationService localizationServiceImpl;

    @BeforeAll
    public static void startedAll() {
        System.out.println("Начало теста");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println(" Окончание теста");
    }

    GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
    LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
    Location location = Mockito.mock(Location.class);

    @Test
    public void messageRus() {
        Map<String, String> map = new HashMap<>();
        map.put("x-real-ip", "172.0.32.11");
        Mockito.when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String result1 = messageSender.send(map);
        assertEquals("Добро пожаловать", result1);
    }

    @Test
    public void messageUS() {
        Map<String, String> map = new HashMap<>();
        map.put("x-real-ip", "96.44.183.149");
        Mockito.when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String result2 = messageSender.send(map);
        assertEquals("Welcome", result2);
    }
}