import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HeapSort {
	
	public static void sort(int arr[]) {
		int n = arr.length-1;
		for (int k = n/2 + 1; k > 0; k--)
			BuildingAHeap.sift_down(arr, k, n);
		while (n > 1) {
			BuildingAHeap.swap(arr, 1, n--);
			BuildingAHeap.sift_down(arr, 1, n);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("inHeapSort.txt"));
		PrintWriter out = new PrintWriter(new File("outHeapSort.txt"));
		int n = in.nextInt();
		int a[] = new int[n+1];
		for (int i = 1; i <= n; i++)
			a[i] = in.nextInt();
		sort(a);
		for (int i = 1; i <= n; i++)
			out.print(a[i] + " ");
		in.close();
		out.close();
	}

}
