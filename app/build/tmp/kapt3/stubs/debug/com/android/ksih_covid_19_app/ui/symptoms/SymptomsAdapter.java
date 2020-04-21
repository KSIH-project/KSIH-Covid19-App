package com.android.ksih_covid_19_app.ui.symptoms;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/android/ksih_covid_19_app/ui/symptoms/SymptomsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/android/ksih_covid_19_app/ui/symptoms/SymptomsAdapter$ViewHolder;", "context", "Landroid/content/Context;", "symptomsList", "", "Lcom/android/ksih_covid_19_app/ui/symptoms/SymptomsData;", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getSymptomsList", "()Ljava/util/List;", "setSymptomsList", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class SymptomsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.android.ksih_covid_19_app.ui.symptoms.SymptomsAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.android.ksih_covid_19_app.ui.symptoms.SymptomsData> symptomsList;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.android.ksih_covid_19_app.ui.symptoms.SymptomsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.android.ksih_covid_19_app.ui.symptoms.SymptomsAdapter.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.android.ksih_covid_19_app.ui.symptoms.SymptomsData> getSymptomsList() {
        return null;
    }
    
    public final void setSymptomsList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.android.ksih_covid_19_app.ui.symptoms.SymptomsData> p0) {
    }
    
    public SymptomsAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.android.ksih_covid_19_app.ui.symptoms.SymptomsData> symptomsList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/android/ksih_covid_19_app/ui/symptoms/SymptomsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/android/ksih_covid_19_app/ui/symptoms/SymptomsAdapter;Landroid/view/View;)V", "pos", "", "getPos", "()I", "setPos", "(I)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "setData", "", "symptoms", "Lcom/android/ksih_covid_19_app/ui/symptoms/SymptomsData;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        public android.widget.TextView title;
        private int pos = -1;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTitle() {
            return null;
        }
        
        public final void setTitle(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        public final int getPos() {
            return 0;
        }
        
        public final void setPos(int p0) {
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        com.android.ksih_covid_19_app.ui.symptoms.SymptomsData symptoms) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}