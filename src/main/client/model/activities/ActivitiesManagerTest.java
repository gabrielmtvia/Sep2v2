package main.client.model.activities;

import main.client.networking.activities.ActivitiesClient;
import main.client.networking.activities.ActivitiesClientModel;
import main.client.networking.rmi.RmiClient;
import main.shared.Activity;
import main.shared.UserName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ActivitiesManagerTest {


    @org.junit.jupiter.api.Test
    void saveActivity() {
        ActivitiesManager activitiesManager = new ActivitiesManager(new ActivitiesClient(new RmiClient()));
        String response = activitiesManager.saveActivity(new Activity("Test", 100,"2021-12-17","9:00", "9:50"));
        assertTrue(response.contains("successfully"));

    }

    @org.junit.jupiter.api.Test
    void registerActivities() {
        ActivitiesManager activitiesManager = new ActivitiesManager(new ActivitiesClient(new RmiClient()));
        String response = activitiesManager.registerActivities(new Activity("Test", 100,"2021-12-17","9:00", "9:50"), new UserName("test"));
        assertTrue(response.contains("successfully"));

        response = activitiesManager.registerActivities(new Activity("Test", 100,"2021-12-17","9:00", "9:50"), new UserName("test"));
        assertTrue(response.contains("duplicate"));
    }

    @org.junit.jupiter.api.Test
    void cancelRegistration() {
        ActivitiesManager activitiesManager = new ActivitiesManager(new ActivitiesClient(new RmiClient()));
        String response = activitiesManager.cancelRegistration(new Activity("Test", 100,"2021-12-17","9:00", "9:50"), new UserName("test"));
        System.out.println(response);
        assertTrue(response.contains("resultado"));
    }

    @org.junit.jupiter.api.Test
    void deleteActivity() {
        ActivitiesManager activitiesManager = new ActivitiesManager(new ActivitiesClient(new RmiClient()));
        String response = activitiesManager.deleteActivity(new Activity("Test", 100,"2021-12-17","9:00", "9:50"));
        assertTrue(response.contains("successfully"));
    }


}