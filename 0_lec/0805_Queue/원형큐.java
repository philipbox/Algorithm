package day07_0805;

import java.util.Scanner;

public class 원형큐 {

	public static int front = 0;
	public static int rear = 0;
	public static int[] Queue = new int[5];
	public static void main(String[] args) {
		//적당한 크기의 1차원 배열과 front, rear를 준비
		//사용자의 입력에 따라, 1.삽입	2.삭제	3.isEmpty	4.isFull 로직을수행하도록 구현
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. enQueue\n2. deQueue\n3. print\n0. Exit");
			int sel = sc.nextInt();
			if (sel==1) {
				//삽입
				if(isFull()) {
					System.out.println("Queue is full");
				}
				else {
					int data = sc.nextInt();
					enQueue(data);
				}
			} else if(sel ==2) {
				if(isEmpty()) {
					System.out.println("Queue is empty");
				}
				else {
					System.out.println("delete : "+ deQueue());
				}
			} else if(sel ==3) {
				//print
				print();
			}else {
				break;
			}
			
		}//end while
	}//end main
	
	
	
	public static void enQueue(int data) {
		rear = (rear+1) % Queue.length;
		Queue[rear] = data;
	}
	
	public static int deQueue() {
		front = (front+1) % Queue.length;
		return Queue[front];
	}
	
	public static boolean isEmpty() {
		if(front == rear)
			return true;
		else 
			return false;
	}
	
	public static boolean isFull() {
		if(front == rear+1)
			return true;
		else
			return false;
	}
	
	public static void print() {
		System.out.println("Queue : ");
		for(int i = front+1; i<=rear; i++) {
			System.out.print(Queue[i] + " ");
		}
		System.out.println();
	}
	

	
}
