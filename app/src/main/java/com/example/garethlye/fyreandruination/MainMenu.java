package com.example.garethlye.fyreandruination;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import com.example.garethlye.fyreandruination.databinding.ActivityMainMenuBinding;

import music.AudioPlayer;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainMenuBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_menu);
        binding.setViewModel(MainMenu.this);
        startAudio();
    }

    public void onNewGameClicked(final View view){
        Intent startLore = new Intent(MainMenu.this, LoreIntro.class);
        startActivity(startLore);
    }

    public void startAudio() {
        Intent objIntent = new Intent(MainMenu.this, AudioPlayer.class);
        startService(objIntent);
    }

    @Override
    public void onPause(){
        Intent objIntent = new Intent(MainMenu.this, AudioPlayer.class);
        stopService(objIntent);
    }

    @Override
    public void onDestroy(){
        Intent objIntent = new Intent(MainMenu.this, AudioPlayer.class);
        stopService(objIntent);
    }
}
