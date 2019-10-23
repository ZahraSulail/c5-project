package com.barmej.guesstheanswer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ShareActivity extends AppCompatActivity {
    private String mQuestionText;
    public EditText mEditTextShareTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        mEditTextShareTitle = findViewById(R.id.edit_text_share_title);
        mQuestionText = getIntent().getStringExtra("Question text extra");

        SharedPreferences sharedPreferences = getSharedPreferences("app pief", MODE_PRIVATE);
        String questionTitle = sharedPreferences.getString("Share title",  "");
        mEditTextShareTitle.setText(questionTitle);

    }

    public void onShareQuestionClicked(View viee){

     String questionTitle = mEditTextShareTitle.getText().toString();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, questionTitle + "\n" + mQuestionText );
        shareIntent.setType("text/plain");
        startActivity(shareIntent);


        SharedPreferences sharedPreferences = getSharedPreferences("app pief", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Share title", questionTitle);
        editor.apply();
    }
}
