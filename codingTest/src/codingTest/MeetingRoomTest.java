package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomTest {
	
	
	static class Meeting implements Comparable<Meeting>{
		
		int start, end;
		
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			
			//����ð��� ���� ��, ���ٸ� ���۽ð��� ���� �� 
			return this.end != o.end ? this.end-o.end: this.start - o.start;
		}
		
		
	}

	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Meeting[] meetings = new Meeting[N];
		
		for(int i = 0; i<N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		// sort �߰�
		Arrays.sort(meetings);
		ArrayList<Meeting> result = new ArrayList<>();
		
		// ���� ���� ������ �ָ� �ִ´�.
		result.add(meetings[0]); //ùȸ�� �����층�� �ֱ�
		
		for(int i = 0; i<N; i++) {
			
			// �����ٸ��� �־��� �ִ� ���� ���������� ����ð���  ������ ���� ����ϴ� ���� �ð��� ���۽ð� ���� 
			// ����.
			if(result.get(result.size()-1).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
			
		}
		
		System.out.println(result.size());
		
		for(Meeting meeting : result) {
			System.out.println(meeting.start+"-"+meeting.end);
		}
		
		
	}

}
