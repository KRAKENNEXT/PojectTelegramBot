import org.example.Main;
import org.example.api.Auroras;

import static org.junit.jupiter.api.Assertions.*;

import org.example.api.exceptions.ClientException;
import org.example.api.exceptions.ProcessingDataException;
import org.example.api.exceptions.ServiceNotAvailableException;
import org.example.api.models.LocationHunt;
import org.example.api.models.ace.AceBz;
import org.example.api.models.ace.AceDensity;
import org.example.api.models.ace.AceKP;
import org.example.api.models.ace.AceSpeed;
import org.example.telegram.helper.Helper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestApplication {
    private final Auroras api = new Auroras();

    @Test
    public void testConnectionAPI() {
        assertDoesNotThrow(api::getLocationsForHunt);
    }

    @Test
    public void testConnectionTelegram() {
        assertDoesNotThrow(Main::start);
    }

    @Test
    public void testIsButtonId() {
        List<String> validData = List.of("MENU", "KP", "HUNT", "BACK_ACE", "SPEED");
        List<String> notValidData = List.of("TEST", "wether", "KPS", "MEnU", "bz");

        validData.forEach(i->assertTrue(Helper.isButtonId(i)));

        notValidData.forEach(i->assertFalse(Helper.isButtonId(i)));
    }

    @Test
    public void testFindLocationsForHunt() throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        var items = api.getLocationsForHunt();
        items.forEach(i-> assertInstanceOf(LocationHunt.class, i));
    }

    @Test
    public void testGetAceKP() throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        assertDoesNotThrow(api::getAceKp);
        assertInstanceOf(AceKP.class, api.getAceKp());
    }

    @Test
    public void testGetBZ() throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        assertDoesNotThrow(api::getAceBz);
        assertInstanceOf(AceBz.class, api.getAceBz());
    }

    @Test
    public void testGetDensity() throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        assertDoesNotThrow(api::getAceDensity);
        assertInstanceOf(AceDensity.class, api.getAceDensity());
    }

    @Test
    public void testGetSpeed() throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        assertDoesNotThrow(api::getAceSpeed);
        assertInstanceOf(AceSpeed.class, api.getAceSpeed());
    }
}
