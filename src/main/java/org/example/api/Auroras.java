package org.example.api;

import org.example.api.exceptions.ClientException;
import org.example.api.exceptions.ProcessingDataException;
import org.example.api.exceptions.ServiceNotAvailableException;
import org.example.api.models.LocationHunt;
import org.example.api.models.ace.AceBz;
import org.example.api.models.ace.AceDensity;
import org.example.api.models.ace.AceKP;
import org.example.api.models.ace.AceSpeed;
import org.example.api.parser.SerializeToObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Auroras {
    private HttpClient client;

    public Auroras(){
        client = HttpClient.newBuilder().build();
    }

    public List<LocationHunt> getLocationsForHunt() throws ClientException, ServiceNotAvailableException, ProcessingDataException {
        String url = "https://api.auroras.live/v1/?type=locations";
        return SerializeToObject.serializeToLocationHunt(sendRequest(url));
    }

    public LocationHunt getSearchLocation(String id) throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        List<LocationHunt> allLocations = getLocationsForHunt();

        return allLocations.stream().filter(i->i.getId().equals(id)).findFirst().orElseThrow();
    }

    public AceKP getAceKp() throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        String url = "https://api.auroras.live/v1/?type=ace&data=kp";
        return SerializeToObject.serializeToAceKP(sendRequest(url));
    }

    public AceBz getAceBz() throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        String url = "https://api.auroras.live/v1/?type=ace&data=bz";
        return SerializeToObject.serializeToAceBz(sendRequest(url));
    }

    public AceDensity getAceDensity() throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        String url = "https://api.auroras.live/v1/?type=ace&data=density";
        return SerializeToObject.serializeToAceDensity(sendRequest(url));
    }

    public AceSpeed getAceSpeed() throws ServiceNotAvailableException, ProcessingDataException, ClientException {
        String url = "https://api.auroras.live/v1/?type=ace&data=speed";
        return SerializeToObject.serializeAceSpeed(sendRequest(url));
    }




    private String sendRequest(String url) throws ClientException, ServiceNotAvailableException, ProcessingDataException {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
        HttpResponse<String> response = null;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()>=400&&response.statusCode()<500)
                throw new ClientException("Произошла ошибка на стороне клиента");

            else if (response.statusCode()>=500) {
                throw new ServiceNotAvailableException("Сервис в данный момент не доступен");
            }

        }catch (IOException | InterruptedException ex){
            throw new ProcessingDataException(ex.getLocalizedMessage());
        }

        return response.body();
    }
}
