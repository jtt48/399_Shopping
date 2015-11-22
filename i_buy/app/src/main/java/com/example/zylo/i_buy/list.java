package com.example.zylo.i_buy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class list extends AppCompatActivity {
    String[] the_list = new String[20];
    private Database db = new Database(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setlistlistener();

    }

    private void setlistlistener() {

        the_list[0] = db.get_name();
        System.out.println(the_list[0]);

        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,the_list);

        ListView list = (ListView)findViewById(R.id.List);

        list.setAdapter(adapter);

    }


    /** Called when the user clicks the button */
    public void to_main(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /** Called when the user clicks the button */
    public void to_add(View view2) {
        // just placing the db add function here for testing purposes.
        // this will ultimetly be called in the add page when a new item is added and we will querey the database when this page is opened.
        //db.set_name("Tomatto");
        Intent intent = new Intent(this, add.class);
        startActivity(intent);
    }
}
