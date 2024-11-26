/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryt;

/**
 *
 * @author Muhammad Qasim
 */
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class DeleteOP{

    public Node delete(Node root, int key) {
        if (root == null)
            return root;
        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
             root.data = minValue(root.right);
             root.right = delete(root.right, root.data);
        }

        return root;
    }
      public int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
    public static void main(String[] args) {
        DeleteOP tree = new DeleteOP();
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);
        System.out.println("Delete 20:");
        root = tree.delete(root, 20);
        System.out.println("Deleted 20");

        System.out.println("Delete 30:");
        root = tree.delete(root, 30);
        System.out.println("Deleted 30");

        System.out.println("Delete 50:");
        root = tree.delete(root, 50);
        System.out.println("Deleted 50");
    }
}

    
