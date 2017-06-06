package com.test.collection;


public class CustomSingleLinkedListUtility {

	Node head;
	Node tail;
	public void add(int new_data) {

		if (head == null) {
			head = new Node(new_data);
			return;
		}
		tail().next = new Node(new_data);
	}

	public Node tail() {
		tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}
		return tail;
	}

	public void removeFirst(){
		Node first = head;
        final Node next = first.next;
        first.data = 0;
        first.next = null; // help GC
        head = next;
	}
	
	public void removeTail(){
		Node last = tail();
		final Node prev = last.prev;
		last.data = 0;
		last.prev = null; // help GC
		tail = prev;
	}
	void printNthFromLast(int n) {
		int len = 0;
		Node temp = head;

		while (temp != null) {
			temp = temp.next;
			len++;
		}

		if (n > len || n <= 0)
			return;
		temp = head;
		for (int x = 0; x < len - n; x++)
			temp = temp.next;
		System.out.println(temp.data);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node current = head;
		while (current != null) {
			sb.append(current.data).append("-->");
			current = current.next;
		}
		return sb.toString();
	}

	// Checks whether the value x is present in linked list
	public boolean search(Node head, int x) {
		Node current = head; // Initialize current
		while (current != null) {
			if (current.data == x)
				return true; // data found
			current = current.next;
		}
		return false; // data not found
	}

	public void printMiddle() {
		Node fastPointer = head;
		Node slowPointer = head;

		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}
		System.out.println("Middle value is " + slowPointer.data);
	}

	public String reverseList(Node head){
		Node prev = null;
		Node current = head;
		Node next = null;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	
		StringBuffer sb = new StringBuffer();
		Node node = head;
		while (node != null) {
			sb.append(node.data).append("-->");
			node = node.next;
		}
		return sb.toString();
	}
	
	
	public static void main(String[] arg) {
		CustomSingleLinkedListUtility linkedList = new CustomSingleLinkedListUtility();
		linkedList.add(15);
		linkedList.add(20);
		linkedList.add(25);
		linkedList.add(30);
		linkedList.add(40);
		System.out.println("Added Elements ::: " + linkedList);
		//linkedList.head = linkedList.reverseList(linkedList.head);
		System.out.println("Print element after reversing ::: "+ linkedList.reverseList(linkedList.head));
		
		System.out.println("Print 2nd Element from last ::: ");
		linkedList.printNthFromLast(2);

		if (linkedList.search(linkedList.head, 21))
			System.out.println("Search element '21' FOUND in the list");
		else
			System.out.println("Search element '21' NOT FOUND in the list");

		linkedList.printMiddle();
		linkedList.removeFirst();
		System.out.println("Print elements after removing first :::"+ linkedList);
		linkedList.removeTail();
		System.out.println("Print elements after removing last :::"+ linkedList);
//		linkedList.removeTail();
//		System.out.println("Print elements after removing last :::"+ linkedList);
	}
}

class Node {
	int data;
	Node next;
	Node prev;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	public Node(Node prev, int data, Node next) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
}