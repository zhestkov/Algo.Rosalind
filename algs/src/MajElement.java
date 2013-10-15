import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class MajElement {
	
	static int getElement(int a[], int n) {
		int maj_index = 0;
		int cnt = 1;
		for (int i = 1; i < n; i++) {
			if (a[maj_index] == a[i])
				cnt++;
			else
				cnt--;
			if (cnt == 0) {
				maj_index = i;
				cnt = 1;
			}
		}
		return a[maj_index];
	}
	
	public static boolean isTrue(int a[], int n, int k) {
		int cnt = 0;
		for (int i = 0; i < n; i++) 
			if (a[i] == k)
				cnt++;
		if (cnt > n/2)
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("inMajElement.txt"));
		PrintWriter out = new PrintWriter(new File("outMajElement.txt"));
		int k = in.nextInt();
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++)
				a[j] = in.nextInt();
			int t = getElement(a, n);
			if (isTrue(a, n, t))
				out.print(t + " ");
			else
				out.print(-1 + " ");
		}
		in.close();
		out.close();
	}
}