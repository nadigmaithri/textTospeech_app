package com.example.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    EditText inputtext;
    TextToSpeech textToSpeech;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputtext = findViewById(R.id.textspeech);
        btn = findViewById(R.id.button);



        btn.setOnClickListener(this);



        textToSpeech = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                    Toast.makeText(getBaseContext(), "SUCCESS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    @Override
    public void onClick(View view) {
        String text = inputtext.getText().toString();
        textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
    }

}