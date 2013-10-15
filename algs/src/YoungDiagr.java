import java.util.Scanner;

public class YoungDiagr {
	

	static int g(int n, int k, int deep, int arr[]) {
		if (n == 0) 	
			return 1;
		if (k > n)
			return 0;
		int a[] = new int[deep+1];
		for (int i = 0; i < deep; i++)
			for (int j =0; j < deep; j++)
				if (arr[i] + arr[j] == k && i != j)
					return g(n, k+1, deep, arr);
		for (int i = 0; i < deep; i++)
			a[i] = arr[i]; a[deep] = k;
		return g(n-k, k, deep+1, a) + g(n, k+1, deep, a);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[] = new int[1];
		int n = in.nextInt();
		System.out.print(g(n, 1, 0, arr));
		
	}
}