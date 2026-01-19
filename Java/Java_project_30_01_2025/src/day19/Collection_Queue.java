package day19;

import java.util.PriorityQueue;
import java.util.Queue;

public class Collection_Queue {
	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(30);
		queue.add(20);
		queue.add(50);
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
