package com.company;

import java.nio.file.AccessMode;
import java.util.ArrayList;
import java.util.Stack;

public class Int_to_postbruh {
    private String output[];
    private String input[];
    private Stack<String> stack = new Stack<>();
    int j = 0;


    static String[] split(String com) {
        ArrayList<String> result = new ArrayList<>();
        String temp;
        int length = 0;
        for (String ch : com.split(" ")) {
            temp = "";
            if (!ch.equals("")) {
                for (char i : ch.toCharArray()) {
                    if (i >= 40 && i <= 43 || i == '/' || i == '-' || i == '^') {
                        if (!temp.equals("")) {
                            result.add(temp);
                            length++;
                        }
                        temp = "";
                        result.add("" + i);
                        length++;
                    } else temp += i;
                }
                if (!temp.equals("")) {
                    result.add(temp);
                    length++;
                }
            }
        }
        if (result.get(0).equals("-")) {
            result.remove(0);
            result.set(0, "-" + result.get(0));
            length--;
        }
        for (int i = 0; i < length; i++) {
            if (result.get(i).equals("(") && result.get(i + 1).equals("-")) {
                if (result.get(i + 3).equals(")")) {
                    result.remove(i);
                    result.remove(i);
                    result.set(i, "-" + result.get(i));
                    result.remove(i + 1);
                    length -= 3;
                } else {
                    result.remove(i + 1);
                    result.set(i + 1, "-" + result.get(i + 1));
                    length--;
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public String[] int_to_post(String[] Amogus){
        int size = Amogus.length;
        this.input = new String[size];
        for(int i = 0; i < Amogus.length; i++){
            switch(Amogus[i]){
                case "+":
                case "-":
                    gotOper(Amogus[i], 1);
                    break;
                case "*":
                case "/":
                    gotOper(Amogus[i], 2);
                    break;
                case "(":
                    stack.push(Amogus[i]);
                    break;
                case ")":
                    gotParen(Amogus[i]);
                    break;
                default:
                    input[j] = Amogus[i];
                    j++;
                    break;
            }
        }
        while(!stack.isEmpty())
            input[j] = stack.pop();


        this.output = new String[j];

        for(int i = 0; i < j ; i++){
            output[i] = input[i];
        }


        return output;
    }
    public void gotOper(String opThis, int prior1){

        while (!stack.isEmpty()){

            String opTop = stack.pop();

            if(opTop == "("){
                stack.push(opTop);
                break;
            } else {
                int prior2;
                if (opTop == "+" || opTop == "-")
                    prior2 = 1;
                else
                    prior2 = 2;
                if (prior2 < prior1){
                    stack.push(opTop);
                    break;
                }
                else {
                    input[j] = opTop;
                    j++;
                }

            }

        }
        stack.push(opThis);
    }
    public void gotParen(String ch){

        while (!stack.isEmpty()){

            String chx = stack.pop();

            char gob = chx.charAt(0);

            if ( gob == '(')
                break;
            else{ input[j] = String.valueOf(gob);
                  j++;
            }
        }
    }


}