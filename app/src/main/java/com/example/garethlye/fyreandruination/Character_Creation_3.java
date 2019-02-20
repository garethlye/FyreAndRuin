package com.example.garethlye.fyreandruination;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.garethlye.fyreandruination.databinding.ActivityCharacterCreation3Binding;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.AudioPlayer;

public class Character_Creation_3 extends AppCompatActivity {

    @BindView(R.id.strengthSeekBar)
    SeekBar strSB;

    @BindView(R.id.agilitySeekBar)
    SeekBar agiSB;

    @BindView(R.id.dexteritySeekBar)
    SeekBar dexSB;

    @BindView(R.id.wisdomSeekBar)
    SeekBar wisSB;

    @BindView(R.id.charismaSeekBar)
    SeekBar chaSB;

    @BindView(R.id.constitutionSeekBar)
    SeekBar consSB;

    @BindView(R.id.strengthValue)
    TextView strengthValue;

    @BindView(R.id.agilityValue)
    TextView agilityValue;

    @BindView(R.id.dexterityValue)
    TextView dexterityValue;

    @BindView(R.id.wisdomValue)
    TextView wisdomValue;

    @BindView(R.id.charismaValue)
    TextView charismaValue;

    @BindView(R.id.constitutionValue)
    TextView constitutionValue;

    @BindView(R.id.totalValueTextView)
    TextView totalValueTextView;

    @BindView(R.id.maxValueReachedTextView)
    TextView maxValueReachedTextView;

    @BindView(R.id.attributeDescription)
    TextView attributeDescriptionText;

    @BindView(R.id.strengthText)
    TextView strengthText;

    @BindView(R.id.agilityText)
    TextView agilityText;

    @BindView(R.id.dexterityText)
    TextView dexterityText;

    @BindView(R.id.wisdomText)
    TextView wisdomText;

    @BindView(R.id.charismaText)
    TextView charismaText;

    @BindView(R.id.constitutionText)
    TextView constitutionText;

    @BindView(R.id.characterCreation3ContinueBtn)
    TextView continueButton;

    private ObservableField<String> totalValue = new ObservableField<>();
    private int                     str        = 0, agi = 0, dex = 0, wis = 0, cha = 0, cons = 0;
    private int max = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation_3);

        ActivityCharacterCreation3Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_character_creation_3);
        binding.setViewModel(Character_Creation_3.this);
        ButterKnife.bind(this);
        totalValue.set(Integer.toString(str + agi + dex + wis + cha + cons));
        strSB.setMax(max);
        agiSB.setMax(max);
        dexSB.setMax(max);
        wisSB.setMax(max);
        chaSB.setMax(max);
        consSB.setMax(max);

        strSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int i, final boolean b) {
                updateTotalValue(1, i);
                strengthValue.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
            }
        });

        agiSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int i, final boolean b) {
                updateTotalValue(2, i);
                agilityValue.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
            }
        });

        dexSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int i, final boolean b) {
                updateTotalValue(3, i);
                dexterityValue.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
            }
        });

        wisSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int i, final boolean b) {
                updateTotalValue(4, i);
                wisdomValue.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
            }
        });

        chaSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int i, final boolean b) {
                updateTotalValue(5, i);
                charismaValue.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
            }
        });

        consSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int i, final boolean b) {
                updateTotalValue(6, i);
                constitutionValue.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar) {
            }
        });

        strengthText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                attributeDescriptionText.setText(R.string.strengthDescription);
            }
        });

        agilityText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                attributeDescriptionText.setText(R.string.agilityDescription);
            }
        });

        dexterityText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                attributeDescriptionText.setText(R.string.dexterityDescription);
            }
        });

        wisdomText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                attributeDescriptionText.setText(R.string.wisdomDescription);
            }
        });

        charismaText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                attributeDescriptionText.setText(R.string.charismaDescription);
            }
        });

        constitutionText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                attributeDescriptionText.setText(R.string.constitutionDescription);
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (Integer.parseInt(totalValue.get()) > 10 || Integer.parseInt(totalValue.get()) < 10) {
                    new AlertDialog.Builder(Character_Creation_3.this)
                            .setTitle("Attribute Error")
                            .setMessage(R.string.attributeError)
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
                else if (Integer.parseInt(totalValue.get()) == 10){
                    new AlertDialog.Builder(Character_Creation_3.this)
                            .setTitle("Confirm Attributes")
                            .setMessage(R.string.attributeConfirm)
                            .setPositiveButton("I'm Sure", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //CONTINUE CODE
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            }
        });

    }

    private void updateTotalValue(int attribute, int value) {
        switch (attribute) { //int value represent which attribute
            case 1:
                str = value;
                break;
            case 2:
                agi = value;
                break;
            case 3:
                dex = value;
                break;
            case 4:
                wis = value;
                break;
            case 5:
                cha = value;
                break;
            case 6:
                cons = value;
                break;
        }

        totalValue.set(Integer.toString(str + agi + dex + wis + cha + cons));
        updateTextViewColor();
    }

    private void updateTextViewColor() {
        if (Integer.parseInt(totalValue.get()) > 10) {
            totalValueTextView.setTextColor(Color.parseColor("#ff0000"));
            maxValueReachedTextView.setVisibility(View.VISIBLE);
        }
        else {
            totalValueTextView.setTextColor(Color.parseColor("#808080"));
            maxValueReachedTextView.setVisibility(View.INVISIBLE);
        }
    }

    public ObservableField<String> getTotalValue() {
        return totalValue;
    }

    @Override
    public void onDestroy(){
        Intent objIntent = new Intent(Character_Creation_3.this, AudioPlayer.class);
        stopService(objIntent);
        super.onDestroy();
    }

}
