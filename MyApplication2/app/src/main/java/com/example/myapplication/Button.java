package com.example.myapplication;

import android.view.View;

public class Button {
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setText(String todayDate) {
    }
}
