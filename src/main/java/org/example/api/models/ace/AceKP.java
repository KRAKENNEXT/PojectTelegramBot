package org.example.api.models.ace;

import com.google.gson.annotations.SerializedName;

public class AceKP extends AceBase{
    @SerializedName("kp")
    private String kp;
    private String kpColour;

    public AceKP() {
    }

    public String getKp() {
        return kp;
    }

    public String getKpColour() {
        return kpColour;
    }

    public void setKpColour(String kpColour) {
        this.kpColour = kpColour;
    }

    @Override
    public String toString() {
        return "Информация по параметру KP\n" +
                "Дата замера: "+date+"\n" +
                "KP: "+kp+"\n" +
                "Цвет: "+kpColour;
    }
}
