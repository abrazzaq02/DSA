/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryt;

/**
 *
 * @author Muhammad Qasim
 */
public class BTNode {
    int data;
    BTNode left;
    BTNode right;

    public BTNode(int data) {
        this.data = data;
        left=right=null;
    }
    
    public void insertLeftChild(BTNode parent , BTNode child){
    parent.left = child;
    }
    
    public void insertRightChild(BTNode parent , BTNode child){
    parent.right = child;
    }
    
    
}
