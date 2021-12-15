package main.client.model.activities;

import main.client.networking.activities.ActivitiesClient;
import main.client.networking.rmi.RmiClient;
import main.shared.Activity;
import main.shared.UserName;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ActivitiesManagerTest {

    ActivitiesManager activitiesManager;
    Activity activity;
    UserName username;

    @BeforeEach
    void setUp() {
        activitiesManager = new ActivitiesManager(new ActivitiesClient(new RmiClient()));
        activity = new Activity("Test", 100,"2021-12-17","9:00", "9:50");
        username = new UserName("test");
    }

    @org.junit.jupiter.api.Test
    void saveActivity() {

        String response = activitiesManager.saveActivity(activity);
        assertTrue(response.contains("successfully"));

    }

    @org.junit.jupiter.api.Test
    void registerActivities() {
        String response = activitiesManager.registerActivities(activity, username);
        assertTrue(response.contains("successfully"));

        response = activitiesManager.registerActivities(activity, username);
        assertTrue(response.contains("duplicate"));
    }

    @org.junit.jupiter.api.Test
    void cancelRegistration() {
        String response = activitiesManager.cancelRegistration(activity , username);
        System.out.println(response);
        assertTrue(response.contains("result"));
    }

    @org.junit.jupiter.api.Test
    void deleteActivity() {
        String response = activitiesManager.deleteActivity(activity);
        assertTrue(response.contains("successfully"));
    }


}