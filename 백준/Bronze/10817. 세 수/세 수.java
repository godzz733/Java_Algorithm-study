import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		ArrayList arr = new ArrayList();
		for (int i=0; i<3; i++) {
			int a = sc.nextInt();
			arr.add(a);
		}
		arr.sort(Comparator.naturalOrder());
		System.out.println(arr.get(1));
	}
}