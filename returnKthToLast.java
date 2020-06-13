/*
"Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list."

github.com/J-Nying
*/


import java.io.*;
import java.util.*;
import javax.swing.*;

public class returnKthToLast{

   public static void main(String[] args){
   
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the size of the Linked List:");
      int size = input.nextInt();
      LinkedList list = new LinkedList();
      int count = 0;
      
      while(count<size){
         System.out.println("Enter value number " + (count+1) + ":");
         int newNode = input.nextInt();
         list = appendNode(list, newNode);
         count++;
      }
      
      System.out.println("Here is the original Linked List:");
      printLinkedList(list);


      System.out.println("\nEnter a number to find the nth to last node:");
      int k = input.nextInt();
      if(k>size){
         System.out.println("Not possible to print " + k + "st/nd/rd/th to last node because the list is only " + size + " nodes long.");
         printLinkedList(list);
      }
      else{
         System.out.println("This is the " +k+ "st/nd/rd/th to last node: " + kthToLast(list, k));
      }
   }
   
   
   public static int kthToLast(LinkedList l, int k){
      Node firstNode = l.head;
      Node lastNode = l.head;
      int count=0;
      
      if(k==0 || k==1){
         while(lastNode.next!=null)
         {
            lastNode=lastNode.next;
         }
         return lastNode.data;
      }
      else{
         while(count<k)
         {
            lastNode=lastNode.next;
            count++;
         }
         while(lastNode!=null)
         {
            firstNode=firstNode.next;
            lastNode=lastNode.next;
         }
         
         return firstNode.data;
      }
   }
   

   public static LinkedList appendNode(LinkedList l, int d){
      Node newNode=new Node(d);
      
      if(l.head==null)
      {
         l.head=newNode;            
      }      
      else{
         Node currentNode=l.head;
         while(currentNode.next!=null)
         {
            currentNode=currentNode.next;
         }
         
         if(currentNode.next==null)
         {
            currentNode.next=newNode;
         }
      }
      
      return l;
   }
   
   
   
   
   public static void printLinkedList(LinkedList l){
      Node currentNode=l.head;
      
      while(currentNode.next!=null){
         System.out.print(currentNode.data + " -> ");
         currentNode=currentNode.next;
      }
      
      System.out.print(currentNode.data + "");                       
   }




}




class LinkedList{
   Node head;
}

class Node{
   int data;
   Node next;
   
   Node(int d){
      data = d;
   }

}

