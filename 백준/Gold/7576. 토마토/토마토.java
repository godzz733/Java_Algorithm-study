import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{

	static int n,m;
	static int[][] arr;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean [][] visited;
	static class pos{
		int x,y,cnt;
		public pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt =cnt;
		}
	}	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		visited = new boolean[n][m];
		Queue<pos> q = new LinkedList<>();
		int result = 0, check=0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				arr[j][i] = sc.nextInt();
				if (arr[j][i]==1) {
					q.add(new pos(j,i,0));
					visited[j][i] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			pos cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int cnt = cur.cnt;
			if (cnt>result) {
				result = cnt;
			}
			for (int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx<0 || nx>=n || ny<0 || ny>=m) {
					continue;
				}
				if (arr[nx][ny]==0 && !visited[nx][ny]) {
					arr[nx][ny] = 1;
					q.add(new pos(nx,ny,cnt+1));
					visited[nx][ny]=true;
				}
				
			}
		}
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (arr[j][i]==0) {
					check++;
					break;
				}
			}
		}
		if (check>0) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
			
		}
		
	}