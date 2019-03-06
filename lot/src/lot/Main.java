package lot;

import java.util.Scanner;

public class Main {
	/*
	���������. ���������� �����, ����������� ���������
	�������������� �����. ����������� �������� �����������,
	����������� � �������� ��������
	*/
	public static void main(String[] args) {
		final int n = 3;
		Scanner scan = new Scanner(System.in);
		Lot[] lot = new Lot[n];
		boolean flag = true;
		lot[0] = new Lot();

		for(int i = 1; i < n; i++) {
			System.out.println(i + " ���������:");
			lot[i] = new Lot();
			do {
				double num = scan.nextDouble();
				flag = lot[i].setLot(num);
			} while(flag);
		}

		System.out.println("��������� �: " + lot[1]);
		System.out.println("��������� �: " + lot[2]);

		lot[0].unionLot(lot[1], lot[2]);
		System.out.println("\n�����������: " + lot[0]);

		lot[0].confLot(lot[1], lot[2]);
		System.out.println("�����������: " + lot[0]);

		lot[0].diffLot(lot[1], lot[2]);
		System.out.println("��������(A \\ B): " + lot[0]);

		lot[0].diffLot(lot[2], lot[1]);
		System.out.println("��������(B \\ A): " + lot[0]);

		scan.close();
	}
}