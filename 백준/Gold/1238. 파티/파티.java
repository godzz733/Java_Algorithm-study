import java.io.*;
import java.util.*;


class pos{
	int x,dist;
	pos(int x, int dist){
		this.x = x;
		this.dist = dist;
	}
}
public class Main {

	static int n,m,end;
	static ArrayList<ArrayList<pos>> lst;
	static int [][] arr;
	static PriorityQueue<pos> q;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); end = Integer.parseInt(st.nextToken());
		lst = new ArrayList<>();
		for (int i=0; i<n+1; i++) {
			lst.add(new ArrayList<pos>());
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			lst.get(Integer.parseInt(st.nextToken())).add(new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		q = new PriorityQueue<>(new Comparator<pos>() {
			@Override
			public int compare(pos o1, pos o2) {
				return o1.dist-o2.dist;
			}
		});
		arr = new int [n+1][n+1];
		for (int i=0; i<n+1; i++) {
			Arrays.fill(arr[i], 987654321);
		}
		int result = 0;
		for (int i=1; i<n+1; i++) {
			dik(i);
		}
		for (int i=1; i<n+1; i++) {
			result = Math.max(arr[i][end] + arr[end][i], result);
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
			
	}
	public static void dik(int dot) {
		arr[dot][dot] = 0;
		q.add(new pos(dot,0));
		while (!q.isEmpty()) {
			pos cur = q.poll();
			int x = cur.x;
			int dist = cur.dist;
			if (arr[dot][x] < dist) continue;
			for (int i=0; i<lst.get(x).size(); i++) {
				int cost = dist + lst.get(x).get(i).dist;
				if (arr[dot][lst.get(x).get(i).x] > cost) {
					arr[dot][lst.get(x).get(i).x] = cost;
					q.add(new pos(lst.get(x).get(i).x, cost));
				}
			}
		}
	}
	

}