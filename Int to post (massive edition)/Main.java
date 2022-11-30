package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = "(3*4+2-3)";
        Int_to_postbruh int_to_postbruh = new Int_to_postbruh();
        String job[] = int_to_postbruh.int_to_post(Int_to_postbruh.split(command));
        System.out.println(Arrays.toString(job));


    }

}