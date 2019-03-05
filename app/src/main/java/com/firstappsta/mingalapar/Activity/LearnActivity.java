package com.firstappsta.mingalapar.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.firstappsta.mingalapar.Data.CategoryData;
import com.firstappsta.mingalapar.Data.DBWord;
import com.firstappsta.mingalapar.Data.WordData;
import com.firstappsta.mingalapar.Library.CustomDialogClass;
import com.firstappsta.mingalapar.R;
import com.firstappsta.mingalapar.Utility.Constant;
import com.firstappsta.mingalapar.Utility.SimpleGestureFilter;
import com.firstappsta.mingalapar.Utility.Utility;

import java.util.ArrayList;

public class LearnActivity extends _BaseActivity{


    LinearLayout linearLayout, linearLayout1, linearLayout2, linearLayout3, linearLayout4 ;
    int currentCount = 0;
    int totalDisplay = 4;
    ArrayList<WordData> datas = new ArrayList<>();
    TextView tvCategoryTitle, tvTitleMm1, tvTitleMm2, tvTitleMm3, tvTitleMm4, tvTitleEng1, tvTitleEng2, tvTitleEng3, tvTitleEng4;
    ImageView img1, img2, img3, img4;
    ArrayList<TextView> tvTitleMms = new ArrayList<>();
    ArrayList<TextView> tvTitleEngs = new ArrayList<>();
    Button btnNext, btnPrevious;
    //    ArrayList<ImageView> imgs = new ArrayList<>();
    //ImageView[] imgs = {img1,img2, img3, img4};
    ArrayList<ImageView> imgs = new ArrayList<>();
    ArrayList<LinearLayout> layouts = new ArrayList<>();
    LottieAnimationView animation_sound1, animation_sound2, animation_sound3, animation_sound4;
//    ArrayList<LottieAnimationView> animationViews = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        overridePendingTransition(R.anim.slide_left, R.anim.slide_right);


//        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        // Animation
        animation_sound1 = findViewById(R.id.animation_sound1);
        animation_sound2 = findViewById(R.id.animation_sound2);
        animation_sound3 = findViewById(R.id.animation_sound3);
        animation_sound4 = findViewById(R.id.animation_sound4);
//        animationViews.add(animation_sound1);
//        animationViews.add(animation_sound2);
//        animationViews.add(animation_sound3);
//        animationViews.add(animation_sound4);



        ImageButton back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(LearnActivity.this,CategoryActivity.class);
//                startActivity(intent);
                onBackPressed();
            }
        });

        linearLayout = findViewById(R.id.linearLayout);


        tvCategoryTitle = findViewById(R.id.tvCategoryTitle);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);

        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout4 = findViewById(R.id.linearLayout4);
        layouts.add(linearLayout1);
        layouts.add(linearLayout2);
        layouts.add(linearLayout3);
        layouts.add(linearLayout4);

        tvTitleMm1 = findViewById(R.id.tvTitleMm1);
        tvTitleMm2 = findViewById(R.id.tvTitleMm2);
        tvTitleMm3 = findViewById(R.id.tvTitleMm3);
        tvTitleMm4 = findViewById(R.id.tvTitleMm4);
        tvTitleMms.add(tvTitleMm1);
        tvTitleMms.add(tvTitleMm2);
        tvTitleMms.add(tvTitleMm3);
        tvTitleMms.add(tvTitleMm4);

        tvTitleEng1 = findViewById(R.id.tvTitleEng1);
        tvTitleEng2 = findViewById(R.id.tvTitleEng2);
        tvTitleEng3 = findViewById(R.id.tvTitleEng3);
        tvTitleEng4 = findViewById(R.id.tvTitleEng4);
        tvTitleEngs.add(tvTitleEng1);
        tvTitleEngs.add(tvTitleEng2);
        tvTitleEngs.add(tvTitleEng3);
        tvTitleEngs.add(tvTitleEng4);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        imgs.add(img1);
        imgs.add(img2);
        imgs.add(img3);
        imgs.add(img4);





//        Integer integer = (Integer) getIntent().getSerializableExtra("Category");
//        Log.e("integer","CCCCCCCCCCCCCCCCCCCCCCCCCC");
//        Integer integer = getIntent().getExtras().getInt("Category");

        CategoryData categoryData = (CategoryData) getIntent().getSerializableExtra("CategoryTitle");
        tvCategoryTitle.setText(categoryData.getTitle());
        Log.e("Title", "TTTTTTTTTTTTt");

        Constant.Category category = (Constant.Category) getIntent().getSerializableExtra("Category");
        Log.e("category", "Get Extra EEEEEEEEEEEEEEEE" + category);



        switch (category) {
            case Animals:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_ANIMALS);
                Log.e("category", "CCCCCCCCCCCCCCCCCCCCCCCCCC: " + datas);
                break;

            case Number:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_NUMBER);
                break;

            case Color:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_COLOR);
                break;

            case Family:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_FAMILY);
                break;

            case BodyPart:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_BODYPART);
                break;

            case Occupation:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_OCCUPATION);
                break;

            case Vegetable:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_VEGETABLE);
                break;

            case Fruit:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_FRUIT);
                break;

            case Transportation:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_TRANSPORTATION);
                break;

            case Flower:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_FLOWER);
                break;

            case MonthDay:
                datas = DBWord.getInstance(LearnActivity.this).getData(DBWord.TABLE_MONTH_DAY);
                break;

            default:
                break;


        }


        showData();
        btnCheck(btnPrevious);


        }


        public void onClickNext (View view){

            currentCount += totalDisplay;
            btnCheck(btnNext);
            btnCheck(btnPrevious);
              showData();


            Log.e("NextCurrentCount", "NNNNNNNNNNN" + currentCount);

        }

        public void onClickPrevious (View view){
            currentCount -= totalDisplay;
            btnCheck(btnNext);
            btnCheck(btnPrevious);
            showData();
        }


        public void showData() {
            int k = 0;

            for (int i = currentCount; i < currentCount + totalDisplay; i++) {

                if (i >= datas.size()) {
                    Log.e("DataSize:", "Data Sizeeeeeee:" + datas.size());
                    layouts.get(k).setVisibility(View.INVISIBLE);
//                    tvTitleMms.get(k).setVisibility(View.INVISIBLE);
//                    tvTitleEngs.get(k).setVisibility(View.INVISIBLE);
//                    imgs.get(k).setVisibility(View.INVISIBLE);

                } else {
                    tvTitleMms.get(k).setText(datas.get(i).getTextMm());
                    Log.e("ForLooping=", "FFFFFFFFFFFFFFFFFFFF: " + k);
                    Log.e("IIIIIII=", "Valueee:" + datas.get(i).getImgId());
                    Utility.embedViewWithUnicode(this, tvTitleMms.get(k));
                    tvTitleEngs.get(k).setText(datas.get(i).getTextEng());
                    imgs.get(k).setImageResource(datas.get(i).getImgId());
                    layouts.get(k).setVisibility(View.VISIBLE);
//                    tvTitleMms.get(k).setVisibility(View.VISIBLE);
//                    tvTitleEngs.get(k).setVisibility(View.VISIBLE);
//                    imgs.get(k).setVisibility(View.VISIBLE);
                }
                k++;

            }

        }


        public void btnCheck (View view){
            int dataSize = datas.size();

            switch (view.getId()) {
                case R.id.btnNext:

                {
                    if (currentCount + totalDisplay >= dataSize) {
                        btnNext.setVisibility(View.INVISIBLE);

                    } else
                        btnNext.setVisibility(View.VISIBLE);
                }

                case R.id.btnPrevious: {
                    if (currentCount == 0) {
                        btnPrevious.setVisibility(View.INVISIBLE);

                    } else
                        btnPrevious.setVisibility(View.VISIBLE);
                }


            }


        }

        public void onClickSpeaker(View view){
            switch (view.getId()){
                case R.id.imgSpeaker1:
                    playSound(0);

                    animation_sound1.playAnimation();
                    break;

                case R.id.imgSpeaker2:
                    playSound(1);
                    animation_sound2.playAnimation();
                    break;

                case R.id.imgSpeaker3:
                    playSound(2);
                    animation_sound3.playAnimation();

                    break;

                case R.id.imgSpeaker4:
                    playSound(3);
                    animation_sound4.playAnimation();

                    break;

            }
        }

        private void playSound(int index){

            playVoice(datas.get(index+currentCount).getVoiceId());
        }


    public void onClickImage(View view) {

//        CustomDialogClass cdd = new CustomDialogClass(this);
//        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        int index = 0;
        switch (view.getId()) {
            case R.id.img1:
                index = 0;
                break;

            case R.id.img2:
                index = 1;
                break;

            case R.id.img3:
                index = 2;
                break;

            case R.id.img4:
                index = 3;
                break;


        }

        Bundle args = new Bundle();
//        Intent i = new Intent();
//        i.putExtra("titleeng", datas.get(index + currentCount).getTextEng());
//        i.putExtra("titlemm", datas.get(index + currentCount).getTextMm());
//        i.putExtra("imgid", datas.get(index + currentCount).getImgId());
//        i.putExtra("voiceid", datas.get(index + currentCount).getVoiceId());
//        i.putExtra("desc", datas.get(index + currentCount).getDesc());
        args.putString("titleeng", datas.get(index + currentCount).getTextEng());
        args.putString("titlemm", datas.get(index + currentCount).getTextMm());
        args.putInt("imgid", datas.get(index + currentCount).getImgId());
        args.putInt("voiceid", datas.get(index + currentCount).getVoiceId());
        args.putString("desc", datas.get(index + currentCount).getDesc());


//        cdd.show();

        CustomDialogClass customDialog = new CustomDialogClass();
        customDialog.setArguments(args);
        customDialog.show(getSupportFragmentManager(), "customDialog");



//        Intent i = new Intent(LearnActivity.this, ZoomActivity.class);
//
//        int index = 0;
//        switch (view.getId()){
//            case R.id.img1: index = 0; break;
//
//            case R.id.img2: index = 1; break;
//
//            case R.id.img3: index = 2; break;
//
//            case R.id.img4: index = 3; break;
//
//
//        }
//
//        i.putExtra("titleeng",   datas.get(index+currentCount).getTextEng());
//        i.putExtra("titlemm",   datas.get(index+currentCount).getTextMm());
//        i.putExtra("imgid",   datas.get(index+currentCount).getImgId());
//        i.putExtra("voiceid",datas.get(index+currentCount).getVoiceId());
//        i.putExtra("desc",datas.get(index+currentCount).getDesc());
//        startActivity(i);


    }



}









