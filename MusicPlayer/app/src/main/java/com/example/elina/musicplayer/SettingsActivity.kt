package com.example.elina.musicplayer

import android.os.Bundle
import android.preference.PreferenceActivity
import android.preference.PreferenceManager

class SettingsActivity : PreferenceActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preferences)
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        val currentTheme = sharedPref.getString("pref_theme", "pref_theme_default")
        var themeId = R.style.Theme1
        when (currentTheme) {
            "Theme1" -> themeId = R.style.Theme1
            "Theme2" -> themeId = R.style.Theme2
            "Theme3" -> themeId = R.style.Theme3
            else -> themeId = R.style.Theme1
        }
        setTheme(themeId)
    }
}
