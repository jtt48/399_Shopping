package com.example.zylo.i_buy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    /** Called when the user clicks the button */
    public void to_main(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
