package NSpace;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n, t = 0;
		System.out.print("Введите размер массива n >= 2: ");
		n = scan.nextInt();
		int x[] = new int[n];
		int y[] = new int[n];
		int c[] = new int[2*n];
		
		x = randmas(x);
		outmas(x, "x");
		y = randmas(y);
		outmas(y, "y");
		
		for(int i = 0; i < n; i++) {
			c[i] = x[i];
			c[n + i] = y[i];
		}
		outmas(c, "x or y");
		
		for(int i = 0; i < n; i++)
			for(int k = 0; k < n; k++)
				if(x[i] == y[k]) t++;
		if(t > 0) {
			int d[] = new int[t];
			t = 0;
			for(int i = 0; i < n; i++) {
				for(int k = 0; k < n; k++)
					if(x[i] == y[k]) {
						d[t] = x[i];
						t++;
					}
			}
			outmas(d, "x and y");
		}
		else System.out.println("\nNo x and y");
		
		scan.close();
	}

	public static void outmas(int x[], String s) {
		System.out.print("\nМассив " + s + ": ");
		for(int a : x) {
			System.out.print(a + " ");
		}
	}
	
	public static int[] randmas(int x[]) {
		for(int i = 0; i < x.length; i++) {
			x[i] = randnum(x);
		}
		return x;
	}

	public static int randnum(int x[]) {
		int r = (int) (Math.random() * 10);//2 * x.length);
		for(int a : x) {
			if(a == r) return randnum(x);
		}
		return r;
	}
}
