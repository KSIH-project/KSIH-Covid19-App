package com.android.ksih_covid_19_app.ui.symptoms

import android.app.Dialog
import android.os.Bundle
import com.android.ksih_covid_19_app.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * created by CHukwuwaUchenna
 *[BottomSheetDialogFragment] that uses a custom
 * theme which gives the bottomSheet rounded corners
 * and dose not dim the navigation bar if any
 */

open class RoundedBottomSheetDialogFragment : BottomSheetDialogFragment() {
    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog  = BottomSheetDialog(requireContext(),theme)
}