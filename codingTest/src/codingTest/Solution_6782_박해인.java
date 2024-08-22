package codingTest;

import java.io.*;
import java.util.*;

public class Solution_6782_������ {
	
	static int cnt;
	
/*
4
2
3
4
99
*/

	static boolean isInteger(double N) {
		return N == (long)N;
	}

	static void root (long N) {
		
		if(N==2) {
			return;
		}
		//1. �������� �� �� ���� �� 
		if(isInteger(Math.sqrt(N))) {
			//System.out.println("�������� �� �� ������"+N);
			cnt++;
			N = (long)Math.sqrt(N);
			root(N);
		//2. �������� �� �� ������->5��� �����غ���:�������� �������� !!-> ���� ����� �������� �Ǵ¹�?
		}else {
			
			//System.out.println("�������� �� �� ������"+N);
			long a = (long)(Math.sqrt(N)+1);
			long b = a*a;
			//b�� �ɶ� ���� ����� �������� �Ǵ°ž�...
			cnt += (int)(b-N);
			//�׸��� N�� b �־���,
			N = b;
			root(N);
			
		}

	}
	
	

	
	public static void main(String [] args) throws IOException {
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for(int t=0; t<T; t++) {
			
			long N = Long.parseLong(sc.nextLine());
			cnt = 0;
			root(N);
			System.out.println("#"+(t+1)+" "+cnt);
		}
		
		
		
	}
	
	
	
}
