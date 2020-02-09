import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Basics {

    @Test
    public void javaBasics() {
        sumTwoDigits(10, 15);
        sumTwoDigits(35, 45);
        sumTwoDigits("15", "33");
/*
        int a = 10;
        int b = 15;
        int c = a + b;
        System.out.println("Sum of a and b is: " + c);

        String d = "10";
        String e = "15";

        int g = 30;
        int h = 45;
        int i = g + h;

        System.out.println(i);

        String f = d + e;
        System.out.println(f);
*/
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String myString = input.next();
        System.out.println("Text entered = " + myString);
    }

    private void sumTwoDigits(int a, int b) {
        int c = a + b;
        System.out.println("Sum is: " + c);
    }

    private void sumTwoDigits(String a, String b) {
        int c = Integer.parseInt(a);
        int d = Integer.parseInt(b);
        sumTwoDigits(c, d);

    }

}
