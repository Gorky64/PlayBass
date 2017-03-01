package com.example.goran.playbass;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by Goran on 16.1.2017..
 */

public class CustomPreferenceFragment extends PreferenceFragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}