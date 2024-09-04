import java.util.*;
import java.io.*;

// ���  + �ݺ����� �̿��� DFS(����Ž��) & ����ȭ 
public class �ִ��� {
	static String[] arr;
	static int max, swap_num; // �ִ� �ݾ�, ��ȯ Ƚ�� 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.setIn(new FileInputStream("src/input/input_1244.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			/*
			 * ���� ���ڿ�(123456)�� ���� ����(����)�� �и�(�� ���ڿ� ""�� ��������)�Ͽ� arr �迭�� ����
			 * "123456"�� .split("")�� �����ϸ� ["1", "2", "3", "4", "5", "6"]
			 * �� ���ڿ��� �� ���ڵ��� �迭�� ���ҷ� �ϳ��� ����� 
			 */
			arr = sc.next().split(""); 
			swap_num = sc.nextInt(); 
			// �Է� �� 
			
			max = 0;
			// �ð��ʰ� ����ȭ
			if (arr.length < swap_num) { // swap Ƚ���� �ڸ������� Ŭ ��
				swap_num = arr.length; // �ڸ�����ŭ�� �Űܵ� ���� �ű� �� ����
			}
			dfs(0, 0);
			System.out.println("#" + tc + " " + max);
		}
	}

	static void dfs(int start, int cnt) { // dfs�� ���� ��� ����� �� Ž�� 
		if (cnt == swap_num) { // ��ȯȽ����ŭ ��ȯ�ߴٸ� (���� ����)
			String result = ""; // ���� arr�� ����� ���ڿ����� ���ļ� �ϳ��� ���� ���ڿ��� ���� 
			for (String s : arr) // arr�� ����� �� ���ڸ� �ϳ��� ���ڿ�(result)�� ����
				result += s; //  ["3", "2", "1"] -> "321"
			max = Math.max(max, Integer.parseInt(result)); 
			return;
		}
		for (int i = start; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				// swap
				String temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				dfs(i, cnt + 1); // ���� +1
				// �� �ܰ迡�� �� �ڸ��� ��ȯ�� ��, �ٽ� swap �ؼ� ���� �ڸ��� ����(��Ʈ��ŷ).
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
}