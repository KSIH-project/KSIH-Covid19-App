
package com.android.ksih_covid_19_app.Model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountrySummary implements Serializable {

    private final static long serialVersionUID = -6017823349086103753L;
    @SerializedName("Global")
    @Expose
    private Global global;
    @SerializedName("Countries")
    @Expose
    private List<Country> countries = null;
    @SerializedName("Date")
    @Expose
    private String date;

    /**
     * No args constructor for use in serialization
     */
    public CountrySummary() {
    }

    /**
     * @param date
     * @param global
     * @param countries
     */
    public CountrySummary(Global global, List<Country> countries, String date) {
        super();
        this.global = global;
        this.countries = countries;
        this.date = date;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
