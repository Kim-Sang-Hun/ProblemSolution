import java.util.Scanner;

public class Main {
	static String[][] map;
	static int[][] dirs = {{1, 0}, {1, 1}, {0, 1}, {1, -1}};
	static int[] idx = new int[3];
	
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		map = new String[19][];
		for (int i = 0; i < 19; i++) {
			map[i] = s.nextLine().split(" ");
		}
		loop:
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (!map[i][j].equals("0")) {
					for (int k = 0; k < dirs.length; k++) {
						int bY = i - dirs[k][0];
						int bX = j - dirs[k][1];
						int nY = i + dirs[k][0];
						int nX = j + dirs[k][1];
						int count = 1;
						while (bY >= 0 && bY < 19 && bX >= 0 && bX < 19 && map[bY][bX].equals(map[i][j])) {
							count++;
							bY -= dirs[k][0];
							bX -= dirs[k][1];
						}
						while (nY >= 0 && nY < 19 && nX >= 0 && nX < 19 && map[nY][nX].equals(map[i][j])) {
							count++;
							nY += dirs[k][0];
							nX += dirs[k][1];
						}
						if (count == 5) {
							idx[2] = Integer.parseInt(map[i][j]);
							if (k == 3) {
								idx[0] = nY - dirs[k][0] + 1;
								idx[1] = nX - dirs[k][1] + 1;
							} else {
								idx[0] = bY + dirs[k][0] + 1;
								idx[1] = bX + dirs[k][1] + 1;
							}
							break loop;
						}
					}
				}
			}
		}
		System.out.println(idx[2]);
		if (idx[2] != 0)
		System.out.println(idx[0] + " " + idx[1]);
	}
}