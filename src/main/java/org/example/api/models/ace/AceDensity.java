package org.example.api.models.ace;

import com.google.gson.annotations.SerializedName;

public class AceDensity extends AceBase{
    @SerializedName("density")
    private String density;
    @SerializedName("colour")
    private String colour;

    public AceDensity() {
    }

    public String getDensity() {
        return density;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "AceDensity{\n" +
                "density='" + density + '\'' + '\n'+
                ", colour='" + colour + '\'' + '\n'+
                ", date='" + date + '\'' + '\n'+
                '}';
    }
}
