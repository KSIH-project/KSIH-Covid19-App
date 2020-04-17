package com.android.ksih_covid_19_app.dataSource.remote;

import java.lang.System;

/**
 * Created by SegunFrancis
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/android/ksih_covid_19_app/dataSource/remote/RemoteRepo;", "", "getDayOneTotal", "Lretrofit2/Call;", "", "Lcom/android/ksih_covid_19_app/model/DayOneTotalResponseItem;", "country", "", "getLiveByCountryAndStatusRemote", "Lcom/android/ksih_covid_19_app/model/LiveByCountryAndStatusItem;", "getSummary", "Lcom/android/ksih_covid_19_app/model/Summary;", "app_debug"})
public abstract interface RemoteRepo {
    
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<java.util.List<com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem>> getLiveByCountryAndStatusRemote(@org.jetbrains.annotations.NotNull()
    java.lang.String country);
    
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<com.android.ksih_covid_19_app.model.Summary> getSummary();
    
    @org.jetbrains.annotations.NotNull()
    public abstract retrofit2.Call<java.util.List<com.android.ksih_covid_19_app.model.DayOneTotalResponseItem>> getDayOneTotal(@org.jetbrains.annotations.NotNull()
    java.lang.String country);
}