package com.example.anurag.phonecallapp;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;

public class TextToSpeechActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    private TextToSpeech tts;
    private Button btnSpeak;
    private EditText txtText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        btnSpeak = findViewById(R.id.btnSpeak);
        txtText = findViewById(R.id.editText);
        tts = new TextToSpeech(this, this);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                speakOut();
            }
        });
    }

    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    private void speakOut() {
        String text = txtText.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}
