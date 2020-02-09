import org.gavaghan.geodesy.*;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class HomeworkOne {

    @Test
    public static void main(String[] args) {
        System.out.println("TASK 1");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter car: ");
        String car = input.next();
        System.out.println("Enter price: ");
        double price = input.nextDouble();
        System.out.println("Enter mileage");
        double mileage = input.nextDouble();
        System.out.println("Prodam " + car + " za cenu " + price + " s probegom " + mileage);


        // uzd 2
        System.out.println("TASK 2");
        double cena = 3.57;
        System.out.println("Vvedite skolko samolet ispolzuet topliva (v litrah) na 100 km:");
        double toplivoNaSto = input.nextDouble();
        System.out.println("Vvedite skolko samolet proletel (v kilometrah):");
        double rasstojanie = input.nextDouble();
        double stoimost = rasstojanie * toplivoNaSto / 100 * cena;
        System.out.println("Polet samoleta stoil: " + stoimost + " eiro");

        //uzd 3
        System.out.println("TASK 3");
        System.out.println("Vvedite personalnij kod");
        String personalnijKod = input.next();
        taskThree(personalnijKod);

        //uzd 4
        System.out.println("TASK 4*");
        //sorry zdes' tolko nado zamenit' . na ,
        System.out.println("Enter latitude of 1 place: ");
        double latitudeFirst = input.nextDouble();
        System.out.println("Enter longitude or 1 place: ");
        double longitudeFirst = input.nextDouble();
        System.out.println("Enter latitude of 1 place: ");
        double lattitudeSecond = input.nextDouble();
        System.out.println("Enter longitude or 1 place: ");
        double longitudeSecond = input.nextDouble();
        distance(latitudeFirst, lattitudeSecond, longitudeFirst, longitudeSecond);
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



