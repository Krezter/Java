import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int num, ost;
		num = scan.nextInt();
		System.out.print(num + " = ");

		ost = num;
		while(ost > 3) {
			ost = (int) Math.sqrt(num);
			ost *= ost;
			System.out.print(ost + " + ");
			num = num - ost;
		}
		System.out.print(ost);
	}
}
