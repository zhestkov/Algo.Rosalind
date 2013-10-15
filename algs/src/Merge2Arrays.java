import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Merge2Arrays {
	
	
	public static int[] merge(int a[], int b[], int n, int m) {
		int i = 0;
		int j = 0;
		int k;
		int res[] = new int[n+m];
		for (k = 0; k < n+m && i < n && j < m; k++) {
			if (a[i] < b[j]) {
				res[k] = a[i];
				++i;
			}
			else if (a[i] > b[j]) {
				res[k] = b[j];
				++j;
			}
			else {
				res[k++] = a[i];
				res[k] = b[j];
				++i;
				++j;
			}
		}
		if (i == n)
			System.arraycopy(b, j, res, k, m - j);
		else if (j == m)
			System.arraycopy(a, i, res, k, n - i);
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("inMerge2Arrays.txt"));
		PrintWriter out = new PrintWriter(new File("outMerge2Arrays.txt"));
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		int m = in.nextInt();
		int b[] = new int[m];
		for (int i = 0; i < m; i++)
			b[i] = in.nextInt();
		int res[] = merge(a, b, n, m);
		for (int t : res)
			out.print(t + " ");
		
		in.close();
		out.close();
	}
	
}