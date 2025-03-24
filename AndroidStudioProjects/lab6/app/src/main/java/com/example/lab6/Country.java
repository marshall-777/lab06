package com.example.lab6;

public class Country {
    private String countryName;
    private String flagName;
    private int population;

    public Country(String countryName, String flagName, int population) {
        this.countryName = countryName;
        this.flagName = flagName;
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getFlagName() {
        return flagName;
    }

    public int getPopulation() {
        return population;
    }
}
