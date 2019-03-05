package com.firstappsta.mingalapar.Utility;

import android.content.Context;
import android.media.MediaPlayer;


public class SoundEffect {

    private static SoundEffect instance;

    private static MediaPlayer mpVoice;


    private static Context context;

    private SoundEffect(){}  //private constructor.

    public static SoundEffect getInstance(Context mContext){
        context = mContext;
        if (instance == null){ //if there is no instance available... create new one
//            mpBackground = MediaPlayer.create(mContext, R.raw.soundbg);
//            mpBackground.setLooping(true);
//            mpBackground.setVolume(0.5f,0.5f);
//
//            mpBtnSound = MediaPlayer.create(mContext, R.raw.soundbtnclick);
//            mpBtnSound.setLooping(false);
//
//            mpResultSound = MediaPlayer.create(mContext, R.raw.soundresult);
//            mpResultSound.setLooping(false);

            instance = new SoundEffect();
        }

        return instance;
    }


        public void playVoice(int voice){
            if(mpVoice != null){
                mpVoice.release();
                mpVoice = null;
            }
            mpVoice = MediaPlayer.create(context, voice);
            mpVoice.setLooping(false);
            mpVoice.start();
        }

//    public void stopBg(){
//        mpBackground.stop();
//    }
//
//    public void destroyBg(){
//        if(mpBackground != null){
//            mpBackground.release();
//            mpBackground = null;
//        }
//    }
}
