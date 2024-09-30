/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

/**
 *
 * @author Muhammad Qasim
 */
public class QueueArray {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Queue class
    static class Queue1 {
        Node front; // front of the queue
        Node rear; // rear of the queue

        // Constructor to initialize the queue
        Queue1() {
            front = null;
            rear = null;
        }

        // Function to check if the queue is empty
        boolean isEmpty() {
            return front == null;
        }

        // Function to add an element to the rear of the queue
        void enqueue(int data) {
            Node newNode = new Node(data);

            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        // Function to remove an element from the front of the queue
        int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int data = front.data;
            front = front.next;

            if (front == null) {
                rear = null;
            }

            return data;
        }

        // Function to get the front element of the queue
        int front() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return front.data;
        }

        // Function to get the size of the queue
        int size() {
            int count = 0;
            Node temp = front;

            while (temp != null) {
                count++;
                temp = temp.next;
            }

            return count;
        }

        // Function to print the queue
        void printQueue() {
            Node temp = front;

            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue1 queue = new Queue1();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue: ");
        queue.printQueue();

        System.out.println("Front: " + queue.front());
        System.out.println("Size: " + queue.size());

        int dequeued = queue.dequeue();
        System.out.println("Dequeued: " + dequeued);

        System.out.println("Queue: ");
        queue.printQueue();
    }
}
