package org.example.api.models.ace;

import com.google.gson.annotations.SerializedName;

abstract public class AceBase {
    @SerializedName("date")
    protected String date;

    public String getDate() {
        return date;
    }
}
