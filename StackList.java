/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSA_Lab_03;

/**
 *
 * @author Muhammad Qasim
 */
public class StackList {
  
    private int maxSize;
    private int top;
    private int[] stackArray;

    public StackList(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top >= maxSize - 1) {
            System.out.println("Stack is full. Can't push element.");
            return;
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (top < 0) {
            System.out.println("Stack is empty. Can't pop element.");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek() {
        if (top < 0) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        StackList stack = new StackList(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Peek: " + stack.peek()); // prints 30
        System.out.println("Pop: " + stack.pop()); // prints 30
        System.out.println("IsEmpty: " + stack.isEmpty()); // prints false
        System.out.println("IsFull: " + stack.isFull()); // prints false
    }
}

