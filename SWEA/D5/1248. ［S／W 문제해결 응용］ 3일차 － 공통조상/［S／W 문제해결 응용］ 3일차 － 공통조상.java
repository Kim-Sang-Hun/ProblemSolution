import java.util.*;

class Solution {
    public static int count;
    public static void count(Node[] map, int idx) {
        Node tmp = map[idx];
        count++;
        if (tmp.left != 0) count(map, tmp.left);
        if (tmp.right != 0) count(map, tmp.right);
    }
    
    public static class Node {
    	int idx, head, left, right;
        
        Node(int idx, int head, int left, int right) {
        	this.idx = idx;
            this.head = head;
            this.left = left;
            this.right = right;
        }
    }
    
	public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
        	int V = s.nextInt();
            int E = s.nextInt();
            int e1 = s.nextInt();
            int e2 = s.nextInt();
           	Node[] map = new Node[V + 1];
            for (int i = 0; i < V + 1; i++) {
            	map[i] = new Node(i, 0, 0, 0);
            }
            boolean[] visited = new boolean[V + 1];
            
            for (int i = 0; i < E; i++) {
            	Node head = map[s.nextInt()];
                Node tail = map[s.nextInt()];
                
                if (head.left == 0) {
                	head.left = tail.idx;
                } else {
                	head.right = tail.idx;
                }
                tail.head = head.idx;
            }
            int commonParent = 1;
            while (true) {
            	if (e1 != 1) {
                	e1 = map[e1].head;
                    if (visited[e1]) {
                    	commonParent = e1;
                        break;
                    }
                    visited[e1] = true;
                }
                if (e2 != 1) {
                	e2 = map[e2].head;
                    if (visited[e2]) {
                    	commonParent = e2;
                        break;
                    }
                    visited[e2] = true;
                }
                if (e1 == e2) {
                	commonParent = e2;
                    break;
                }
            }
            count = 0;
            count(map, commonParent);

            System.out.printf("#%d %d %d\n", tc, commonParent, count);
        }
    }
}