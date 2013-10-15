import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class InsertionSort {
	
	public static int sort(int a[]) {
		int cnt = 0;
		for (int i = 1; i < a.length; i++)
			for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
				int t = a[j];
				a[j] = a[j-1];
				a[j-1] = t;
				cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(new File("inInsertionSort.txt"));
	PrintWriter out = new PrintWriter(new File("outInsertionSort.txt"));
	int n = in.nextInt();
	int a[] = new int[n];
	for (int i = 0; i < n; i++)
		a[i] = in.nextInt();
	out.print(sort(a));
	in.close();
	out.close();
	}

}
