package com.firstappsta.mingalapar.Adapter;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstappsta.mingalapar.Activity.CategoryActivity;
import com.firstappsta.mingalapar.Data.CategoryData;
import com.firstappsta.mingalapar.R;
import com.firstappsta.mingalapar.Utility.Utility;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<CategoryData> {

//    private int lastPosition = -1;


        Context context;
        int layoutResourceId;
        ArrayList<CategoryData> data;
        private int minHeight = 0;

        public CategoryAdapter(Context context, int resource, ArrayList<CategoryData> data) {
            super(context, resource, data);
            this.context = context;
            layoutResourceId = resource;
            this.data = data;
        }

        public void setMinHeight(int minHeight) {
            this.minHeight = minHeight;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView;
            Category category;
            if (item == null) {

                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                item = inflater.inflate(layoutResourceId, parent, false);

                if (minHeight != 0) {

                    item.setMinimumHeight(minHeight);
                    ViewGroup.LayoutParams layoutParams = item.getLayoutParams();
                    layoutParams.height = minHeight;
                }
                category = new Category();
                item.setTag(category);
            } else {
                category = (Category) item.getTag();
            }

            category.img = item.findViewById(R.id.img);
            category.tvTitle = item.findViewById(R.id.tvTitle);
            category.tvInfo = item.findViewById(R.id.tvInfo);

            category.img.setImageResource(data.get(position).getImgId());
            category.tvTitle.setText(data.get(position).getTitle());
            category.tvInfo.setText(data.get(position).getInfo());
            Utility.embedViewWithUnicode(context, category.tvInfo );


            Animation animation = AnimationUtils.loadAnimation(context, R.anim.animcategory);
            item.startAnimation(animation);

//            AlphaAnimation alphaAnim = new AlphaAnimation(0,1);
//            alphaAnim.setDuration(1000);
//            alphaAnim.setFillAfter(true);
//
//            TranslateAnimation translateAnim = new TranslateAnimation(0,0,0.5f,0);
//            translateAnim.setDuration(600);
//            translateAnim.setFillAfter(true);
//
//            AnimationSet animSet = new AnimationSet(true);
//            animSet.addAnimation(alphaAnim);
//            animSet.addAnimation(translateAnim);
//            item.startAnimation(animSet);


            return item;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        static class Category {

            ImageView img;
            TextView tvTitle, tvInfo;
        }
}







