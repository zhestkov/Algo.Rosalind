import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class BuildingAHeap {
	
	public static void swap(int a[], int i, int j) {
		int t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
    public static void sift_down(int[] arr, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && arr[j] < arr[j+1])	j++;
            if (arr[k] >= arr[j])	break;
            swap(arr, k, j);
            k = j;           
        }
    }
    
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("inBuildHeap.txt"));
		PrintWriter out = new PrintWriter(new File("outBuildHeap.txt"));
		int n = in.nextInt();
		int a[] = new int[n+1];
		for (int i = 1; i <= n; i++)
			a[i] = in.nextInt();
        int N = a.length;
        for (int k = N/2 + 1; k > 0; k--)
        	sift_down(a, k, N-1);
			
		
		for (int i = 1; i <= n; i++)
			out.print(a[i] + " ");
		in.close();
		out.close();
	}
}