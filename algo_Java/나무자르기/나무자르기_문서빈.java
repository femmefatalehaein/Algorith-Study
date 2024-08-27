package algo_Java;

import java.util.*;
import java.io.*;

public class �����ڸ���_������ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner in = new Scanner(System.in);

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] tree = new int[N];

		int min = 0, max = 0;

		for (int i = 0; i < N; i++) {
			// tree[i] = Integer.parseInt(st.nextToken());
			tree[i] = in.nextInt();

			if (max < tree[i]) { // �Է¹��� ������ max���� Ŭ ��� max���� �ش� ���� ���̷� ����
				max = tree[i];
			}
		}

		// �̺� Ž��
		while (min < max) {
			int mid = (min + max) / 2;
			long sum = 0;
			for (int treeH : tree) { // tree �߸� ���� = tree ���� - �ڸ��� ��ġ(mid)
										// 0 ������ ���� �ջ����� �ʴ´�.
				if (treeH - mid > 0) {
					sum += (treeH - mid);
				}
			}

			if (sum < M) {
				max = mid;
			}

			else {
				min = mid + 1;
			}
		}

		System.out.println(min - 1);
	}

}
