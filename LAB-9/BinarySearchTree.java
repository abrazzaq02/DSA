/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplebinarytree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
class BinarySearchTree {
    Node root;
    public BinarySearchTree() {
        this.root = null;
    }
    public void insert(int value) {
        root = insertRec(root, value);
    }
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }
    public int countNodes() {
        return countNodesRec(root);
    }
    private int countNodesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }
    public boolean search(int value) {
        return searchRec(root, value);
    }
    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value == root.value) {
            return true;
        }
        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
    }
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }
}
 class BinarySearchtree{
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insertion test
        int[] valuesToInsert = {50, 30, 20, 40, 70, 60, 80};
        for (int value : valuesToInsert) {
            bst.insert(value);
            System.out.println("Inserted " + value + ". Total nodes: " + bst.countNodes());
        }

        // Search test
        int[] valuesToSearch = {20, 60, 90};
        for (int value : valuesToSearch) {
            boolean exists = bst.search(value);
            System.out.println("Value " + value + (exists ? " exists" : " does not exist") + " in the BST.");
        }

        System.out.print("In-order Traversal: ");
        bst.inOrder();

        System.out.print("Pre-order Traversal: ");
        bst.preOrder();

        System.out.print("Post-order Traversal: ");
        bst.postOrder();

        System.out.print("Level-order Traversal: ");
    }}