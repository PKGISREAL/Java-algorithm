package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String output;
        InToPost theTrans = new InToPost(input);
        output = theTrans.doThings();
        System.out.println("Postfix is " + output + '\n');



    }
}
