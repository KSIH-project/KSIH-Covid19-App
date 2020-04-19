package com.android.ksih_covid_19_app.ui.summary;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/android/ksih_covid_19_app/ui/summary/SummaryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/android/ksih_covid_19_app/ui/summary/SummaryAdapter;", "connectivityReceiver", "Lcom/android/ksih_covid_19_app/ui/summary/SummaryFragment$ConnectivityReceiver;", "getConnectivityReceiver", "()Lcom/android/ksih_covid_19_app/ui/summary/SummaryFragment$ConnectivityReceiver;", "setConnectivityReceiver", "(Lcom/android/ksih_covid_19_app/ui/summary/SummaryFragment$ConnectivityReceiver;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewModel", "Lcom/android/ksih_covid_19_app/ui/summary/MainSummaryViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "setUpAdapter", "setUpObservers", "ConnectivityReceiver", "app_debug"})
public final class SummaryFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.android.ksih_covid_19_app.ui.summary.SummaryFragment.ConnectivityReceiver connectivityReceiver;
    private com.android.ksih_covid_19_app.ui.summary.MainSummaryViewModel viewModel;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.android.ksih_covid_19_app.ui.summary.SummaryAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final com.android.ksih_covid_19_app.ui.summary.SummaryFragment.ConnectivityReceiver getConnectivityReceiver() {
        return null;
    }
    
    public final void setConnectivityReceiver(@org.jetbrains.annotations.Nullable()
    com.android.ksih_covid_19_app.ui.summary.SummaryFragment.ConnectivityReceiver p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setUpObservers() {
    }
    
    private final void setUpAdapter() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    public SummaryFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/android/ksih_covid_19_app/ui/summary/SummaryFragment$ConnectivityReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/android/ksih_covid_19_app/ui/summary/SummaryFragment;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_debug"})
    public final class ConnectivityReceiver extends android.content.BroadcastReceiver {
        
        @java.lang.Override()
        public void onReceive(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.content.Intent intent) {
        }
        
        public ConnectivityReceiver() {
            super();
        }
    }
}