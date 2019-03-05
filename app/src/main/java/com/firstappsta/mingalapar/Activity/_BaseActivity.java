package com.firstappsta.mingalapar.Activity;

import android.support.v7.app.AppCompatActivity;

import com.firstappsta.mingalapar.Utility.SoundEffect;

public class _BaseActivity extends AppCompatActivity{

    public void playVoice(int voiceId){
        SoundEffect.getInstance(this).playVoice(voiceId);

    }


}
