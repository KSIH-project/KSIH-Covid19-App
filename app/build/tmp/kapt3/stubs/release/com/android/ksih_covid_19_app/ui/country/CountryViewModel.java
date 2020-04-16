package com.android.ksih_covid_19_app.ui.country;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/android/ksih_covid_19_app/ui/country/CountryViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "myApplication", "Landroid/app/Application;", "(Landroid/app/Application;)V", "dao", "Lcom/android/ksih_covid_19_app/dataSource/local/Covid19Dao;", "repository", "Lcom/android/ksih_covid_19_app/dataSource/BaseRepository;", "responseMessage", "Landroidx/lifecycle/MutableLiveData;", "Lcom/android/ksih_covid_19_app/utility/Event;", "Lcom/android/ksih_covid_19_app/utility/Result;", "Lcom/android/ksih_covid_19_app/model/Summary;", "getResponseMessage", "()Landroidx/lifecycle/MutableLiveData;", "setResponseMessage", "(Landroidx/lifecycle/MutableLiveData;)V", "getCountryAndNewCasesList", "Landroidx/lifecycle/LiveData;", "", "Lcom/android/ksih_covid_19_app/model/Country;", "getSummaryRemote", "", "refreshList", "app_release"})
public final class CountryViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.android.ksih_covid_19_app.dataSource.BaseRepository repository = null;
    private final com.android.ksih_covid_19_app.dataSource.local.Covid19Dao dao = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.android.ksih_covid_19_app.utility.Event<com.android.ksih_covid_19_app.utility.Result<com.android.ksih_covid_19_app.model.Summary>>> responseMessage;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.android.ksih_covid_19_app.utility.Event<com.android.ksih_covid_19_app.utility.Result<com.android.ksih_covid_19_app.model.Summary>>> getResponseMessage() {
        return null;
    }
    
    public final void setResponseMessage(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.android.ksih_covid_19_app.utility.Event<com.android.ksih_covid_19_app.utility.Result<com.android.ksih_covid_19_app.model.Summary>>> p0) {
    }
    
    private final void getSummaryRemote() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.android.ksih_covid_19_app.model.Country>> getCountryAndNewCasesList() {
        return null;
    }
    
    public final void refreshList() {
    }
    
    public CountryViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application myApplication) {
        super(null);
    }
}