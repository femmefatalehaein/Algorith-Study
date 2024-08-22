package codingTest;

import java.io.*;
import java.util.*;


public class SameColorSpace {
/*
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1 
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
*/
	static int N, map[][];
	static int white, green;
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for( int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();	
			}
		}

		cut(0,0,N);
		System.out.println(white);
		System.out.println(green);
	}
	
	//�������� (r,c) ���� size��ŭ ũ���� ������ Ȯ���Ѵ�.
	static void cut(int r, int c, int size) {
		
		// �־��� ������ ��� ���� ������ �̷�������� üũ
		// ���� ������ �̷���� ���� ������ 4����
		// ���� ���̸� �������� ����
		int sum = 0;
		for(int i =r, rEnd = r+size; i<rEnd; i++) {
			for(int j = c, cEnd = c+size; j<cEnd; j++) {	
				sum += map[i][j];
			}
		}
		//�������̸� �������� ����
		if(sum == 0) {
			white++;
			return;
		}else if(sum == size*size) {
			green++;
			return;
		}else {
			// ���� ������ �̷���� ���� ������ 4����
			int half = size/2;
			//#1
			cut(r,c,half);
			//#2
			cut(r,c+half,half);
			//#3
			cut(r+half,c,half);
			//#4
			cut(r+half,c+half,half);
		}
	}
	
	
	
}
