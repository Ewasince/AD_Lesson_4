package com.mirea.lavrenov.loadermanger;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MyLoader extends AsyncTaskLoader<String> {
    private String textStart;
    public static final String ARG_WORD = "word";

    public MyLoader(@NonNull Context context, Bundle args) {
        super(context);
        if (args != null)
            textStart = args.getString(ARG_WORD);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    Random rnd = new Random();

    @Override
    public String loadInBackground() {
        // emulate long-running operation
//        SystemClock.sleep(5000);
//        return textStart;
        StringBuilder oldText = new StringBuilder(textStart);
        StringBuilder newText = new StringBuilder();
        while (oldText.length() > 0) {
            newText.append(popChar(oldText));
        }
        return newText.toString();
    }

    char popChar(StringBuilder strB) {
        int len = strB.length();
        int rndNum = rnd.nextInt(len);
        char char_ = strB.charAt(rndNum);
        strB.deleteCharAt(rndNum);
        return char_;
    }
}