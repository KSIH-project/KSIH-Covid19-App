package com.android.ksih_covid_19_app.ui.dayOneTotal;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/android/ksih_covid_19_app/ui/dayOneTotal/DayOneTotalFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/android/ksih_covid_19_app/utility/adapter/CountryAdapter$OnCovidItemClickListener;", "()V", "dayOneViewModel", "Lcom/android/ksih_covid_19_app/ui/dayOneTotal/DayOneTotalViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "item", "Lcom/android/ksih_covid_19_app/model/Country;", "refresh", "value", "", "showSnackBar", "message", "", "app_release"})
public final class DayOneTotalFragment extends androidx.fragment.app.Fragment implements com.android.ksih_covid_19_app.utility.adapter.CountryAdapter.OnCovidItemClickListener {
    private com.android.ksih_covid_19_app.ui.dayOneTotal.DayOneTotalViewModel dayOneViewModel;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Navigate to country details
     */
    @java.lang.Override()
    public void onItemClick(@org.jetbrains.annotations.NotNull()
    com.android.ksih_covid_19_app.model.Country item) {
    }
    
    private final void showSnackBar(java.lang.String message) {
    }
    
    private final void refresh(boolean value) {
    }
    
    public DayOneTotalFragment() {
        super();
    }
}