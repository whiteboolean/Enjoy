package com.example.enjoy.rxjava_derry.day01

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.enjoy.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}