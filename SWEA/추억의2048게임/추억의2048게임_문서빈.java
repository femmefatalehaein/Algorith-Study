package algo_Java;

import java.util.*;
import java.io.*;

public class Solution_6109_������ {
	static int N;
	static String S;
	static int[][] in_arr;
	static int[][] out_arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = st.nextToken();
			in_arr = new int[N][N];
			out_arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					in_arr[i][j] = Integer.parseInt(st.nextToken());
				}
			} // �Է� ��

			switch (S) {
			case "up":
				for (int j = 0; j < N; j++) { // �� �켱 Ž��
					for (int i = 0; i < N - 1; i++) { // ������ �Ʒ���
						if (in_arr[i][j] == 0) // ���� ���� 0�̸� �н�
							continue;

						int idx = i + 1;

						while (in_arr[idx][j] == 0) { // ���� ���� 0�̸� ������
							if (idx == N - 1) // ������ Ž��
								break;
							idx++;
						}

						if (in_arr[idx][j] == 0) // ���� ���� 0�̸� �н�
							continue;

						if (in_arr[i][j] == in_arr[idx][j]) { // ��ġ�� �����
							in_arr[i][j] += in_arr[i][j];
							in_arr[idx][j] = 0;
							i = idx;
						}
					}
					int cur = 0;
					for (int i = 0; i < N; i++) { // ��� �Է�
						if (in_arr[i][j] != 0) {
							out_arr[cur++][j] = in_arr[i][j];
						}
					}
				}
				break;

			case "down":
				for (int j = 0; j < N; j++) { // �� �켱 Ž��
					for (int i = N - 1; i > 0; i--) { // �Ʒ����� ����
						if (in_arr[i][j] == 0) // ���� ���� 0�̸� �н�
							continue;

						int idx = i - 1;

						while (in_arr[idx][j] == 0) { // ���� ���� 0�̸� ������
							if (idx == 0) // ������ Ž��
								break;
							idx--;
						}

						if (in_arr[idx][j] == 0) // ���� ���� 0�̸� �н�
							continue;

						if (in_arr[i][j] == in_arr[idx][j]) { // ��ġ�� �����
							in_arr[i][j] += in_arr[i][j];
							in_arr[idx][j] = 0;
							i = idx;
						}
					}
					int cur = N - 1; // ??
					for (int i = N - 1; i > 0; i--) { // ��� �Է�
						if (in_arr[i][j] != 0) {
							out_arr[cur--][j] = in_arr[i][j];
						}
					}
				}
				break;

			case "left":
				for (int i = 0; i < N; i++) { // �� �켱 Ž��
					for (int j = 0; j < N - 1; j++) { // ������ �Ʒ���
						if (in_arr[i][j] == 0) // ���� ���� 0�̸� �н�
							continue;

						int idx = j + 1;

						while (in_arr[i][idx] == 0) { // ���� ���� 0�̸� ������
							if (idx == N - 1) // ������ Ž��
								break;
							idx++;
						}

						if (in_arr[i][idx] == 0) // ���� ���� 0�̸� �н�
							continue;

						if (in_arr[i][j] == in_arr[i][idx]) { // ��ġ�� �����
							in_arr[i][j] += in_arr[i][j];
							in_arr[i][idx] = 0;
							j = idx;
						}
					}
					int cur = 0;
					for (int j = 0; j < N; j++) { // ��� �Է�
						if (in_arr[i][j] != 0) {
							out_arr[i][cur++] = in_arr[i][j];
						}
					}
				}
				break;

			case "right":
				for (int i = 0; i < N; i++) { // �� �켱 Ž��
					for (int j = N - 1; j > 0; j--) { // �����ʺ��� ��������
						if (in_arr[i][j] == 0) // ���� ���� 0�̸� �н�
							continue;

						int idx = j - 1;

						while (in_arr[i][idx] == 0) { // ���� ���� 0�̸� ������
							if (idx == 0) // ������ Ž��
								break;
							idx--;
						}

						if (in_arr[idx][j] == 0) // ���� ���� 0�̸� �н�
							continue;

						if (in_arr[i][j] == in_arr[i][idx]) { // ��ġ�� �����
							in_arr[i][j] += in_arr[i][j];
							in_arr[i][idx] = 0;
							j = idx;
						}
					}
					int cur = N - 1; // ??
					for (int j = N - 1; j > 0; j--) { // ��� �Է�
						if (in_arr[i][j] != 0) {
							out_arr[i][cur--] = in_arr[i][j];
						}
					}
				}
				break;

			}

			System.out.println("#" + tc);
			for (int[] is : out_arr) {
				for (int i : is) {
					System.out.print(i + " ");
				}
				System.out.println();
			}

		}

	}
}
