package com.android.ksih_covid_19_app.dataSource.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J \u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\'\u00a8\u0006\f"}, d2 = {"Lcom/android/ksih_covid_19_app/dataSource/remote/Covid19Api;", "", "getDayOneTotal", "Lretrofit2/Call;", "", "Lcom/android/ksih_covid_19_app/model/DayOneTotalResponseItem;", "country", "", "getLiveByCountryAndStatus", "Lcom/android/ksih_covid_19_app/model/LiveByCountryAndStatusItem;", "getSummary", "Lcom/android/ksih_covid_19_app/model/Summary;", "app_release"})
public abstract interface Covid19Api {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "live/country/{country}/status/confirmed")
    public abstract retrofit2.Call<java.util.List<com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem>> getLiveByCountryAndStatus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "country")
    java.lang.String country);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "total/dayone/country/{country}/status/confirmed")
    public abstract retrofit2.Call<java.util.List<com.android.ksih_covid_19_app.model.DayOneTotalResponseItem>> getDayOneTotal(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "country")
    java.lang.String country);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "summary")
    public abstract retrofit2.Call<com.android.ksih_covid_19_app.model.Summary> getSummary();
}