package com.example.anurag.phonecallapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainListActivity extends AppCompatActivity {

    @BindView(R.id.Make_a_Call)
    Button MakeACall;
    @BindView(R.id.progressBar)
    Button progressBar;
    @BindView(R.id.seekBar)
    Button seekBar;
    @BindView(R.id.text_to_speech)
    Button textToSpeech;
    @BindView(R.id.Web_View)
    Button WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.Make_a_Call, R.id.progressBar, R.id.seekBar, R.id.text_to_speech, R.id.Web_View})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Make_a_Call:
                Intent intent1 = new Intent(MainListActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.progressBar:
                Intent intent2 = new Intent(MainListActivity.this,ProgressBarActivity.class);
                startActivity(intent2);
                break;
            case R.id.seekBar:
                Intent intent3 = new Intent(MainListActivity.this,SeekBarActivity.class);
                startActivity(intent3);
                break;
            case R.id.text_to_speech:
                Intent intent4 = new Intent(MainListActivity.this,TextToSpeechActivity.class);
                startActivity(intent4);
                break;
            case R.id.Web_View:
                Intent intent5 = new Intent(MainListActivity.this,WebViewActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
