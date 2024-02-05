import java.util.Scanner;

public class Main {
	
	static class Node {
		int num;
		Node next;
		
		
		Node(int idx) {
			this.num = idx;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		Node head = new Node(1);
		Node tmp = head;
		for (int i = 2; i <= N; i++) {
			Node newNode = new Node(i);
			tmp.next = newNode;
			tmp = newNode;
			if (i == N) {
				tmp.next = head;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Node before = null;
		for(int i = 0; i < N - 1; i++) {
			for (int j = 0; j < K; j++) {
				before = tmp;
				tmp = tmp.next;
			}
			sb.append(tmp.num + ", ");
			before.next = tmp.next;
			tmp.next = null;
			tmp = before;
		}
		sb.append(tmp.num + ">");
		System.out.println(sb);
		s.close();
	}
}