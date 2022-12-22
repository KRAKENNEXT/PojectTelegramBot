package org.example.api.models;

public class LocationHunt {
    private String id;
    private String name;
    private String description;
    private String subdivision;
    private String county;
    private String lat;
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

    public String getCounty() {
        return county;
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
                ", county='" + county + '\'' +
                ", lat='" + lat + '\'' +
                ", longLocation='" + longLocation + '\'' +
                '}';
    }
}
