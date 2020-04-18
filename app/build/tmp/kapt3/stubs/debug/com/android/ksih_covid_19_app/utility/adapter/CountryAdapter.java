package com.android.ksih_covid_19_app.utility.adapter;

import java.lang.System;

/**
 * Created by SegunFrancis
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0014\u0010\t\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/android/ksih_covid_19_app/utility/adapter/CountryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/android/ksih_covid_19_app/utility/adapter/CountryAdapter$LiveByCountryViewHolder;", "listener", "Lcom/android/ksih_covid_19_app/utility/adapter/CountryAdapter$OnCovidItemClickListener;", "(Lcom/android/ksih_covid_19_app/utility/adapter/CountryAdapter$OnCovidItemClickListener;)V", "countryList", "", "Lcom/android/ksih_covid_19_app/model/Country;", "displayData", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "LiveByCountryViewHolder", "OnCovidItemClickListener", "app_debug"})
public final class CountryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.android.ksih_covid_19_app.utility.adapter.CountryAdapter.LiveByCountryViewHolder> {
    private java.util.List<com.android.ksih_covid_19_app.model.Country> countryList;
    private final com.android.ksih_covid_19_app.utility.adapter.CountryAdapter.OnCovidItemClickListener listener = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.android.ksih_covid_19_app.utility.adapter.CountryAdapter.LiveByCountryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.android.ksih_covid_19_app.utility.adapter.CountryAdapter.LiveByCountryViewHolder holder, int position) {
    }
    
    public final void displayData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.android.ksih_covid_19_app.model.Country> countryList) {
    }
    
    public CountryAdapter(@org.jetbrains.annotations.NotNull()
    com.android.ksih_covid_19_app.utility.adapter.CountryAdapter.OnCovidItemClickListener listener) {
        super();
    }
    
    /**
     * Handles recyclerView item click
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/android/ksih_covid_19_app/utility/adapter/CountryAdapter$OnCovidItemClickListener;", "", "onItemClick", "", "item", "Lcom/android/ksih_covid_19_app/model/Country;", "app_debug"})
    public static abstract interface OnCovidItemClickListener {
        
        /**
         * Navigate to bottomSheetDialog
         */
        public abstract void onItemClick(@org.jetbrains.annotations.NotNull()
        com.android.ksih_covid_19_app.model.Country item);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/android/ksih_covid_19_app/utility/adapter/CountryAdapter$LiveByCountryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/android/ksih_covid_19_app/model/Country;", "listener", "Lcom/android/ksih_covid_19_app/utility/adapter/CountryAdapter$OnCovidItemClickListener;", "app_debug"})
    public static final class LiveByCountryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.android.ksih_covid_19_app.model.Country item, @org.jetbrains.annotations.NotNull()
        com.android.ksih_covid_19_app.utility.adapter.CountryAdapter.OnCovidItemClickListener listener) {
        }
        
        public LiveByCountryViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}