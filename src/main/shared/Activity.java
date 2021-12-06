package main.shared;

import java.io.Serializable;

public class Activity implements Serializable {
    private String activityName;
    private String price;
    private String day;
    private String month;
    private String year;
    private String time;

    @Override
    public String toString() {
        return "Activity{" +
                "activityName='" + activityName + '\'' +
                ", price='" + price + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }





    public Activity(String activityName, String time, String price, String day, String month, String year) {
        this.activityName = activityName;
        this.price = price;
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;

    }
}