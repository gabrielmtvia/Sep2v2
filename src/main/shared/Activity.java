package main.shared;

import java.io.Serializable;
import java.util.Objects;

public class Activity implements Serializable
{
    private String activityName;
    private String price;
    private String date;
    private String startTime;
    private String endTime;

    public String getActivityName()
    {
        return activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public String getPrice()
    {
        return price;
    }

    public String setPrice(String price)
    {
        return this.price = price;
    }

    public String getDate()
    {
        return date;
    }

    public String setDate(String date)
    {
        return  this.date = date;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public Activity(String activityName, String price, String date, String startTime, String endTime)
    {
        this.activityName = activityName;
        this.price = price;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(activityName, activity.activityName) && Objects.equals(price, activity.price) && Objects.equals(date, activity.date) && Objects.equals(startTime, activity.startTime) && Objects.equals(endTime, activity.endTime);
    }

}