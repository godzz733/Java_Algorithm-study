import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	static ArrayList<Integer>[] a;
	static boolean visited[];
	static int n,m;
	static int cnt;
	
	public static int dfs(int i) {
		visited[i] = true;
		for (int k:a[i]) {
			if (!visited[k]) {
				cnt++;
				dfs(k);
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new ArrayList[n+1];
		visited = new boolean[n+1];
		cnt = 0;
		for (int i=1; i<=n; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			a[u].add(v);
			a[v].add(u);
		}
		System.out.println(dfs(1));
		sc.close();
	}
}