package com.firstappsta.mingalapar.Utility;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

import mm.technomation.mmtext.mmtext;

public class Utility {
    public static void embedViewWithUnicode(Context context, View view){
        mmtext.prepareView(context, view,mmtext.TEXT_UNICODE,true,true);
    }

    public static int getRandomWithExclusion(Random rnd, int start, int end, ArrayList<Integer> excludes) {
        int random = rnd.nextInt((end+1) - start) + start;
        while (isNumberExcluded(random, excludes)){
            random = rnd.nextInt((end+1) - start) + start;
        }
        return random;
    }

    public static Boolean isNumberExcluded(int num, ArrayList<Integer> excludes){

        for (int ex : excludes) {
            if (num == ex) {
                return true;
            }
        }

        return false;
    }
}
