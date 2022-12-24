package org.example.api.models.ace;

import com.google.gson.annotations.SerializedName;

public class AceSpeed extends AceBase{
    @SerializedName("speed")
    private String speed;
    @SerializedName("colour")
    private String colour;

    public AceSpeed() {
    }

    public String getSpeed() {
        return speed;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "AceSpeed{" +
                "speed='" + speed + '\'' +
                ", colour='" + colour + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
