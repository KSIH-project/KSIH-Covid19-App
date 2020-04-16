package com.android.ksih_covid_19_app.ui.liveByCountryAndStatus;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/android/ksih_covid_19_app/ui/liveByCountryAndStatus/LiveByCountryAndStatusFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/android/ksih_covid_19_app/utility/adapter/LiveByCountryAdapter$OnCovidItemClickListener;", "()V", "viewModel", "Lcom/android/ksih_covid_19_app/ui/liveByCountryAndStatus/LiveByCountryAndStatusViewModel;", "onItemClick", "", "item", "Lcom/android/ksih_covid_19_app/model/Country;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "refresh", "value", "", "showSnackBar", "message", "", "app_release"})
public final class LiveByCountryAndStatusFragment extends androidx.fragment.app.Fragment implements com.android.ksih_covid_19_app.utility.adapter.LiveByCountryAdapter.OnCovidItemClickListener {
    private com.android.ksih_covid_19_app.ui.liveByCountryAndStatus.LiveByCountryAndStatusViewModel viewModel;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Navigate to bottomSheetDialog
     */
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.NotNull()
    com.android.ksih_covid_19_app.model.Country item) {
    }
    
    private final void showSnackBar(java.lang.String message) {
    }
    
    private final void refresh(boolean value) {
    }
    
    public LiveByCountryAndStatusFragment() {
        super();
    }
}