package com.android.ksih_covid_19_app.utility.adapter;

import java.lang.System;

/**
 * Created by SegunFrancis
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/android/ksih_covid_19_app/utility/adapter/DayOneAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/android/ksih_covid_19_app/model/DayOneTotalResponseItem;", "Lcom/android/ksih_covid_19_app/utility/adapter/DayOneAdapter$DayOneViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DayOneViewHolder", "DiffUtilCallBack", "app_release"})
public final class DayOneAdapter extends androidx.recyclerview.widget.ListAdapter<com.android.ksih_covid_19_app.model.DayOneTotalResponseItem, com.android.ksih_covid_19_app.utility.adapter.DayOneAdapter.DayOneViewHolder> {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.android.ksih_covid_19_app.utility.adapter.DayOneAdapter.DayOneViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.android.ksih_covid_19_app.utility.adapter.DayOneAdapter.DayOneViewHolder holder, int position) {
    }
    
    public DayOneAdapter() {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/android/ksih_covid_19_app/utility/adapter/DayOneAdapter$DayOneViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/android/ksih_covid_19_app/model/DayOneTotalResponseItem;", "app_release"})
    public static final class DayOneViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.android.ksih_covid_19_app.model.DayOneTotalResponseItem item) {
        }
        
        public DayOneViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/android/ksih_covid_19_app/utility/adapter/DayOneAdapter$DiffUtilCallBack;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/android/ksih_covid_19_app/model/DayOneTotalResponseItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    public static final class DiffUtilCallBack extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.android.ksih_covid_19_app.model.DayOneTotalResponseItem> {
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.android.ksih_covid_19_app.model.DayOneTotalResponseItem oldItem, @org.jetbrains.annotations.NotNull()
        com.android.ksih_covid_19_app.model.DayOneTotalResponseItem newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.android.ksih_covid_19_app.model.DayOneTotalResponseItem oldItem, @org.jetbrains.annotations.NotNull()
        com.android.ksih_covid_19_app.model.DayOneTotalResponseItem newItem) {
            return false;
        }
        
        public DiffUtilCallBack() {
            super();
        }
    }
}