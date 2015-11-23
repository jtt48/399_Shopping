package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.SaveCallback;

public class Add extends AppCompatActivity {

    private EditText mTaskInput;
    private EditText mTaskAmount;
    private EditText mTaskCost;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Add an Item to the List");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    // method that returns you to the list menue and sends task to the Parse database
    public void submit(View view) {
        createTask(view);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // method to create a task
    public void createTask(View v) {
        mTaskInput = (EditText) findViewById(R.id.task_name);
        mTaskAmount = (EditText) findViewById(R.id.task_quantity);
        mTaskCost = (EditText) findViewById(R.id.task_cost);
        if (mTaskInput.getText().length() > 0){
            Task t = new Task();

            // getting the values for the List item (task).
            t.setDescription(mTaskInput.getText().toString());
            t.setAmount(mTaskAmount.getText().toString());
            t.setPrice(mTaskCost.getText().toString());
            // t.setAmount(Integer.parseInt(mTaskInput.getText().toString()));

            t.setCompleted(false);
            t.saveEventually(new SaveCallback() {
                @Override
                public void done(ParseException e) {

                }
            });
            mTaskInput.setText("");
        }
    }
}
