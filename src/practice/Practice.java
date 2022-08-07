package practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter Principal: ");
        int principal = scanner.nextInt();

        System.out.println("Please enter interest");
        float interest = scanner.nextFloat();

        double mortgage = principal * interest * interest / principal * Math.pow(2, 3);

        System.out.println("Mortgage is: " + NumberFormat.getCurrencyInstance().format(mortgage));

        scanner.close();

    }

}
