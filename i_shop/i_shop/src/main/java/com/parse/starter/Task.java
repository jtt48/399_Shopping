package com.parse.starter;

/**
 * Created by Zylo on 11/14/2015.
 */

    import com.parse.ParseClassName;
    import com.parse.ParseObject;

    @ParseClassName("Task")
    public class Task extends ParseObject{
        public Task(){

        }

        public boolean isCompleted(){
            return getBoolean("completed");
        }

        //getter and setter methods for all parts of a task
        public void setCompleted(boolean complete){
            put("completed", complete);
        }

        public String getDescription(){
            return getString("description");
        }

        public void setDescription(String description){
            put("description", description);
        }

        public String getAmount(){
            return getString("amount");
        }

        public void setAmount(String amount){
            put("amount", amount);
        }

        public String getPrice(){
            return getString("price");
        }

        public void setPrice(String amount){
            put("price", amount);
        }



    }
