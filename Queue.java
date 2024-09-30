/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queue;

/**
 *
 * @author Muhammad Qasim
 */
public class Queue {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Queue1 {
        Node front;
        Node rear;
        Queue1() {
            front = null;
            rear = null;
        }
         boolean isEmpty() {
            return front == null;
        }
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
        int front() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return front.data;
        }
        int size() {
            int count = 0;
            Node temp = front;

            while (temp != null) {
                count++;
                temp = temp.next;
            }

            return count;
        }

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
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
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