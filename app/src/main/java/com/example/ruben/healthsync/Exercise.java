package com.example.ruben.healthsync;

/**
 * Created by Ruben on 25.02.2017.
 */
public class Exercise {

    String endTime;
    String startTime;
    String duration;
    String maxHeartRate;
    String meanHeartRate;
    String maxCadence;
    String exerciseType;
    String maxSpeed;
    String caloriesBurned;
    String meanSpeed;
    String meanCadence;
    String minHeartRate;
    String distance;
    String createTime;

    public Exercise(String endTime, String startTime, String duration, String maxHeartRate,
               String meanHeartRate, String maxCadence, String exerciseType, String maxSpeed,
               String caloriesBurned, String meanSpeed, String meanCadence, String minHeartRate,
               String distance, String createTime) {

        this.endTime = endTime;
        this.startTime = startTime;
        this.duration = duration;
        this.maxHeartRate = maxHeartRate;
        this.meanHeartRate = meanHeartRate;
        this.maxCadence = maxCadence;
        this.exerciseType = exerciseType;
        this.maxSpeed = maxSpeed;
        this.caloriesBurned = caloriesBurned;
        this.meanSpeed = meanSpeed;
        this.meanCadence = meanCadence;
        this.minHeartRate = minHeartRate;
        this.distance = distance;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Exercise{ \n" +
                "endTime=" + endTime + "\n" +
                "startTime=" + startTime + "\n" +
                "duration=" + duration + "\n" +
                "maxHeartRate=" + maxHeartRate + "\n" +
                "meanHeartRate=" + meanHeartRate + "\n" +
                "maxCadence=" + maxCadence + "\n" +
                "exerciseType=" + exerciseType + "\n" +
                "maxSpeed=" + maxSpeed + "\n" +
                "caloriesBurned=" + caloriesBurned + "\n" +
                "meanSpeed=" + meanSpeed + "\n" +
                "meanCadence=" + meanCadence + "\n" +
                "minHeartRate=" + minHeartRate + "\n" +
                "distance=" + distance + "\n" +
                "createTime=" + createTime +
                '}';
    }
}
