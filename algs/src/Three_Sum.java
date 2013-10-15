import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Three_Sum {
	
	private static int indexOf(int arr[], int k) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == k)
				return i + 1;
		return -1;
	}
	
	private static int[] sort_indices(int a[], int k1, int k2, int k3) {
		int temp[] = new int[3];
		temp[0] = indexOf(a, k1);
		temp[1] = indexOf(a, k2);
		temp[2] = indexOf(a, k3);
		Arrays.sort(temp);
		return temp;
		
	}
	
	
	public static String check(int a[]) {
		int b[] = new int[a.length];
		for (int i = 0; i < b.length; i++)
			b[i] = a[i];
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++)
			for (int j = i+1; j < a.length; j++) {
				int r = BinSearch.bs(a, -a[i]-a[j], 0, a.length-1);
				if (r > j) {
					int res[] = sort_indices(b, a[i], a[j], a[r]);
					return res[0] + " " + res[1] + " " + res[2];
				}
			}
		return "-1";
	}
	
	public static void main(String[] args) throws IOException  {
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		int k = in.nextInt();
		int n = in.nextInt();
		int a[][] = new int[k][n];
		for (int i = 0; i < k; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = in.nextInt();
		
		for (int i = 0; i < k; i++)
			out.println(check(a[i])); 
		in.close();
		out.close();
	}	
}