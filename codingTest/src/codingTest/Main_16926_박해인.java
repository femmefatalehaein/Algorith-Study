package codingTest;

import java.io.*;
import java.util.*;
		
public class Main_16926_������ {

	static int N,M,R;
	static int[][] input;
	static int min;
	
	static int[] dx = {0, 1, 0, -1}; // �������� �ִ�, ���� �ִ�, ���������� �ִ�, �Ʒ��� �ִ�
	static int[] dy = {1, 0, -1, 0};
	
    // ȸ�� ��Ű�� �޼ҵ�
    static void rotate() {
    	
    	// ���� ���� �� /2��ŭ ȸ�����Ѿ� ��!
    	for(int t=0; t<min/2; t++) { // ȸ�� ��ų �׷��� ���� ���ϱ�
    		
    		int x = t;
    		int y = t;
    		System.out.println("t��"+t);
    		//���� �� �ִ� ���� ? (0,0) (1,1)   
    		
    		int temp = input[x][y]; // �������� ���� �� �̸� ������
    		
    		System.out.println("temp�� : "+temp);
    		
    		int idx = 0; // ��, ��, ��, �� �������� �̵��ϸ� �ݽð� �������� �� ���� �ε���
    		
    		// idx 0, 1, 2, 3
    		
    		while(idx < 4) { // �������� �ִ�, ���� �ִ�, ���������� �ִ�, �Ʒ��� �ִ� ������ ���ʷ� ����
    						 // ������ ����, �Ʒ��� ����, ���� ����, ���� ����
    			int nx = x + dx[idx];
    			int ny = y + dy[idx];
    			
    			// ���� ���̶��
    			if(nx < N-t && ny < M-t && nx >= t && ny >= t) {
    				input[x][y] = input[nx][ny];
    				x = nx;
    				y = ny;
    			} 
    			
    			// ������ ����ٸ� ���� �������� �
    			else {
    				idx++;
    			}
    		}
    		
    		input[t+1][t] = temp; // �� ���� �� �־� ��
    	}
    }
    
	public static void main(String [] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		input = new int [N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		min = Math.min(N, M);
		
		
		for(int i=1; i<=R; i++) { // ȸ�� Ƚ����ŭ ȸ����Ŵ
    		rotate();
    	}
		
		
		for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			System.out.print(input[i][j] + " ");
    		}
    		System.out.println();
    	}
		
	}
	
}

