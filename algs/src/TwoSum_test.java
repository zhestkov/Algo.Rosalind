import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoSum_test {
	
	private static int indexOf(int a[], int k) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == k)
				return i + 1;
		return -1;
	}
	
	private static int srchIndex(int a[], int k) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == k)
				return i+1;
		return a.length-1;
	}
	
	public static String check(int a[], int n) {
		int b[] = new int[n];
		int t1 = -1;
		int t2 = -1;
		for (int i = 0; i < n; i++)
			b[i] = a[i];
		Arrays.sort(a);
		int i = 0;
		int j = srchIndex(a, 0);
		while (j >= 0 && j < a.length && i < a.length) {
			int sum = a[i] + a[j];
			if (sum == 0) {
				t1 = indexOf(b, a[i]);
				t2 = indexOf(b, a[j]);	
			}
			if (sum > 0)
				j--;
			else
				i++;
			if (i > j)
				break;
		}
		if (t1 < t2)
			return t1 + " " + t2;
		else if (t1 > t2)
			return t2 + " " + t1;
		else
			return "-1";
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("in2Sum.txt"));
		PrintWriter out = new PrintWriter(new File("out2Sum.txt"));
		int k = in.nextInt();
		int n = in.nextInt();
		int a[][] = new int[k][n];
		for (int i = 0; i < k; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = in.nextInt();
		for (int i = 0; i < k; i++)
			out.println(check(a[i], n));		
		in.close();
		out.close();
	}
}
