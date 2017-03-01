package com.example.goran.playbass;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class CustomPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new CustomPreferenceFragment()).commit();
    }
}
