package com.android.ksih_covid_19_app.dataSource.local;

import java.lang.System;

/**
 * Created by SegunFrancis
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0016\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040\u0003H\'J\u001f\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/android/ksih_covid_19_app/dataSource/local/Covid19Dao;", "", "getCountryAndNewCasesListLocal", "Landroidx/lifecycle/LiveData;", "", "Lcom/android/ksih_covid_19_app/model/Country;", "getLiveByCountryAndStatus", "Lcom/android/ksih_covid_19_app/model/LiveByCountryAndStatusItem;", "setCountryAndNewCasesList", "", "countryList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLiveByCountryAndStatus", "responseList", "app_release"})
public abstract interface Covid19Dao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM LiveByCountryAndStatusItem")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem>> getLiveByCountryAndStatus();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object setLiveByCountryAndStatus(@org.jetbrains.annotations.NotNull()
    java.util.List<com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem> responseList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Country")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.android.ksih_covid_19_app.model.Country>> getCountryAndNewCasesListLocal();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object setCountryAndNewCasesList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.android.ksih_covid_19_app.model.Country> countryList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}