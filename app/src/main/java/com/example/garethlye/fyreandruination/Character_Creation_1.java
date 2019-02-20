package com.example.garethlye.fyreandruination;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.garethlye.fyreandruination.databinding.ActivityCharacterCreation1Binding;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.AudioPlayer;

public class Character_Creation_1 extends AppCompatActivity {

    @BindView(R.id.adventurerNameEditText)
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCharacterCreation1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_character_creation_1);
        binding.setViewModel(Character_Creation_1.this);
        ButterKnife.bind(this);
    }

    public void onConfirmBtnClicked(final View view){
        String name = mEditText.getText().toString();

        AlertDialog dlgAlert  = new AlertDialog.Builder(Character_Creation_1.this).create();
        dlgAlert.setTitle("Confirm Name");
        dlgAlert.setMessage("Are you sure you want to use \""+name+"\" as your adventurer name?\nThis cannot be changed later on.");
        dlgAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dlgAlert.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent creation_2 = new Intent(Character_Creation_1.this, Character_Creation_2.class);
                startActivity(creation_2);
            }
        });

        dlgAlert.show();
    }

    @Override
    public void onDestroy(){
        Intent objIntent = new Intent(Character_Creation_1.this, AudioPlayer.class);
        stopService(objIntent);
        super.onDestroy();
    }

    @Override
    public void onPause() {
        Intent objIntent = new Intent(Character_Creation_1.this, AudioPlayer.class);
        stopService(objIntent);
        super.onPause();
    }
}
