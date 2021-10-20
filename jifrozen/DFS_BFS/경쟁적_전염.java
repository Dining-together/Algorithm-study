package DFS_BFS;
import java.util.*;
import java.io.*;

public class 경쟁적_전염 {
	static int n, m, s, x, y, nx, ny = 0;
	static int[][] arr = new int[201][201];
	static ArrayList<Node> nodes = new ArrayList<>();
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	static class Node implements Comparable<Node> {
		private int x;
		private int y;
		private int index;
		private int sec;

		Node(int index, int x, int y, int sec) {
			this.index = index;
			this.x = x;
			this.y = y;
			this.sec = sec;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public int getIndex() {
			return this.index;
		}

		public int getSec() {
			return this.sec;
		}

		@Override
		public int compareTo(Node other) {
			if (this.index < other.index)
				return -1;
			return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0) {
					nodes.add(new Node(arr[i][j], i, j, 0));
				}
			}
		}

		Collections.sort(nodes);

		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		int result = bfs();

		System.out.print(result);

	}

	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < nodes.size(); i++) {
			q.offer(nodes.get(i));
		}
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.getSec() == s) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = node.getX() + dx[i];
				int ny = node.getY() + dy[i];
				int index = node.getIndex();
				int sec = node.getSec();

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (arr[nx][ny] == 0) {
						arr[nx][ny] = index;
						q.offer(new Node(arr[nx][ny], nx, ny, sec + 1));
					}
				}
			}

		}
		return arr[x-1][y-1];
	}
}
