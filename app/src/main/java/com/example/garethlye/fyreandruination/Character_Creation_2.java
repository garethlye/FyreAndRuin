package com.example.garethlye.fyreandruination;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.garethlye.fyreandruination.databinding.ActivityCharacterCreation2Binding;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.AudioPlayer;


public class Character_Creation_2 extends AppCompatActivity {

    @BindView(R.id.classesSpinner)
    Spinner classSpinner;

    @BindView(R.id.racesSpinner)
    Spinner raceSpinner;

    @BindView(R.id.sexSpinner)
    Spinner sexSpinner;

    @BindView(R.id.classDescription)
    TextView classTextView;

    @BindView(R.id.raceDescription)
    TextView raceTextView;

    private ObservableField<String> classDescription = new ObservableField<>();
    private ObservableField<String> raceDescription  = new ObservableField<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCharacterCreation2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_character_creation_2);
        binding.setViewModel(Character_Creation_2.this);
        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> classAdapter = ArrayAdapter.createFromResource(this, R.array.classes, android.R.layout.simple_list_item_1);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        classSpinner.setAdapter(classAdapter);

        classTextView.setMovementMethod(new ScrollingMovementMethod());
        raceTextView.setMovementMethod(new ScrollingMovementMethod());

        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                switch (pos) {
                    case 0:
                        classDescription.set(getString(R.string.warriorDescription));
                        break;
                    case 1:
                        classDescription.set(getString(R.string.beserkerDescription));
                        break;
                    case 2:
                        classDescription.set(getString(R.string.paladinDescription));
                        break;
                    case 3:
                        classDescription.set(getString(R.string.spellcasterDesciption));
                        break;
                    case 4:
                        classDescription.set(getString(R.string.oracleDescription));
                        break;
                    case 5:
                        classDescription.set(getString(R.string.enchanterDescription));
                        break;
                    case 6:
                        classDescription.set(getString(R.string.assassinDescription));
                        break;
                    case 7:
                        classDescription.set(getString(R.string.archerDesciption));
                        break;
                    case 8:
                        classDescription.set(getString(R.string.ballistaDescription));
                        break;
                    default:
                        classDescription.set("ERROR OCCURED");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


        ArrayAdapter<CharSequence> raceAdapter = ArrayAdapter.createFromResource(this, R.array.races, android.R.layout.simple_list_item_1);
        raceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        raceSpinner.setAdapter(raceAdapter);

        raceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> adapterView, final View view, final int pos, final long l) {
                switch (pos) {
                    case 0:
                        raceDescription.set(getString(R.string.humanDescription));
                        break;
                    case 1:
                        raceDescription.set(getString(R.string.elvesDescription));
                        break;
                    case 2:
                        raceDescription.set(getString(R.string.faeDescription));
                        break;
                    case 3:
                        raceDescription.set(getString(R.string.dwarfDescription));
                        break;
                    case 4:
                        raceDescription.set(getString(R.string.demonDescription));
                        break;
                    default:
                        raceDescription.set("ERROR OCCURED");

                }
            }

            @Override
            public void onNothingSelected(final AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> sexAdapter = ArrayAdapter.createFromResource(this, R.array.sex, android.R.layout.simple_list_item_1);
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexSpinner.setAdapter(sexAdapter);

        sexSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(final AdapterView<?> adapterView, final View view, final int pos, final long l) {
                switch(pos){
                    case 0:
                        //SET SEX TO MALE
                        break;
                    case 1:
                        //SET SEX TO FEMALE
                        break;
                    default:
                        raceDescription.set("ERROR OCCURED");
                }
            }

            @Override
            public void onNothingSelected(final AdapterView<?> adapterView) {

            }
        });

    }

    public void onContinueClicked(final View view){

        AlertDialog dlgAlert  = new AlertDialog.Builder(Character_Creation_2.this).create();
        dlgAlert.setTitle("Confirm Selection");
        dlgAlert.setMessage("Are you sure you about your class/race/sex?\nThis cannot be changed later on.");
        dlgAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dlgAlert.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent creation_2 = new Intent(Character_Creation_2.this, Character_Creation_3.class);
                startActivity(creation_2);
            }
        });

        dlgAlert.show();

    }

    public ObservableField<String> getClassDescription() {
        return classDescription;
    }

    public ObservableField<String> getRaceDescription() {
        return raceDescription;
    }

    @Override
    public void onDestroy(){
        Intent objIntent = new Intent(Character_Creation_2.this, AudioPlayer.class);
        stopService(objIntent);
        super.onDestroy();
    }
}