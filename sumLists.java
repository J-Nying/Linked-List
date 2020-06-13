/*
"Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit.
The digits are stored in reverse order, such that the 1's digit is at the head of the iist.
Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE input: (7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
Output; 2 -> 1 -> 9. That is, 912.

github.com/J-Nying
*/

import java.io.*;
import java.util.*;
import javax.swing.*;

public class sumLists{

   public static void main (String[] args)
   {
   
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the size of the first Linked List:");
      int size = input.nextInt();
      LinkedList listOne = new LinkedList();
      int newNode = 0;

      int count = 0;
      
      while(count<size){
      
         System.out.println("Enter value number " + (count+1) + ":");
         newNode = input.nextInt();
         while(newNode<0 || newNode>9){
            System.out.println("Invalid. Number must be between 0-9:");
            newNode = input.nextInt();
         }
         listOne = appendNode(listOne, newNode);
         count++;

      }
      
      System.out.println("Enter the size of the second Linked List:");
      int size2 = input.nextInt();
      LinkedList listTwo = new LinkedList();
      count=0;
      
      while(count<size2){
      
         System.out.println("Enter value no." + (count+1) + ":");
         newNode = input.nextInt();
         while(newNode<0 || newNode>9){
            System.out.println("Invalid. Number must be between 1-9:");
            newNode = input.nextInt();
         }
         listTwo = appendNode(listTwo, newNode);
         count++;

      }

      
      System.out.println("Here is the sum:");
      printLinkedList(listOne);
      System.out.println("\n+");
      printLinkedList(listTwo);
      
      System.out.println("\n=");
      printLinkedList(sumOfLists(listOne, listTwo));

  
   }



   public static LinkedList sumOfLists(LinkedList l1, LinkedList l2){
      Node currentNode1 = l1.head;
      Node currentNode2 = l2.head;
      int sum = 0;
      int carryOver = 0;
      LinkedList finalList = new LinkedList();
      
      while(currentNode1!=null || currentNode2!=null)
      {  
         if(currentNode1==null)
         {  
            sum = currentNode2.data+carryOver;
            
            if(sum>9)
            {
               finalList = appendNode(finalList, sum-10);
               carryOver=1;
            }
            else
            {
               finalList = appendNode(finalList, sum);
               carryOver=0;
            }
            
            currentNode2=currentNode2.next;
         }
         
         else if(currentNode2==null)
         {
            sum = currentNode1.data+carryOver;            
            if(sum>9)
            {
               finalList = appendNode(finalList, sum-10);
               carryOver=1;
            }
            else
            {
               finalList = appendNode(finalList, sum);
               carryOver=0;
            }

            currentNode1=currentNode1.next;
         }
         
         else
         {
            sum = currentNode1.data+currentNode2.data+carryOver;
            if(sum>9)
            {
               finalList = appendNode(finalList, sum-10);
               carryOver = 1;
            }
            
            else
            {
               finalList = appendNode(finalList, sum);
               carryOver=0;
            }
            currentNode1=currentNode1.next;
            currentNode2=currentNode2.next;
         }
         
         
      }
      
            
      if(carryOver>0){
         finalList = appendNode(finalList, carryOver);
      }
      
      return finalList;
   
   }
   
   
//    public static LinkedList covertNumToLinkedList(int o){
//    
//       LinkedList numToList = new LinkedList();
//       String s = Integer.toString(o);
//       System.out.println(s);
//       int count = 0;
//       while(count<s.length()){
//       numToList = appendNode(numToList, s.charAt(count));
//       count++;
//       }
//       
//       
//       
//       return numToList;
//    
//    }



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