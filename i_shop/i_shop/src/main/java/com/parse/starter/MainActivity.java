/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

  private EditText mTaskInput;
  private EditText mTaskAmount;
  private ListView mListView;
  TaskAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setTitle("i_shop");
    setContentView(R.layout.activity_main);
    //ParseObject testObject = new ParseObject("TestObject");
    //testObject.put("foo", "bar");
    //testObject.saveInBackground();
    ParseAnalytics.trackAppOpenedInBackground(getIntent());

    //create the list and its adapter
    mAdapter = new TaskAdapter(this, new ArrayList<Task>());
    mListView = (ListView) findViewById(R.id.task_list);
    mListView.setAdapter(mAdapter);
    mListView.setOnItemClickListener(this);

    updateData();

  }
/*
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
*/

  // in charge of deleting tasks from the list
  public void remover(View vew) {
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
    query.whereEqualTo("completed", true);
    query.getFirstInBackground(new GetCallback<ParseObject>() {
      public void done(ParseObject object, ParseException e) {
        if (object == null) {
          Log.d("score", "The getFirst request failed.");
        } else {
          Log.d("score", "Retrieved the object.");
          object.deleteEventually();
        }
      }
    });
    updateData();
  }

// method for updating the list
  public void updateData(){
    ParseQuery<Task> query = ParseQuery.getQuery(Task.class);
    query.findInBackground(new FindCallback<Task>() {

      @TargetApi(Build.VERSION_CODES.HONEYCOMB)
      @Override
      public void done(List<Task> tasks, ParseException error) {
        if (tasks != null) {
          mAdapter.clear();
          mAdapter.addAll(tasks);
        }
      }
    });
  }

// method for changing the view to the add screen
  public void add(View view) {
    Intent intent = new Intent(this, Add.class);
    startActivity(intent);
  }

// method used to place the strike marker on items in the list so the delete button can delete them
  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Task task = mAdapter.getItem(position);
    TextView taskDescription = (TextView) view.findViewById(R.id.task_description);

    task.setCompleted(!task.isCompleted());

    if(task.isCompleted()){
      taskDescription.setPaintFlags(taskDescription.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }else{
      taskDescription.setPaintFlags(taskDescription.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
    }

    task.saveEventually();
  }






}

