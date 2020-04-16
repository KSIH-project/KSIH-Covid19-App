package com.android.ksih_covid_19_app.ui.dayOneTotal;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b0\u0018J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0006\u0010\u001f\u001a\u00020\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/android/ksih_covid_19_app/ui/dayOneTotal/DayOneTotalViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "myApplication", "Landroid/app/Application;", "(Landroid/app/Application;)V", "dao", "Lcom/android/ksih_covid_19_app/dataSource/local/Covid19Dao;", "dayOneResponseMessage", "Landroidx/lifecycle/MutableLiveData;", "Lcom/android/ksih_covid_19_app/utility/Event;", "Lcom/android/ksih_covid_19_app/utility/Result;", "", "Lcom/android/ksih_covid_19_app/model/DayOneTotalResponseItem;", "getDayOneResponseMessage", "()Landroidx/lifecycle/MutableLiveData;", "setDayOneResponseMessage", "(Landroidx/lifecycle/MutableLiveData;)V", "repository", "Lcom/android/ksih_covid_19_app/dataSource/BaseRepository;", "responseMessage", "Lcom/android/ksih_covid_19_app/model/Summary;", "getResponseMessage", "setResponseMessage", "getDayOneCasesList", "Landroidx/lifecycle/LiveData;", "Lcom/android/ksih_covid_19_app/model/Country;", "getDayOneTotal", "", "country", "", "getSummaryRemote", "refreshList", "app_debug"})
public final class DayOneTotalViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.android.ksih_covid_19_app.dataSource.BaseRepository repository = null;
    private final com.android.ksih_covid_19_app.dataSource.local.Covid19Dao dao = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.android.ksih_covid_19_app.utility.Event<com.android.ksih_covid_19_app.utility.Result<com.android.ksih_covid_19_app.model.Summary>>> responseMessage;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.android.ksih_covid_19_app.utility.Event<com.android.ksih_covid_19_app.utility.Result<java.util.List<com.android.ksih_covid_19_app.model.DayOneTotalResponseItem>>>> dayOneResponseMessage;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.android.ksih_covid_19_app.utility.Event<com.android.ksih_covid_19_app.utility.Result<com.android.ksih_covid_19_app.model.Summary>>> getResponseMessage() {
        return null;
    }
    
    public final void setResponseMessage(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.android.ksih_covid_19_app.utility.Event<com.android.ksih_covid_19_app.utility.Result<com.android.ksih_covid_19_app.model.Summary>>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.android.ksih_covid_19_app.utility.Event<com.android.ksih_covid_19_app.utility.Result<java.util.List<com.android.ksih_covid_19_app.model.DayOneTotalResponseItem>>>> getDayOneResponseMessage() {
        return null;
    }
    
    public final void setDayOneResponseMessage(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.android.ksih_covid_19_app.utility.Event<com.android.ksih_covid_19_app.utility.Result<java.util.List<com.android.ksih_covid_19_app.model.DayOneTotalResponseItem>>>> p0) {
    }
    
    private final void getSummaryRemote() {
    }
    
    public final void getDayOneTotal(@org.jetbrains.annotations.NotNull()
    java.lang.String country) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.android.ksih_covid_19_app.model.Country>> getDayOneCasesList() {
        return null;
    }
    
    public final void refreshList() {
    }
    
    public DayOneTotalViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application myApplication) {
        super(null);
    }
}