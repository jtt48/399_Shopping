package com.example.zylo.i_buy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    /** Called when the user clicks the button */
    public void to_list(View view) {
        db.set_name("Tomatto");
        Intent intent = new Intent(this, list.class);
        startActivity(intent);
    }
}
