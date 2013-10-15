import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
public class BinSearch {

	public static int bs(int a[], int key, int lo, int hi) {
		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo)/2;
		if (key < a[mid])
			return bs(a, key, lo, mid-1);
		else if (key > a[mid])
			return bs(a, key, mid+1, hi);
		else
			return mid;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("inBS.txt"));
		PrintWriter out = new PrintWriter(new File("outBS.txt"));
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		out.print(bs(a, k, 0, n-1));
		in.close();
		out.close();
		
	}

}
