package LinkedList;

import java.util.HashSet;

public class Link {

//    public String bookName;
//    public int numbersSold;
//
//    public Link(String bookName, int numbersSold) {
//        this.bookName = bookName;
//        this.numbersSold = numbersSold;
//    }
//
//    public Link next;
//
//    public static void main (String[] args) {
//        LinkedList theLinkedList = new LinkedList();
//
//        theLinkedList.addFirstLink("Don Bradman0", 120);
//        theLinkedList.addFirstLink("Don Bradman1", 121);
//        theLinkedList.addFirstLink("Don Bradman2", 122);
//        theLinkedList.addFirstLink("Don Bradman3", 123);
//
//        theLinkedList.display();
//    }
//
//    public void display() {
//        System.out.println(bookName + " : " + numbersSold + ",000,000");
//    }
//
//    public String toString() {
//        return bookName;
//    }

    public static void deleteDups1(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    public static void deleteDups2(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
			/* Remove all future nodes that have the same value */
            LinkedListNode runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 19999999; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
//        long startTime1 = System.nanoTime();
//        System.out.println(head.printForward());
//        deleteDups1(head);
//        System.out.println(head.printForward());
//        long endTime1 = System.nanoTime();
//        System.out.println("Total elapsed time 1: " + (endTime1 - startTime1)/1000000);

        long startTime = System.nanoTime();
//        System.out.println(head.printForward());
        deleteDups2(head);
//        System.out.println(head.printForward());
        long endTime = System.nanoTime();
        System.out.println("Total elapsed time 2: " + (endTime - startTime)/1000000);
    }

}

//class LinkedList {
//
//    Link firstLink;
//
//    LinkedList() {
//        firstLink = null;
//    }
//
//    public boolean isEmpty(){
//        return firstLink == null;
//    }
//
//    public void addFirstLink(String bookName, int numbersSold){
//        Link n = new Link(bookName, numbersSold);
//        n.next = firstLink;
//
//        firstLink = n;
//    }
//
//    public void display() {
//        Link theLink = firstLink;
//
//        while(theLink != null) {
//            theLink.display();
//
//            System.out.println("Next Link: " + theLink.next);
//
//            theLink = theLink.next;
//            System.out.println();
//        }
//    }
//}
