package main.shared;

import java.io.Serializable;

public class Activity implements Serializable {
    private String activityName;
    private String price;
    private String date;
    private String startTime;
    private String endTime;



    public String getActivityName() {
        return activityName;
    }
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getPrice() {
        return price;
    }

    public String setPrice(String price) {
        return this.price = price;
    }

    public String getDate() {
        return date;
    }

    public String setDate(String date) {
        return  this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }


    public Activity(String activityName, String price, String date, String startTime, String endTime) {
        this.activityName = activityName;
        this.price = price;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}