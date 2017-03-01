package com.example.goran.playbass;

import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Goran on 24.2.2017..
 */
//APP Intro class
public class Intro extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFlowAnimation();
        addSlide(SampleSlide.newInstance(R.layout.slide_1));
        addSlide(SampleSlide.newInstance(R.layout.slide_2));
        addSlide(SampleSlide.newInstance(R.layout.slide_3));
        addSlide(SampleSlide.newInstance(R.layout.slide_4));
    }
    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }
    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }
}
