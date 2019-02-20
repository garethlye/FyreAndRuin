package com.example.garethlye.fyreandruination;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.garethlye.fyreandruination.databinding.ActivityLoreIntroBinding;

import music.AudioPlayer;

public class LoreIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoreIntroBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_lore_intro);
        binding.setViewModel(LoreIntro.this);
    }

    public void onContinueClicked(final View view){
        Intent startLore = new Intent(LoreIntro.this, Character_Creation_1.class);
        startActivity(startLore);
    }

    @Override
    public void onDestroy(){
        Intent objIntent = new Intent(LoreIntro.this, AudioPlayer.class);
        stopService(objIntent);
        super.onDestroy();
    }
}
