package com.parse.starter;

/**
 * Created by Zylo on 11/16/2015.
 */
import java.util.List;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// task adapter for the list to display the tasks
public class TaskAdapter extends ArrayAdapter<Task> {
    private Context mContext;
    private List<Task> mTasks;

    public TaskAdapter(Context context, List<Task> objects) {
        super(context, R.layout.task_row_item, objects);
        this.mContext = context;
        this.mTasks = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
            convertView = mLayoutInflater.inflate(R.layout.task_row_item, null);
        }

        Task task = mTasks.get(position);

        TextView descriptionView = (TextView) convertView.findViewById(R.id.task_description);
        TextView amountView = (TextView) convertView.findViewById(R.id.task_amount);
        TextView costView = (TextView) convertView.findViewById(R.id.task_cost);

        descriptionView.setText(task.getDescription());
        amountView.setText(task.getAmount());
        costView.setText(task.getPrice());

        if(task.isCompleted()){
            descriptionView.setPaintFlags(descriptionView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }else{
            descriptionView.setPaintFlags(descriptionView.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }

        return convertView;
    }

}