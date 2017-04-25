package com.example.phuongdong.puzzle.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class PuzzleAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<Bitmap> arrayBitmap;

    private int imageWidth, imageHeight;

    //constructor
    public PuzzleAdapter(Context context, ArrayList<Bitmap> arrayBitmap){

        this.context = context;
        this.arrayBitmap = arrayBitmap;
        imageWidth = arrayBitmap.get(0).getWidth();
        imageHeight = arrayBitmap.get(0).getHeight();
        Log.e("with image", imageWidth + "");
        Log.e("height image", imageHeight + "");
        // start get size screen device
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        imageWidth = width;
        imageHeight = height;
        Log.e("with device", width + "");
        Log.e("height device", height + "");
        // end
    }

    // return how many view is crated
    public int getCount() {

        return arrayBitmap.size();

    }

    public Object getItem(int position) {

        return arrayBitmap.get(position);

    }

    public long getItemId(int position) {

        return position;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView image;

        if(convertView == null){

            image = new ImageView(this.context);

            image.setLayoutParams(new GridView.LayoutParams(imageWidth - 6, imageHeight - 6));

            image.setPadding(0, 0, 0, 0);

        }else{

            image = (ImageView) convertView;

        }

        image.setImageBitmap(arrayBitmap.get(position));

        return image;

    }

}
