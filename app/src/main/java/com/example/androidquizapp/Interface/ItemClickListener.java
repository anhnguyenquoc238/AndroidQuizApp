package com.example.androidquizapp.Interface;

import android.view.View;

//interface to implement onClick at Recycler Item
public interface ItemClickListener {
    void onClick(View view,int position, boolean isLongClick);
}
