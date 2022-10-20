package geo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

class GeoServiceImplTest {

    @BeforeAll
    public static void startedAll() {
        System.out.println("Начало теста");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println(" Окончание теста");
    }

    @Test
    public void ipRus() {
        String ip = "172.0.32.11";
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);
        Country assertCountry = location.getCountry();
        Assertions.assertSame(assertCountry, RUSSIA);
    }

    @Test
    public void ipUs() {
        String ip = "96.44.183.149";
        Location location = new Location("New York", Country.USA, " 10th Avenue", 32);
        GeoServiceImpl geoservice = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoservice.byIp(ip)).thenReturn(location);
        Country assertCountry = location.getCountry();
        Assertions.assertSame(assertCountry, USA);
    }

}