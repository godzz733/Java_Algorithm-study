import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> arr = new PriorityQueue<Integer>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(Integer.parseInt(st.nextToken()));
		}
		br.close();
		long result=0;
		for (int i=0; i<n-1; i++) {
			int a = arr.poll();
			int b = arr.poll();
			arr.add(a+b);
			result += a+b;
		}
		System.out.println(result);
	}
}