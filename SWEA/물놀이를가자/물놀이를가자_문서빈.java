import java.util.*;
import java.io.*;

// BFS
// 1 <= N, M <= 1000 
// ���� for������ ������ 1000 * 1000 = 1,000,000 �鸸�̶� �ð��ʰ��� �� �� �ִ�.
public class �����̸�����_������ {
	static int N, M ,min;
	static List<Pos> list; 
 	static int[][] arr;
	static int[][] check;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			check = new int[N][M];
			list = new ArrayList<>();
			min = 0;

		
			// �ʱ�ȭ
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					check[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for (int i = 0; i < N; i++) {
				String a = br.readLine();
				for (int j = 0; j < M; j++) {
					if ('L' == a.charAt(j)) {
						arr[i][j] = 1;
					} else {
						list.add(new Pos(i, j));
						arr[i][j] = 0;
					}
				}
			}
			
			bfs();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// max�̸� ���� ��ġ
					if (check[i][j] == Integer.MAX_VALUE) continue;
					min += check[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + min);
		}
	}
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		// �ʱ� �� ��ġ �ֱ�
		for (int i = 0; i < list.size(); i++) {
			Pos p = list.get(i);
			queue.offer(p);
			visited[p.x][p.y] = true;
		}
		
		int index = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i ++) {
				Pos pos = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = pos.x + dx[j];
					int y = pos.y + dy[j];
					
					// ������ ����ų� �̹� �湮�� ���, �Ǵ� ���� ��ġ�� ���
					if (x < 0 || x >= N || y < 0 || y >= N || arr[x][y] == 0) continue;
					
					// ���� ������ check �迭�� ���� ǥ��
					if (arr[x][y] == 1) {
						check[x][y] = index;
					}
					
					visited[x][y] = true;
					queue.add(new Pos(x,y));
				}
			}
			
			index++;
		}
	}
	
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
