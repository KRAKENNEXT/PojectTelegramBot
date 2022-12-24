package org.example.api.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.example.api.models.LocationHunt;
import org.example.api.models.ace.AceBz;
import org.example.api.models.ace.AceDensity;
import org.example.api.models.ace.AceKP;
import org.example.api.models.ace.AceSpeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SerializeToObject {

    private static final Gson gson = new GsonBuilder().create();

    public static List<LocationHunt> serializeToLocationHunt(String JSON){
        List<LocationHunt> locationHunts = new ArrayList<>();
        JsonElement json = getJsonElement(JSON);

        for (Map.Entry<String, JsonElement> entry: json.getAsJsonObject().asMap().entrySet()){
            if (!entry.getKey().equals("message")){
                locationHunts.add(gson.fromJson(entry.getValue(), LocationHunt.class));
            }
        }

        return locationHunts;
    }

    public static AceKP serializeToAceKP(String JSON){
        JsonElement json = getJsonElement(JSON);
        AceKP aceKP = gson.fromJson(json.getAsJsonObject(), AceKP.class);
        aceKP.setKpColour(json.getAsJsonObject().get("colour").getAsJsonObject().get("kp").getAsString());
        return aceKP;
    }

    public static AceBz serializeToAceBz(String JSON){
        return gson.fromJson(getJsonElement(JSON), AceBz.class);
    }

    public static AceDensity serializeToAceDensity(String JSON){
        return gson.fromJson(getJsonElement(JSON), AceDensity.class);
    }

    public static AceSpeed serializeAceSpeed(String JSON){
        return gson.fromJson(getJsonElement(JSON), AceSpeed.class);
    }

    private static JsonElement getJsonElement(String JSON){
        return JsonParser.parseString(JSON);
    }
}
