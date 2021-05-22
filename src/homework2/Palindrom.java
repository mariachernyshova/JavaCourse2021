package homework2;

import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");

        String input = in.nextLine();
        System.out.println(input);

        //убираем пробелы из строки
        input = input.toLowerCase().replace(" ", "");
        System.out.println(input);

        StringBuilder reverseString = new StringBuilder(input).reverse();
        System.out.println(input.equals(reverseString.toString()));
    }

}
