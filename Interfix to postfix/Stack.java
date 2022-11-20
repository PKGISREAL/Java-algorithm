package com.company;

public class Stack {

    private int size;
    private char[] steck;
    private int top = -1;

    public Stack(int Max){
        this.size = Max;
        steck = new char[Max];

    }

    public void push(char number){
        this.steck[++top] = number;

    }

    public char take(){
        return this.steck[top--];
    }

    public char showTop(){
        return this.steck[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == size - 1);
    }

}
