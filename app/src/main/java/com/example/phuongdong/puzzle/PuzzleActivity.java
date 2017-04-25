package com.example.phuongdong.puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class PuzzleActivity extends AppCompatActivity {

    private static final int NUMBER_SMALL_IMAGE = 9;
    public static final String RESOURCE_IMAGE = "resource_id";
    public static final String NUMBER_SMALL_IMAGE_NAME = "small_image_numbers";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        // create control view
        Button play = (Button) findViewById(R.id.small_image);
        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PuzzleActivity.this, PlayGameActivity.class);
                intent.putExtra(PuzzleActivity.RESOURCE_IMAGE, R.drawable.image_test);
                intent.putExtra(PuzzleActivity.NUMBER_SMALL_IMAGE_NAME, PuzzleActivity.NUMBER_SMALL_IMAGE);
                startActivity(intent);
            }
        });

    }
}
