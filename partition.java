/*
"Partition; Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.
If x is contained within the list, the values of x only need to be after the elements less than x (see below).
The partition element x can appear anywhere in the 'right partition'; it does not need to appear between the left and right partitions.
EXAMPLE
Input:  3 -> S -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
"

github.com/J-Nying
*/

import java.io.*;
import java.util.*;
import javax.swing.*;

public class partition{

   public static void main (String[] args)
   {
   
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
      
      System.out.println("Here is the Linked List:");
      printLinkedList(list);
      
      System.out.println("\nEnter partition:");
      int x = input.nextInt();
      
      
      System.out.println("Here is the new Linked List partitioned around " + x + ":");
      LinkedList partitionedList = Partition(list, x);

      printLinkedList(partitionedList);

      
      
   }



   public static LinkedList Partition(LinkedList l, int x){
      Node currentNode = l.head;
      LinkedList newList = new LinkedList();      

      while(currentNode!=null)
      {
         if(currentNode.data<x){
         newList=appendNode(newList, currentNode.data);
         }
         
         currentNode=currentNode.next;

      }
      
      currentNode = l.head;
      
      while(currentNode!=null)
      {
         if(currentNode.data>=x){
            newList=appendNode(newList, currentNode.data);
         }
         currentNode=currentNode.next;
      }
      
      return newList;
   
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