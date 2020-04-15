package com.android.ksih_covid_19_app.utility

import java.text.DecimalFormat

object Constants {
    const val BASE_URL = "https://api.covid19api.com/"

    const val COUNTRY_BUNDLE_CODE = "country"

    fun String.toFlagEmoji(): String {
        val countryCodeCaps = this.toUpperCase()
        val firstLetter = Character.codePointAt(countryCodeCaps, 0) - 0x41 + 0x1F1E6
        val secondLetter = Character.codePointAt(countryCodeCaps, 1) - 0x41 + 0x1F1E6
        return String(Character.toChars(firstLetter)) + String(Character.toChars(secondLetter))
    }

    fun percentageCase(value: Int, confirmed: Int): String {
        val percentage = value.toDouble().div(confirmed.toDouble()).times(100.0)
        val format = DecimalFormat("0.00")
        return format.format(percentage)
    }
}