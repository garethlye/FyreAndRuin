package com.example.garethlye.fyreandruination;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import com.example.garethlye.fyreandruination.databinding.ActivityMainMenuBinding;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.AudioPlayer;
import pl.droidsonroids.gif.GifImageView;

public class MainMenu extends AppCompatActivity {

    @BindView(R.id.backgroundGifView)
    GifImageView mBackgroundGifView;

    @BindView(R.id.activity_main_menu)
    View mMainView;

    @BindView(R.id.buttonLL)
    View mButtonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainMenuBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_menu);
        binding.setViewModel(MainMenu.this);
        ButterKnife.bind(this);
        startAudio();
        mBackgroundGifView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mButtonView.setVisibility(View.VISIBLE);
            }
        }, 20000);

        mMainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (mButtonView.getVisibility() == View.INVISIBLE || mButtonView.getVisibility() == View.GONE) {
                    mButtonView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void onNewGameClicked(final View view) {
        Intent startLore = new Intent(MainMenu.this, LoreIntro.class);
        startActivity(startLore);
    }

    public void startAudio() {
        Intent objIntent = new Intent(MainMenu.this, AudioPlayer.class);
        startService(objIntent);
    }

    @Override
    public void onDestroy() {
        Intent objIntent = new Intent(MainMenu.this, AudioPlayer.class);
        stopService(objIntent);
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        startAudio();
        super.onResume();
    }
}
