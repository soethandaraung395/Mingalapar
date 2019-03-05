package com.firstappsta.mingalapar.Activity;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.firstappsta.mingalapar.Adapter.CategoryAdapter;
import com.firstappsta.mingalapar.Data.CategoryData;
import com.firstappsta.mingalapar.Library.TextViewPlus;
import com.firstappsta.mingalapar.R;
import com.firstappsta.mingalapar.Utility.Constant;
import com.firstappsta.mingalapar.Utility.Utility;

import java.util.ArrayList;


public class CategoryActivity extends AppCompatActivity {

    ArrayList<CategoryData> categoryDatas = new ArrayList<>();
    ScrollView scrollView;
    ListView lvCategory;
    CategoryAdapter categoryAdapter;
    Constant.Category constantCat;
    String categoryTitle;
    // String hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        scrollView = findViewById(R.id.scrollView);
        lvCategory = findViewById(R.id.lvCategory);

        overridePendingTransition(R.anim.fade_in, R.anim.anim_still);

        categoryDatas.add(new CategoryData(Constant.Category.Number, R.drawable.btn_0001_numbers, "Number", "ကိန်းဂဏန်း"));
        categoryDatas.add(new CategoryData(Constant.Category.Color, R.drawable.btn_0005_color, "Color", "အရောင်"));
        categoryDatas.add(new CategoryData(Constant.Category.Family, R.drawable.btn_0006_family, "Family", "မိသားစု"));
        categoryDatas.add(new CategoryData(Constant.Category.BodyPart, R.drawable.btn_0000_bodypart, "Body Part", "ခန္ဒာကိုယ်အစိတ်အပိုင်း"));
        categoryDatas.add(new CategoryData(Constant.Category.Occupation, R.drawable.btn_0003_job, "Job", "အလုပ်အကိုင်"));
        categoryDatas.add(new CategoryData(Constant.Category.Vegetable, R.drawable.btn_0007_vegitable, "Vegetable", "ဟင်းသီးဟင်းရွက်"));
        categoryDatas.add(new CategoryData(Constant.Category.Fruit, R.drawable.btn_0004_fruit, "Fruit", "သစ်သီးဝလံ"));
        categoryDatas.add(new CategoryData(Constant.Category.Animals, R.drawable.btn_0007_animal, "Animal", "တိရစ္ဆာန်"));
        categoryDatas.add(new CategoryData(Constant.Category.Transportation, R.drawable.btn_0002_transportation, "Vehicle", "ယာဉ်"));
        categoryDatas.add(new CategoryData(Constant.Category.Flower, R.drawable.btn_0009_flower, "Flower", "ပန်း"));
        categoryDatas.add((new CategoryData(Constant.Category.MonthDay, R.drawable.btn_0008_monthday, "Month/Day", "လ / နေ့ရက်")));


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        categoryAdapter = new CategoryAdapter(this, R.layout.adapter_category, categoryDatas);
        categoryAdapter.setMinHeight((int) ((displayMetrics.widthPixels - 40) / 2.42));
        lvCategory.setAdapter(categoryAdapter);


        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                constantCat = categoryDatas.get(position).getCategory();
                Log.e("constantCat: ", "HHHHHHHHHHH" + constantCat);
                showCustomDialog(position);


//                to write in Learn Page
                //   cd.putExtra("data",categoryDatas.get(position));
//                Intent i = new Intent(CategoryActivity.this, TestActivity.class);
//                i.putExtra("data",categoryDatas.get(position));
//                startActivity(i);
            }
        });

    }

    private void showCustomDialog(final int position) {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(metrics.widthPixels, metrics.heightPixels);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;


        final Button btnLearn = (Button) dialog.findViewById(R.id.btnLearn);


        Button btnTest = (Button) dialog.findViewById(R.id.btnTest);
        final ImageView back = dialog.findViewById(R.id.back);


        btnLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDimiss(dialog, back, Constant.UserActionType.LEARN, position);

            }

        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDimiss(dialog, back, Constant.UserActionType.TEST, position);


            }

        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDimiss(dialog, back, Constant.UserActionType.NONE, 0);
            }
        });

        dialog.show();

        AlphaAnimation alphaAni = new AlphaAnimation(0f, 0.8f);
        alphaAni.setFillAfter(true);
        alphaAni.setDuration(600);
        back.startAnimation(alphaAni);

    }

    private void dialogDimiss(final Dialog dialog, ImageView back, final Constant.UserActionType type, final int position) {
        AlphaAnimation alphaAni = new AlphaAnimation(0.6f, 0f);
        alphaAni.setFillAfter(true);
        alphaAni.setDuration(200);
        back.startAnimation(alphaAni);
        alphaAni.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dialog.dismiss();
                if (type != Constant.UserActionType.NONE) {
                    createActivity(type, position);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void createActivity(Constant.UserActionType type, int position) {

        Intent i;
        if (type == Constant.UserActionType.LEARN) {
            i = new Intent(CategoryActivity.this, LearnActivity.class);
        } else {
            i = new Intent(CategoryActivity.this, TestActivity.class);
        }
        i.putExtra("Category", constantCat);
        i.putExtra("CategoryTitle", categoryDatas.get(position));
        startActivity(i);
    }
}

//    public void onClickRow (View v){
//        Intent i = new Intent(CategoryActivity.this, CustomDialogClass.class);
//        startActivity(i);
//
//    }

//    public void onClickBtns(View v) {
//
//        Intent i;
//
//
//        switch (v.getId()) {
//            case R.id.btnLearn:
//                i = new Intent(CategoryActivity.this, LearnActivity.class);
//                startActivity(i);
//                break;
//
//            case R.id.btnTest:
//                i = new Intent(CategoryActivity.this, TestActivity.class);
//                startActivity(i);
//                break;
//
//                default: break;
//
//
//        }
//
//    }












