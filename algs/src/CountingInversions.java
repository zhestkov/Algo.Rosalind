import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CountingInversions {
	
	private static long cnt; 
	private static int aux[];
	
	public static void sort(int a[]) {
		aux = new int[a.length];
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(int a[], int lo, int hi) {
		if (hi <= lo)	return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	public static void merge(int a[], int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++) {
			if (i > mid)	a[k] = aux[j++];
			else if (j > hi)	a[k] = aux[i++];
			else if (aux[j] < aux[i]) {
				cnt += mid - i + 1;
				a[k] = aux[j++];
			}
			else	a[k] = aux[i++];
		}
	}	
	public static long checkCounter(int a[]) {
		int n = a.length;
		long res = 0;
		for (int i = 0; i < n-1; i++)
			for (int j = i+1; j < n; j++)
				if (a[i] > a[j])
					res++;
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("inCountInversions.txt"));
		//PrintWriter out = new PrintWriter(new File("outCountInversions.txt"));
		cnt = 0;
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		long check_cnt = checkCounter(a);
		sort(a);
		System.out.println(cnt);
		System.out.println("brute-force: " + check_cnt);
		for (int t: a)
			System.out.print(t + " ");
		in.close();
		//out.close();
	}

}
