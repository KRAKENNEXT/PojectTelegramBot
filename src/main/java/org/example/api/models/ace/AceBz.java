package org.example.api.models.ace;

import com.google.gson.annotations.SerializedName;

public class AceBz extends AceBase{
    @SerializedName("bz")
    private String bz;
    @SerializedName("colour")
    private String colour;

    public AceBz() {
    }

    public String getBz() {
        return bz;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "Информация по параметру BZ\n" +
                "Дата замера: "+date+"\n" +
                "BZ: "+bz+"\n" +
                "Цвет: "+colour;
    }
}
