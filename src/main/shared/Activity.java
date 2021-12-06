package main.shared;

import java.io.Serializable;

public class Activity implements Serializable {
    private String activityName;
    private String price;
    private String date;
    private String time;

    @Override
    public String toString() {
        return "Activity {" +
                "activityName='" + activityName + '\'' +
                ", price='" + price + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }



    public String getActivityName() {
        return activityName;
    }
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Activity(String activityName, String price, String date, String time) {
        this.activityName = activityName;
        this.price = price;
        this.date = date;
        this.time = time;
    }
}