package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class Int_to_postbruh {
    private String output[];
    private String input[];
    private Stack<String> stack = new Stack<>();
    int j = 0;


    private static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")
                || c.equals("^") || c.equals("(")|| c.equals(")");
    }
    private static int getPrec(String op1) {
        switch (op1)
        {
            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;

            default:
                return -1;
        }
    }

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

    public static String[] int_to_post(String[] infix)
    {
        Stack<String> stack = new Stack<>();
        ArrayList<String> postfix = new ArrayList<>();
        String temp;

        for (String s : infix)
        {
            temp = s;

            if (!isOperator(temp)) {
                postfix.add(temp);
            } else if (temp.equals("(")) {
                stack.push(temp);
            } else if (temp.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }
                if (!stack.isEmpty() && !stack.peek().equals("("))
                    return null;
                else if (!stack.isEmpty())
                    stack.pop();
            } else if (isOperator(temp)) {
                if (!stack.isEmpty() && getPrec(temp) <= getPrec(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(temp);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        return postfix.toArray(new String[0]);
    }

    //Stackoverflow the best
}
