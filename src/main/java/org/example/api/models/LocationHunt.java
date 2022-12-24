package org.example.api.models;

import com.google.gson.annotations.SerializedName;

public class LocationHunt {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("subdivision")
    private String subdivision;
    @SerializedName("country")
    private String country;
    @SerializedName("lat")
    private String lat;
    @SerializedName("long")
    private String longLocation;

    public LocationHunt() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public String getCountry() {
        return country;
    }

    public String getLat() {
        return lat;
    }

    public String getLongLocation() {
        return longLocation;
    }

    @Override
    public String toString() {
        return "LocationHunt{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", subdivision='" + subdivision + '\'' +
                ", country='" + country + '\'' +
                ", lat='" + lat + '\'' +
                ", longLocation='" + longLocation + '\'' +
                '}';
    }
}
