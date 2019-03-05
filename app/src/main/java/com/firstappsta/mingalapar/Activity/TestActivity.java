package com.firstappsta.mingalapar.Activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.WrapperListAdapter;

import com.firstappsta.mingalapar.Data.CategoryData;
import com.firstappsta.mingalapar.Data.DBWord;
import com.firstappsta.mingalapar.Data.WordData;
import com.firstappsta.mingalapar.Library.TextViewPlus;
import com.firstappsta.mingalapar.R;
import com.firstappsta.mingalapar.Utility.Constant;
import com.firstappsta.mingalapar.Utility.Utility;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TestActivity extends _BaseActivity {

    TextView tvCategoryTitle, tvTitleMm, tvTitleEng, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    ImageView img;
    ArrayList<TextView> tvAnswers = new ArrayList<>();
    ArrayList<WordData> datas = new ArrayList<>();
    Button btnNextTest;

    int currentQuestionCount = 0;
    WordData currentCorrentAnswer;
    ArrayList<WordData> fakeAnswers = new ArrayList<>();
    ArrayList<WordData> answers = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        overridePendingTransition(R.anim.slide_left, R.anim.slide_right);

        ImageButton back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnNextTest = findViewById(R.id.btnNextTest);
        tvCategoryTitle = findViewById(R.id.tvCategoryTitle);
        tvTitleEng = findViewById(R.id.tvTitleEng);
        tvTitleMm = findViewById(R.id.tvTitleMm);

        img = findViewById(R.id.img);

        tvAnswer1 = findViewById(R.id.tvAnswer1);
        tvAnswer2 = findViewById(R.id.tvAnswer2);
        tvAnswer3 = findViewById(R.id.tvAnswer3);
        tvAnswer4 = findViewById(R.id.tvAnswer4);
        tvAnswers.add(tvAnswer1);
        tvAnswers.add(tvAnswer2);
        tvAnswers.add(tvAnswer3);
        tvAnswers.add(tvAnswer4);


        CategoryData categoryData = (CategoryData) getIntent().getSerializableExtra("CategoryTitle");
        tvCategoryTitle.setText(categoryData.getTitle());

        Constant.Category category = (Constant.Category) getIntent().getSerializableExtra("Category");
        Log.e("category", "Get Extra EEEEEEEEEEEEEEEE" + category);


        switch (category) {
            case Animals:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_ANIMALS);
                Log.e("category", "CCCCCCCCCCCCCCCCCCCCCCCCCC: " + datas);
                break;

            case Number:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_NUMBER);
                break;

            case Color:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_COLOR);
                break;

            case Family:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_FAMILY);
                break;

            case BodyPart:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_BODYPART);
                break;

            case Occupation:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_OCCUPATION);
                break;

            case Vegetable:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_VEGETABLE);
                break;

            case Fruit:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_FRUIT);
                break;

            case Transportation:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_TRANSPORTATION);
                break;

            case Flower:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_FLOWER);
                break;

            case MonthDay:
                datas = DBWord.getInstance(TestActivity.this).getData(DBWord.TABLE_MONTH_DAY);
                break;

            default:
                break;


        }

        Collections.shuffle(datas);
        setQuestion();
//        showRightAnswer(tvTitleMm);
//        showChoice();
//        onClickNextTest(tvTitleMm);

    }

    private void setQuestion(){

        btnNextTest.setVisibility(View.INVISIBLE);

        currentCorrentAnswer = datas.get(currentQuestionCount);
        tvTitleEng.setText(currentCorrentAnswer.getTextEng());
        tvTitleMm.setText("");
        img.setImageResource(currentCorrentAnswer.getImgId());


        ArrayList<Integer> excludeNums = new ArrayList<>();
        excludeNums.add(currentQuestionCount);
        Random random = new Random();
        int index = 0;

        answers.clear();
        answers.add(currentCorrentAnswer);

        fakeAnswers.clear();
        for(int i = 0; i < 3; i++){
            index = Utility.getRandomWithExclusion(random,0,datas.size()-1,excludeNums);
            fakeAnswers.add(datas.get(index));
            excludeNums.add(index);
            answers.add(datas.get(index));
        }

        Collections.shuffle(answers);

        tvAnswer1.setText(answers.get(0).getTextMm());
        tvAnswer1.setTag(answers.get(0).getTextEng());
        tvAnswer2.setText(answers.get(1).getTextMm());
        tvAnswer2.setTag(answers.get(1).getTextEng());
        tvAnswer3.setText(answers.get(2).getTextMm());
        tvAnswer3.setTag(answers.get(2).getTextEng());
        tvAnswer4.setText(answers.get(3).getTextMm());
        tvAnswer4.setTag(answers.get(3).getTextEng());


        Utility.embedViewWithUnicode(this, tvAnswer1);
        Utility.embedViewWithUnicode(this, tvAnswer2);
        Utility.embedViewWithUnicode(this, tvAnswer3);
        Utility.embedViewWithUnicode(this, tvAnswer4);


    }


    public void onClickNextTest(View view){

        tvAnswer1.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        tvAnswer2.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        tvAnswer3.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
        tvAnswer4.setBackgroundColor(ContextCompat.getColor(this,R.color.white));

        currentQuestionCount++;

        // ALL QUESTIONS COMPLETED
        if(currentQuestionCount >= datas.size()) {
            showFinishDialog();
            return;
        }
        setQuestion();


    }


    private void showFinishDialog (){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.test_finish_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(metrics.widthPixels, metrics.heightPixels);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        Button btnRestart = (Button) dialog.findViewById(R.id.btnRestart);
        Button btnQuit = (Button) dialog.findViewById(R.id.btnQuit);

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestionCount = 0;
                Collections.shuffle(datas);
                setQuestion();
                dialog.dismiss();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });
        dialog.show();
    }


    public void onClickAnswer(View view){


        TextView tvClickAnswer;
        int index = 0;

        switch (view.getId()){

            case R.id.tvAnswer1:
                tvClickAnswer = tvAnswer1;
                index = 0;
                break;

            case R.id.tvAnswer2:
                tvClickAnswer = tvAnswer2;
                index = 1;
                break;

            case R.id.tvAnswer3:
                tvClickAnswer = tvAnswer3;
                index = 2;
                break;

            case R.id.tvAnswer4:
                tvClickAnswer = tvAnswer4;
                index = 3;
                break;

                default: return;
        }

        Log.e("test",tvClickAnswer.getTag().toString());
         if(tvClickAnswer.getTag().equals(currentCorrentAnswer.getTextEng())){
            tvClickAnswer.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
             btnNextTest.setVisibility(View.VISIBLE);
             tvTitleMm.setText(currentCorrentAnswer.getTextMm());
             Utility.embedViewWithUnicode(this,tvTitleMm);
         }else {
             tvClickAnswer.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
          }

          playVoice(answers.get(index).getVoiceId());

    }

}

