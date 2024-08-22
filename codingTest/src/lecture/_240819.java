package lecture;

import java.util.Arrays;
import java.util.Scanner;

public class _240819 {
	
	static int N,R;
	static int[] input, numbers;
	
	static void perm(int cnt, int flag) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		/*���� ��Ʈ*/
		for(int  i =0; i<N; i++) {
			//0�� �ƴϰ� 1�̴�.
			if( (flag & 1<<i) != 0 ) continue;
			numbers[cnt] = input[i];
			//���� �� ������ �� 
			flag |= 1<<i;
			perm(cnt+1, flag | 1<<i );
			//�����ϱ�
			//flag &= ~(1<<i);

		}
	}
	

	public static void main(String [] args) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		numbers = new int[R];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
	
		perm(0, 0);
		

		
	}
}
