package com.example.zylo.i_buy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void to_list(View view) {
        Intent intent = new Intent(this, list.class);
        startActivity(intent);
       // EditText editText = (EditText) findViewById(R.id.list);
        // Do something in response to button
    }
}
