package com.firstappsta.mingalapar.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.firstappsta.mingalapar.Data.CategoryData;
import com.firstappsta.mingalapar.Library.CustomDialogClass;
import com.firstappsta.mingalapar.Library.TextViewPlus;
import com.firstappsta.mingalapar.R;
import com.firstappsta.mingalapar.Utility.Utility;

public class ZoomActivity extends _BaseActivity {

    int voiceId = 0;
    TextViewPlus tvTitleEng, tvTitleMm, tvDesc;
    ImageView img;
    LottieAnimationView animationSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);


        tvTitleEng = findViewById(R.id.tvTitleEng);
        tvTitleMm = findViewById(R.id.tvTitleMm);
        tvDesc = findViewById(R.id.tvDesc);
        img = findViewById(R.id.img);
        animationSound = findViewById(R.id.animation_sound);


        Intent i = getIntent();

        tvTitleEng.setText(i.getStringExtra("titleeng"));
        tvTitleMm.setText(i.getStringExtra("titlemm"));
        Utility.embedViewWithUnicode(this, tvTitleMm);

        String desc = i.getStringExtra("desc");
        if(!desc.isEmpty()) {
            tvDesc.setText(desc);
            tvDesc.setTextSize(20);
        }

        img.setImageResource(i.getIntExtra("imgid",0));
        voiceId = i.getIntExtra("voiceid",0);

    }

    public void onClickSpeaker(View view){
        animationSound.playAnimation();
        playVoice(voiceId);

    }

    public void onClickQuit(View view){
        finish();
    }

}
