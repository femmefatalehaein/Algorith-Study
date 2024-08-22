package lecture;

import java.util.Arrays;
import java.util.Scanner;

public class NextPerm {
	
	static int N,R;
	static int[] input, numbers;
	
	
	//boolean : true(���� ���� ����) ,false(���� ���� ����)
	static boolean np(int[] p) {
		
			int N = p.length;
			//�� ������ i��
			int i = N-1;
			
			//�� �տ� �ִ� �༮�� ������ ���ų� ũ��? 
			while(i>0 && p[i-1]>=p[i]) --i;
			
			//���� �տ��� ����.
			if(i==0) return false;
			
			//step 2 ) ����� �� ��ȯ��ġ�� ��ȯ�� ��(i-1 ��ġ ������ ū ���� ���� ���� ��) �ڸ� ã��
			// i ã������ -> �ڿ������� j�� ã�ư�����.
			int j = N-1;
			while(p[i-1]>=p[j]) --j;
			
			//step 3) �� ��ġ�� �� ��ȯ
			swap(p, i-1, j);
			
			//step 4) �������� �� �ڱ��� ���������� ���·� ����.
			int k = N-1;
			while(i<k) {
				swap(p, i++,k--);
			}
			
			return true;
	}
	
	static void swap(int [] p, int i, int j) {
		
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
		
	}
	

	public static void main(String [] args) {
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		//R = sc.nextInt();
		input = new int[N];
		//numbers = new int[R];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
	
		//1. ���� ���� �ؾ��ϴ� �� // �������� ������ ���
		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���
		Arrays.sort(input); //�������� ����\
		do {
			System.out.println(Arrays.toString(input));
		}while(np(input));
	        
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		
		long secDiffTime = (afterTime - beforeTime)/1000;
		System.out.println("�ð�����(m) : "+secDiffTime);

		
	}
}
