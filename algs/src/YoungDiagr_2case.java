import java.util.Scanner;
public class YoungDiagr_2case {
	
	public static int g(int n, int k, int c) {
		if (n == 0)
			return 1;
		if (k > n)
			return 0;
		return g(n, k+c-1, c) + g(n-k-c+1, k, c);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c= in.nextInt();
		System.out.print(g(n, 1, c));
	}

}
