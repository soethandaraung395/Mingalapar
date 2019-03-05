package com.firstappsta.mingalapar.Library;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.firstappsta.mingalapar.R;
import com.firstappsta.mingalapar.Utility.SoundEffect;
import com.firstappsta.mingalapar.Utility.Utility;



public class CustomDialogClass extends DialogFragment
{
    LayoutInflater inflater;
    int voiceId = 0;
    TextViewPlus tvTitleEng, tvTitleMm, tvDesc;
    ImageView img, quit;
    LottieAnimationView animationSound;
//    LinearLayout linLayoutOnClickSpeaker;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.activity_zoom,null);
        Intent i=getActivity().getIntent();

        quit= view.findViewById(R.id.quit);
//        linLayoutOnClickSpeaker = view.findViewById(R.id.linLayoutOnClickSpeaker);
        tvTitleEng = view.findViewById((R.id.tvTitleEng));
        tvTitleMm = view.findViewById((R.id.tvTitleMm));
        tvDesc = view.findViewById((R.id.tvDesc));
        img = view.findViewById((R.id.img));
        animationSound = view.findViewById((R.id.animation_sound));

//        Bundle args = getArguments();

//        tvTitleEng = (TextViewPlus) getArguments().get("titleeng");
//        tvTitleMm = (TextViewPlus) getArguments().get("titlemm");
          tvTitleEng.setText(getArguments().getString("titleeng"));
          tvTitleMm.setText(getArguments().getString("titlemm"));
          Utility.embedViewWithUnicode(getContext(),tvTitleMm);


//        args.getString("titleeng");
//        args.getString("titlemm");
//        args.getInt("imgid");
//        args.getInt("voiceid");
//        args.getString("desc");
        String desc = getArguments().getString("desc");
        if(!desc.isEmpty()){
            tvDesc.setText(desc);
            tvDesc.setTextSize(20);
        }
        img.setImageResource(getArguments().getInt("imgid",0));
        voiceId = getArguments().getInt("voiceid",0);


//        img.setImageResource(args.getInt("imgid", 0));
//        voiceId = args.getInt("voiceid",0);


//        tvTitleEng.setText(i.getStringExtra("titleeng"));
//        tvTitleMm.setText(i.getStringExtra("titlemm"));
//        tvDesc.setText(i.getStringExtra("desc"));
//        String desc = i.getStringExtra("desc");
//        if(!desc.isEmpty()) {
//            tvDesc.setText(desc);
//            tvDesc.setTextSize(20);
//        }

        builder.setView(view);
        final AlertDialog dialog=builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        onClickSpeaker(voiceId);


//        linLayoutOnClickSpeaker.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                animationSound.playAnimation();
//                SoundEffect.getInstance(getContext()).playVoice(voiceId);
//            }
//        });



        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return dialog;


    }

    public void onClickSpeaker(int voiceId) {
        animationSound.playAnimation();
        SoundEffect.getInstance(getContext()).playVoice(voiceId);


    }



}
