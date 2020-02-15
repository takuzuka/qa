import org.gavaghan.geodesy.*;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class HomeworkOne {
    @Test
    public void homeworkOne() {
        System.out.println("TASK 1");
        String car ="tesla";
        double price = 355.111;
        double mileage = 39911.136;
        System.out.println("Prodam " + car + " za cenu " + price + " s probegom " + mileage);


        System.out.println("TASK 2");
        double fuelCost = 3.57;
        double fuelOnHundredKm = 80;
        double distance = 100;
        double flycost = distance * fuelOnHundredKm / 100 * fuelCost;
        System.out.println("Cost of the flight: " + flycost + " eiro");

        System.out.println("TASK 3");
        taskThree("260698-10905");

        System.out.println("TASK 4*");
        distance(56.950075, 56.959433 ,24.120794, 24.119210);
    }

    private static double distance(double latitudeFirst, double latitudeSecond, double longitudeFirst,
                                   double longtidufeSecond) {


        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(latitudeSecond - latitudeFirst);
        double lonDistance = Math.toRadians(longtidufeSecond - longitudeFirst);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(latitudeFirst)) * Math.cos(Math.toRadians(latitudeSecond))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        distance = Math.pow(distance, 2); //vozvrhashaet pokazatel' u osnovanija

        System.out.println(Math.sqrt(distance));
        return Math.sqrt(distance);
    }

    private static void taskThree(String personalnijKod) {

        String person = personalnijKod.replace("-", "");
        Long code = Long.parseLong(person);
        long day = code / 1000000000;
        long month = code % 1000000000 / 10000000;
        long yearEnd = code % 10000000 / 100000;
        long century = code % 100000 / 10000;
        String yearBeginning = "";
        if (day > 31) {
            System.err.println("Something is wrong with your date of birthday");
        } else if (century == 1) {
            yearBeginning = "19";
        } else if (century == 2) {
            yearBeginning = "20";
        } else {
            System.out.println("OH MY GOD, SOMETHING WRONG HERE");
        }
        String monthInWords = "";
        if (month == 1) {
            monthInWords = "January";
        } else if (month == 2) {
            monthInWords = "February";
        } else if (month == 3) {
            monthInWords = "March";
        } else if (month == 4) {
            monthInWords = "April";
        } else if (month == 5) {
            monthInWords = "March";
        } else if (month == 6) {
            monthInWords = "June";
        } else if (month == 7) {
            monthInWords = "July";
        } else if (month == 8) {
            monthInWords = "August";
        } else if (month == 9) {
            monthInWords = "September";
        } else if (month == 10) {
            monthInWords = "October";
        } else if (month == 11) {
            monthInWords = "November";
        } else if (month == 12) {
            monthInWords = "December";
        } else {
            System.out.println("OH MY GOD, SOMETHING WRONG HERE");
        }
        System.out.println("You are born " + day + " " + monthInWords + " " + yearBeginning + yearEnd);
    }
}
//public static void main(String[] args) chto eto takoe i pochemu ne mogu ispolzovat' eshe raz
//static --?



