package com.android.ksih_covid_19_app.dataSource;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0016J\u001e\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\n0\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001e\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\n0\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011H\u0016J\u001f\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/android/ksih_covid_19_app/dataSource/BaseRepository;", "Lcom/android/ksih_covid_19_app/dataSource/remote/RemoteRepo;", "Lcom/android/ksih_covid_19_app/dataSource/local/LocalRepo;", "api", "Lcom/android/ksih_covid_19_app/dataSource/remote/Covid19Api;", "dao", "Lcom/android/ksih_covid_19_app/dataSource/local/Covid19Dao;", "(Lcom/android/ksih_covid_19_app/dataSource/remote/Covid19Api;Lcom/android/ksih_covid_19_app/dataSource/local/Covid19Dao;)V", "getCountryAndNewCasesListLocal", "Landroidx/lifecycle/LiveData;", "", "Lcom/android/ksih_covid_19_app/model/Country;", "getLiveByCountryAndStatusLocal", "Lcom/android/ksih_covid_19_app/model/LiveByCountryAndStatusItem;", "country", "", "getLiveByCountryAndStatusRemote", "Lretrofit2/Call;", "getSummary", "Lcom/android/ksih_covid_19_app/model/Summary;", "setCountryAndNewCasesListLocal", "", "countryList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLiveByCountryAndStatusLocal", "responseList", "app_debug"})
public final class BaseRepository implements com.android.ksih_covid_19_app.dataSource.remote.RemoteRepo, com.android.ksih_covid_19_app.dataSource.local.LocalRepo {
    private final com.android.ksih_covid_19_app.dataSource.remote.Covid19Api api = null;
    private final com.android.ksih_covid_19_app.dataSource.local.Covid19Dao dao = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public retrofit2.Call<java.util.List<com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem>> getLiveByCountryAndStatusRemote(@org.jetbrains.annotations.NotNull()
    java.lang.String country) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem>> getLiveByCountryAndStatusLocal(@org.jetbrains.annotations.NotNull()
    java.lang.String country) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object setLiveByCountryAndStatusLocal(@org.jetbrains.annotations.NotNull()
    java.util.List<com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem> responseList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.LiveData<java.util.List<com.android.ksih_covid_19_app.model.Country>> getCountryAndNewCasesListLocal() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object setCountryAndNewCasesListLocal(@org.jetbrains.annotations.NotNull()
    java.util.List<com.android.ksih_covid_19_app.model.Country> countryList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public retrofit2.Call<com.android.ksih_covid_19_app.model.Summary> getSummary() {
        return null;
    }
    
    public BaseRepository(@org.jetbrains.annotations.NotNull()
    com.android.ksih_covid_19_app.dataSource.remote.Covid19Api api, @org.jetbrains.annotations.NotNull()
    com.android.ksih_covid_19_app.dataSource.local.Covid19Dao dao) {
        super();
    }
}