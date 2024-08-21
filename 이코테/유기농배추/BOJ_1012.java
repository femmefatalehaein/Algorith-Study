package algo_Java;

import java.util.*;
import java.io.*;

public class BOJ_1012 {
	static int[][] field; //���߹��� ǥ����  2���� �迭
	static boolean[][] visited; // �ش� ��ġ�� �湮�ߴ��� Ȯ���� 2���� �迭
	// �� ���߿��� �����ؼ� ����� ��� ���߸� �湮�� �Ŀ��� �ش� �׷쿡 ���� ���ߵ��� �� �̻� Ž���� �ʿ䰡 ����!
	static int M, N; // ���߹��� ����, ���� ����
	static int[] dx = {-1, 1, 0, 0}; // x��ǥ�� �����¿� �̵��� ���� �迭
	static int[] dy = {0, 0, -1, 1}; // y��ǥ�� �����¿� �̵��� ���� �迭
	// dx, dy �迭�� ���� ���� ��ġ���� �ֺ� ��ġ���� �̵��� ���� ����� �� ���� 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽�
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()); // ������ ��ġ�� ���� 
			
			field = new int[N][M]; // ���� �� �ʱ�ȭ 
			visited = new boolean[N][M];
			
			// ������ ��ġ�� �Է� �޾� field �迭�� ǥ��
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[x][y] = 1; // (x, y) ��ġ�� ���߰� ����
			}
			
			int cnt = 0; // ����� ���� �׷��� ���� ������ ���� (������ ���ߵ��� �ϳ��� �׷����� ����)
			// ���߰� ������ �ִ� ���� = �����¿�� ����� ���
			
			// ���߹��� ��� ��ġ �˻� 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// ���߰� �ְ�, ���� �湮���� ���� ��ġ��� DFS ����
					if (field[i][j] == 1 && !visited[i][j]) {
						DFS(i, j);
						cnt ++; // DFS�� ������ ����� �׷��� �ϳ� ã�� ���̹Ƿ� cnt 1 ���� 					
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
	
	// DFS �Լ�
	static void DFS(int x, int y) {
		visited[x][y] = true; // ���� ��ġ�� �湮������ ǥ�� 
		
		// �����¿� �������� �̵�
		for (int i = 0; i < 4; i++) {
			// (x,y)��ǥ���� ��,��,��,��� ���� �̵� 
			int nx = x + dx[i]; 
			int ny = y + dy[i]; 
			
			// nx, ny�� ���߹��� ���� ���� �ְ�
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) { // ���� �� ���ֱ�!
				// �ش� ��ġ�� ���߰� �ְ�, ���� �湮���� �ʾҴٸ� DFS ��� ȣ��
				if (field[nx][ny] == 1 && !visited[nx][ny]) {
					DFS(nx, ny);
				}
			} 
		} 
		
	}
}
