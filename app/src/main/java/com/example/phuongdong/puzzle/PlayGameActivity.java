package com.example.phuongdong.puzzle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Random;


public class PlayGameActivity extends AppCompatActivity {

    private static final int MAX = 9;
    private static final int MIN = 0;

    private ImageButton imageButton2, imageButton3, imageButton4, imageButton5, imageButton6,
            imageButton7, imageButton8, imageButton9, imageButton10, imageButton11;
    private ScrollView scrollView;
    private RelativeLayout relativeLayout;
    private Random random = new Random();
    private ArrayList<Integer> arrayRandom = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game_puzzle);
        setTitle("Playing Game");
        //create control view
        init();
        // get data from intent before activity
        Bundle bundle = getIntent().getExtras();
        int resource_id = bundle.getInt(PuzzleActivity.RESOURCE_IMAGE);
        int small_image_numbers = bundle.getInt(PuzzleActivity.NUMBER_SMALL_IMAGE_NAME);
        // split small image and set to image button
        splitImage(resource_id, small_image_numbers);
        eventSwap();
    }

    public void init() {
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        relativeLayout = (RelativeLayout) findViewById(R.id.rlLayout);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setDrawingCacheEnabled(true);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setDrawingCacheEnabled(true);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setDrawingCacheEnabled(true);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        imageButton5.setDrawingCacheEnabled(true);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setDrawingCacheEnabled(true);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setDrawingCacheEnabled(true);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
        imageButton8.setDrawingCacheEnabled(true);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton9);
        imageButton9.setDrawingCacheEnabled(true);
        imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton10.setDrawingCacheEnabled(true);
        imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton11.setDrawingCacheEnabled(true);
    }

    public Bitmap readBitmapAndScale(int id) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), id, options);
        options.inSampleSize = 4;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(getResources(), id, options);
    }

    private void splitImage(int id, int numberSmallImage) {
        int rows, cols;
        int smallImageHeight, smallImageWidth;
        ImageButton arrayImageButtonRandom[] = {imageButton4, imageButton7, imageButton2, imageButton3, imageButton6, imageButton8, imageButton9, imageButton5, imageButton10, imageButton11};

        Bitmap bitmap = readBitmapAndScale(id);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);
        rows = cols = (int) Math.sqrt(numberSmallImage);
        smallImageHeight = bitmap.getHeight() / rows;
        smallImageWidth = bitmap.getWidth() / cols;

        int indexImageButton = 0;
        int yCo = 0;
        for (int x = 0; x < rows; x++) {
            int xCo = 0;
            for (int y = 0; y < cols; y++) {
                Bitmap bitmapSmall = Bitmap.createBitmap(scaledBitmap, xCo, yCo, smallImageWidth, smallImageHeight);
                arrayImageButtonRandom[indexImageButton].setImageBitmap(bitmapSmall);
                indexImageButton++;
                if(indexImageButton == 9){
                    Log.e("indexImageButton", ""+indexImageButton);
                    arrayImageButtonRandom[indexImageButton].setImageBitmap(null);
                }
                xCo += smallImageWidth;
            }
            yCo += smallImageHeight;
        }
    }

    public void eventSwap(){
        final ImageButton arrayImageButton[] = {imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11};
        arrayImageButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayImageButton[1].getDrawingCache().equals(null)){
                    arrayImageButton[1].setImageBitmap(arrayImageButton[0].getDrawingCache());
                    arrayImageButton[0].setImageBitmap(null);
                }
                if(arrayImageButton[3].getDrawingCache().equals(null)){
                    arrayImageButton[3].setImageBitmap(arrayImageButton[0].getDrawingCache());
                    arrayImageButton[0].setImageBitmap(null);
                }
            }
        });

        arrayImageButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayImageButton[0].getDrawingCache().equals(null)){
                    arrayImageButton[0].setImageBitmap(arrayImageButton[1].getDrawingCache());
                    arrayImageButton[1].setImageBitmap(null);
                }
                if(arrayImageButton[2].getDrawingCache().equals(null)){
                    arrayImageButton[0].setImageBitmap(arrayImageButton[1].getDrawingCache());
                    arrayImageButton[1].setImageBitmap(null);
                }
                if(arrayImageButton[4].getDrawingCache().equals(null)){
                    arrayImageButton[0].setImageBitmap(arrayImageButton[1].getDrawingCache());
                    arrayImageButton[1].setImageBitmap(null);
                }
            }
        });

        arrayImageButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayImageButton[1].getDrawingCache().equals(null)){
                    arrayImageButton[1].setImageBitmap(arrayImageButton[2].getDrawingCache());
                    arrayImageButton[2].setImageBitmap(null);
                }
                if(arrayImageButton[5].getDrawingCache().equals(null)){
                    arrayImageButton[5].setImageBitmap(arrayImageButton[2].getDrawingCache());
                    arrayImageButton[2].setImageBitmap(null);
                }
            }
        });

        arrayImageButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayImageButton[0].getDrawingCache().equals(null)){
                    arrayImageButton[0].setImageBitmap(arrayImageButton[3].getDrawingCache());
                    arrayImageButton[3].setImageBitmap(null);
                }
                if(arrayImageButton[4].getDrawingCache().equals(null)){
                    arrayImageButton[4].setImageBitmap(arrayImageButton[3].getDrawingCache());
                    arrayImageButton[3].setImageBitmap(null);
                }
                if(arrayImageButton[6].getDrawingCache().equals(null)){
                    arrayImageButton[6].setImageBitmap(arrayImageButton[3].getDrawingCache());
                    arrayImageButton[3].setImageBitmap(null);
                }
            }
        });

        arrayImageButton[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayImageButton[1].getDrawingCache().equals(null)){
                    arrayImageButton[1].setImageBitmap(arrayImageButton[4].getDrawingCache());
                    arrayImageButton[4].setImageBitmap(null);
                }
                if(arrayImageButton[3].getDrawingCache().equals(null)){
                    arrayImageButton[3].setImageBitmap(arrayImageButton[4].getDrawingCache());
                    arrayImageButton[4].setImageBitmap(null);
                }
                if(arrayImageButton[5].getDrawingCache().equals(null)){
                    arrayImageButton[5].setImageBitmap(arrayImageButton[4].getDrawingCache());
                    arrayImageButton[4].setImageBitmap(null);
                }
                if(arrayImageButton[7].getDrawingCache().equals(null)){
                    arrayImageButton[7].setImageBitmap(arrayImageButton[4].getDrawingCache());
                    arrayImageButton[4].setImageBitmap(null);
                }
            }
        });

        arrayImageButton[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayImageButton[2].getDrawingCache().equals(null)){
                    arrayImageButton[2].setImageBitmap(arrayImageButton[5].getDrawingCache());
                    arrayImageButton[5].setImageBitmap(null);
                }
                if(arrayImageButton[4].getDrawingCache().equals(null)){
                    arrayImageButton[4].setImageBitmap(arrayImageButton[5].getDrawingCache());
                    arrayImageButton[5].setImageBitmap(null);
                }
                if(arrayImageButton[8].getDrawingCache().equals(null)){
                    arrayImageButton[8].setImageBitmap(arrayImageButton[5].getDrawingCache());
                    arrayImageButton[5].setImageBitmap(null);
                }
            }
        });

        arrayImageButton[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayImageButton[3].getDrawingCache().equals(null)){
                    arrayImageButton[3].setImageBitmap(arrayImageButton[6].getDrawingCache());
                    arrayImageButton[6].setImageBitmap(null);
                }
                if(arrayImageButton[7].getDrawingCache().equals(null)){
                    arrayImageButton[7].setImageBitmap(arrayImageButton[6].getDrawingCache());
                    arrayImageButton[6].setImageBitmap(null);
                }
            }
        });

        arrayImageButton[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayImageButton[4].getDrawingCache().equals(null)){
                    arrayImageButton[4].setImageBitmap(arrayImageButton[7].getDrawingCache());
                    arrayImageButton[7].setImageBitmap(null);
                }
                if(arrayImageButton[6].getDrawingCache().equals(null)){
                    arrayImageButton[6].setImageBitmap(arrayImageButton[7].getDrawingCache());
                    arrayImageButton[7].setImageBitmap(null);
                }
                if(arrayImageButton[8].getDrawingCache().equals(null)){
                    arrayImageButton[8].setImageBitmap(arrayImageButton[7].getDrawingCache());
                    arrayImageButton[7].setImageBitmap(null);
                }
            }
        });

        arrayImageButton[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmapImage5 = ((BitmapDrawable)arrayImageButton[5].getDrawable()).getBitmap();
                Bitmap bitmapImage7 = ((BitmapDrawable)arrayImageButton[7].getDrawable()).getBitmap();
                Bitmap bitmapImage8 = ((BitmapDrawable)arrayImageButton[8].getDrawable()).getBitmap();
                Log.e("9",""+arrayImageButton[9].getDrawable());
                if(arrayImageButton[9].getDrawable().equals(null)) {
                    arrayImageButton[9].setImageBitmap(bitmapImage8);
                    arrayImageButton[8].setImageBitmap(null);
                    Log.e("swap", "swap ok");
                }
                if(bitmapImage5.equals(null)){
                    arrayImageButton[5].setImageBitmap(bitmapImage8);
                    arrayImageButton[8].setImageBitmap(null);
                }
                if(bitmapImage7.equals(null)){
                    arrayImageButton[7].setImageBitmap(bitmapImage8);
                    arrayImageButton[8].setImageBitmap(null);
                }
            }
        });

        arrayImageButton[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayImageButton[8].getDrawingCache().equals(null)){
                    arrayImageButton[8].setImageBitmap(arrayImageButton[9].getDrawingCache());
                    arrayImageButton[9].setImageBitmap(null);
                }
            }
        });

    }
}
