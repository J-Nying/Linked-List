/*
"Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?"

github.com/J-Nying
*/

import java.io.*;
import java.util.*;
import javax.swing.*;


public class removeDups{
   

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
      
      System.out.println("");
      System.out.println("Here is the Linked List with duplicates removed:");
      printLinkedList(removeDups(list));
      
      
   }


   public static LinkedList appendNode(LinkedList l, int d){
      Node newNode=new Node(d);
      
      if(l.head==null){
         l.head=newNode;            
      }
      
      else{
         Node currentNode=l.head;
         while(currentNode.next!=null){
            currentNode=currentNode.next;
         }
         
         if(currentNode.next==null){
            currentNode.next=newNode;
         }
      }
      
      return l;
   }
   
   
   public static LinkedList removeDups(LinkedList l){
      Node currentNode=l.head;
      
      while(currentNode!=null){
         Node n = currentNode;
         while(n.next!=null){
            if(n.next.data==currentNode.data){
               n.next=n.next.next;
            }
            else{
               n=n.next;
            }
         }
         currentNode=currentNode.next;
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